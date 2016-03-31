/**
 * 
 */
package states;

import general.Game;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import messages.AccountCreation;
import messages.AccountRejected;
import messages.Verify;
import display.Button;
import display.FixedWidthMessage;
import display.PasswordArea;
import display.TextField;

/**
 * @author joelmanning
 *
 */
public class AccountCreationState extends State implements ActionListener
{
    private static final int TEXT_WIDTH = 120;
    private static final int TEXT_HEIGHT = 30;
    private static final int SPACING = 10;
    private TextField username;
    private PasswordArea password;
    private PasswordArea verifyPassword;
    private TextField email;
    private Button createAccount;
    private Button toLogin;

    /**
     * @param bounds
     */
    public AccountCreationState(Rectangle bounds)
    {
        super(bounds);
    }

    /**
     * 
     */
    private static final long serialVersionUID = -1624420981242089419L;

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        int leftPos = Game.WIDTH / 2 - TEXT_WIDTH - SPACING / 2;
        int rightPos = (Game.WIDTH + SPACING) / 2;
        int topPos = (Game.HEIGHT - TEXT_WIDTH) / 2 - TEXT_HEIGHT - SPACING;
        int midPos = (Game.HEIGHT - TEXT_WIDTH) / 2;
        int bottomPos = (Game.HEIGHT - TEXT_WIDTH) / 2 + TEXT_HEIGHT + SPACING;
        username = new TextField(leftPos, topPos, TEXT_WIDTH, TEXT_HEIGHT,
                "Enter Username");
        add(username);
        email = new TextField(rightPos, topPos, TEXT_WIDTH, TEXT_HEIGHT,
                "Enter Email");
        add(email);
        password = new PasswordArea(leftPos, midPos, TEXT_WIDTH, TEXT_HEIGHT,
                "Enter Password");
        add(password);
        verifyPassword = new PasswordArea(rightPos, midPos, TEXT_WIDTH,
                TEXT_HEIGHT, "Verify Password");
        add(verifyPassword);
        createAccount = new Button(leftPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH,
                "Create Account");
        add(createAccount);
        createAccount.addActionListener(this);
        toLogin = new Button(rightPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH,
                "Back To Login");
        add(toLogin);
        toLogin.addActionListener(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onBegin()
     */
    @Override
    public void onBegin()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onLeave()
     */
    @Override
    public void onLeave()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        if (o instanceof Verify)
        {
            FixedWidthMessage
                    .showMessage(
                            "An email should arrive shortly, telling you your verification number.",
                            "Email Verification",
                            JOptionPane.INFORMATION_MESSAGE, getWidth() / 2);
            setState(new VerificationState(getBounds()));
        } else if(o instanceof AccountRejected){
            FixedWidthMessage
            .showMessage(
                    ((AccountRejected) o).getMessage(), "Account Error",
                    JOptionPane.WARNING_MESSAGE, getWidth() / 2);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(toLogin))
        {
            setState(new LoginState(getBounds()));
        }
        else if (e.getSource().equals(createAccount))
        {
            if (Arrays.equals(password.getPassword(),
                    verifyPassword.getPassword()))
            {
                send(new AccountCreation(username.getText(), new String(
                        password.getPassword()), email.getText()));
            }
            else
            {
                FixedWidthMessage.showMessage(
                        "Please make sure your passwords match.",
                        "Verify password", JOptionPane.INFORMATION_MESSAGE,
                        getWidth() / 2);
            }
        }
    }

}
