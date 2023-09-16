/**
 * Name and SLU ID Number: TANK, Rithik | 2233293
 * Date: September 15, 2023,
 * Name of Project: Prelim Programming Exercises
 */
package prelim;

/**
 * Called when the list reaches max capacity and a new element is attempted to be added
 */
public class ListOverflowException extends Exception {
    public ListOverflowException() {
        System.out.println("The list already has 5 properties in it.");
    }

}
