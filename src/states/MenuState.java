/**
 * 
 */
package states;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import display.Button;

/**
 * @author joelmanning
 *
 */
public class MenuState extends GameState implements ActionListener
{
    /**
     * 
     */
    private static final long serialVersionUID = -7741577124011125435L;
    private Button play;
    private Button collection;
    private Button shop;
    /**
     * @param bounds
     */
    public MenuState(Rectangle bounds)
    {
        super(bounds);
    }

    /* (non-Javadoc)
     * @see states.State#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        int high = 0;
        int mid = getHeight() * 3 / 10;
        int low = getHeight() * 6 / 10;
        play = new Button(0, high, getWidth(), mid, "Play");
        add(play);
        play.addActionListener(this);
        collection = new Button(0, mid, getWidth(), mid, "Collection");
        add(collection);
        collection.addActionListener(this);
        shop = new Button(0, low, getWidth(), mid, "Shop");
        add(shop);
        shop.addActionListener(this);
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
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(play)){
            setState(new DeckSelectionState(getBounds()));
        }
    }

}
