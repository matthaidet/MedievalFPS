/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.frames.Frame;
import main.frames.MainMenu;

/**
 *
 * @author MattH
 */
public class FrameHandler {
    private static Frame currentFrame;
    private static Frame[] frames;

    public static void switchTo(Frame frame) {
        currentFrame = frame;
    }

    public static void updateCurrentFrame() {
        currentFrame.update();
    }

    public static void displayCurrentFrame() {
        currentFrame.display();
    }

    public static Frame getCurrentFrame() {
        return currentFrame;
    }
}
