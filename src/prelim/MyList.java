/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */
package prelim;
import java.util.NoSuchElementException;

/** List Interface */
public interface MyList<E>{
    public int getSize();
    public void insert(E data) throws ListOverflowException;
    public E getElement(E data) throws NoSuchElementException;
    public boolean delete (E data); //returns false if the data is not deleted in the list
    public int search (E data); // returns index of data, else -1 is returned
}
