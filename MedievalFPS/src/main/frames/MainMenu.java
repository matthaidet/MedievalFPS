/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.frames;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import main.FrameHandler;
import main.Main;
import main.GUI;
import main.Player;
import main.Profile;
import main.maps.DesertIsland;

/**
 *
 * @author MattH
 */
public class MainMenu implements Frame {
    private Nifty nifty;
    private GUI menu;
    private Main main;
    private Profile profile;


    public MainMenu(Main m, Profile p) {
        main = m;
        profile = p;
        this.init();
    }

    public String getName() {
        return "Main-Menu";
    }

    public void init() {
        main.getFlyByCamera().setEnabled(false);
        menu = new GUI("Interface/MainMenu.xml", "Main-Menu");
    }

    public void display() {
        menu.display(main, nifty);
    }

    public void exit() {
        main.quit();
    }

    public void play() {
        Player player = new Player(profile);
        FrameHandler.switchTo(new Game(player, main, new DesertIsland()));
        FrameHandler.displayCurrentFrame();

    }

    public void update() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void action(int i) {
        switch (i) {
            case 0:
                exit();
                break;

            case 1:
                play();
                break;

            case 2:

                break;
        }
    }
}


