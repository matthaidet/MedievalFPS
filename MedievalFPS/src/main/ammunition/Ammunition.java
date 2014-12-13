/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.ammunition;

import main.projectiles.Projectile;

/**
 *
 * @author MattH
 */
public interface Ammunition {

    public Projectile getProjectile();

    public String getName();

}
