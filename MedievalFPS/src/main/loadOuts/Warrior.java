/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.loadOuts;

import main.weapons.BasicSword;
import main.weapons.Weapon;

/**
 *
 * @author MattH
 */
public class Warrior implements LoadOut {

    public String getName() {
        return "Warrior";
    }

    public float getSpeed() {
        return .5f;
    }

    public float getMaxHealth() {
        return 100f;
    }

    public float getHealthRegen() {
        return .01f;
    }

    public Weapon[] getWeapons() {
        Weapon[] weapons = {new BasicSword()};
        return weapons;
    }

    public String getIconPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
