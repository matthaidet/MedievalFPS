/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author MattH
 */
public class Environment {
    private Spatial sceneModel;
    private RigidBodyControl landscape;
    private Node rootNode;

    public Environment(Main main, Map map) {
        AssetManager assetManager = main.getAssetManager();
        rootNode = main.getRootNode();

        sceneModel = main.getAssetManager().loadModel(map.getTerrainFilePath());
        CollisionShape sceneShape =
                CollisionShapeFactory.createMeshShape((Node) sceneModel);
        landscape = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(landscape);
        FilterPostProcessor water;
        water = assetManager.loadFilter(map.getWaterFilePath());
        main.getViewPort().addProcessor(water);
        Spatial decorations = assetManager.loadModel(map.getDecorationsFilePath());
        rootNode.attachChild(decorations);
        rootNode.attachChild(sceneModel);
        //this.setUpLight();
    }

    private void setUpLight() {
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(al);
        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
        rootNode.addLight(dl);
    }

    public RigidBodyControl getLandscape() {
        return landscape;
    }

    public Spatial getSceneModel() {
        return sceneModel;
    }
}
