/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author MattH
 */
public interface Weapon {

    public String getName();

    public float getDamage();

    public void action();

    public String getIconPath();

    public float getAttackSpeed();
}
