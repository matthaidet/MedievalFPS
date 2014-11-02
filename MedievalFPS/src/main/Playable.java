/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.maps.Map;
import com.jme3.bullet.BulletAppState;
import de.lessvoid.nifty.Nifty;
import main.gui.GUI;

/**
 *
 * @author MattH
 */
public class Playable {
    private Nifty nifty;
    private Controls controls;
    private Environment environment;
    private Player player;
    private Main main;
    private GUI hud;
    private BulletAppState bulletAppState;


    public Playable(Main main, Map map, Player player, Nifty nifty) {
        this.nifty = nifty;
        this.player = player;
        this.main = main;
        this.bulletAppState = main.getBulletAppState();
    }

    public void load(Map map) {
        environment = new Environment(main, map);
        player.init(main, environment);
        controls = new Controls(player);
        controls.setUpKeys(main);
        bulletAppState = new BulletAppState();
    }

    public void init() {
        main.getStateManager().attach(bulletAppState);
        bulletAppState.getPhysicsSpace().add(player);
        main.getRootNode().attachChild(environment.getSceneModel());
        bulletAppState.getPhysicsSpace().add(environment.getLandscape());
    }

    public void update() {
        player.update(main, controls);
    }
    
}
