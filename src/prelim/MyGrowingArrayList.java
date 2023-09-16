/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */
package prelim;

import java.util.NoSuchElementException;

/**
 * Class for my growing array list
 * @param <T>
 */
public class MyGrowingArrayList<T> implements MyList<T>{
    private int size = 5; // starting size of list
    private T[] arrayOfObjects = (T[]) new Object[size]; // holds objects

    private int pointer = 0;

    @Override
    /**
     * Method to get size
     */
    public int getSize(){
        return size;
    }

    /**
     * Method to insert object
     * Algorithm:
     *      1. If list is full call growArray method
     *      2. Add object to list
     *      3. Increment pointer
     * @param data
     * @throws ListOverflowException
     */
    @Override
    public void insert(T data) throws ListOverflowException {
        if (arrayOfObjects[size-1] != null) {
            growArray();
        }
        arrayOfObjects[pointer] = data;
        pointer++;
    }

    /**
     * Getter
     * @param data
     * @return object
     * @throws NoSuchElementException
     */
    @Override
    public T getElement(T data) throws NoSuchElementException{
        return arrayOfObjects[search(data)];
    }

    /**
     * Getter
     * @param index
     * @return object
     * @throws NoSuchElementException
     */
    public T getElementAtIndex(int index) throws NoSuchElementException {
        return arrayOfObjects[index];
    }

    /**
     * Method to delete item
     * Algorithm:
     *      1. Find index of item to delete
     *      2. Set its value to null
     *      3. Move every other object one step to the left
     *      4. -1 from the pointer
     *      5. Return true
     * @param itemToDelete
     * @return
     */
    @Override
    public boolean delete(T itemToDelete) {
        int indexOfDelete = search(itemToDelete);
        if (indexOfDelete == -1)
            return false;
        arrayOfObjects[indexOfDelete] = null;
        for (int x = indexOfDelete+1; x < size; x++) {
            arrayOfObjects[x-1] = arrayOfObjects[x];
        }
        pointer--;
        return true;
    }

    /**
     * Method to search for an object in a list and return its index
     * Algorithm:
     *      1. Iterate through objects
     *      2. If object exists return its index
     * @param data
     * @return
     */
    @Override
    public int search(T data) {
        for (int x=0;x<arrayOfObjects.length; x++)
            if (arrayOfObjects[x] == data)
                return x;
        return -1;
    }

    /**
     * Method to double size of arrayOfObjects
     * Algorithm:
     *      1. Create a new Object to store current arrayOfObjects objects
     *      2. Reinstantiate arrayOfObjects with double the size
     *      3. Copy the objects back to arrayOfObjects
     */
    public void growArray() {
        int oldSize = size;
        T[] tempStore = (T[]) new Object[oldSize];
        for (int x=0; x<size; x++)
            tempStore[x] = arrayOfObjects[x];

        this.size *=2;
        this.arrayOfObjects = (T[]) new Object[size];
        for(int x=0; x< oldSize;x++)
            arrayOfObjects[x] = tempStore[x];
    }

    /**
     * Method to display all objects to user
     */
    public void display() {
        int x = 1;
        for (T object: arrayOfObjects) {
            if (object!= null) {
                System.out.println(x + ". " + object);
                x++;
            }
        }
    }

}
