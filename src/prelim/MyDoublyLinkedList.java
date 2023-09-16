package prelim;

public class MyDoublyLinkedList<T> {

    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    private int nodeCount = 0;

    public DoublyLinkedNode<T> getHead() {
        return head;
    }

    public DoublyLinkedNode<T> getTail() {
        return tail;
    }

    public void setHead(DoublyLinkedNode<T> head) {
        this.head = head;
    }

    public void setTail(DoublyLinkedNode<T> tail) {
        this.tail = tail;
    }

    public int getNodeCount() {
        return nodeCount;
    }

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

    public void insertAtIndex(int index, T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        DoublyLinkedNode<T> tempPointer = head;
        if (head == null) {
            tail = newNode;
            head = newNode;
        } else {
            for (int x = 0; x < index - 1; x++)
                tempPointer = tempPointer.getNext();
        }
        if (index==0) {
            System.out.println("THIS IS TEMPPOINTER: " + tempPointer);
            insertAtHead(data);
        } else if (tempPointer == tail) {
            insertAtTail(data);
        } else {
            DoublyLinkedNode<T> after;
            after = tempPointer.getNext();

            tempPointer.setNext(newNode);
            newNode.setPrevious(tempPointer);

            newNode.setNext(after);

            if (after != null)
                after.setPrevious(newNode);
            nodeCount++;
        }
    }

    public Object get(int index) {
        DoublyLinkedNode<T> tempPointer = head;
        for (int x =0; x<index; x++)
            tempPointer = tempPointer.getNext();
        return tempPointer;
    }

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

    public void deleteAtHead() throws NullPointerException {
        DoublyLinkedNode<T> tempPointer = head.getNext();
        head.setNext(null);
        tempPointer.setPrevious(null);
        head = tempPointer;
        nodeCount--;
    }

    public void deleteAtIndex(int index) throws NullPointerException {
        DoublyLinkedNode<T> tempPointer = head;
        for (int x = 0; x<index-1;x++) {
            tempPointer = tempPointer.getNext();
        }
        DoublyLinkedNode<T> middle = tempPointer.getNext();
        DoublyLinkedNode<T> after = middle.getNext();
        tempPointer.setNext(after);
        if (after!= null)
            after.setPrevious(tempPointer);
        middle.setPrevious(null);
        middle.setNext(null);
        nodeCount--;
    }


    @Override
    public String toString() {
        return "MyDoublyLinkedList{" +
                "\nhead=" + head +
                ",\ntail=" + tail +
                "\n}";
    }
}
