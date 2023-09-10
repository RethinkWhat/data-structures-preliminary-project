package prelim;

public interface LinkedListInterface<T> {
    public T getInformation();

    public MySinglyLinkedList<T> getLink();

    public void setInformation(T information);

    public void setLink(MySinglyLinkedList<T> link);

}
