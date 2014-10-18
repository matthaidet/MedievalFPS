/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;


/**
 *
 * @author MattH and LeonB
 */
public class ModelObject extends Geometry {
private String filePath;
    private Vector3f position;
    private float glow;
    private Vector3f size;
    private boolean sizeSet;
    private Spatial spatial;
    private RigidBodyControl rigidBody;
    private Node node;
    private AssetManager assetManager;
    private Quaternion rotation;
    private boolean rotationSet;
    private Spatial modelSpatial;


    public ModelObject(String filePath, Vector3f p, AssetManager a) {
        sizeSet = false; //excludes size and rotation if they are not specified
        rotationSet = false;
        this.filePath = filePath;
        position = p;
        assetManager = a;
    }
    
    public void drawModel() {
        modelSpatial = assetManager.loadModel(filePath); //create model with filepath
        if(rotationSet == true) { //only set rotation if has been specified
            modelSpatial.setLocalRotation(rotation);
        }
        modelSpatial.setLocalTranslation(position);
        if(sizeSet == true) { //only set scale if it has been specified
            modelSpatial.setLocalScale(size);
        }
        node.attachChild(modelSpatial);
    }

    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getSize() {
        return size;
    }
    
    public Quaternion getRotation() {
        return rotation;
    }
    
    public void setRotation(Quaternion q) { //set rotation
        rotation = q;
        rotationSet = true; //mark that rotation has been set
    }
    
    public void setSize(Vector3f s) { //specify size
        size = s;
        sizeSet = true; //mark that size has been set
    }
    
    public void setPosition(Vector3f p) {
        position = p; //set position constantly for moving objects
    }
    

}
