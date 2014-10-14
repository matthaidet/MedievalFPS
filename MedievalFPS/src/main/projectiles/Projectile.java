/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.projectiles;

import com.jme3.asset.AssetManager;
import java.util.Vector;
import main.ModelObject;

/**
 *
 * @author MattH
 */
public class Projectile extends ModelObject {
    private String filePath;
    private float mass;

    public Projectile(String filePath, AssetManager a, Vector position, float mass) {
        super(filePath, position, a);
        this.mass = mass;
        this.filePath = filePath;
    }
}
