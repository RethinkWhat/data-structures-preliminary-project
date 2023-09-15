package prelim;

public class MySinglyLinkedList<T> {

    private Node head;
    private Node tail;
    private int nodesCount=0;

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


    public int getNodesCount() {
        return nodesCount;
    }

    public void insertAtTail(T data) {
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
        Node<T> newNode = new Node<T>(data);
        Node<T> tempPointer = head;

        for (int x = 0; x < index - 1; x++) {
            tempPointer = tempPointer.getNext();
        }
        System.out.println("THIS IS TEMP POINTER: " + tempPointer);

        if (index == nodesCount)
            insertAtTail(data);
        else {
            if (index == 0) {
                insertAtHead(data);
            } else {
                Node after = tempPointer.getNext();
                tempPointer.setNext(newNode);
                newNode.setNext(after);
                nodesCount++;
            }
        }
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
        nodesCount--;
    }

    public void deleteTail() {
        Node tempPointer = head;
        for (int x=0;x<nodesCount-2;x++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(null);
        tail = tempPointer;
        nodesCount--;
    }

    public void deleteAtIndex(int index) throws NullPointerException {
        Node previousPointer = head;
        for (int x=0; x<index-1; x++)
            previousPointer = previousPointer.getNext();

        Node futurePointer = previousPointer.getNext();
        futurePointer = futurePointer.getNext();
        previousPointer.setNext(futurePointer);
        nodesCount--;
    }


    @Override
    public String toString() {
        return "MySinglyLinkedList{" +
                "\nhead=" + head +
                ",\n\ntail=" + tail +
                "\n}";
    }
}
