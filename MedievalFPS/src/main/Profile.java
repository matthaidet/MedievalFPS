/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import main.gui.Menu;
/**
 *
 * @author MattH
 */
public class Profile {
    private String name;
    private String password;
    private boolean isInGame;
    private Menu currentMenu;
    
    public Profile(){
        
    }
    
    public String getName(){
        return name;
    }
}
