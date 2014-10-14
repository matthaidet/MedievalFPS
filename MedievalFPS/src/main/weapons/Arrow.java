/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.weapons;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import main.Player;
import main.projectiles.Projectile;

/**
 *
 * @author MattH
 */
public class Arrow extends Projectile {

    public Arrow(Vector3f p, AssetManager a, Player pl) {
        super("", a, p, 1.1f, pl);
    }
}
