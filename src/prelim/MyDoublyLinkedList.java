package prelim;

public class MyDoublyLinkedList<T> {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public int nodeCount = 0;

    public DoublyLinkedNode getHead() {
        return head;
    }

    public DoublyLinkedNode getTail() {
        return tail;
    }

    public void setHead(DoublyLinkedNode head) {
        this.head = head;
    }

    public void setTail(DoublyLinkedNode tail) {
        this.tail = tail;
    }

    public void insertAtTail(T data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
    }

    public void insertAtHead(T data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if (head == null)
            tail = newNode;
        else {
            newNode.setNext(head);
            head.setPrevious(newNode);
        }
        head = newNode;
    }

    public void insertAtIndex(int index, T data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        DoublyLinkedNode tempPointer = head;
        if (head == null) {
            tail = newNode;
            head = newNode;
        } else {
            for (int x = 0; x < index - 1; x++)
                tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(newNode);
        newNode.setPrevious(tempPointer);
        newNode.setNext(tempPointer.getNext());
        tempPointer.getNext().setPrevious(newNode);


    }


    @Override
    public String toString() {
        return "MyDoublyLinkedList{" +
                "\nhead=" + head +
                ",\ntail=" + tail +
                '}';
    }
}
