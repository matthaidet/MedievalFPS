/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.projectiles;

import main.ModelObject;

/**
 *
 * @author MattH
 */
public class Projectile extends ModelObject {
    private String filePath;
    private float mass;

    public Projectile(String filePath, float mass) {
        super(filePath);
        this.mass = mass;
        this.filePath = filePath;
    }
}
