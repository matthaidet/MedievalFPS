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
    static float dropRate;
    static float dropBooster;
    static float gravity;
    
    static float updateDropRate(float currentDropRate) {
        return 3;
    }
    
    static float addDropBooster(float currentDropRate, float dropBooster) {
        return 3;
    }
    
    static public void setDropRate(float newDropRate) {
        dropRate = newDropRate;
    }
    
}
