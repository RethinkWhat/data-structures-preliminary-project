package prelim;

public class ListOverflowException extends Exception {
    public ListOverflowException() {
        System.out.println("The list already has 5 properties in it.");
    }

}
