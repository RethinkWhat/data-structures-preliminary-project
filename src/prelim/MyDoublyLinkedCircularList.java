package prelim;

import java.util.function.DoublePredicate;

public class MyDoublyLinkedCircularList<T> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    private int nodeCount = 0;

    public DoublyLinkedNode<T> getHead(){
        return head;
    }

    public DoublyLinkedNode<T> getTail() {
        return tail;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setHead(DoublyLinkedNode<T> head) {
        this.head = head;
    }

    public void setTail(DoublyLinkedNode<T> tail) {
        this.tail = tail;
    }

    public void addAtHead(T data){
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            head.setPrevious(tail);
            tail.setNext(head);
        }
    }

    public void addAtTail(T data) {
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
    }

    public void addAtIndex(int index, T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            DoublyLinkedNode<T> tempPointer = head;
            for (int x = 0; x< index-2; x++) {
                tempPointer = tempPointer.getNext();
            }
            DoublyLinkedNode<T> after = tempPointer.getNext();
            tempPointer.setNext(newNode);
            newNode.setPrevious(tempPointer);
            newNode.setNext(after);
            if (after!= null) {
                if (index ==0)
                    head = newNode;
                after.setPrevious(newNode);
            }
            else {
                newNode.setNext(head);
                head.setPrevious(newNode);
                tail = newNode;
            }
        }
    }

    public void deleteHead() throws NullPointerException {
        DoublyLinkedNode<T> newHead = head.getNext();
        newHead.setPrevious(tail);
        tail.setNext(newHead);
        head.setPrevious(null);
        head.setNext(null);
        head = newHead;
    }

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
    }

    public void deleteAtIndex(int index) throws NullPointerException {
        DoublyLinkedNode<T> tempPointer = head;
        for (int x =0; x<index-2;x++)
            tempPointer = tempPointer.getNext();
        DoublyLinkedNode<T> toDelete = tempPointer.getNext();
        DoublyLinkedNode<T> after = toDelete.getNext();
        tempPointer.setNext(after);
        toDelete.setPrevious(null);
        toDelete.setNext(null);
        if (after != null) {
            after.setPrevious(tempPointer);
            if (index ==0)
                head = tempPointer;
        } else {
            tempPointer.setNext(head);
            head.setPrevious(tempPointer);
            tail = tempPointer;
        }

    }


}
