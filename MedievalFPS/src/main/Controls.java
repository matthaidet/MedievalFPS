/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;

/**
 *
 * @author MattH
 */
public class Controls implements ActionListener {
    private Player player;
    private boolean left = false, right = false, up = false, down = false;


    public Controls(Player player) {
        this.player = player;
    }

    /**
     * We over-write some navigational key mappings here, so we can add
     * physics-controlled walking and jumping:
     */
    public void setUpKeys(Main main) {
        main.getInputManager().addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        main.getInputManager().addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        main.getInputManager().addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        main.getInputManager().addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
        main.getInputManager().addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        main.getInputManager().addListener(this, "Left");
        main.getInputManager().addListener(this, "Right");
        main.getInputManager().addListener(this, "Up");
        main.getInputManager().addListener(this, "Down");
        main.getInputManager().addListener(this, "Jump");
    }

    /**
     * These are our custom actions triggered by key presses. We do not walk
     * yet, we just keep track of the direction the user pressed.
     */
    public void onAction(String binding, boolean isPressed, float tpf) {

        if (binding.equals("Left")) {
            left = isPressed;
        } else if (binding.equals("Right")) {
            right = isPressed;
        } else if (binding.equals("Up")) {
            up = isPressed;
        } else if (binding.equals("Down")) {
            down = isPressed;
        } else if (binding.equals("Jump")) {
            if (isPressed) {
                player.jump();
            }
        }
    }

    public boolean getIsLeft() {
        return left;
    }

    public boolean getIsRight() {
        return right;
    }

    public boolean getIsUp() {
        return up;
    }

    public boolean getIsDown() {
        return down;
    }
}
