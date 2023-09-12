package prelim;

public class DoublyLinkedNode<T> {
    private T data;
    private DoublyLinkedNode<T> next;
    private DoublyLinkedNode<T> previous;


    public DoublyLinkedNode() {
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    public DoublyLinkedNode(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return data;
    }

    public DoublyLinkedNode<T> getNext(){
        return next;
    }

    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    public String toString() {
        return "DoublyLinkedNode Next {" +
              //  "previous=" + previous +
                "\n\t  data=" + data +
                "\n\t  next=" + next +
                "\n}";
    }

}
