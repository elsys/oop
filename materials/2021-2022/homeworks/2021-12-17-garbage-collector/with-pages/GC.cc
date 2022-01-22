#include <iostream>
#include <fstream>
#include <list>
#include <cstddef>

#include "GC.hh"

using namespace std;

//
// Constructors and destructors
//
GC::GC() {}

GC::MemPage::MemPage(size_t page_size) {
  // Allocate the initial 1k memory
  memory_start = new char[page_size];
  // Record it as a single free block
  free_blocks.push_back(new MemBlock(memory_start, page_size));
}

GC::MemPage::~MemPage() {
  // Empty all lists
  for(auto it = allocated_blocks.begin(); it != allocated_blocks.end(); it++) delete *it;
  allocated_blocks.clear();
  for(auto it = free_blocks.begin(); it != free_blocks.end(); it++) delete *it;
  free_blocks.clear();
  // Free the memory
  delete[] memory_start;
}

GC::MemBlock::MemBlock(char* start, size_t size) : start(start), size(size) {}

GC::InvalidSizeException::InvalidSizeException(const char* what_arg) : logic_error(what_arg) {}

//
// Static members that aren't const must be initialized outside of the class
//
list<GC::MemPage*> GC::pages = list<GC::MemPage*>();

//
// Helpers
//
size_t GC::MemPage::total_free_size() {
  size_t size = 0;
  for(auto it = free_blocks.begin(); it != free_blocks.end(); it++) size += (*it)->size;

  return size;
}

GC::MemBlock* GC::MemPage::find_free_block(size_t target_size) {
  // Search for a usable block
  for(auto it = free_blocks.begin(); it != free_blocks.end(); it++) {
    MemBlock* curr_block = *it;
    // The free block must be large enough to fit the required size
    if(curr_block->size >= target_size) return curr_block;
  }

  // If no blocks were found return null
  return nullptr;
}

void* GC::MemPage::allocate_in_block(GC::MemBlock* block, size_t target_size) {
  // Get an iterator to the block
  for(auto it = free_blocks.begin(); it != free_blocks.end(); it++) {
    if(*it == block) {
      // Remove it from the list of free
      free_blocks.erase(it);

      if(block->size > target_size) {
        // Break off the last bytes in a new free block
        MemBlock* remaining = new MemBlock(block->start + target_size, block->size - target_size);
        free_blocks.push_back(remaining);

        // Update the size of the block
        block->size = target_size;
      }

      // And add it tothe list of used
      allocated_blocks.push_back(block);

      // Return a pointer to the start of the block
      return block->start;
    }
  }

  // If no blocks were found throw and allocation error
  throw InvalidSizeException("Cannot find suitable memory block");
}

size_t GC::total_free_size() {
  size_t size = 0;
  for(auto it = pages.begin(); it != pages.end(); it++) size += (*it)->total_free_size();

  return size;
}

size_t GC::total_allocated_size() {
  return page_size * pages.size() - total_free_size();
}

void GC::init() {
  // Alocate a single page
  pages.push_back(new MemPage(page_size));
}

void GC::clear() {
  // Go over all pages and free them
  for(auto it = pages.begin(); it != pages.end(); it++) delete *it;
  pages.clear();
}

// GC::MemBlock* GC::MemPage::find_block(void *target_memory, list<MemBlock*>& list) {
GC::MemBlock* GC::MemPage::find_block(void *target_memory, list<MemBlock*>& list) {
  for(auto it = list.begin(); it != list.end(); it++) {
    MemBlock* curr_block = *it;
    if((void*)(curr_block->start) == target_memory) return curr_block;
  }

  return nullptr;
}

GC::MemBlock* GC::MemPage::find_block(void *target_memory) {
  return find_block(target_memory, allocated_blocks);
}

void GC::MemPage::free_block(GC::MemBlock *block) {
  // Remove it from the list of used
  allocated_blocks.remove(block);
  // And add it tothe list of free
  free_blocks.push_back(block);
  // Note: Doing it this way will cause the description of the memory to get more and more fragmented over time -
  // when allocating blocks can be split into smaller blocks, but when freeing we do not combine them back into larger ones.
  // The scope of the task doesn't explicitly require us to handle this.
}

//
// Allocations
//
void* GC::allocate(size_t target_size) {
  // Search for a page with a free block with the required size
  for(auto it = pages.begin(); it != pages.end(); it++) {
    MemPage* page = *it;
    MemBlock* candidate_block = page->find_free_block(target_size);
    if(candidate_block == nullptr) continue;

    // If a block is found allocate and return
    return page->allocate_in_block(candidate_block, target_size);
  }

  // Throw if the page limit is reached
  if(pages.size() >= max_pages)
    throw bad_alloc();

  // Create a new page and allocate in it
  MemPage* new_page = new MemPage(page_size);
  pages.push_back(new_page);
  return new_page->allocate_in_block(new_page->find_free_block(target_size), target_size);
}

void GC::free(void *target_memory) {
  // Search across the pages
  for(auto it = pages.begin(); it != pages.end(); it++) {
    MemPage* page = *it;
    MemBlock* block = page->find_block(target_memory);

    if(block != nullptr) {
      // Free the block
      page->free_block(block);
      return;
    }
  }

  // Throw if the block isn't found
  throw bad_alloc();
}

void GC::MemPage::shrink_block(GC::MemBlock* block, size_t new_size) {
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

void GC::shrink(void *target_memory, size_t new_size) {
  // Search across the pages
  for(auto it = pages.begin(); it != pages.end(); it++) {
    MemPage* page = *it;
    MemBlock* block = page->find_block(target_memory);

    if(block != nullptr) {
      // Shrink the block
      page->shrink_block(block, new_size);
      return;
    }
  }

  // Throw if the block isn't found
  throw bad_alloc();
}

void GC::MemPage::grow_block(GC::MemBlock *block, size_t new_size) {
  // Throw if the new size is less than the current
  if(new_size < block->size) throw InvalidSizeException("New size of block must be smaller");
  // Just return if the size is the same
  if(new_size == block->size) return;

  size_t required_bytes = new_size - block->size;

  // Get the next block if it is free
  MemBlock* next_free = find_block((char*)block->start + block->size, free_blocks);

  // Check if there is any free memory after the block
  if(!next_free) throw bad_alloc();

  // If the next block is free but not large enough we need to find free ones after it
  // The simple solution is to recursively grow until we have a single large block that fits the new size
  if(next_free->size < required_bytes)
    grow_block(next_free, required_bytes);

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

void GC::grow(void *target_memory, size_t new_size) {
  // Search across the pages
  for(auto it = pages.begin(); it != pages.end(); it++) {
    MemPage* page = *it;
    MemBlock* block = page->find_block(target_memory);

    if(block != nullptr) {
      // Grow the block
      page->grow_block(block, new_size);
      return;
    }
  }

  // Throw if the block isn't found
  throw bad_alloc();
}

//
// Dump to file
//
void GC::MemPage::dump_list(list<MemBlock*>& list, ostream& out) {
  for(auto it = list.begin(); it != list.end(); it++) {
    MemBlock* curr_block = *it;
    out << (void*)curr_block->start
        << " - "
        << (void*)(curr_block->start + curr_block->size - 1)
        << " (" << curr_block->size << ")"
        << endl;
  }
}

void GC::MemPage::dump(ofstream& ofs) {
  ofs << page_size - total_free_size() << " / " << page_size << endl;
  dump_list(allocated_blocks, ofs);
}

void GC::MemPage::dump_all(ofstream& ofs) {
  ofs << page_size - total_free_size() << " / " << page_size << endl;
  ofs << "Free blocks:" << endl;
  dump_list(free_blocks, ofs);
  ofs << "Used blocks:" << endl;
  dump_list(allocated_blocks, ofs);
}

void GC::dump(string file_path) {
  ofstream ofs = ofstream(file_path);
  if(!ofs) throw system_error();

  ofs << total_allocated_size() << " / " << page_size * pages.size() << endl;
  int page_counter = 0;
  for(auto it = pages.begin(); it != pages.end(); it++) {
    ofs << "Page " << page_counter++ << endl;
    (*it)->dump(ofs);
  }

  ofs.close();
}

void GC::dump_all(string file_path) {
  ofstream ofs = ofstream(file_path);
  if(!ofs) throw system_error();

  ofs << total_allocated_size() << " / " << page_size * pages.size() << endl;
  int page_counter = 0;
  for(auto it = pages.begin(); it != pages.end(); it++) {
    ofs << "Page " << page_counter++ << endl;
    (*it)->dump_all(ofs);
  }

  ofs.close();
}
