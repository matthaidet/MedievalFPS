package main;

import main.gui.HUD;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.bullet.BulletAppState;
import com.jme3.input.InputManager;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Spatial;
import com.jme3.renderer.Camera;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    private BulletAppState bulletAppState;
    private Nifty nifty;
    private Spatial sceneModel;
    private HUD hud;
    private Controls controls;
    private Player player;
    private Environment environment;
 
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        environment = new Environment(this);
        player = new Player(new Profile());
        bulletAppState.getPhysicsSpace().add(player);
        rootNode.attachChild(environment.getSceneModel());
        bulletAppState.getPhysicsSpace().add(environment.getLandscape());
        controls = new Controls(player);
        hud = new HUD();
        hud.displayHUD(nifty, this);
        controls.setUpKeys(this);
        player.init(this, environment);
        setUpLight();
    }

    private void setUpLight() {
        // We add light so we see the scene
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(al);

        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
        rootNode.addLight(dl);
    }

    @Override
    public void simpleUpdate(float tpf) {
        healthMeter(); //update impromptu health meter
        player.update(this, controls);
    }
    
    void healthMeter() { //sketchy heath meter. you should probably find a better data output
        float health = player.getHealth();
        String healthString = String.valueOf(health);
        //fpsText.setText("Health: "+healthString);
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
