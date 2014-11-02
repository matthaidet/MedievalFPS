/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.frames;

import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author MattH
 */
public interface Frame{

    public String getName();

    public void init();

    public void display();

    public void update();

    public void action(int i);
}
