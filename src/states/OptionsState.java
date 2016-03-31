/**
 * 
 */
package states;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import display.Button;

/**
 * @author joelmanning
 *
 */
public class OptionsState extends GameState implements ActionListener, MouseListener
{
    /**
     * 
     */
    private static final long serialVersionUID = 9056088700908769718L;
    private Button quit;
    private Button settings;

    /**
     * @param bounds
     */
    public OptionsState(Rectangle bounds)
    {
        super(bounds);
    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        settings = new Button(getWidth() / 5, getHeight() / 5,
                getWidth() * 3 / 5, getHeight() / 5, "Settings");
        add(settings);
        settings.addActionListener(this);
        quit = new Button(getWidth() / 5, getHeight() * 3 / 5,
                getWidth() * 3 / 5, getHeight() / 5, "Quit");
        add(quit);
        quit.addActionListener(this);
        addMouseListener(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onBegin()
     */
    @Override
    public void onBegin()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onLeave()
     */
    @Override
    public void onLeave()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(quit)){
            System.exit(0);
        } else if(e.getSource().equals(settings)){
            addState(new SettingsState(getBounds()));
        } else {
            System.out.println("OptionsState recieved an action");
        }
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
