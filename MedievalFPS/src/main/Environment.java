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
    private String terrainFilePath, decorationsFilePath, waterFilePath;
    private Spatial sceneModel;
    private RigidBodyControl landscape;
    private Node rootNode;

    public Environment(Main main) {
        AssetManager assetManager = main.getAssetManager();
        rootNode = main.getRootNode();

        sceneModel = main.getAssetManager().loadModel("Models/Scenes/originalScene.j3o");
        CollisionShape sceneShape =
                CollisionShapeFactory.createMeshShape((Node) sceneModel);
        landscape = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(landscape);
        FilterPostProcessor water;
        water = assetManager.loadFilter("Models/waterFilter.j3f");
        main.getViewPort().addProcessor(water);
        Spatial decorations = assetManager.loadModel(
                "Models/Scenes/noCollisionScene.j3o");
        rootNode.attachChild(decorations);
        this.setUpLight();
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

    public RigidBodyControl getLandscape() {
        return landscape;
    }

    public Spatial getSceneModel() {
        return sceneModel;
    }
}
