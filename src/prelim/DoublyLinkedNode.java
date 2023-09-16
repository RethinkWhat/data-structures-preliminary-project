/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */

package prelim;

/**
 * Class for a doubly linked node
 * @param <T>
 */
public class DoublyLinkedNode<T> {

    /** Class variables */
    private T data;
    private DoublyLinkedNode<T> next;
    private DoublyLinkedNode<T> previous;


    /**
     * Default Constructor
     */
    public DoublyLinkedNode() {
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    /**
     * Constructor
     * @param data
     */
    public DoublyLinkedNode(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    /**
     * Getter
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * Getter
     * @return next
     */
    public DoublyLinkedNode<T> getNext(){
        return next;
    }

    /**
     * Getter
     * @return previous
     */
    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    /**
     * Setter
     * @param data : T
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Setter
     * @param next : DoublyLinkedNode<T>
     */
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    /**
     * Setter
     * @param previous : DoublyLinkedNode<T>
     */
    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    /**
     * String representation of Node
     * @return  String representation
     */
    public String toString() {
        return data.toString();
    }

}
