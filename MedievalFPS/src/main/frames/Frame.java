/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.frames;

/**
 *
 * @author MattH
 */
public interface Frame{

    public String getName();

    public void init();

    public void display();

    public void update();

    public void dispose();

    public void action(int i);
}
