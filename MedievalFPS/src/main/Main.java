package main;

import com.jme3.app.SimpleApplication;
import com.jme3.audio.AudioRenderer;
import com.jme3.bullet.BulletAppState;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.Camera;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import main.maps.DesertIsland;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    public BulletAppState bulletAppState;
    private Nifty nifty;
    private Player player;
    private Environment environment;
    private Game game;
 
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        player = new Player(new Profile());
        game = new Game(this, new DesertIsland(), player, nifty);
    }

    @Override
    public void simpleUpdate(float tpf) {
        game.gameLoop();
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    public void bind(Nifty nifty, Screen screen) {
        System.out.println("bind( " + screen.getScreenId() + ")");
    }

    public void onStartScreen() {
        System.out.println("onStartScreen");
    }

    public void onEndScreen() {
        System.out.println("onEndScreen");
    }

    public void quit() {
        nifty.gotoScreen("end");
    }

    public AudioRenderer getAudioManager() {
        return audioRenderer;
    }

    public BulletAppState getBulletAppState() {
        return bulletAppState;
    }

    public Camera getCam() {
        return cam;
    }
}
