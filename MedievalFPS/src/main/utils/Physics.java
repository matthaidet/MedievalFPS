/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

/**
 *
 * @author Leon
 */
public class Physics {
    static Double gravity;
    
    public static double updateY(double currentY, double timeElapsed) {
        gravity = 32.0;
        //double gravityMilli = gravity / 1000;
        //double newDropRate = currentDropRate + gravityMilli;
        double newDropRate =  1/gravity* (timeElapsed * timeElapsed);
        return newDropRate;
    }
    
    public static double updateSpeed(double currentSpeed, double timeElapsed) {
        double newSpeed;
        newSpeed = -0.1*(timeElapsed * timeElapsed);
        return newSpeed;
    }
    public static void setGravity(double newGravity) {
        gravity = newGravity;
    }
    
    public static double getGravity() {
        return gravity;
    }
}
