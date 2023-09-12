package prelim;

public class practice {
    public static void main(String[] args) {
        MyDoublyLinkedList list =  new MyDoublyLinkedList();
        list.insertAtTail(6);
        list.insertAtTail(7);
        list.insertAtTail(8);
        list.insertAtTail(9);
        list.insertAtTail(69);
        //list.insertAtIndex(4,100);
        list.deleteAtIndex(4);
        System.out.println(list);
    }
}
