/**
 * 
 */
package states;

import java.awt.Rectangle;

import general.Mode;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import messages.Ping;
import messages.Pong;
import display.FixedWidthMessage;
import display.Label;

/**
 * @author joelmanning
 *
 */
public class DefaultState extends State
{
    /**
     * 
     */
    private static final long serialVersionUID = -2327126081465418680L;
    private JLabel pinging;
    
    public DefaultState(Rectangle bounds){
        super(bounds);
        pinging = new Label(10, 10, 50, 30, "Pinging");
    }
    /* (non-Javadoc)
     * @see states.State#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        send(new Ping());
    }

    /* (non-Javadoc)
     * @see states.State#onBegin()
     */
    @Override
    public void onBegin()
    {
        add(pinging);
        System.out.println("Added pinging");
    }

    /* (non-Javadoc)
     * @see states.State#onLeave()
     */
    @Override
    public void onLeave()
    {
        remove(pinging);
    }

    /* (non-Javadoc)
     * @see states.State#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        System.out.println("There should be nothing below default state, program exitting.");
        System.exit(0);
    }

    /* (non-Javadoc)
     * @see states.State#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        if(Pong.class.isAssignableFrom(o.getClass())){
            if(Mode.DEBUG){
                System.out.println("Got a pong!");
            }
            //FixedWidthMessage.showMessage("I'm gonna switch to login now, bye :)", "Switching", JOptionPane.INFORMATION_MESSAGE, null, 50);
            addState(new LoginState(getBounds()));
        }
    }

}
