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
 * @author MattH
 */
public interface Projectile {

    public void launch(Player owner, Vector3f position, Vector3f velocity, Quaternion direction);

    public void stop();

    public void bounce();
}
