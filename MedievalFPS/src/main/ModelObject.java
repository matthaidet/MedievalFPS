/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;


/**
 *
 * @author MattH
 */
public class ModelObject extends Geometry {
private String filePath;
    private Vector3f position;
    private float glow;
    private Vector3f size;
    private Spatial spatial;
    private RigidBodyControl rigidBody;
    private Node node;
    private AssetManager assetManager;


    public ModelObject(String filePath, Vector3f p, AssetManager a) {
        this.filePath = filePath;
        position = p;
        assetManager = a;
    }

    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getSize() {
        return size;
    }

}
