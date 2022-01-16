package lab05b;

import javax.swing.*;
import java.awt.*;

/**
 * A class which extends JPanel and creates a panel with 
 * labels for different showings for numbers.
 * @author Onurcan Ataç
 */
public class LabelPanel extends JPanel {

    JLabel decimalLabel;
    JLabel hexLabel;
    JLabel binaryLabel;

    /**
     * Constructor to create a LabelPanel
     */
    public LabelPanel()
    {
        this.setLayout(new GridLayout(3,1));
        
        decimalLabel = new JLabel("Decimal");
        this.add(decimalLabel);

        hexLabel = new JLabel("Hex");
        this.add(hexLabel);

        binaryLabel = new JLabel("Binary");
        this.add(binaryLabel);
     
    }
    
}
