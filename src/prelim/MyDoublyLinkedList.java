package prelim;

/**
 * Class for Doubly Linked List
 * @param <T>
 */
public class MyDoublyLinkedList<T> {

    /**
     * Class variables
     */
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    // Variable to hold the number of nodes in the doubly linked list
    private int nodeCount = 0;

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

    /**
     * Method to get the node count
     * @return nodeCount
     */
    public int getNodeCount() {
        return nodeCount;
    }

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
    public void insertAtTail(T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        nodeCount++;
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
        nodeCount++;
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
            insertAtTail(data);
        } else {
            DoublyLinkedNode<T> after;
            after = tempPointer.getNext();

            tempPointer.setNext(newNode);
            newNode.setPrevious(tempPointer);

            newNode.setNext(after);

            after.setPrevious(newNode);
            nodeCount++;
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
        for (int x = 0; x < nodeCount-2; x++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(null);
        tail.setPrevious(null);
        tail = tempPointer;
        nodeCount--;
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
        nodeCount--;
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
        else if (index ==nodeCount-1)
            deleteAtTail();
        else {
            DoublyLinkedNode<T> middle = tempPointer.getNext();
            DoublyLinkedNode<T> after = middle.getNext();
            tempPointer.setNext(after);
            after.setPrevious(tempPointer);
            middle.setPrevious(null);
            middle.setNext(null);
            nodeCount--;
        }
    }


    /**
     * Method to return the list in string form
     * @return
     */
    @Override
    public String toString() {
        return "MyDoublyLinkedList{" +
                "\nhead=" + head +
                ",\ntail=" + tail +
                "\n}";
    }
}
