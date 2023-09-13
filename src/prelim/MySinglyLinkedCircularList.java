package prelim;

public class MySinglyLinkedCircularList<T> {
    private Node<T> head;
    private Node<T> tail;

    private int nodeCount = 0;


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
        this.tail = head;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void addAtHead(T datum) {
        Node<T> newNode = new Node(datum);

        if (head==null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
        nodeCount++;
    }

    public void addAtTail(T datum) {
        Node<T> newNode = new Node<>(datum);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setNext(head);
        }
        tail = newNode;
        nodeCount++;
    }

    public void addAtIndex(int index, T datum) {
        Node<T> newNode = new Node<>(datum);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tempPointer = head;
            for (int x = 0; x< index-2; x++) {
                tempPointer = tempPointer.getNext();
            }
            Node<T> after = tempPointer.getNext();
            tempPointer.setNext(newNode);
            if (after!=null) {
                if (index ==0)
                    head = tempPointer;
                newNode.setNext(after);
            }
            else {
                tail = newNode;
                tail.setNext(head);
            }
        }
        nodeCount++;
    }

    public void deleteHead() throws NullPointerException{
        Node<T> tempPointer = head;
        head.setNext(null);
        tempPointer = tempPointer.getNext();
        tail.setNext(tempPointer);
        nodeCount--;
    }

    public void deleteTail() throws NullPointerException{
        Node<T> tempPointer = tail;
        while (tempPointer.getNext()!=tail) {
            tempPointer = tempPointer.getNext();
        }
        tail.setNext(null);
        tail = tempPointer;
        tempPointer.setNext(head);
        nodeCount--;
    }

    public void deleteAtIndex(int index) throws NullPointerException{
        Node<T> tempPointer = head;
        for (int x=0; x<index-2; x++) {
            tempPointer = tempPointer.getNext();
        }
        Node<T> toDelete = tempPointer.getNext();
        Node<T> after = toDelete.getNext();
        toDelete.setNext(null);

        tempPointer.setNext(after);
        if (after == null)
            tempPointer.setNext(head);
        nodeCount--;
    }
}
