package prelim;

public class MySinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int nodesCount = 0;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }


    public int getNodesCount() {
        return nodesCount;
    }

    public void insertAtTail(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        nodesCount++;
    }

    public void insertAtHead(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
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
        if (tempPointer != head && tempPointer != tail) {
            newNode.setNext(tempPointer.getNext());
            tempPointer.setNext(newNode);
        } else {
            if (tempPointer == head) {
                head = newNode;
                newNode.setNext(tempPointer);
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }

        nodesCount++;
    }

    public Node<T> get(int index) throws NullPointerException {
        Node<T> tempPointer = head;
        for (int x = 0; x < index; x++) {
            tempPointer = tempPointer.getNext();
        }
        return tempPointer;
    }

    public void deleteHead() {
        Node<T> tempPointer = head.getNext();
        head.setNext(null);
        head = tempPointer;
        nodesCount--;
    }

    public void deleteTail() {
        Node<T> tempPointer = head;
        for (int x = 0; x < nodesCount - 2; x++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setNext(null);
        tail = tempPointer;
        nodesCount--;
    }

    public void deleteAtIndex(int index) throws NullPointerException {
        Node<T> previousPointer = head;
        for (int x = 0; x < index - 1; x++)
            previousPointer = previousPointer.getNext();

        Node<T> futurePointer = previousPointer.getNext();
        futurePointer = futurePointer.getNext();
        previousPointer.setNext(futurePointer);
        nodesCount--;
    }

    void sortedInsert(T data) {
        Node newNode = new Node(data,null);
        Node current;
        if (head == null || head.toString().compareToIgnoreCase(
                newNode.toString()) >0) {
            newNode.setNext(head);
            head = newNode;
        }
        else {
            current = head;
            while (current.getNext() != null
                    && current.getNext().toString().compareToIgnoreCase(
                            newNode.toString())<=0) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }


    @Override
    public String toString() {
        return "MySinglyLinkedList{ " + head.toString();
    }
}
