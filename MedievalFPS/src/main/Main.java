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
    private NiftyJmeDisplay hudDisplay;
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        initializeWorld(); //initialize water processor and other things and loads terrain
        flyCam.setMoveSpeed(30); //i think we all agree that the camera was too damn slow!
        

// attach the nifty display to the gui view port as a processor
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
                inputManager,
                audioRenderer,
                guiViewPort);
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("Interface/HUD.xml", "start", this);

        guiViewPort.addProcessor(niftyDisplay);
         
        
        
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
    
   public void initializeWorld() {
       FilterPostProcessor water;
       water = assetManager.loadFilter("Models/waterFilter.j3f");
       viewPort.addProcessor(water);
       Spatial myTerrain = assetManager.loadModel(
                "Models/Scenes/scene1.j3o");
       rootNode.attachChild(myTerrain);
   }
}
