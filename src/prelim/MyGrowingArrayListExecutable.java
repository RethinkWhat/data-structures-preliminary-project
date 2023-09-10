package prelim;

import java.util.Scanner;

public class MyGrowingArrayListExecutable {

    public static class Student{
        private String name;
        private String id;
        private String course;

        public Student(String name, String id, String course) {
            this.name = name;
            this.id = id;
            this.course = course;
        }

        public String getName(){
            return name;
        }

        public String getId(){
            return id;
        }

        public String getCourse(){
            return course;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        @Override
        public String toString() {
            return name + ", " + id + ", " + course;
        }
    }

    public static MyGrowingArrayList<Student> studentList = new MyGrowingArrayList<Student>();
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        showIntroduction();
        do {
            try {
                run();
            } catch (ListOverflowException ex) {
            }
        }while (true);
    }

    public static void showIntroduction(){
        System.out.println("===================================================================================");
        System.out.println("\t\tThis application is capable of accepting a list of student names and\n" +
                "\ttheir pertinent information. The list itself has several different features.");
        System.out.println("===================================================================================");
    }

    public static void run() throws ListOverflowException{
        System.out.println("Currently the maximum size of the list is " + studentList.getSize() + ".");
        int choice = showMenu();
        switch (choice) {
            case 1 -> addStudent();
            case 2 -> display();
            case 3 -> deleteProperty();
            case 4 -> exit();
        }
    }

    public static int showMenu() {
        int input = 0;
        do {
            try {
                System.out.println("Enter the number of what you would like to do:");
                System.out.println("\t1. Add a student to list.");
                System.out.println("\t2. Display all students and their respective information.");
                System.out.println("\t3. Delete a student in list.");
                System.out.println("\t4. Quit.");
                System.out.print("\t\t -> ");
                input = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid number.");
            }
        } while(input >4 || input <1);
        return input;
    }

    public static void addStudent() throws ListOverflowException {
        System.out.println();
        String studName = requestInput("Enter the student name. ");
        String studID = requestInput("Enter the student's ID number.");
        String studCourse = requestInput("Enter the student's course.");
        Student newStudent = new Student(studName,studID,studCourse);
        studentList.insert(newStudent);
    }

    public static String requestInput(String prompt) {
        System.out.println("\t" + prompt);
        System.out.print("\t\t--> ");
        return keyboard.nextLine();
    }

    public static void display() {
        studentList.display();
        System.out.println("Press enter to return to menu.");
        keyboard.nextLine();
    }
    public static void deleteProperty() {
        System.out.println("Here are all of the students in the list:");
        studentList.display();
        int index = 0;
        do {
            index = Integer.parseInt(requestInput("Enter the index of the item you would like to delete."));
        } while (index < 0 || index > studentList.getSize());
        index -= 1;
        studentList.delete(studentList.getElementAtIndex(index));



    }

    public static void exit() {
        System.out.println("Thank you!");
        System.exit(0);
    }
}
