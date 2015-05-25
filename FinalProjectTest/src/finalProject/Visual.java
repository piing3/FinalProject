/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author d.holmberg
 */
class Visual {

    public Visual() throws FileNotFoundException {
        int fullscreen = JOptionPane.showConfirmDialog(null, "Would you like to run in fullscreen?","Fullscreen" , JOptionPane.YES_NO_OPTION);
        Map map = new Map(fullscreen);
    }
    
}
