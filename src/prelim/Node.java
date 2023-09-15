/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */

package prelim;

public class Node<T> {

    //Declare class variables
    private T data;
    private Node<T> next;

    // Create default constructor
    public Node() {
        this.data = null;
        this.next = null;
    }

    /**
     * Constructor
     * Algorithm:
     *      1. Accept data as a parameter and pass it to the data class variable
     * @param data
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Method to get data
     * @return data : T
     */
    public T getData() {
        return data;
    }

    /**
     * Method to set the next node
     * @param node : Node<T>
     */
    public void setNext(Node<T> node) {
        next = node;
    }

    /**
     * Method to set the data of the node
     * @param data : T
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Method to get the next Node
     * @return next : Node<T>
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Method to return the data as a string
     * @return data : String
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
