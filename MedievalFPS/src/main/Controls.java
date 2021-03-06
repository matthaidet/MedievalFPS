/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;

/**
 *
 * @author MattH
 */
public class Controls implements ActionListener {
    private Player player;
    private boolean left = false, right = false, up = false, down = false, pulling = false;


    public Controls(Player player) {
        this.player = player;
    }

    public void setUpKeys(Main main) {
        main.getInputManager().addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        main.getInputManager().addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        main.getInputManager().addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        main.getInputManager().addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
        main.getInputManager().addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        main.getInputManager().addMapping("Click", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        main.getInputManager().addListener(this, "Left");
        main.getInputManager().addListener(this, "Right");
        main.getInputManager().addListener(this, "Up");
        main.getInputManager().addListener(this, "Down");
        main.getInputManager().addListener(this, "Jump");
        main.getInputManager().addListener(this, "Click");
    }


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
        } else if (binding.equals("Click")) {
            pulling = isPressed;
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

    public boolean getIsPulling() {
        return pulling;
    }
}
