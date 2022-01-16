package lab05b;

import javax.swing.*;
import java.awt.*;

/**
 * Class that runes Number Converter app and
 * contains the main method.
 * @author Onurcan Ataç
 */
public class NumberConverter {   
    public static void main(String[] args) {

        //declare and initialize frame and required panels
        JFrame frame = new JFrame("Convert Numbers");
        JPanel textFieldPanel = new TextFieldPanel();
        JPanel labelPanel = new LabelPanel();

        //make sure that app stops working when the app window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the size of the frame
        frame.setSize(500,500);

        //default layout of frame is BorderLayout, so we don't have to set it again

        //add the panels to the frame in required positions
        frame.add(labelPanel, BorderLayout.WEST);
        frame.add(textFieldPanel, BorderLayout.CENTER);

        //set the frame visible
        frame.setVisible(true);
   
    }
}
