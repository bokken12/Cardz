/**
 * 
 */
package states;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author joelmanning
 *
 */
public class SettingsState extends GameState implements MouseListener
{

    /**
     * 
     */
    private static final long serialVersionUID = 4841310739705331150L;

    /**
     * @param bounds
     */
    public SettingsState(Rectangle bounds)
    {
        super(bounds);
    }

    /* (non-Javadoc)
     * @see states.State#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        addMouseListener(this);
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
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        removeState();
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

}
