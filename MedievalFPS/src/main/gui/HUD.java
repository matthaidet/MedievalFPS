/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.gui;

import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import main.Main;

/**
 *
 * @author MattH
 */
public class HUD extends GUI implements ScreenController {

    public HUD() {
        
    }

    public void displayHUD(Nifty nifty, Main main) {
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(main.getAssetManager(),
                main.getInputManager(),
                main.getAudioManager(),
                main.getGuiViewPort());
        nifty = niftyDisplay.getNifty();

        nifty.fromXml("Interface/HUD.xml", "start", this);

        main.getGuiViewPort().addProcessor(niftyDisplay);
    }

    public void bind(Nifty nifty, Screen screen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void onStartScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void onEndScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
