package prelim;
import java.util.Scanner;

public class ExecutableClassMySinglyLinkedList {
    public static class Bag {
        private String type;
        private String brand;
        private int pockets;

        public Bag() {
            type = "backpack";
            brand = "unbranded";
            pockets = 2;
        }

        public Bag(String type, String brand, int pockets) {
            this.type = type;
            this.brand = brand;
            this.pockets = pockets;
        }

        public String getType() {
            return type;
        }

        public String getBrand() {
            return brand;
        }

        public int getPockets() {
            return pockets;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setPockets(int pockets) {
            this.pockets = pockets;
        }

        public String toString() {
            return brand + ", " + type + ", " + pockets + " pockets";
        }
    }

    static Scanner keyboard = new Scanner(System.in);
    static MySinglyLinkedList<Bag> bagList = new MySinglyLinkedList<Bag>();

    static String invalidNumber = "Enter a valid number.";
    static String indexDoesNotExist = "There is no bag at that index";
    public static void main(String[] args) {
        showHeader();
        showInstructions();
        run();
    }

    public static void showHeader() {
        System.out.println("----------------------------------------------------------");
        System.out.println("                       Singly Linked List                 ");
        System.out.println("----------------------------------------------------------");
    }
    public static void showInstructions() {
        System.out.println("This program allows a user to keep track of a list of bags, " +
                "\naccepting information like its brand, type and number of pockets.");
    }

    public static void run() {
        do {
            logicMenu();
        } while (true);
    }
    public static void logicMenu() {
        showMainMenu();
        int choice = enterChoice(1,5, "Enter your choice: ", invalidNumber);
        switch (choice) {
            case 1-> addObject();
            case 2-> deleteObject();
            case 3-> getObject();
            case 4-> showBags();
            case 5-> quit();
        }
    }

    public static void showMainMenu() {
        System.out.println("----------------------------------------------------------");
        System.out.println("     1. Add a bag to the list.");
        System.out.println("     2. Delete a bag from the list.");
        System.out.println("     3. Get an object from the list.");
        System.out.println("     4. Display all bags in the list. ");
        System.out.println("     5. Quit program.");
        System.out.println("----------------------------------------------------------");
    }

    public static int enterChoice(int min, int max, String prompt, String errorMessage) {
        int choice = -1;
        do {
            try {
                System.out.print(prompt);
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice <min || choice >max)
                    System.out.println(errorMessage);
            } catch (NumberFormatException ex) {
                System.out.println("Enter an integer.");
            }
        } while(choice <min || choice > max);
        return choice;
    }

    public static void addObject() {
        showAddMenu();
        int choice = enterChoice(1,3, "Enter your choice: ",invalidNumber);
        int index = 0;
        if (choice==3)
            index = enterChoice(0, bagList.getNodesCount(),"Enter index: ", indexDoesNotExist);
        Bag newBag = requestBag();
        switch (choice) {
            case 1 -> bagList.insertAtHead(newBag);
            case 2 -> bagList.insertAtTail(newBag);
            case 3 -> bagList.insertAtIndex(index,newBag);
        }
    }

    public static Bag requestBag() {
        System.out.print("  Enter the type of the bag: ");
        String bagType = keyboard.nextLine();
        System.out.print("  Enter the brand of the bag: ");
        String bagBrand = keyboard.nextLine();
        boolean condition = false;
        int pocketsNumber = 0;
        do {
            try {
                System.out.print("  Enter the number of pockets of the bag: ");
                pocketsNumber = Integer.parseInt(keyboard.nextLine());
                condition = true;
            } catch (NumberFormatException ex){
                System.out.println("Enter a valid number. Try again.");
            }
        } while (!condition);
        return new Bag(bagType,bagBrand,pocketsNumber);
    }

    public static void showAddMenu(){
        System.out.println("----------------------------------------------------------");
        System.out.println("    1. Add a bag at head. ");
        System.out.println("    2. Add a bag at tail. ");
        System.out.println("    3. Add a bag at an index. ");
        System.out.println("----------------------------------------------------------");
    }

    public static void showDeleteMenu(){
        System.out.println("----------------------------------------------------------");
        System.out.println("    1. Delete bag at head. ");
        System.out.println("    2. Delete bag at tail. ");
        System.out.println("    3. Delete a bag at an index. ");
        System.out.println("----------------------------------------------------------");
    }

    public static void deleteObject() {
        showDeleteMenu();
        int choice = enterChoice(1,3, "Enter your choice: ",invalidNumber);
        int index = 0;
        if (choice==3)
            index = enterChoice(0, bagList.getNodesCount(),"Enter index: ", indexDoesNotExist);
        switch (choice) {
            case 1 -> bagList.deleteHead();
            case 2 -> bagList.deleteTail();
            case 3 -> bagList.deleteAtIndex(index);
        }
    }

    public static void getObject() {
        int choice = enterChoice(0, bagList.getNodesCount()-1, "Enter the index of the number you would like to get: ",invalidNumber);
        System.out.println(bagList.get(choice));
    }

    public static void quit() {
        System.out.println("Thank you for using the program!");
        System.exit(0);
    }

    public static void showBags() {
        for (int x = 0; x<bagList.getNodesCount(); x++)
            System.out.println((x+1) + ". " + bagList.get(x));
    }

}
