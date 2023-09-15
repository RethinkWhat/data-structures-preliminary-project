package prelim;

import java.util.NoSuchElementException;

public class MyGrowingArrayList<T> implements MyList<T>{
    private int size = 5;                                       // Set the initial length of the array list
    private T[] arrayOfObjects = (T[]) new Object[size];        // Set the arrayOfObjects length equal to the size object

    private int pointer = 0;                                    // An increment variable to hold number of existing values in array

    @Override
    /**
     * Method to return the size of the arrayOfObjects
     */
    public int getSize(){
        return size;
    }

    @Override
    /**
     * Method to insert an object to the array of objects
     * Method:
     *      1. If arrayOfObjects is at max capacity, wherein there is no
     *      longer any null space to insert an object call growArray method.
     *      2. Add new data to the index of the pointer
     *      3. Increment pointer
     */
    public void insert(T data) throws ListOverflowException {
        if (arrayOfObjects[size-1] != null) {
            growArray();
        }
        arrayOfObjects[pointer] = data;
        pointer++;
    }

    /**
     * Method to get element in a list
     * @param data
     * @return
     * @throws NoSuchElementException
     * Algorithm:
     *      1. Call the search method get the index of the passed in object in the list
     *      2. Pass in the index to the arrayOfObjects and return it
     */
    @Override
    public T getElement(T data) throws NoSuchElementException{
        return arrayOfObjects[search(data)];
    }

    /**
     * Returns the element found at a passed in index
     * @param index
     * @return
     * @throws NoSuchElementException
     */
    public T getElementAtIndex(int index) throws NoSuchElementException {
        return arrayOfObjects[index];
    }

    /**
     *
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
     *
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
     * Method to grow the arraw
     * Algorithm:
     *      1. Create a 
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
     * Method to display all the objects of the array of objects
     * Algorithm:
     *      1. Create a for loop to iterate through all the objects of the array of objects
     *      2. If object is not null display it
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
