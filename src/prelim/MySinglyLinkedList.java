package prelim;

public class MySinglyLinkedList<T>{

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int nodesCount=0;

    public void insert(T data) {
        Node newNode = new Node(data);
        if (head==null) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
        nodesCount++;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = null;
        }
        else {
            newNode.setNext(head);
            head = newNode;
        }
        nodesCount++;
    }

    public void insertAtIndex(int index, T data) throws NullPointerException {
        Node newNode = new Node(data);
        Node tempPointer = head;

        for (int x =0; x<index-1; x++) {
            tempPointer = tempPointer.getNext();
        }
        newNode.setNext(tempPointer.getNext());
        tempPointer.setNext(newNode);
        nodesCount++;
    }

    public Node get(int index) throws NullPointerException {
        Node tempPointer = head;
        for (int x = 0 ;x <index; x++) {
            tempPointer = tempPointer.getNext();
        }
        return tempPointer;
    }

    public void deleteHead() {
        Node tempPointer = head.getNext();
        head.setNext(null);
        head = tempPointer;
    }

    public void deleteTail() {
        Node tempPointer = head;
        for (int x=0;x<nodesCount-2;x++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(null);
        tail = tempPointer;
    }

    public void deleteAtIndex(int index) throws NullPointerException {
        Node previousPointer = head;
        for (int x=0; x<index-1; x++)
            previousPointer = previousPointer.getNext();

        Node futurePointer = previousPointer.getNext();
        futurePointer = futurePointer.getNext();
        previousPointer.setNext(futurePointer);
    }


    @Override
    public String toString() {
        return "MySinglyLinkedList{" +
                "\nhead=" + head +
                ",\n\ntail=" + tail +
                "\n}";
    }
}
