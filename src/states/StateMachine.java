package states;

import java.util.Stack;

import javax.swing.JLayeredPane;

import networking.ObjectListener;

/**
 * @author joelmanning
 *
 */
public class StateMachine extends JLayeredPane implements ObjectListener
{
    /**
     * 
     */
    private static final long serialVersionUID = 8208235583234489139L;
    private int position;
    private Stack<State> states;

    public StateMachine(int x, int y, int width, int height)
    {
        position = -29999;
        states = new Stack<State>();
    }

    public void run()
    {
        states.add(new DefaultState(getBounds()));
        add(states.peek());
        position++;
        states.peek().onInitialize();
        states.peek().onBegin();
        repaint();
    }

    public void addState(State s)
    {
        states.peek().onLeave();
        states.push(s);
        add(s, position);
        position++;
        s.onInitialize();
        s.onBegin();
        repaint();
    }

    public void removeState()
    {
        states.peek().onLeave();
        states.peek().onDestroy();
        remove(states.pop());
        position--;
        states.peek().onBegin();
        repaint();
    }

    public void setState(State s)
    {
        states.peek().onLeave();
        states.peek().onDestroy();
        remove(states.pop());
        add(s, position - 1);
        s.onInitialize();
        s.onBegin();
        repaint();
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
