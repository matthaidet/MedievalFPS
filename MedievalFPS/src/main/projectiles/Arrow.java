/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.projectiles;

import com.jme3.asset.AssetManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import main.ModelObject;
import main.Player;

/**
 *
 * @author MattH & Leon
 */
public class Arrow extends ModelObject implements Projectile {
    Vector3f position;
    boolean isMoving;
    float angle;
    AssetManager assetManager;
    
    public Arrow(Vector3f p, AssetManager a, Player pl) {
        super("Arrow", p, a);
    }

    public void launch(Player owner, Vector3f position, Vector3f velocity, Quaternion direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void bounce() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
