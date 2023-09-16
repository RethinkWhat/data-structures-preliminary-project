package prelim;

import java.util.NoSuchElementException;
import java.util.function.DoublePredicate;

/**
 * Class for a Circular Linked List
 * @param <T>
 */
public class MyDoublyLinkedCircularList<T> implements MyList<T> {

    /** Class Variables */
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    private int size = 0; // Variable to hold the total nodes in the linked list


    /**
     * Method to get head
     * @return head
     */
    public DoublyLinkedNode<T> getHead(){
        return head;
    }

    /**
     * Method to get the tail
     * @return tail
     */
    public DoublyLinkedNode<T> getTail() {
        return tail;
    }

    /**
     * Method to get the total node count
     * @return nodeCount
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to set the head
     * @param head : DoublyLinkedNode<T>
     */
    public void setHead(DoublyLinkedNode<T> head) {
        this.head = head;
    }

    /**
     * Method to set the tail
     * @param tail : DoublyLinkedNode<T>
     */
    public void setTail(DoublyLinkedNode<T> tail) {
        this.tail = tail;
    }

    /**
     * Method to get the node at the passed in index
     * Algorithm:
     *      1. Create a temporary pointer node and set its value to head
     *      2. Create a for loop to traverse through the linked list
     *          2.1. If the number of nodes traversed equals the index return the temporary pointer node
     *          2.1. Set temporary pointer node equal to the next node in the linked list
     * @param index : int
     * @return node
     */
    public DoublyLinkedNode<T> get(int index) {
        DoublyLinkedNode<T> tempPointer = head;
        for (int x =0; x<=index;x++) {
            if (x == index)
                return tempPointer;
            tempPointer = tempPointer.getNext();
        }
        return null;
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
        DoublyLinkedNode<T> tempPointer = head;
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
        DoublyLinkedNode<T> tempNode = head;
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
        DoublyLinkedNode<T> tempPointer = head;
        for (int x = 0; x<size; x++) {
            if (tempPointer.getData() == data)
                return x;
            tempPointer = tempPointer.getNext();
        }
        return -1;
    }

    /**
     * Method to add a node at head
     * Algorithm:
     *      1. Create a new node given the data passed in
     *      2. If the head is null, set the new node as head and tail
     *      3. Else,
     *          3.1. Set the next node of new node as head
     *          3.2. Set the previous node of head as the new node
     *          3.3. Set the new node as head
     *          3.4. Set the previous node of head as tail
     *          3.5. Set the next node of tail as head
     *      4. Increment the node count
     * @param data
     */
    public void addAtHead(T data){
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("called");
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            head.setPrevious(tail);
            tail.setNext(head);
        }
        size++;
    }

    @Override
    /**
     * Method to add a node at tail
     * Algorithm:
     *      1. Create a new node given the data passed in
     *      2. If the head is null, set head and tail equal to new node
     *      3. Else,
     *          3.1. Set the set next node of tail equal to new node
     *          3.2. Set the previous node of the new node equal to tail
     *          3.3. Set the next node of the new node equal to head
     *          3.4. Set the previous node of head equal to the new Node
     *          3.5. Set the new Node as the tail
     *      4. Increment the node count
     * @param data : T
     */
    public void insert(T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            newNode.setNext(head);
            head.setPrevious(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Method to add at an index
     * Algorithm:
     *      1. Create a new node given the data passed in
     *      2. If the index is equal to 0 call addAtHead
     *      3. If the index is equal to nodeCount call addAtTail
     *      4. Else,
     *          4.1. Create a temporary node pointer object and set its value to head
     *          4.2. Create a for loop to iterate 1 less than passed in index
     *                  4.2.1. Have temp pointer move to the next node in the linked list
     *          4.3. Create an after node and set its value to the next value after the temp node
     *          4.4. Set the next node of the temp pointer equal to the new node
     *          4.5. Set the new node's previous node equal to the temp pointer
     *          4.6. Set the next node after the new node equal to the node after
     *          4.7. Set the after node's previous node equal to the new node
     *          4.8. Increment the node count
     * @param index : int
     * @param data : T
     */
    public void addAtIndex(int index, T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (index == 0) {
            addAtHead(data);
        } else if (index == size)
            insert(data);
        else {
            DoublyLinkedNode<T> tempPointer = head;
            for (int x = 0; x < index - 1; x++) {
                tempPointer = tempPointer.getNext();
            }
            DoublyLinkedNode<T> after = tempPointer.getNext();
            tempPointer.setNext(newNode);
            newNode.setPrevious(tempPointer);
            newNode.setNext(after);
            after.setPrevious(newNode);
            size++;
        }
    }

    /**
     * Method to delete node at head
     * Algorithm:
     *      1. Create a temporary node pointer object and set its value to head
     *      2. Set the previous node of the head equal to tail
     *      3. Set the next node after tail equal to the temporary pointer node
     *      4. Set the next node of head equal to null
     *      5. Set the previous node of the head node equal to null
     *      6. Set the temporary pointer as the new head
     *      7. -1 from the total node count
     * @throws NullPointerException
     */
    public void deleteHead() throws NullPointerException {
        DoublyLinkedNode<T> tempPointer = head.getNext();
        head.setPrevious(tail);
        tail.setNext(tempPointer);
        head.setNext(null);
        head.setPrevious(null);
        head = tempPointer;
        size--;
    }

    /**
     * Method to delete a node at the tail
     * Algorithm:
     *      1. Create a temporary node pointer object and set its value to head
     *      2. Have the tempo node traverse the linked list till the last node not equal tail
     *          2.1. Set the temporary pointer node equal the next node in the list
     *      3. Set the next node of the temp pointer equal to head
     *      4. Set the previous node of the head equal to the temp node
     *      5. Set the previous and next node of tail equal to null
     *      6. Set the temp node as the new tail
     *      7. -1 from total node count
     * @throws NullPointerException
     */
    public void deleteTail() throws NullPointerException {
        DoublyLinkedNode<T> newTail = head;
        while (newTail.getNext() != tail) {
            newTail = newTail.getNext();
        }
        newTail.setNext(head);
        head.setPrevious(newTail);
        tail.setPrevious(null);
        tail.setNext(null);
        tail = newTail;
        size--;
    }

    /**
     * Method to delete node at a specified index
     * @param index
     * @throws NullPointerException
     * Algorithm:
     *      1. If passed in index = 1, call deleteHead method
     *      2. If passed in index = nodeCount -1 call deleteTail method
     *      3. Else,
     *          3.1. Create a temporary node pointer object and set its value to head
     *          3.2. Create a for loop and have it increment till 1 less than passed in index
     *              3.2.1. Have temp node equal to the next node on the linked list
     *          3.3. Create a node to delete which is the next node of the temp pointer node
     *          3.4. Create a node to hold the node after the node to be deleted
     *          3.5. Set the next node after temp pointer equal to the after variable
     *          3.6. Set the previous and next of the node to delete equal to null
     *          3.7. Set the previous node of after equal to the temp pointer
     *          3.8. -1 from total node count
     */
    public void deleteAtIndex(int index) throws NullPointerException {

        if (index == 0)
            deleteHead();
        if (index == size - 1)
            deleteTail();
        else {
            DoublyLinkedNode<T> tempPointer = head;
            for (int x = 0; x < index - 1; x++)
                tempPointer = tempPointer.getNext();
            DoublyLinkedNode<T> toDelete = tempPointer.getNext();
            DoublyLinkedNode<T> after = toDelete.getNext();
            tempPointer.setNext(after);
            toDelete.setPrevious(null);
            toDelete.setNext(null);
            after.setPrevious(tempPointer);
            size--;
        }

    }


}
