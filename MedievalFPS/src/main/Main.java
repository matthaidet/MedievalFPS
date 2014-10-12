package main;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Spatial;
import com.jme3.util.SkyFactory;
import com.jme3.water.WaterFilter;
import com.jme3.water.SimpleWaterProcessor;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    Spatial waterPlane;
    Geometry lightSphere;
    SimpleWaterProcessor waterProcessor;
    Node sceneNode;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(30); //i think we all agree that the camera was too damn slow!
        Spatial myTerrain = assetManager.loadModel(
                "Models/Scenes/scene1.j3o");
        rootNode.attachChild(myTerrain);
        rootNode.attachChild(SkyFactory.createSky(assetManager, "Textures/skybox1.dds", false));
        sceneNode = new Node("Scene");
        
        rootNode.attachChild(sceneNode);
        //WATER
        waterProcessor = new SimpleWaterProcessor(assetManager);
        waterProcessor.setReflectionScene(sceneNode);
        waterProcessor.setDebug(false);
        viewPort.addProcessor(waterProcessor);


        //create water quad
       
        waterPlane=(Spatial)  assetManager.loadModel("Models/Water.mesh.xml");
        waterPlane.setMaterial(waterProcessor.getMaterial());
        waterPlane.setLocalScale(40);
        waterPlane.setLocalTranslation(-5, 0, 5);
        waterPlane.setMaterial(waterProcessor.getMaterial());
        rootNode.attachChild(waterPlane);
        
    }
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
