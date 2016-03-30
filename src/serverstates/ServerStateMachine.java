/**
 * 
 */
package serverstates;

import java.util.Stack;

import server.Handler;
import states.State;
import networking.ObjectListener;

/**
 * @author joelmanning
 *
 */
public class ServerStateMachine implements ObjectListener
{
    private Stack<ServerState> states;
    private Handler handle;
    
    public ServerStateMachine(Handler handle){
        this.handle = handle;
        states = new Stack<ServerState>();
        states.push(new DefaultServerState(handle));
        states.peek().onInitialize();
        states.peek().onBegin();
    }
    
    public void addState(ServerState s){
        states.peek().onLeave();
        states.push(s);
        s.onInitialize();
        s.onBegin();
    }
    
    public void removeState(){
        states.peek().onLeave();
        states.peek().onDestroy();
        states.peek().onBegin();
    }
    
    public void setState(ServerState s){
        states.peek().onLeave();
        states.peek().onDestroy();
        s.onInitialize();
        s.onBegin();
    }

    /*
     * (non-Javadoc)
     * 
     * @see networking.ObjectListener#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        states.peek().objectRecieved(o);
    }
}
