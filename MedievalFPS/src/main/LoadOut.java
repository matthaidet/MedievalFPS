/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.abilities.Ability;
import main.weapons.Weapon;
import traits.Trait;

/**
 *
 * @author MattH
 */
public class LoadOut {

    private String name;
    private float speed;
    private float strength;
    private float weight;
    private float healthRegen;
    private float maxHealth;
    private float resistance;
    private float precision;
    private Weapon weapon;
    private Ability ability;
    private Trait[] traits;

    public LoadOut() {
    }

    public String getName() {
        return name;
    }

    public float getSpeed() {
        return speed;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public float getHealthRegen() {
        return healthRegen;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Trait[] getTraits() {
        return traits;
    }
}
