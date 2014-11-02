package main;

import com.jme3.app.SimpleApplication;
import com.jme3.audio.AudioRenderer;
import com.jme3.bullet.BulletAppState;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.Camera;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import main.frames.Game;
import main.frames.MainMenu;
import main.maps.DesertIsland;
/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    public BulletAppState bulletAppState;
    private Player player;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        player = new Player(new Profile());
//        FrameHandler.switchTo(new MainMenu(this, new Profile()));
        FrameHandler.switchTo(new Game(player, this, new DesertIsland()));
        FrameHandler.displayCurrentFrame();
    }
 

    @Override
    public void simpleUpdate(float tpf) {
        FrameHandler.updateCurrentFrame();
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