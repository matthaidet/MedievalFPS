/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Leon
 */
public class Physics {
    static Double gravity;
    static Double gravityMilli;
    
    public static double updateDropRate(double currentDropRate) {
        //double gravityMilli = gravity / 1000;
        //double newDropRate = currentDropRate + gravityMilli;
        double newDropRate =  -0.07*((currentDropRate - 2) * (currentDropRate -2)) + 0.3;
        return newDropRate;
    }
    
    public static double updateSpeed(double currentSpeed) {
        double newSpeed;
        newSpeed = -0.1*(currentSpeed * currentSpeed);
        return newSpeed;
    }
    public static void setGravity(double newGravity) {
        gravity = newGravity;
        gravityMilli = gravity/1000;
    }
    
    public static double getGravity() {
        return gravity;
    }
    
    public static double getGravityMilli() {
        return gravityMilli;
    }
}
