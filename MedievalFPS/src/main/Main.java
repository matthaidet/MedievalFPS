package main;

import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.post.FilterPostProcessor;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import com.jme3.util.SkyFactory;
import com.jme3.water.SimpleWaterProcessor;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication implements ScreenController {

    private Nifty nifty;
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
        GUI gui = new GUI();
        
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(30); //i think we all agree that the camera was too damn slow!
        Spatial myTerrain = assetManager.loadModel(
                "Models/Scenes/scene1.j3o");
        rootNode.attachChild(myTerrain);

        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
                inputManager,
                audioRenderer,
                guiViewPort);
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("Interface/HUD.xml", "start", this);

        // attach the nifty display to the gui view port as a processor
        guiViewPort.addProcessor(niftyDisplay);
        
        rootNode.attachChild(SkyFactory.createSky(assetManager, "Textures/skybox1.dds", false));
        
         
        FilterPostProcessor water;
        water = assetManager.loadFilter("Models/waterFilter.j3f");
        viewPort.addProcessor(water);
        
    }
    @Override
    public void simpleUpdate(float tpf) {
        
        //TODO: add update code
        
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
}
