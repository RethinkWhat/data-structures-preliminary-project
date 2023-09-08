package prelim;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class PersonalProperties {

    public class Property {
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

    public void main(String[] args) {
        do {
            try {
                run();
            } catch (ListOverflowException ex) {
                System.out.println("The list already has 5 properties in it.");
            }
        } while (true);
    }

    public void run() throws ListOverflowException {
        showIntroduction();
        logicMenu(showMenu());

    }
    public static void showIntroduction(){
        System.out.println("==============================================================================");
        System.out.println("\tThis application is capable of accepting a list of 5 \n" +
                "different personal properties. The list itself has several different features.");
        System.out.println("==============================================================================");
    }

    public static int showMenu() {
        int input = 0;
        do {
            System.out.println("Enter the number of what you would like to do:");
            System.out.println("\t1. Add property to list.");
            System.out.println("\t2. Display information of property in list.");
            System.out.println("\t3. Delete property in list");
            System.out.println("\t4. Quit.");
            input = Integer.parseInt(keyboard.nextLine());
        } while(input >4 || input <1);
        return input;
    }

    public void logicMenu(int choice) throws ListOverflowException{
        switch (choice) {
            case 1 -> addProperty();
            case 2 -> propertiesList.display();
            case 3 -> deleteProperty();
            case 4 -> exit();
        }
    }

    public static void exit() {
        System.out.println("Thank you!");
        System.exit(0);
    }

    public void addProperty() throws ListOverflowException {
        System.out.println();
        String itemName = requestInput("Enter the property name. ");
        int quantity = Integer.parseInt(requestInput("Enter the quantity of the said property."_);
        String model = requestInput("Enter the model.");
        Property newObject = new Property(itemName,quantity,model);
        propertiesList.insert(newObject);
    }

    public void deleteProperty() {
        System.out.println();
        propertiesList.display();
        int index = 0;
        do {
            index = Integer.parseInt(requestInput("Enter the index of the item you would like to delete."));
        } while (index < 0 || index > propertiesList.getSize());
        propertiesList.delete(propertiesList.getObject(index));
    }

    public static String requestInput(String prompt) {
        System.out.println(prompt);
        System.out.print("--> ");
        return keyboard.nextLine();
    }
}

