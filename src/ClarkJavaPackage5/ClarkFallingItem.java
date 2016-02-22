/*
 * Falling Item Announcer
 *
 *  The program countdowns and displays the position and velocity of a falling item.
 *  It outputs the current velocity and position every second until the position falls 
 *  below 600 feet. The program runs with the ClarkTrajectoryProjector.java class.
 */

/*
 * @author jeannaclark
 * @version Java Assn 5: Falling Item, version 1.0
 */

package ClarkJavaPackage5;

import java.lang.Math;
import java.util.Scanner;

public class ClarkFallingItem {
 
    // Define variables
    private final double initialPosition, initialVelocity; // constant values
    private int currentTime;
    private double currentPosition, currentVelocity;
    public static double TERMINAL_VELOCITY = -500.0; // terminal velocity constant: -500 ft / sec
    
    // Initialize object with constructor
        ClarkFallingItem (double initialPosition, double initialVelocity) {    
            this.initialPosition = initialPosition;
            this.currentPosition = initialPosition;
            this.initialVelocity = initialVelocity;
            this.currentVelocity = initialVelocity;
            this.currentTime = 0;
        } 
        
    /* getter for current time
     * @return currentTime
     */
    public int getCurrentTime() {
        return currentTime;     
    } 
    
     /* getter for current position
     * @return currentPosition
     */
    public double getcurrentPosition() {
        return currentPosition;     
    } 
    
    // resets the ClarkFallingItem object
    public void resetClarkFallingItem() {
        // increment time by 1 second
        this.currentTime = this.currentTime + 1;
        
        // calculate and set current velocity at updated currentTime
        this.currentVelocity = (-32 * this.currentTime) + this.initialVelocity;
        
        // test for velocity lower than terminal velocity and display no lower than terminal velocity
        if (this.currentVelocity < TERMINAL_VELOCITY) {
            this.currentVelocity = TERMINAL_VELOCITY;
        }
        
        // calculate and set current position at updated currentTime
        if (this.currentVelocity == TERMINAL_VELOCITY) {
            this.currentPosition = this.currentPosition - 500;
        }
        else { // use formula for trajectory if velocity != terminal speed
            this.currentPosition = ((-16 * Math.pow(this.currentTime, 2) + (this.initialVelocity * this.currentTime) + this.initialPosition));
        }
    }
    
    // tracks the ClarkFallingItem object as it falls
    public void trackClarkFallingItem() {
        // display initial velocity and position
        System.out.printf("\n\nObject released from %.1f", initialPosition); 
        System.out.printf(" feet at an initial velocity of %.1f", initialVelocity);
        System.out.print(" ft/sec");
        
        // display current position and velocity as time passes. stop when item is at 600 ft
        while (this.currentPosition > ClarkTrajectoryProjector.HEIGHT_THRESHOLD) {
            // recalculate data for 1 second later
            resetClarkFallingItem();
            
            System.out.print("\n\tAt " + this.currentTime + " seconds, position is ");
            System.out.printf("%.1f", this.currentPosition);
            System.out.print(" feet and velocity is ");
            System.out.printf("%.1f", this.currentVelocity);
            System.out.print(" ft/sec");
        }
    }
}
