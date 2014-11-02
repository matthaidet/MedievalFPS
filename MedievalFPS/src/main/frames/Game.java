/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.frames;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import main.Main;
import main.Playable;
import main.Player;
import main.GUI;
import main.maps.DesertIsland;
import main.maps.Map;

/**
 *
 * @author MattH
 */
public class Game implements Frame {
    private Playable playable;
    private Nifty nifty;
    private Player player;
    private Main main;
    private GUI hud;
    private Map map;

    public Game(Player p, Main m, Map mp) {
        player = p;
        main = m;
        map = mp;
        this.init();
    }

public String getName() {
    return "Game";
    }

    public void init() {
        playable = new Playable(main, map, player, nifty);
        hud = new GUI("Interface/HUD.xml", "HUD");
        playable.load(map);
    }

    public void display() {
        hud.display(main, nifty);
        playable.init();
    }

    public void update() {
        playable.update();
    }

    public void action(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
