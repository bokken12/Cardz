/**
 * 
 */
package states;

import java.awt.Rectangle;

import general.Game;

import javax.swing.JPanel;

import networking.ObjectListener;

/**
 * @author joelmanning
 *
 */
public abstract class State extends JPanel implements ObjectListener
{

    /**
     * 
     */
    private static final long serialVersionUID = -6360153584599762104L;

    public State(int x, int y, int width, int height)
    {
        this(new Rectangle(x, y, width, height));
    }

    public State(Rectangle bounds)
    {
        setLayout(null);
        setBounds(bounds);
        setOpaque(false);
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
        Game.getGame().getClient().write(o);
    }

    protected void addState(State s)
    {
        Game.getGame().getSm().addState(s);
    }

    protected void setState(State s)
    {
        Game.getGame().getSm().setState(s);
    }

    protected void removeState()
    {
        Game.getGame().getSm().removeState();
    }
}
