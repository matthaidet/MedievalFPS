/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.weapons;

import main.projectiles.Projectile;

/**
 *
 * @author MattH
 */
public interface Weapon {

    public String getName();

    public float getBaseDamage();

    public Projectile getAmoType();

    public void getRange();

    public String getModelPath();

    public String getIconPath();

    public void shoot();
}
