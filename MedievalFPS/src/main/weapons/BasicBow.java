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
public class BasicBow implements Weapon {

    private int currentDrawback;
    private int maxDrawback;

    public BasicBow() {
        currentDrawback = 0;
    }

    public void init(float additionalRange, float additionalAccuracy, float additionalDamage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return "Basic-Bow";
    }

    public float getBaseDamage() {
        return 1;
    }

    public Projectile getAmoType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMaxDrawback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCurrentDrawback() {
        return this.currentDrawback;
    }

    public float getBaseRange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getModelPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIconPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void release() {
        this.currentDrawback += 0;
    }

    public void pull(int amount) {
        this.currentDrawback += amount;
    }

    public float getBaseAccuracy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
