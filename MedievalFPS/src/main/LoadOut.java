/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author MattH
 */
public interface LoadOut {

    public String getName();

    public float getSpeed();

    public float getMaxHealth();

    public float getHealthRegen();

    public Weapon[] getWeapons();

    public String getIconPath();
}
