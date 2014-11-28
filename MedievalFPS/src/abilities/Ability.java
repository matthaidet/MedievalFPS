/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abilities;

import com.jme3.texture.Image;
import main.Player;

/**
 *
 * @author MattH
 */
public interface Ability {

    public String getName();

    public Image getIconImage();

    public void init(Player p);

    public void update(Player p);

    public void activate(Player p);
}
