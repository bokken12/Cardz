/**
 * 
 */
package states;

import general.Game;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import messages.AccountRejected;
import messages.LoginAccepted;
import messages.LoginRejected;
import messages.Verification;
import messages.VerificationRejected;
import display.Button;
import display.FixedWidthMessage;
import display.TextField;

/**
 * @author joelmanning
 *
 */
public class VerificationState extends State implements ActionListener
{
    /**
     * 
     */
    private static final long serialVersionUID = -256012226380874371L;
    private static final int TEXT_WIDTH = 120;
    private static final int TEXT_HEIGHT = 30;
    private static final int SPACING = 10;
    private Button verify;
    private Button accountCreation;
    private TextField number;
    /**
     * @param bounds
     */
    public VerificationState(Rectangle bounds)
    {
        super(bounds);
    }

    /* (non-Javadoc)
     * @see states.State#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        int leftPos = Game.WIDTH / 2 - TEXT_WIDTH - SPACING / 2;
        int rightPos = (Game.WIDTH + SPACING) / 2;
        int topPos = (Game.HEIGHT - TEXT_HEIGHT - SPACING - TEXT_WIDTH) / 2;
        int bottomPos = (Game.HEIGHT + TEXT_HEIGHT + SPACING - TEXT_WIDTH) / 2;
        verify = new Button(rightPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH, "Verify");
        add(verify);
        verify.addActionListener(this);
        accountCreation = new Button(leftPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH, "Account Creation");
        add(accountCreation);
        accountCreation.addActionListener(this);
        number = new TextField(leftPos, topPos, 2 * TEXT_WIDTH + SPACING, TEXT_HEIGHT, "Enter Verification Code");
        add(number);
    }

    /* (non-Javadoc)
     * @see states.State#onBegin()
     */
    @Override
    public void onBegin()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see states.State#onLeave()
     */
    @Override
    public void onLeave()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see states.State#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see states.State#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        if(o instanceof VerificationRejected){
            FixedWidthMessage.showMessage("The verification code you entered was incorrect, please try again.", "Verification Failed", JOptionPane.INFORMATION_MESSAGE, getWidth()/2);
        } else if(o instanceof AccountRejected){
            AccountCreationState acs = new AccountCreationState(getBounds());
            setState(acs);
            acs.objectRecieved(o);
        } else if(o instanceof LoginAccepted || o instanceof LoginRejected){
            LoginState ls = new LoginState(getBounds());
            setState(ls);
            ls.objectRecieved(o);
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(accountCreation)){
            setState(new AccountCreationState(getBounds()));
        } else if(e.getSource().equals(verify)){
            try {
                int i = Integer.parseInt(number.getText());
                send(new Verification(i));
            } catch(NumberFormatException nfe){
                FixedWidthMessage.showMessage("Please make sure you have entered a valid number.", "Number Formatting", JOptionPane.INFORMATION_MESSAGE, getWidth()/2);
            }
        }
    }

}
