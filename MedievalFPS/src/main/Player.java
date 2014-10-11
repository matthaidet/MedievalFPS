/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author MattH
 */
public class Player {
    private int score;
    private int health;
    private boolean isLiving;
    private LoadOut loadOut;
    private String name;
    private int remainingRespawnTime;
    
    public Player(Profile profile){
        name = profile.getName();
        this.remainingRespawnTime = 0;
    }
    
}
