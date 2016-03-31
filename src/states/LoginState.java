/**
 * 
 */
package states;

import general.Game;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import messages.Login;
import messages.LoginAccepted;
import messages.LoginRejected;
import display.Button;
import display.FixedWidthMessage;
import display.PasswordArea;
import display.TextField;

/**
 * @author joelmanning
 *
 */
public class LoginState extends State implements ActionListener
{
    private static final int TEXT_WIDTH = 120;
    private static final int TEXT_HEIGHT = 30;
    private static final int SPACING = 10;
    private TextField username;
    private PasswordArea password;
    private Button login;
    private Button toAccountCreation;
    /**
     * @param bounds
     */
    public LoginState(Rectangle bounds)
    {
        super(bounds);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 992972211143862167L;

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
        username = new TextField(leftPos, topPos, TEXT_WIDTH, TEXT_HEIGHT,
                "Enter Username");
        add(username);
        password = new PasswordArea(rightPos, topPos, TEXT_WIDTH, TEXT_HEIGHT,
                "Enter Password");
        add(password);
        login = new Button(leftPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH, "Login");
        add(login);
        login.addActionListener(this);
        toAccountCreation = new Button(rightPos, bottomPos, TEXT_WIDTH,
                TEXT_WIDTH, "Account Creation");
        add(toAccountCreation);
        toAccountCreation.addActionListener(this);
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
        if(o instanceof LoginAccepted){
            GameState.setData(((LoginAccepted) o).getData());
            if(GameState.getData() == null){
                System.out.println("Was null");
            } else {
                System.out.println("Was good");
            }
            setState(new MenuState(getBounds()));
        } else if(o instanceof LoginRejected){
            FixedWidthMessage.showMessage(((LoginRejected) o).getMessage(), "Login Failed", JOptionPane.WARNING_MESSAGE, getWidth()/2);
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(toAccountCreation)){
            setState(new AccountCreationState(getBounds()));
        } else if(e.getSource().equals(login)){
            String pass = new String(password.getPassword());
            send(new Login(username.getText(), pass));
        }
    }

}
