package prelim;

public class practice {
    public static void main(String[] args) {
        MyDoublyLinkedList list =  new MyDoublyLinkedList();
        list.insertAtTail(6);
        list.insertAtTail(7);
        list.insertAtTail(8);
        list.insertAtTail(9);
        list.insertAtTail(10);
        list.insertAtIndex(3,100);
        System.out.println(list);
    }
}
