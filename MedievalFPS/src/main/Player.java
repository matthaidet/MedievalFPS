/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Vector;

/**
 *
 * @author MattH
 */
public class Player {
    private int score;
    private float health;
    private int deaths;
    private boolean isLiving;
    private LoadOut loadOut;
    private String name;
    private int remainingRespawnTime;
    private Vector position;
    
    public Player(Profile profile){
        name = profile.getName();
        this.remainingRespawnTime = 0;
    }

    public void spawn(Vector p) {
        position = p;
        isLiving = true;
        health = loadOut.getHealthStat();
    }
    
}
