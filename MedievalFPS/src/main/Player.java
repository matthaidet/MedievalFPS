/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;


/**
 *
 * @author MattH
 */
public class Player extends CharacterControl {
    private int score;
    private float health;
    private int deaths;
    private boolean isLiving;
    private LoadOut loadOut;
    private String name;
    private int remainingRespawnTime;
    private Vector3f position;
    
    public Player(Profile profile){
        name = profile.getName();
        this.remainingRespawnTime = 0;
    }

    public void spawn(Vector3f p) {
        position = p;
        isLiving = true;
        health = loadOut.getHealthStat();
    }
    
}
