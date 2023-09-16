/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */
package prelim;

import java.util.NoSuchElementException;

/**
 * Class for a Singly Linked Circular List
 * @param <T>
 */
public class MySinglyLinkedCircularList<T> implements MyList<T>{

    /** Class variables */
    private Node<T> head;
    private Node<T> tail;

    // Variable to hold the number of nodes in the linked list
    private int size = 0;


    /**
     * Method to get the head
     * @return head
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Method to get the tail
     * @return tail
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Method to set the tail
     * @param head : Node<T>
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * Method to set the tail
     * @param tail : Node<T>
     */
    public void setTail(Node<T> tail) {
        this.tail = head;
    }

    /**
     * Method to get the total number of nodes
     * @return nodeCount
     */
    public int getSize() {
        return size;
    }


    /**
     * Method to get element given a passed in data
     * Algorithm:
     *      1. Create a tempPointer object and set it to head
     *      2. Create a for loop to traverse all nodes in linked list
     *          2.1. If tempPointer data equals passed in data return the data
     *          2.2 Have tempPointer equal to the next node in the list
     *      3. If for loop is exited  throw NoSuchElementException
     * @param data :T
     * @return
     * @throws NoSuchElementException
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        Node<T> tempPointer = head;
        for (int x=0; x<size; x++) {
            if(tempPointer.getData()==data)
                return tempPointer.getData();
            tempPointer = tempPointer.getNext();
        }
        throw new NoSuchElementException();
    }

    /**
     * Method to delete an object given a passed in datum
     * Algorithm:
     *      1. Create a tempPointer object and set it to head
     *      2. Create a for loop to traverse all nodes in linked list
     *          2.1. If tempPointer data equals passed in data
     *                  2.2. Call deleteAtIndex method and pass in x
     *                  2.3. Return true
     *          2.2. Set temNode equal to next node in list
     *      3. If for loop is exited return false
     * @param data : T
     * @return deleteConfirmation
     */
    @Override
    public boolean delete(T data) {
        Node<T> tempNode = head;
        for (int x=0; x<size; x++) {
            if(tempNode.getData() == data) {
                deleteAtIndex(x);
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }

    /**
     * Method to search for object index given data
     * Algorithm:
     *      1. Create a tempPointer object and set it to head
     *      2. Create a for loop to traverse all nodes in linked list
     *          2.1. If tempPointer data equals passed in data return x
     *      3. Have temp Pointer object equal next node in list
     *      4. Return -1 if object exits for loops
     * @param data : T
     * @return index
     */
    @Override
    public int search(T data) {
        Node<T> tempPointer = head;
        for (int x = 0; x<size; x++) {
            if (tempPointer.getData() == data)
                return x;
            tempPointer = tempPointer.getNext();
        }
        return -1;
    }


    /**
     * Method to get  Node at a passed in index
     * Algorithm:
     *      1. Create a temporary pointer node
     *      2. Iterate through all nodes in the linked list using a for loops
     *          2.1. If index equals the number of iterations done return the temporary pointer node
     *          2.2. Set the temporary pointer node equal to the next node in the list
     * @param index : int
     * @return node indexed
     */
    public Node<T> get(int index) {
        Node<T> tempPointer = head;
        for (int x = 0; x < size; x++){
            if (x==index)
                return tempPointer;
            tempPointer = tempPointer.getNext();
        }
        return null;
    }

    /**
     * Method to add node at head
     * Algorithm:
     *      1. Create a new Node and insert the passed in datum
     *      2. If head is null set head and tail equal to null
     *      3. Else, set the node after the new node equal to head
     *      4. Set new node as the head
     *      5. Set the next node of the tail equal to head
     *      6. Increment node count
     * @param datum : T
     */
    public void addAtHead(T datum) {
        Node<T> newNode = new Node<T>(datum);

        if (head==null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
        size++;
    }

    /**
     * Method to add a new node at tail
     * Algorithm:
     *      1. Create a new node and insert the passed in datum as a parameter
     *      2. If the head is null set head equal to the new node
     *      3. Else, set next node of  tail as the new node and set new node of new node as head
     *      4. Set new node as the tail
     *      5. Increment nodeCount by 1
     * @param datum
     */
    public void insert(T datum) {
        Node<T> newNode = new Node<>(datum);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setNext(head);
        }
        tail = newNode;
        size++;
    }

    /**
     * Method to delete a node at index
     * Algorithm:
     *      1. Create a new node and insert the passed in datum as a parameter
     *      2. If the passed in index is equal to 0 call insertAtHead
     *      3. If the passed in index is equal to nodeCount call insertAtTail
     *      4. Else,
     *          4.1. Create a temporary node pointer and set its value to head
     *          4.2. Create a for loop to iterate one less than the passed in index
     *              4.2.1. Have the temporary node move to the next node
     *          4.3. Create a variable to hold the after where the new node will be inserted
     *          4.4. Set the next node of the temporary pointer equal to the new node
     *          4.5. Set the next node after the new node equal to the variable after
     *          4.6. Increment node count
     * @param index : int
     * @param datum : T
     */
    public void addAtIndex(int index, T datum) {
        Node<T> newNode = new Node<>(datum);
        if (index == 0) {
            addAtHead(datum);
        } else if (index == size) {
            insert(datum);
        }
        else {
            Node<T> tempPointer = head;
            for (int x = 0; x < index - 1; x++) {
                tempPointer = tempPointer.getNext();
            }
            Node<T> after = tempPointer.getNext();
            tempPointer.setNext(newNode);
            newNode.setNext(after);
            size++;
        }
    }

    /**
     * Method to delete node at head
     * Algorithm:
     *      1. Create a temporary pointer node equal to the node after head
     *      2. Set the tail equal to the temporary pointer
     *      3. Set the temporary pointer as head
     *      4. -1 from the node count
     * @throws NullPointerException
     */
    public void deleteHead() throws NullPointerException{
        Node<T> tempPointer = head.getNext();
        tail.setNext(tempPointer);
        head = tempPointer;
        size--;
    }

    /**
     * Method to delete node at tail
     * Algorithm:
     *      1. Create a temporary pointer node equal to the tail
     *      2. Create a loop to iterate while the next node after tempPointer is not equal to null
     *          2.1. Set the tempNode equal to the node after itself
     *      3. Set the next node after tail equal to null
     *      4. Set the tail equal to the temp pointer
     *      5. Set the next node after temp pointer equal to head
     *      6. Minus 1 from the node count
     * @throws NullPointerException
     */
    public void deleteTail() throws NullPointerException{
        Node<T> tempPointer = tail;
        while (tempPointer.getNext()!=tail) {
            tempPointer = tempPointer.getNext();
        }
        tail.setNext(null);
        tail = tempPointer;
        tempPointer.setNext(head);
        size--;
    }

    /**
     * Method to delete node at a passed in index
     * Algorithm:
     *      1. If the passed in index = 0 call deleteHead method
     *      2. If the passed in index = nodeCount -1 call deleteTail method
     *      3. Else, create a temporary Node pointer object and set its value to head
     *      4. Create a for loop and traverse the linked list 1 less than the passed in index
     *      5. Create a node object to hold object to delete (1 after traversed)
     *      6. Create a node object to hold object after node to delete( 1 after to delete)
     *      7. Set the next node of to delete equal to null
     *      8. Set the temporary pointer's next Node equal to after
     *      9. -1 from total node count
     * @param index : int
     * @throws NullPointerException
     */
    public void deleteAtIndex(int index) throws NullPointerException{

        if (index == 0) {
            deleteHead();
        } else if (index== size-1)
            deleteTail();
        else {
            Node<T> tempPointer = head;
            for (int x=0; x<index-1; x++)
                tempPointer = tempPointer.getNext();
            Node<T> toDelete = tempPointer.getNext();
            Node<T> after = toDelete.getNext();
            toDelete.setNext(null);
            tempPointer.setNext(after);
            size--;
        }
    }
}
