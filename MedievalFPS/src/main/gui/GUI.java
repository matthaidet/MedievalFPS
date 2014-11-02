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
public class GUI implements ScreenController {

    private String xmlFilePath;
    private String name;

    public GUI(String xmlPath, String n) {
        xmlFilePath = xmlPath;
        name = n;
    }

    public String getName() {
        return name;
    }

    public void display(Main main, Nifty nifty) {
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(main.getAssetManager(),
                main.getInputManager(),
                main.getAudioManager(),
                main.getGuiViewPort());
        nifty = niftyDisplay.getNifty();

        nifty.fromXml(xmlFilePath, "start", this);

        main.getGuiViewPort().addProcessor(niftyDisplay);
    }

    public void hide() {
    }

    public String getXMLFilePath() {
        return xmlFilePath;
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
