/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.weapons;

/**
 *
 * @author MattH
 */
public class BasicSword implements Weapon {

    public String getName() {
        return "Sword";
    }

    public float getBaseDamage() {
        return 5.1f;
    }

    public String getModelPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIconPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
