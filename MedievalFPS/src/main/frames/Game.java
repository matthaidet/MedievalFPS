/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.frames;

import de.lessvoid.nifty.Nifty;
import main.Main;
import main.Playable;
import main.Player;
import main.maps.DesertIsland;

/**
 *
 * @author MattH
 */
public class Game implements Frame {
    private Playable playable;
    private Nifty nifty;
    private Player player;
    private Main main;

    public Game(Player p, Main m) {
        player = p;
        main = m;
        this.init();
    }

public String getName() {
    return "Game";
    }

    public void init() {
        playable = new Playable(main, new DesertIsland(), player, nifty);
    }

    public void display() {
       
    }

    public void update() {
        playable.update();
    }
}
