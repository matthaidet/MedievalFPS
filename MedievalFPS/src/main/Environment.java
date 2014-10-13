/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author MattH
 */
public class Environment {

    private Spatial sceneModel;
    private RigidBodyControl landscape;

    public Environment(Main main) {
        sceneModel = main.getAssetManager().loadModel("Models/Scenes/originalScene.j3o");
        CollisionShape sceneShape =
                CollisionShapeFactory.createMeshShape((Node) sceneModel);
        landscape = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(landscape);
    }

    public void build(Main main) {
        
    }

    public RigidBodyControl getLandscape() {
        return landscape;
    }

    public Spatial getSceneModel() {
        return sceneModel;
    }
}
