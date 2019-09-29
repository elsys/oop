package org.elsys.zoo;

import java.util.*;

public class Zoo {
    /**
     * Adds the given cell in the Zoo
     * @param name name of the cell
     * @param capacity capacity of the new cell
     * @param hasPool if the new cell has a pool
     */
    public void buildCell(String name, boolean hasPool, int capacity){

    }

    /**
     * Adds the given animal to the given cell
     * @param cellName name of the cell to be added in
     * @param animal the animal that will be added
     */

    public void addAnimal(String cellName, Animal animal) {

    }

    /**
     *
     * @param animal
     * @return possible cells for the animal
     */
    public List<String> possibleCellsFor(Animal animal){
        return null;
    }

    /**
     *
     * @param animal
     * @return if the zoo has the given animal in any of the cells
     */
    public boolean hasAnimal(Animal animal){
        return false;
    }

    /**
     *
     * @return the total space left in all cells
     */
    public int getTotalSpaceLeft(){
        return 0;
    }

    /**
     *
     * @return Map<String, Integer> where each entry is the cell name and the space left in it
     */
    public Map<String, Integer> getSpaceLeft(){
        return null;
    }

    /**
     *
     * @param cellName
     * @return the space left in the given cell
     */
    public int getSpaceLeftIn(String cellName){
        return 0;
    }
}