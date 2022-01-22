#include <iostream>
#include <fstream>
#include <list>
#include <cstddef>

#include "GC.hh"

using namespace std;

//
// Constructors
//
GC::GC() {}
GC::MemBlock::MemBlock(char* start, size_t size) : start(start), size(size) {}
GC::InvalidSizeException::InvalidSizeException(const char* what_arg) : logic_error(what_arg) {}

//
// Static members that aren't const must be initialized outside of the class
//
char *GC::memory_start = nullptr;
list<GC::MemBlock*> GC::free_blocks = list<GC::MemBlock*>();
list<GC::MemBlock*> GC::allocated_blocks = list<GC::MemBlock*>();

//
// Helpers
//
size_t GC::total_free_size() {
  size_t size = 0;
  for(auto it = free_blocks.begin(); it != free_blocks.end(); it++) size += (*it)->size;

  return size;
}

size_t GC::total_allocated_size() {
  return page_size - total_free_size();
}

void GC::init() {
  // Allocate the initial 1k memory
  memory_start = new char[page_size];
  // Record it as a single free block
  free_blocks.push_back(new MemBlock(memory_start, page_size));
}

void GC::clear() {
  // Empty all lists
  for(auto it = allocated_blocks.begin(); it != allocated_blocks.end(); it++) delete *it;
  allocated_blocks.clear();
  for(auto it = free_blocks.begin(); it != free_blocks.end(); it++) delete *it;
  free_blocks.clear();
  // Free the memory
  delete[] memory_start;
}

GC::MemBlock* GC::find_block(void *target_memory, list<MemBlock*>& list) {
  for(auto it = list.begin(); it != list.end(); it++) {
    MemBlock* curr_block = *it;
    if((void*)(curr_block->start) == target_memory) return curr_block;
  }

  return nullptr;
}

//
// Allocations
//
void* GC::allocate(size_t target_size) {
  // Search for a usable block
  for(auto it = free_blocks.begin(); it != free_blocks.end(); it++) {
    MemBlock* curr_block = *it;
    // The free block must be large enough to fit the required size
    if(curr_block->size >= target_size) {
      // Remove it from the list of free
      free_blocks.erase(it);

      if(curr_block->size > target_size) {
        // Break off the last bytes in a new free block
        MemBlock* remaining = new MemBlock(curr_block->start + target_size, curr_block->size - target_size);
        free_blocks.push_back(remaining);

        // Update the size of the block
        curr_block->size = target_size;
      }

      // And add it tothe list of used
      allocated_blocks.push_back(curr_block);

      // Return a pointer to the start of the block
      return curr_block->start;
    }
  }

  // If no blocks were found throw and allocation error
  throw InvalidSizeException("Cannot find suitable memory block");
}

void GC::free(void *target_memory) {
  // Search for the block that needs to be removed
  MemBlock* block = find_block(target_memory, allocated_blocks);

  // Throw if the block isn't found
  if(!block) throw bad_alloc();

  // Remove it from the list of used
  allocated_blocks.remove(block);
  // And add it tothe list of free
  free_blocks.push_back(block);
  // Note: Doing it this way will cause the description of the memory to get more and more fragmented over time -
  // when allocating blocks can be split into smaller blocks, but when freeing we do not combine them back into larger ones.
  // The scope of the task doesn't explicitly require us to handle this.
}

void GC::shrink(void *target_memory, size_t new_size) {
  // Search for the block that needs to be shrunk
  MemBlock* block = find_block(target_memory, allocated_blocks);

  // Throw if the block isn't found
  if(!block) throw bad_alloc();

  // Throw if the new size is larger than the current
  if(new_size > block->size) throw InvalidSizeException("New size of block must be smaller");
  // Just return if the size is the same
  if(new_size == block->size) return;

  // Break off the last bytes in a new free block
  MemBlock* remaining = new MemBlock(block->start + new_size, block->size - new_size);
  free_blocks.push_back(remaining);

  // Update the size of the block
  block->size = new_size;
}

void GC::grow(void *target_memory, size_t new_size) {
  // Search for the block that needs to be grown
  MemBlock* block = find_block(target_memory, allocated_blocks);

  // Throw if the block isn't found
  if(!block) throw bad_alloc();

  // Throw if the new size is less than the current
  if(new_size < block->size) throw InvalidSizeException("New size of block must be smaller");
  // Just return if the size is the same
  if(new_size == block->size) return;

  size_t required_bytes = new_size - block->size;

  // Get the next block if it is free
  MemBlock* next_free = find_block((char*)target_memory + block->size, free_blocks);

  // Check if there is any free memory after the block
  if(!next_free) throw bad_alloc();

  // If the next block is free but not large enough we need to find free ones after it
  // The simple solution is to recursively grow until we have a single large block that fits the new size
  if(next_free->size < required_bytes)
    grow(next_free->start, required_bytes);

  if(next_free->size <= required_bytes) {
    // The block is merged with the current one and removed from the list
    free_blocks.remove(next_free);
    delete next_free;
  } else {
    // Shrink the free block so that the current one can use its bytes
    next_free->start += required_bytes;
    next_free->size -= required_bytes;
  }

  block->size = new_size;
}

//
// Dump to file
//
void GC::dump_list(list<MemBlock*>& list, ostream& out) {
  for(auto it = list.begin(); it != list.end(); it++) {
    MemBlock* curr_block = *it;
    out << (void*)curr_block->start
        << " - "
        << (void*)(curr_block->start + curr_block->size - 1)
        << " (" << curr_block->size << ")"
        << endl;
  }
}

void GC::dump(string file_path) {
  ofstream ofs = ofstream(file_path);
  if(!ofs) throw system_error();

  ofs << total_allocated_size() << " / " << page_size << endl;
  dump_list(allocated_blocks, ofs);

  ofs.close();
}

void GC::dump_all(string file_path) {
  ofstream ofs = ofstream(file_path);
  if(!ofs) throw system_error();

  ofs << total_allocated_size() << " / " << page_size << endl;
  ofs << "Free blocks:" << endl;
  dump_list(free_blocks, ofs);
  ofs << "Used blocks:" << endl;
  dump_list(allocated_blocks, ofs);

  ofs.close();
}
