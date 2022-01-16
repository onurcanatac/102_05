package lab05a;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class extends JPanel and creates a panel which
 * contains buttons for Pot Luck Game.
 * @author Onurcan Ataç
 */
public class PotLuckPanel extends JPanel {

    JButton[] allButtons = new JButton[25];
    JButton[] bombButtons = new JButton[2];
    JButton[] prizeButtons = new JButton[1];
    ArrayList<Integer> buttonNumbers = new ArrayList<>();
    int totalTries;
    ClickListener listenBombsAndPrizes = new ClickListener();
    
    /**
     * Constructor for Pot Luck panel
     */
    public PotLuckPanel()
    {
        this.setLayout(new GridLayout(5,5));
        totalTries = 0;
        
        //create 25 buttons, add them to allButtons array, add them a clicklistener,
        //and also add them to buttonNumbers ArrayList to use later for 
        //determining special buttons
        for(int counter = 1; counter < 26; counter++)
        {
            JButton button = new JButton(""+counter);
            allButtons[counter - 1] = button;
            button.addActionListener(new ClickListener());

            buttonNumbers.add(counter-1, counter);
        }       

        //shuffle the ArrayList of numbers of buttons
        Collections.shuffle(buttonNumbers);

        //select the first two elements from the random shuffled list and 
        //use them as BombButtons
        for( int counter = 0; counter < 2; counter++)
        {
            JButton bButton = new BombButton(buttonNumbers.get(counter) );
            
            bButton.addActionListener(listenBombsAndPrizes);

            bombButtons[counter] = bButton;

            allButtons[buttonNumbers.get(counter)-1] = bButton;
        }

        //select the third element from the random shuffled ArrayList
        //and use it as PrizeButton
        JButton pButton = new PrizeButton(buttonNumbers.get(3));

        pButton.addActionListener(listenBombsAndPrizes);

        allButtons[buttonNumbers.get(3)-1] = pButton;

        prizeButtons[0] = pButton;

        //add all of the buttons to the Pot Luck panel
        for ( JButton jButton : allButtons) 
        {
            this.add(jButton);
        }
    }

    /**
     * Returns the total tries until that moment.
     * @return totalTries
     */
    public int getTotalTries()
    {
        return totalTries;
    }

    /**
     * Increase total tries as entered in the parameter
     * @param increment
     */
    public void increaseTotalTries(int increment )
    {
        totalTries = totalTries + increment;
    }

    /**
     * Method for revealing all BombButtons and PrizeButton
     */
    public void revealSpecialButtons()
    {
        for(int counter = 0; counter < 2; counter++)
        {
            ((BombButton) bombButtons[counter]).setIfRevealed(true);
        }
        ((PrizeButton) prizeButtons[0]).setIfRevealed(true);
        
        repaint();
    }    
}

/**
 * This class is for BombButtons
 * @author Onurcan Ataç
 */
class BombButton extends JButton {

    int number;
    boolean isRevealed;

    /**
     * Constructor for BombButtons.
     * @param number number that BombButton should show before
     * it reveals itself.
     */
    BombButton(int number)
    {
        this.setText("" + number);
        this.setFocusable(false);
        this.number = number;
    }

    /**
     * Method for setting if BombButton is revealed or not.
     * @param revealed
     */
    public void setIfRevealed(boolean revealed)
    {
        isRevealed = revealed;
    }

    /**
     * Getter method for getting isRevealed property.
     * @return isRevealed true/false
     */
    public boolean getIfRevealed()
    {
        return isRevealed;
    }

    /**
     * Overriden paintComponent method for BombButtons
     * to show the bomb image when the bomb is revealed.
     */
    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D graphics2d = (Graphics2D) g;

        super.paintComponent(g);

        if (isRevealed) {

            // Bomb fuse
            graphics2d.setColor(Color.RED);
            graphics2d.setStroke(new BasicStroke(2));
            graphics2d.drawArc(getWidth() / 2, getHeight() / 9, getWidth() / 4, getHeight() * 2 / 9, 180, -100);
            
            // Bomb cap
            graphics2d.setColor(Color.GRAY);
            graphics2d.fillRect( 3 * getWidth() / 8, getHeight() / 5, getWidth() / 4, getHeight() / 6);
            
            // Bomb body
            graphics2d.setColor(Color.BLACK);
            graphics2d.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
        }
    }   
}

/**
 * Class for PrizeButtons
 * @author Onurcan Ataç
 */
class PrizeButton extends JButton {

    int number;
    boolean isRevealed;

    /**
     * Constructor for PrizeButton
     * @param number number that prizeButton
     * displays before revealing itself.
     */
    PrizeButton(int number)
    {
        this.setText("" + number);
        this.setFocusable(false);        
        this.number = number;
    }

    /**
     * Method for setting if PrizeButton is revealed or not.
     * @param revealed
     */
    protected void setIfRevealed(boolean revealed)
    {
        isRevealed = revealed;
    }

    /**
     * Getter method for getting isRevealed property.
     * @return isRevealed true/false
     */
    public boolean getIfRevealed()
    {
        return isRevealed;
    }

    /**
     * Overriden paintComponent method for PrizeButton
     * to show the star image when the star is revealed.
     */
    @Override
    protected void paintComponent(Graphics g) {
        
        //Graphics2D graphics2d = (Graphics2D) g;

        super.paintComponent(g);
        
        if(isRevealed)
        {
            this.setForeground(Color.ORANGE);
            setFont( new Font("Serif", Font.BOLD, 45));
            this.setText("\u2605");
            this.setFocusable(false);
            setOpaque(true);
        }

    }
    
}

    