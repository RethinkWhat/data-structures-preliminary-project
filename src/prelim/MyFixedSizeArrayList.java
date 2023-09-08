package prelim;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList implements MyList<Object> {

    final private Object[] arrayObject = new String[5];
    private int indexCount = 0;

    public int getSize() {
        return arrayObject.length;
    }

    public void insert(Object data) throws ListOverflowException {
        if (indexCount >4)
            throw new ListOverflowException("The number of elements in the list are already 5.");
        else {
            arrayObject[indexCount] = data;
            indexCount++;
        }
    }

    public boolean delete(Object deleteKey) {
        final Object[] copiedArray = new Object[5];
        int deleteIndex = search(deleteKey);
        if (deleteIndex!= -1) {
            for (int x = 0; x < arrayObject.length; x++)
                if (x != deleteIndex)
                    arrayObject[x] = copiedArray[x];
            updateArray(copiedArray);
            indexCount--;
            return true;
        }
        return false;
    }

    public int search(Object search) {
        for (int x =0; x <arrayObject.length; x++)
            if (arrayObject[x] == search)
                return x;
        return -1;
    }

    public Object getObject(int search) {
        return arrayObject[search];
    }

    public void updateArray(Object[] newArray) {
        Arrays.fill(arrayObject, null);
        System.arraycopy(arrayObject, 0, newArray, 0, newArray.length);
    }

    public void display() {
        int x= 1;
        for (Object object:this.arrayObject) {
            System.out.println(x + ". " + object);
            x++;
        }
    }


}
