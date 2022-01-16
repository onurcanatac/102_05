package lab05a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class implements ActionListener and receives the
 * action events from the buttons.
 * @author Onurcan Ataç
 */
public class ClickListener implements ActionListener {

    JLabel messageLabel = new JLabel();
    boolean isFinished = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() instanceof BombButton)
        {  
            if(!isFinished)
            {
                //increase total tries
                ((PotLuckPanel)((BombButton) e.getSource()).getParent()).increaseTotalTries(1);
                
                //reveal all of the buttons
                ((PotLuckPanel)((BombButton) e.getSource()).getParent()).revealSpecialButtons();

                //set text to the messageLabel for user
                messageLabel.setText("You are blown up at attempt " + ((PotLuckPanel)((BombButton) e.getSource()).getParent()).getTotalTries() + "!"  );
                ((PotLuckPanel)((BombButton) e.getSource()).getParent()).getParent().add(messageLabel, BorderLayout.SOUTH);
                
                isFinished = true;
            }
        }

        else if(e.getSource() instanceof PrizeButton)
        {
            if(!isFinished)
            {
                //increase total tries
                ((PotLuckPanel)((PrizeButton) e.getSource()).getParent()).increaseTotalTries(1);
            
                //reveal all of the buttons
                ((PotLuckPanel)((PrizeButton) e.getSource()).getParent()).revealSpecialButtons();

                //set text to the messageLabel for user
                messageLabel.setText("You got it in " + ((PotLuckPanel)((PrizeButton) e.getSource()).getParent()).getTotalTries() + " attempts!"  );
                ((PotLuckPanel)((PrizeButton) e.getSource()).getParent()).getParent().add(messageLabel, BorderLayout.SOUTH);
                
                isFinished = true;
            }   
        }
        
        else
        {
            //disable the button so that user can't click it again
            ((JButton)e.getSource()).setEnabled(false);

            //increase total tries
            ((PotLuckPanel)((JButton) e.getSource()).getParent()).increaseTotalTries(1);
        }
        
    }
}