package prelim;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class PersonalProperties {

    public static class Property {
        private String propertyName;
        private int quantity;
        private String model;

        public Property(String propertyName, int quantity, String model) {
            this.propertyName = propertyName;
            this.quantity = quantity;
            this.model = model;
        }

        public String getPropertyName() {
            return propertyName;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getModel() {
            return  model;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String toString() {
            return propertyName + ", " + quantity + ", " + model + ".";
        }
    }

    public static Scanner keyboard = new Scanner(System.in);
    public  static MyFixedSizeArrayList propertiesList = new MyFixedSizeArrayList();

    public static void main(String[] args) {
        showIntroduction();
        do {
            try {
                run();
            } catch (ListOverflowException ex) {
            }
        } while (true);
    }

    public static void run() throws ListOverflowException {
        logicMenu(showMenu());

    }
    public static void showIntroduction(){
        System.out.println("==============================================================================");
        System.out.println("\t\tThis application is capable of accepting a list of 5 different\n" +
                "\tpersonal properties. The list itself has several different features.");
        System.out.println("==============================================================================");
    }

    public static int showMenu() {
        int input = 0;
        do {
            try {
                System.out.println("Enter the number of what you would like to do:");
                System.out.println("\t1. Add property to list.");
                System.out.println("\t2. Display all properties and their respective information.");
                System.out.println("\t3. Delete property in list");
                System.out.println("\t4. Quit.");
                System.out.print("\t\t -> ");
                input = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid number.");
            }
        } while(input >4 || input <1);
        return input;
    }

    public static void logicMenu(int choice) throws ListOverflowException{
        switch (choice) {
            case 1 -> addProperty();
            case 2 -> {
                propertiesList.display();
                System.out.println("Press enter to return to menu.");
                keyboard.nextLine();
            }
            case 3 -> deleteProperty();
            case 4 -> exit();
        }
    }

    public static void exit() {
        System.out.println("Thank you!");
        System.exit(0);
    }

    public static void addProperty() throws ListOverflowException {
        System.out.println();
        String itemName = requestInput("Enter the property name. ");
        int quantity = Integer.parseInt(requestInput("Enter the quantity of the said property."));
        String model = requestInput("Enter the model.");
        Property newObject = new Property(itemName,quantity,model);
        propertiesList.insert(newObject);
    }

    public static void deleteProperty() {
        System.out.println("Here are all of the properties in the list:");
        propertiesList.display();
        int index = 0;
        do {
            index = Integer.parseInt(requestInput("Enter the index of the item you would like to delete."));
        } while (index < 0 || index > propertiesList.getSize());
        index -= 1;
        propertiesList.delete(propertiesList.getElementAtIndex(index));
    }

    public static String requestInput(String prompt) {
        System.out.println("\t" + prompt);
        System.out.print("\t\t--> ");
        return keyboard.nextLine();
    }
}

