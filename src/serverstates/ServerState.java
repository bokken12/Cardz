/**
 * 
 */
package serverstates;

import networking.ObjectListener;
import server.Handler;
import server.Server;

/**
 * @author joelmanning
 *
 */
public abstract class ServerState implements ObjectListener
{
    protected Handler handle;

    public ServerState(Handler h)
    {
        handle = h;
    }

    public abstract void onInitialize();

    public abstract void onBegin();

    public abstract void onLeave();

    public abstract void onDestroy();

    /*
     * (non-Javadoc)
     * 
     * @see networking.ObjectListener#objectRecieved(java.lang.Object)
     */
    @Override
    public abstract void objectRecieved(Object o);

    protected void send(Object o)
    {
        handle.write(o);
    }

    protected void addState(ServerState s)
    {
        handle.getSm().addState(s);
    }

    protected void setState(ServerState s)
    {
        handle.getSm().addState(s);
    }

    protected void removeState()
    {
        handle.getSm().removeState();
    }
    
    protected void printInfo(String string){
        Server.getServer().printInfo(string);
    }
    
    protected void printError(String string){
        Server.getServer().printError(string);
    }
}
