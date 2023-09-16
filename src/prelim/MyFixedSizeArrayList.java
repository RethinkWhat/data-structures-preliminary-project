/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */
package prelim;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Class for the fixed size array list
 * @param <T>
 */
public class MyFixedSizeArrayList<T> implements MyList<T> {

    final private T[] arrayObject = (T[]) new Object[5]; // The list can only have five objects thus the usage of final
    private int indexCount = 0;

    /**
     * Method to get size of arrayObjects
     * @return
     */
    public int getSize() {
        return arrayObject.length;
    }

    /**
     * Method to handle inserting an object to list
     * Algorithm:
     *      1. If indexCount > 4 (an attempt to have 6 objects in list) throw error
     *      2. Else, Add object to list
     * @param data
     * @throws ListOverflowException
     */
    public void insert(T data) throws ListOverflowException {
        if (indexCount >4)
            throw new ListOverflowException();
        else {
            arrayObject[indexCount] = data;
            indexCount++;
        }
    }


    /**
     * Method to delete an object in list
     * Algorithm:
     *      1. Create a copy list
     *      2. Find delete index by calling search method
     *      3. Create a boolean to hold whether delete was done
     *      4. Iterate through the objects in the list and copy only those that do not equal the
     *      object to be deleted into the copy list
     *      5. Call the updateArray method and pass in the copied list
     *      6. -1 from the index count
     *      7. Return true if no issues arouse in deleting, else return false
     * @param deleteKey
     * @return
     */
    public boolean delete(T deleteKey) {
        final T[] copiedArray = (T[]) new Object[5];
        int deleteIndex = search(deleteKey);
        boolean deleteDone = false;
        if (deleteIndex!= -1) {
            for (int x = 0; x < arrayObject.length; x++) {
                if (x==deleteIndex) {
                    deleteDone = true;
                }
                if (x!= copiedArray.length-1) {
                    if (deleteDone)
                        copiedArray[x] = arrayObject[x + 1];
                    else {
                        copiedArray[x] = arrayObject[x];
                    }
                }
            }
            updateArray(copiedArray);
            indexCount--;
            return true;
        }
        return false;
    }

    /**
     * Method for search in list and returning index
     * Algorithm:
     *      1. Create a for loop to iterate through the objects of the list
     *      2. If the passed in search object equals any item in the list return the index
     *      3. Return -1
     * @param search
     * @return
     */
    public int search(T search) {
        for (int x =0; x <arrayObject.length; x++)
            if (arrayObject[x] == search) {
                return x;
            }
        return -1;

    }

    /**
     * Method to get element
     * Algorithm:
     *      1. Call the search method pass in data and check whether the object exists in arrayObject
     *          1.1. If object exists, return the data, else throw NoSuchElementException
     * @param data
     * @return
     * @throws NoSuchElementException
     */
    public T getElement(T data) throws NoSuchElementException{
        T toReturn = arrayObject[search(data)];
        if (toReturn == null)
            throw new NoSuchElementException();
        return toReturn;
    }

    /**
     * Method to get element at an index
     * @param index
     * @return
     */
    public T getElementAtIndex(int index) {
        return getElement(arrayObject[index]);
    }


    /**
     * Method to update arrayObject
     * Algorithm:
     *      1. Set arrayObject to null
     *      2. Copy the newArray objects to arrayObject
     * @param newArray
     */
    public void updateArray(T[] newArray) {
        for (int x=0; x< newArray.length; x++)
            arrayObject[x] = null;
        for (int x=0; x<arrayObject.length; x++)
            arrayObject[x] = newArray[x];
    }

    /**
     * Method to display all the objects in arrayObject
     */
    public void display() {
        int x= 1;
        for (Object object:this.arrayObject) {
            if (object!=null) {
                System.out.println("\t\t" + x + ". " + object);
                x++;
            }
        }
    }
}
