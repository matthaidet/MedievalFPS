/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;


/**
 *
 * @author MattH
 */
public class Player extends CharacterControl {
    private int score;
    private float health;
    private float maxHealth;
    private int deaths;
    private boolean isLiving;
    private LoadOut loadOut;
    private String name;
    private int remainingRespawnTime;
    private Vector3f position;
    private Vector3f camDir = new Vector3f();
    private Vector3f camLeft = new Vector3f();
    private Vector3f walkDirection = new Vector3f();
    private BulletAppState bulletAppState;
    private CapsuleCollisionShape capsuleShape;
    
    public Player(Profile profile) {
        capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
        this.setCollisionShape(capsuleShape);
        this.stepHeight = 0.05f;
        name = profile.getName();
        this.remainingRespawnTime = 0;
    }

    public void spawn(Vector3f p, LoadOut loadOut) {
        position = p;
        isLiving = true;
        health = maxHealth;
    }

    public void init(Main main, Environment environment) {  
        main.getFlyByCamera().setMoveSpeed(100);
        this.setJumpSpeed(20);
        this.setFallSpeed(30);
        this.setGravity(40);
        this.setPhysicsLocation(new Vector3f(-50, 200, 0));
    }

    public void update(Main main, Controls controls) {
        Camera cam = main.getCam();
        camDir.set(cam.getDirection()).multLocal(0.6f);
        camLeft.set(cam.getLeft()).multLocal(0.4f);
        walkDirection.set(0, 0, 0);
        if (controls.getIsLeft()) {
            walkDirection.addLocal(camLeft);
        }
        if (controls.getIsRight()) {
            walkDirection.addLocal(camLeft.negate());
        }
        if (controls.getIsUp()) {
            walkDirection.addLocal(camDir);
        }
        if (controls.getIsDown()) {
            walkDirection.addLocal(camDir.negate());
        }
        if (cam.getUp().getY() <= 1f && cam.getDirection().getY() <= -.3f) {
            System.out.println(cam.getUp());
            System.out.print(cam.getDirection());
        }
        this.setWalkDirection(walkDirection);
        cam.setLocation(this.getPhysicsLocation());
    }
    
}
