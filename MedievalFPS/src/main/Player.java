/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import main.weapons.BasicBow;
import main.weapons.Weapon;

/**
 *
 * @author MattH
 */
public class Player extends CharacterControl {

    private int score;
    private float health;
    private float maxHealth;
    private float healthRegen;
    private short deaths;
    private boolean isLiving;
    private LoadOut loadOut;
    private Weapon currentWeapon;
    private String name;
    private short remainingRespawnTime;
    private float currentSpeed, maxSpeed;
    private Vector3f position;
    private Vector3f camDir = new Vector3f();
    private Vector3f camLeft = new Vector3f();
    private Vector3f walkDirection = new Vector3f();

    public Player(Profile profile) {
        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
        this.setCollisionShape(capsuleShape);
        this.stepHeight = 0.05f;
        name = profile.getName();
        this.remainingRespawnTime = 0;
        this.maxSpeed = .5f;
        remainingRespawnTime = 0;
        currentWeapon = new BasicBow();
    }

    public void spawn(Vector3f p, LoadOut loadOut) {
        position = p;
        maxHealth = loadOut.getMaxHealth();
        currentSpeed = loadOut.getSpeed();
        healthRegen = loadOut.getHealthRegen();
        this.currentSpeed = this.maxSpeed;
        health = maxHealth;
        isLiving = true;
    }

    public void init(Main main, Environment environment) {
        main.getFlyByCamera().setMoveSpeed(currentSpeed * 3);
        this.setMaxSlope(10);
        this.setJumpSpeed(20);
        this.setFallSpeed(30);
        this.setGravity(35);
        this.setPhysicsLocation(new Vector3f(-50, 100, 0));
    }

    public void update(Main main, Controls controls) {
        Camera cam = main.getCam();
        camDir.set(cam.getDirection()).multLocal(currentSpeed);
        camLeft.set(cam.getLeft()).multLocal(currentSpeed / 2);
        walkDirection.set(0, 0, 0);
        if (controls.getIsLeft()) {
            if (this.onGround()) {
                walkDirection.addLocal(camLeft);
            } else {
                camLeft.set(cam.getLeft()).multLocal(currentSpeed / 2.5f);
                walkDirection.addLocal(camLeft);
            }
        }
        if (controls.getIsRight()) {
            if (this.onGround()) {
                walkDirection.addLocal(camLeft.negate());
            } else {
                camLeft.set(cam.getLeft()).multLocal(currentSpeed / 2.5f);
                walkDirection.addLocal(camLeft.negate());
            }
        }
        if (controls.getIsUp()) {
            if (this.onGround()) {
                walkDirection.addLocal(camDir);
            } else {
                camDir.set(cam.getDirection()).multLocal(currentSpeed / 1.5f);
                walkDirection.addLocal(camDir);
            }
        }
        if (controls.getIsDown()) {
            if (cam.getDirection().getY() >= -.3f) { //fixes flying glitch
                if (this.onGround()) {
                    walkDirection.addLocal(camDir.negate());
                } else {
                    camDir.set(cam.getDirection()).multLocal(currentSpeed / 1.5f);
                    walkDirection.addLocal(camDir.negate());
                }
            } else {
                walkDirection.addLocal(camDir.negate().setY(-.3f));
            }
        }

        if (cam.getDirection().getY() >= 0.5) {
            Vector3f newCamDirection = cam.getDirection();
            newCamDirection.setY(0.4999f);
            cam.lookAtDirection(newCamDirection, cam.getUp());
        }
        if (cam.getDirection().getY() <= -0.6) {
            Vector3f newCamDirection = cam.getDirection();
            newCamDirection.setY(newCamDirection.getY() - newCamDirection.getY() - 0.6f);
            cam.lookAtDirection(newCamDirection, cam.getUp());
        }

        if (controls.getIsPulling()) {
            this.currentWeapon.pull(1);
            currentSpeed = this.maxSpeed / 2;
        } else {
            if (this.currentWeapon.getCurrentDrawback() >= 1) {
                this.currentWeapon.release();
            }
            currentSpeed = this.maxSpeed;
        }


        //prevent camera glitch by stabalizing Roll
        float[] angles = {0, 0, 0};
        cam.getRotation().toAngles(angles);
        cam.getRotation().fromAngles(angles[0], angles[1], 0);


        this.setWalkDirection(walkDirection);
        cam.setLocation(this.getPhysicsLocation());
    }

    float getHealth() {
        return health;
    }
}
