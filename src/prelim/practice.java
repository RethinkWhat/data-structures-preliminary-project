package prelim;

public class practice {
    public static void main(String[] args) {
        MyDoublyLinkedList list =  new MyDoublyLinkedList();
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert("Fire");
        list.insert(69);
        //list.insertAtIndex(4,100);;
        boolean done = list.delete("Fire");

        for (int x =0 ;x <list.getSize(); x++) {
            System.out.println(list.get(x));
        }
        System.out.println("Search: " + list.search("Fire"));
        System.out.println(list.getElement("Fire"));
    }
}
