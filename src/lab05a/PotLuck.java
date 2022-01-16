package lab05a;

import javax.swing.*;
import java.awt.*;

/**
 * Class that runs the Pot Luck app and contains
 * the main method.
 * @author Onurcan Ataç
 */
public class PotLuck {
    public static void main(String[] args)  {

        //create a frame and panel
        JFrame frame;
        JPanel panel;

        //initialize panel
        panel = new PotLuckPanel();

        //initialize frame
        frame = new JFrame("PotLuck");
        
        //default layout of frame is BorderLayout, so we don't have to set it again
        
        //make sure that app stops working when the app window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set sizes of frame and panel
        frame.setSize(500,600);
        panel.setSize(500,500);

        //add panel to the center of frame
        frame.add(panel,BorderLayout.CENTER);
        
        //set the frame visible
        frame.setVisible(true);

    }
    
}
