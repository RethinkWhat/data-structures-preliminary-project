/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */

package prelim;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {

    // Declare class variables
    private Node<T> head;
    private Node<T> tail;
    private int size=0;

    /**
     * Method to get the Node currently set as the head
     * @return head
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Method to get the Node currently set as the tail
     * @return tail
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Method to set the head of the linked list
     * @param head : Node
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * Method to set the tail of the linked list
     * @param tail : Node
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }


    /**
     * Method to get the Number of nodes in the linked list
     * @return nodesCount
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to insert a Node at the tail
     * Algorithm:
     *      1. Create a new Node object from the passed in data
     *      2. If the head is empty, then set the new node as the head
     *      3. Else call the setNext method of the tail and pass in the new Node
     *      4. Set the tail to the newNode
     *      5. Increment the nodesCount variable
     * @param data : T
     */
    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head==null) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
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
     * Method to insert a Node at the head
     * Algorithm:
     *      1. Create a new Node from the passed in data
     *      2. If head is null, then make the new node equal to the head, and set the tail to null
     *      3. Else, call the setNext method of the new node and pass in the head
     *      4. Increment the nodesCount variable
     * @param data : T
     */
    public void insertAtHead(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /**
     * Method to insert a Node at an index
     * Algorithm:
     *      1. Create a new Node from the passed in data
     *      2. Create a temporary pointer by creating a new Node equal to head
     *      3. Create a for loop to iterate till 1 before the index to insert the Node
     *              3.1. Move the temporary pointer variable to the next node using the getNext method
     *      4. If the index has the same value as the nodesCount (we will be inserting at the tail),
     *         call the insertAtHead method.
     *      5. If the index value is equal to 0 (we will be inserting at head), call the insertAtHead
     *         method.
     *      6. Otherwise, call the setNext method of the new node and set it to the next value of the
     *      temporary pointer and set the temporary pointer's next value to the new node.
     * @param index : int
     * @param data : T
     * @throws NullPointerException (Wrong index)
     */
    public void insertAtIndex(int index, T data) throws NullPointerException {
        Node<T> newNode = new Node<T>(data);
        Node<T> tempPointer = head;

        for (int x = 0; x < index - 1; x++) {
            tempPointer = tempPointer.getNext();
        }

        if (index == size)
            insert(data);
        else {
            if (index == 0) {
                insertAtHead(data);
            } else {
                Node<T> after = tempPointer.getNext();
                tempPointer.setNext(newNode);
                newNode.setNext(after);
                size++;
            }
        }
    }

    /**
     * Method to handle getting a Node at a specific index
     * Algorithm:
     *      1. Create a temporary Nde pointer and assign its value as head
     *      2. Create a for loop to iterate while passed in index is not reached
     *          2.1. Have the temporary pointer move to the next Node
     *      3. Return the temporary pointer
     * @param index : int
     * @return tempPointer
     * @throws NullPointerException (When the Node is not at index)
     */
    public Node<T> get(int index) throws NullPointerException {
        Node<T> tempPointer = head;
        for (int x = 0 ;x <index; x++) {
            tempPointer = tempPointer.getNext();
        }
        return tempPointer;
    }

    public Node<T> get(T Node) throws NullPointerException {
        Node<T> tempPointer = head;
        for (int x = 0 ;x <size; x++) {
            tempPointer = tempPointer.getNext();
        }
        return tempPointer;
    }

    /**
     * Method to delete the node which is currently the head
     * Algorithm:
     *      1. Create a temporary pointer node and have its value set to the value after the head
     *      2. Call the setNext method of the head and set it to null
     *      3. Set the temporary pointer at the head
     *      4. -1 from the nodesCount variable
     */
    public void deleteHead() {
        Node<T> tempPointer = head.getNext();
        head.setNext(null);
        head = tempPointer;
        size--;
    }

    /**
     * Method to delete a Node at tail
     * Algorithm:
     *      1. Create a temporary pointer Node and have it point to head
     *      2. Have a for loop iterate through nodes count -2
     *          2.1 Have the temporary pointer move to the next node
     *      3. Set the next value after the temporary pointer equal to null
     *      4. Set the tail equal to temporary pointer
     *      5. -1 from the nodesCount variable
     */
    public void deleteTail() {
        Node<T> tempPointer = head;
        for (int x=0;x<size-2;x++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(null);
        tail = tempPointer;
        size--;
    }

    /**
     * Method to delete a Node at a specified index
     * Algorithm:
     *      1. Create a Node pointer (temporary node)  and have its value set to head
     *      2. Create a for loop to iterate till the passed in index -1
     *          2.1. Have the Node pointer move to the next node
     *      3. Create another Node object and have its value set to the next value of
     *         the first pointer.
     *      4. Have the future pointer equal to the next Node of itself
     *      5.Call the setNext method of temporary node and set its value to future node
     *      6. -1 from nodesCount variable
     * @param index : int
     * @throws NullPointerException (index is invalid)
     */
    public void deleteAtIndex(int index) throws NullPointerException {
        Node<T> previousPointer = head;
        if (index==0)
            deleteHead();
        else if (index == size-1)
            deleteTail();
        else {
            for (int x = 0; x < index - 1; x++)
                previousPointer = previousPointer.getNext();

            Node<T> futurePointer = previousPointer.getNext();
            futurePointer = futurePointer.getNext();
            previousPointer.setNext(futurePointer);
            size--;
        }
    }

    /**
     * Method to display the head and tail of the linked list
     * @return String
     */
    @Override
    public String toString() {
        return "MySinglyLinkedList{" +
                "\nhead=" + head +
                ",\n\ntail=" + tail +
                "\n}";
    }
}
