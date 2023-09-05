package prelim;

import java.util.NoSuchElementException;

public class MyFixedSizeArrayList implements MyList<Object>{

    private Object[] arrayObject = new String[5];
    private int indexCount = 0;

    public int getSize() {
        return arrayObject.length;
    }

    public void insert(Object data) {
        arrayObject[indexCount] = data;
        indexCount ++;
    }

    //public Object getElements(Object data) throws NoSuchElementException {}

    /** UNFINISHED **/
    public boolean delete(Object deleteKey) {
        for (Object obj: arrayObject) {
            if (obj == deleteKey)
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
}
