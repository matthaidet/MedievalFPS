/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.weapons;

import com.jme3.asset.AssetManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import main.ModelObject;
import main.utils.Physics;
import main.Player;
import main.projectiles.Projectile;

/**
 *
 * @author MattH & Leon
 */
public class Arrow extends Projectile {
    Vector3f previousLocation;
    Vector3f location;
    double currentY;
    double currentX;
    double currentZ;
    double dropRate;
    double speed;
    double speedBoost[]; //holds different modifiers for different types of arrows
    double rangeBoost[]; 
    String arrowModelFilePath[];
    int arrowType;
    boolean moving;
    Quaternion direction;
    float startTime;
    float timeElapsed;
    float newAngle;
    AssetManager assetManager;
    ModelObject arrowModel;
    
    public Arrow(Vector3f p, AssetManager a, Player pl) {
        super("", a, p, 1.1f, pl);
    }
    
    private void populateModifiers() {
        speedBoost[0] = 1;
        speedBoost[1] = 1.1;
        speedBoost[2] = 1.2;
        rangeBoost[0] = 1;
        rangeBoost[1] = 1.01;
        rangeBoost[2] = 1.02;
        arrowModelFilePath[0] = "";
        arrowModelFilePath[1] = "";
        arrowModelFilePath[2] = "";
    }
    
    public void initializeArrow(int type, Vector3f createLocation, int newSpeed) {
        startTime = System.currentTimeMillis();
        populateModifiers();
        speed = newSpeed;
        arrowModel = new ModelObject(arrowModelFilePath[arrowType], location, assetManager);
        while(moving == true) {
            timeElapsed = System.currentTimeMillis() - startTime;
            updateGravity();
            updateSpeed();
            updateAngle();
            location.set((int)currentX, (int)currentY, (int)currentZ);
            arrowModel.setRotation(direction);
            arrowModel.setPosition(location);
            arrowModel.drawModel();
           
        }
    }
    
    private void updateGravity() {
        dropRate = Physics.updateY(currentY, timeElapsed);
        dropRate = dropRate * rangeBoost[arrowType];
        
    }
    
    private void updateSpeed() {
        speed = Physics.updateSpeed(speed, timeElapsed);
        speed = speed * speedBoost[arrowType];
        //MUST ADD X, Y, Z update based on the direction the arrow is fired
    }
    
    private void updateAngle() {
        newAngle = location.angleBetween(previousLocation); //finds angle between vectors
        direction.fromAngleAxis(newAngle, new Vector3f(1, 0 ,0));
    }
    
    public void setArrowType(int type) {
        arrowType = type;
    }
    
    public Quaternion getDirection() {
        return direction;
    }
    
    public void setIsMoving(boolean m) {
        moving = m;
    }
    
    public boolean getIsMoving() {
        return moving;
    }
}
