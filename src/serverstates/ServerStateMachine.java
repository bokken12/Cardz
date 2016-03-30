/**
 * 
 */
package serverstates;

import java.util.Stack;

import states.State;
import networking.ObjectListener;

/**
 * @author joelmanning
 *
 */
public class ServerStateMachine implements ObjectListener
{
    private Stack<ServerState> states;
    
    public ServerStateMachine(){
        states = new Stack<ServerState>();
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
