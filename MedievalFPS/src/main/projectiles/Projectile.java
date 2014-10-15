/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.projectiles;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import main.ModelObject;
import main.Player;

/**
 *
 * @author MattH
 */
public class Projectile extends ModelObject {
    private String filePath;
    private float mass;
    private Player owner;

    public Projectile(String filePath, AssetManager a, Vector3f position, float mass, Player p) {
        super(filePath, position, a);
        this.mass = mass;
        this.filePath = filePath;
        this.owner = p;
    }
}
