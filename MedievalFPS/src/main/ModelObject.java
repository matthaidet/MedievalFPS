/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.Vector;

/**
 *
 * @author MattH
 */
public class ModelObject extends Geometry {
private String filePath;
    private Vector position;
    private float glow;
    private Vector size;
    private Spatial spatial;
    private RigidBodyControl rigidBody;
    private Node node;
    private AssetManager assetManager;


    public ModelObject(String filePath, Vector p, AssetManager a) {
        this.filePath = filePath;
        position = p;
        assetManager = a;
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getSize() {
        return size;
    }

}
