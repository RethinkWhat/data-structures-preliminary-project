package prelim;

import java.util.NoSuchElementException;

public class MyGrowingArrayList<T> implements MyList<T>{
    private int size = 5;
    private T[] arrayOfObjects = (T[]) new Object[size];

    private int pointer = 0;

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void insert(T data) throws ListOverflowException {
        if (arrayOfObjects[size-1] != null) {
            growArray();
        }
        arrayOfObjects[pointer] = data;
        pointer++;
    }

    @Override
    public T getElement(T data) throws NoSuchElementException{
        return arrayOfObjects[search(data)];
    }

    public T getElementAtIndex(int index) throws NoSuchElementException {
        return arrayOfObjects[index];
    }

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

    @Override
    public int search(T data) {
        for (int x=0;x<arrayOfObjects.length; x++)
            if (arrayOfObjects[x] == data)
                return x;
        return -1;
    }

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
