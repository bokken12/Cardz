/**
 * 
 */
package serverstates;

import general.Mode;
import messages.Ping;
import messages.Pong;
import server.Handler;

/**
 * @author joelmanning
 *
 */
public class DefaultServerState extends ServerState
{

    /**
     * @param h
     */
    public DefaultServerState(Handler h)
    {
        super(h);
    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onInitialize()
     */
    @Override
    public void onInitialize()
    {
    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onBegin()
     */
    @Override
    public void onBegin()
    {
    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onLeave()
     */
    @Override
    public void onLeave()
    {
    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        System.out.println("There should be nothing below default state, exitting.");
        System.exit(0);
    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        if(Ping.class.isAssignableFrom(o.getClass())){
            if(Mode.DEBUG){
                System.out.println("Got a ping!");
            }
            send(new Pong());
            setState(new LoginServerState(handle));
        }
    }

}
