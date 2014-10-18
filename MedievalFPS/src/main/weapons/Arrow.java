/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.weapons;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import main.Physics;
import main.Player;
import main.projectiles.Projectile;

/**
 *
 * @author MattH & Leon
 */
public class Arrow extends Projectile {
    Vector3f location;
    double currentY;
    double currentX;
    double currentZ;
    double dropRate;
    double speed;
    double speedBoost;
    double rangeBoost;
    
    public Arrow(Vector3f p, AssetManager a, Player pl) {
        super("", a, p, 1.1f, pl);
    }
    
    public void updateLocation() {
        updateGravity();
        updateSpeed();
        location.set((int)currentX, (int)currentY, (int)currentX);
    }
    
    private void updateGravity() {
        currentY = currentY - dropRate;
        dropRate = Physics.updateDropRate(dropRate);
        dropRate = dropRate * rangeBoost;
    }
    
    private void updateSpeed() {
        speed = Physics.updateSpeed(speed);
        speed = speed * speedBoost;
    }
    
    public void setSpeedBoost(double booster) {
        speedBoost = booster;
    }
    
    public void setRangeBoost(double booster) {
        rangeBoost = booster;
    }
}
