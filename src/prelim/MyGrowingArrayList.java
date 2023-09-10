package prelim;

import java.util.NoSuchElementException;

public class MyGrowingArrayList<T> implements MyList<T>{

    private int size = 5;
    private T[] arrayOfObjects = (T[]) new Object[size];

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void insert(T data) throws ListOverflowException {
        if (arrayOfObjects.length == size)
            growArray();

        arrayOfObjects[size] = data;
    }

    @Override
    public T getElement(T data) throws NoSuchElementException{
        return arrayOfObjects[search(data)];
    }

    @Override
    public boolean delete(T itemToDelete) {
        int indexOfDelete = search(itemToDelete);
        if (indexOfDelete == -1)
            return false;
        arrayOfObjects[indexOfDelete] = null;
        for (int x = indexOfDelete+1; x > arrayOfObjects.length-1; x++) {
            arrayOfObjects[x-1] = arrayOfObjects[x];
        }
        return true;
    }

    @Override
    public int search(T data) {
        for (int x=0;x<arrayOfObjects.length; x++)
            if (arrayOfObjects[x] == data)
                return x;
        return -1;
    }

    public void growArray() {
        T[] tempStore = (T[]) new Object[size];
        for (int x=0; x<size; x++)
            tempStore[x] = arrayOfObjects[x];

        this.size *=2;
        this.arrayOfObjects = (T[]) new Object[size];
        for(int x=0; x<size;x++)
            arrayOfObjects[x] = tempStore[x];
    }
}
