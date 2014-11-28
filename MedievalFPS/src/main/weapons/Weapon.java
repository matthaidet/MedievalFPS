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

    public void init(float additionalRange, float additionalAccuracy, float additionalDamage);

    public String getName();

    public float getBaseDamage();

    public Projectile getAmoType();

    public int getMaxDrawback();

    public int getCurrentDrawback();

    public float getBaseRange();

    public String getModelPath();

    public String getIconPath();

    public void release();

    public void pull(int amount);

    public float getBaseAccuracy();
}
