package prelim;

import java.util.NoSuchElementException;

/**
 * Class for Doubly Linked List
 * @param <T>
 */
public class MyDoublyLinkedList<T> implements MyList<T>{

    /**
     * Class variables
     */
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    // Variable to hold the number of nodes in the doubly linked list
    private int size = 0;

    /**
     * Method to get the head
     * @return head
     */
    public DoublyLinkedNode<T> getHead() {
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
     * Method to set the head
     * @param head : DoublyLinkedNode<T>
     */
    public void setHead(DoublyLinkedNode<T> head) {
        this.head = head;
    }

    /**
     * Method to set the tail
     * @param tail : DoublyLinkedNode<T></T>
     */
    public void setTail(DoublyLinkedNode<T> tail) {
        this.tail = tail;
    }

    @Override
    /**
     * Method to get the node count
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


    @Override
    /**
     * Method to insert at tail
     * Algorithm:
     *      1. Create a DoublyLinkedNode object and pass in data as a parameter.
     *      2. If the head is null set the new node as head.
     *      3. Else, set the new node of the tail equal to the new node and set the
     *      previous node of the new node as tail.
     *      4. Make tail equal to the new node.
     *      5. Increment node count
     * @param data : T
     */
    public void insert(T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        size++;
    }

    /**
     * Method to insert at head
     * Algorithm:
     *      1. Create a DoublyLinkedNode object and pass in data as a parameter.
     *      2. If head is empty set the tail equal to new node
     *      3. Else, set the next node of the new node equal to head and set the
     *      previous node of the head equal to new node.
     *      4. Set head equal to the new node
     *      5. Increment node count
     * @param data : T
     */
    public void insertAtHead(T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (head == null)
            tail = newNode;
        else {
            newNode.setNext(head);
            head.setPrevious(newNode);
        }
        head = newNode;
        size++;
    }

    /**
     * Method to insert a node at an index
     * Algorithm:
     *      1.  Create a DoublyLinkedNode object and pass in data as a parameter.
     *      2. Create a temporary pointer node
     *      3. Create a for loop to iterate the temporary pointer till 1 before the specified index
     *      4. If the index is equal to 0 call insertAtHead method
     *      5. If the temporary pointer is pointing at tail call insertAtTail method
     *      6. Else,
     *          6.1. Create a node to hold the node after the index
     *          6.2. Set temp pointer's next node equal to the new node
     *          6.3. Set the previous node of the new node equal to temp pointer
     *          6.4. Set the next node after new node equal to the node made earlier to hold the node after the index
     *          6.5. Set the previous node of the after node equal to the new node
     * @param index
     * @param data
     */
    public void insertAtIndex(int index, T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        DoublyLinkedNode<T> tempPointer = head;
        for (int x = 0; x < index - 1; x++)
            tempPointer = tempPointer.getNext();

        if (index == 0) {
            insertAtHead(data);
        } else if (tempPointer == tail) {
            insert(data);
        } else {
            DoublyLinkedNode<T> after;
            after = tempPointer.getNext();

            tempPointer.setNext(newNode);
            newNode.setPrevious(tempPointer);

            newNode.setNext(after);

            after.setPrevious(newNode);
            size++;
        }
    }

    /**
     * Method to get a node at an index
     * Algorithm:
     *      1. Create a temporary doubly linked node object and set its value to head
     *      2. Iterate through the linked list the passed in index number of times
     *          2.1 Have the temporary pointer node move to the new Node
     *      3. Return the temporary pointer
     * @param index : int
     * @return DoublyLinkedNode
     */
    public DoublyLinkedNode<T> get(int index) {
        DoublyLinkedNode<T> tempPointer = head;
        for (int x =0; x<index; x++)
            tempPointer = tempPointer.getNext();
        return tempPointer;
    }

    /**
     * Method to delete node at tail
     * @throws NullPointerException
     * Algorithm:
     *      1. Create a node temporary pointer object, have its value set to head
     *      2. Create a for loop and have pointer traverse till one less than the tail and have temp pointer point to next node.
     *      3. Set the next node of the temporary pointer equal to null
     *      4. Set the previous node of the tail equal to null
     *      5. Set the tail equal to the temporary pointer
     *      6. -1 from the total node count
     */
    public void deleteAtTail() throws NullPointerException {
        DoublyLinkedNode<T> tempPointer = head;
        for (int x = 0; x < size-2; x++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(null);
        tail.setPrevious(null);
        tail = tempPointer;
        size--;
    }

    /**
     * Method to delete a node at head
     * Algorithm:
     *      1. Create a temporary node pointer object and set its value to the next node after head
     *      2. Set the next node of head equal to null
     *      3. Set the previous node of the temporary pointer equal to null
     *      4. Set the head equal to the temporary pointer
     *      5. -1 from the total node count
     * @throws NullPointerException
     */
    public void deleteAtHead() throws NullPointerException {
        DoublyLinkedNode<T> tempPointer = head.getNext();
        head.setNext(null);
        tempPointer.setPrevious(null);
        head = tempPointer;
        size--;
    }

    /**
     * Method to delete a node at an index
     * Algorithm:
     *      1. Create a temporary node pointer object and set its value to the next node after head
     *      2. Create a for loop and have pointer traverse till one less than the tail and have temp pointer point to next node.
     *      3. If index = 0 call deleteAtHead method
     *      4. If index = total node count -1 call deleteAtTail method
     *      5. Create an object to hold the node to be deleted and another to hold the object after it
     *      6. Set the temporary pointer's next node equal to node to the after node
     *      7. Set the after node's previous node equal to the temporary pointer
     *      8. Set middle previous and after node equal to null
     *      8. -1 from total node count
     * @param index
     * @throws NullPointerException
     */
    public void deleteAtIndex(int index) throws NullPointerException {
        DoublyLinkedNode<T> tempPointer = head;
        for (int x = 0; x<index-1;x++) {
            tempPointer = tempPointer.getNext();
        }
        if (index ==0)
            deleteAtHead();
        else if (index ==size-1)
            deleteAtTail();
        else {
            DoublyLinkedNode<T> middle = tempPointer.getNext();
            DoublyLinkedNode<T> after = middle.getNext();
            tempPointer.setNext(after);
            after.setPrevious(tempPointer);
            middle.setPrevious(null);
            middle.setNext(null);
            size--;
        }
    }


    /**
     * Method to return the list in string form
     * @return String
     */
    @Override
    public String toString() {
        return "MyDoublyLinkedList{" +
                "\nhead=" + head +
                ",\ntail=" + tail +
                "\n}";
    }
}
