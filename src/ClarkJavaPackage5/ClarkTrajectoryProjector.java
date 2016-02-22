/*
 * Trajectory Projector
 *
 *  This program uses a falling objects position and velocity information to project
 *  the objects trajectory. This program runs with the ClarkFallingItem.java class.
 *  This program accepts user inputted data and it will reject inputs lower that are
 *  lower than 600 feet starting position and under -500 feet / second starting velocity.
 */

/*
 * @author jeannaclark
 * @version Java Assn 5: Trajectory Projector, version 1.0 
 */

package ClarkJavaPackage5;

import java.util.Scanner;

public class ClarkTrajectoryProjector {
    
    // Define variables
    public static double HEIGHT_THRESHOLD = 600.0; // set height threshold at 600 feet
    
    public static void main(String[] args) {
        // explain program to user
        System.out.print("This program will calculate the position and velocity \nof ");
        System.out.print("a falling object until it reaches " + HEIGHT_THRESHOLD);
        System.out.print(" feet above ground.");
        
        // collect initial position and velocity
        double initialPosition = getInitialPosition();
        double initialVelocity = getInitialVelocity();
        System.out.print("\n\n\n\n");
        
        // create a ClarkFallingItem object
        ClarkFallingItem fallingSquirrel = new ClarkFallingItem(initialPosition, initialVelocity);
        
        // display countdown from 5
        System.out.print("Countdown:");
        final int COUNTER = 5; 
        for (int count = 0; count < COUNTER; count++) {
            System.out.print("\n\t" + count);
        }
        
        // track the falling item
        fallingSquirrel.trackClarkFallingItem();
        
        // display the stop threshold height along with time and final position
        System.out.print("\n\n\nObject reached " + HEIGHT_THRESHOLD + " feet after " + fallingSquirrel.getCurrentTime() + " seconds.");
        System.out.printf("\nThe object's final position is " + fallingSquirrel.getcurrentPosition());
        System.out.print(" feet.\n\n");
    }
    
    /* gets the ClarkFallingItem's initial position
     * @return initialPosition
    */
    public static double getInitialPosition() {
        double initialPosition = 0.0; // initialize local variable to trigger do-while loop
        do { 
            System.out.print("\n\nPlease enter the intial position (must be over 600.0 feet): ");
            Scanner keyboard = new Scanner(System.in);
            initialPosition = keyboard.nextDouble();
            
            // display error message if incorrect value
            if (initialPosition <= HEIGHT_THRESHOLD) {
                System.out.print("Error - position too low. Try again");
            }
        } while (initialPosition <= HEIGHT_THRESHOLD);
        return initialPosition;
    }
   
    /* gets the ClarkFallingItem's initial velocity
     * @return initialVelocity
    */
    public static double getInitialVelocity() {
        double initialVelocity = -500.1; // initialize local variable to trigger do-while loop
        do { 
            System.out.print("\n\nPlease enter the intial velocity (-500.0 ft/sec or more): ");
            Scanner keyboard = new Scanner(System.in);
            initialVelocity = keyboard.nextDouble();
            
            // display error message if incorrect value
            if (initialVelocity < ClarkFallingItem.TERMINAL_VELOCITY) {
                System.out.print("Error - velocity too low. Try again");
            }
        } while (initialVelocity < ClarkFallingItem.TERMINAL_VELOCITY);
        return initialVelocity;
    }
}
