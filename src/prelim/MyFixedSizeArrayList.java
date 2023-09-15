package prelim;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList<E> implements MyList<E> {

    final private E[] arrayObject = (E[]) new Object[5]; // The list can only have five objects thus the usage of final
    private int indexCount = 0; // To count number of objects CURRENTLY in the list and not null

    /**
     * Method to get number of objects in the list
     * @return
     */
    public int getSize() {
        return indexCount;
    }

    /**
     * Method to insert an object in a list.
     * Algorithm:
     *      1. If the indexCount or the number of items in the list exceed 4 (count 0) throw an error
     *      2. Else add the item to the arrayObject list
     *      3. Increment the index count
     * @param data
     * @throws ListOverflowException
     */
    public void insert(E data) throws ListOverflowException {
        if (indexCount >4)
            throw new ListOverflowException();
        else {
            arrayObject[indexCount] = data;
            indexCount++;
        }
    }


    /**
     * Method to delete an object in a list
     * Algorithm:
     *      1. Create an array to hold the updated list with a deleted element.
     *      2. Call search method and pass in the delete key
     *      3. Create a boolean variable to check if delete has been completed
     *      4. Create an if statement to check whether the delete index is -1, if it is return false
     *      5. Else, create a for loop to iterate through the objects of arrayObject
     *      6. If the object exists set deleteDone to true
     *      7. While the pointer is not on the item to be deleted copy it to new array object to hold the copied array
     * @param deleteKey
     * @return
     */
    public boolean delete(E deleteKey) {
        final E[] copiedArray = (E[]) new Object[5];
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
     * Method to search for an object in an array of objects
     * Algorithm:
     *      1. Create a for loop to iterate through the exists objects in arrayObject
     *      2. If an object matches the passed in parameter return its index
     *      3. Else return -1
     * @param search
     * @return
     */
    public int search(E search) {
        for (int x =0; x <arrayObject.length; x++)
            if (arrayObject[x] == search) {
                return x;
            }
        return -1;

    }

    public E getElement(E data) throws NoSuchElementException{
        return arrayObject[search(data)];
    }

    /**
     * Algorithm:
     *      1. Return the arrayObject at specified index
     * @param index
     * @return
     * @throws NoSuchElementException
     */
    public E getElementAtIndex(int index) throws NoSuchElementException {
        return getElement(arrayObject[index]);
    }

    /**
     * Method to update the state of arrayObject with a passed in new array
     * Algorithm:
     *      1. Create a for loop to iterate through the arrayObjects elements and set each value to null
     *      2. Create a for loop and assign the new values to arrauObject
     * @param newArray
     */
    public void updateArray(E[] newArray) {
        for (int x=0; x< newArray.length; x++)
            arrayObject[x] = null;
        for (int x=0; x<arrayObject.length; x++)
            arrayObject[x] = newArray[x];
    }

    /**
     * Method to display the objects in the array
     * Algorithm:
     *      1. Create a for loop to iterate through all the objects
     *      2. If object content is not all then display its content
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
