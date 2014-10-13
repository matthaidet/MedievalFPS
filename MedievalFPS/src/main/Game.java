/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.bullet.BulletAppState;
import de.lessvoid.nifty.Nifty;
import main.gui.HUD;

/**
 *
 * @author MattH
 */
public class Game {
    private Nifty nifty;
    private Controls controls;
    private Environment environment;
    private Player player;
    private Main main;
    private HUD hud;
    private BulletAppState bulletAppState;


    public Game(Main main, Map map, Player player, Nifty nifty) {
        this.nifty = nifty;
        this.player = player;
        this.main = main;
        this.bulletAppState = main.getBulletAppState();
        load(map);
    }

    private void load(Map map) {
        environment = new Environment(main, map);
        player.init(main, environment);
        controls = new Controls(player);
        controls.setUpKeys(main);
        bulletAppState = new BulletAppState();
        init();
    }

    private void init() {
        main.getStateManager().attach(bulletAppState);
        hud = new HUD();
        hud.displayHUD(nifty, main);
        bulletAppState.getPhysicsSpace().add(player);
        main.getRootNode().attachChild(environment.getSceneModel());
        bulletAppState.getPhysicsSpace().add(environment.getLandscape());
    }

    public void gameLoop() {
        player.update(main, controls);
    }
    
}
