package prelim;

public class PersonalProperties {

    public class property {
        String itemName;
        int quantity;
        boolean inBox;
        String modelNumber;
        String model;


    }

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        showIntroduction();
        do {

        }while(true);
    }
    public static void showIntroduction(){
        System.out.println("==============================================================================");
        System.out.println("\tThis application is capable of accepting a list of 5 \n" +
                "different personal properties. The list itself has several different features.");
        System.out.println("==============================================================================");
    }
}

