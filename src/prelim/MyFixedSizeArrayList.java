package prelim;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList implements MyList {

    final private Object[] arrayObject = new Object[5]; // The list can only have five objects thus the usage of final
    private int indexCount = 0;

    public int getSize() {
        return arrayObject.length;
    }

    public void insert(Object data) throws ListOverflowException {
        if (indexCount >4)
            throw new ListOverflowException();
        else {
            arrayObject[indexCount] = data;
            indexCount++;
        }
    }


    public boolean delete(Object deleteKey) {
        final Object[] copiedArray = new Object[5];
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

    public int search(Object search) {
        for (int x =0; x <arrayObject.length; x++)
            if (arrayObject[x] == search) {
                return x;
            }
        return -1;

    }

    public Object getElement(Object data) throws NoSuchElementException{
        return arrayObject[search(data)];
    }

    public Object getElementAtIndex(int index) throws NoSuchElementException {
        return getElement(arrayObject[index]);
    }


    public void updateArray(Object[] newArray) {
        for (int x=0; x< newArray.length; x++)
            arrayObject[x] = null;
        for (int x=0; x<arrayObject.length; x++)
            arrayObject[x] = newArray[x];
    }

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
