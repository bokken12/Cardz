/**
 * 
 */
package states;

import general.Mode;

import javax.swing.JLabel;

import messages.Ping;
import messages.Pong;
import display.Label;

/**
 * @author joelmanning
 *
 */
public class DefaultState extends State
{
    private JLabel pinging;
    
    public DefaultState(){
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
            addState(new LoginState());
        }
    }

}
