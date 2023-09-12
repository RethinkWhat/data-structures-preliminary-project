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
        nodeCount++;
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
        nodeCount++;
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
        DoublyLinkedNode after;
        after = tempPointer.getNext();

        tempPointer.setNext(newNode);
        newNode.setPrevious(tempPointer);

        newNode.setNext(after);

        if (after!= null)
            after.setPrevious(newNode);
        nodeCount++;
    }

    public Object get(int index) {
        DoublyLinkedNode tempPointer = head;
        int x = 0;
        while (tempPointer.getNext()!= null) {
            if (x==index)
                return tempPointer.getData();
            tempPointer = tempPointer.getNext();
            x++;
        }
        return null;
    }

    public void deleteAtTail() throws NullPointerException {
        DoublyLinkedNode tempPointer = head;
        for (int x = 0; x < nodeCount-2; x++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(null);
        tail.setPrevious(null);
        tail = tempPointer;
        nodeCount--;
    }

    public void deleteAtHead() throws NullPointerException {
        DoublyLinkedNode tempPointer = head.getNext();
        head.setNext(null);
        tempPointer.setPrevious(null);
        head = tempPointer;
        nodeCount--;
    }

    public void deleteAtIndex(int index) throws NullPointerException {
        DoublyLinkedNode tempPointer = head;
        for (int x = 0; x<index-1;x++) {
            tempPointer = tempPointer.getNext();
        }
        DoublyLinkedNode middle = tempPointer.getNext();
        DoublyLinkedNode after = middle.getNext();
        tempPointer.setNext(after);
        if (after!= null)
            after.setPrevious(tempPointer);
        middle.setPrevious(null);
        middle.setNext(null);


    }


    @Override
    public String toString() {
        return "MyDoublyLinkedList{" +
                "\nhead=" + head +
                ",\ntail=" + tail +
                "\n}";
    }
}
