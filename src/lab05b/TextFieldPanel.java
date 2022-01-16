package lab05b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a panel that contains textfields.
 * Also has an inner class which is an implementation
 * of ActionListener.
 * @author Onurcan Ataç
 */
public class TextFieldPanel extends JPanel {

    JTextField decimalField;
    JTextField hexField;
    JTextField binaryField;

    Converter converter = new Converter();

    //constructors
    /**
     * Constuctor for TextFieldPanel which
     * creates textfields and adds them to
     * the panel.
     */ 
    public TextFieldPanel()
    {
        this.setLayout(new GridLayout(3,1));

        decimalField = new JTextField();
        decimalField.addActionListener(converter);
        this.add(decimalField);

        hexField = new JTextField();
        hexField.addActionListener(converter);
        this.add(hexField);

        binaryField = new JTextField();
        binaryField.addActionListener(converter);
        this.add(binaryField);   
    }

    /**
     * An inner class Converter (which implements ActionListener)
     * and performs when numbers are entered. Also makes the 
     * computations among numbers.
     */
    class Converter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource() == decimalField)
            {
                int decimalNumber = Integer.parseInt(decimalField.getText());
                hexField.setText(Integer.toHexString(decimalNumber));
                binaryField.setText(Integer.toBinaryString(decimalNumber));
            }

            else if(e.getSource() == hexField)
            {
                String hexString = hexField.getText();
                int decimal = Integer.parseInt(hexString , 16);
                decimalField.setText("" + decimal);
                binaryField.setText(Integer.toBinaryString(decimal));                
            }

            else if(e.getSource() == binaryField)
            {
                String binaryNumber = binaryField.getText();
                int decimal = Integer.parseInt(binaryNumber,2);
                decimalField.setText("" + decimal);
                hexField.setText(Integer.toHexString(decimal));                
            }   
        }   
    }    
}


