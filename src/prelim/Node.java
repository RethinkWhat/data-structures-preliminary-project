package prelim;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
        this.data = null;
        this.next = null;
    }
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> node) {
        next = node;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "\n" + data+"\n" + next;
    }
}
