/**
 * 
 */
package states;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import display.Button;

/**
 * @author joelmanning
 *
 */
public class DeckSelectionState extends GameState implements ActionListener
{

    /**
     * 
     */
    private static final long serialVersionUID = 2249439061766109329L;
    private List<String> allKeys;
    private int page = 0;
    private Button[][] decks;
    private Button prev;
    private Button next;

    /**
     * @param bounds
     */
    public DeckSelectionState(Rectangle bounds)
    {
        super(bounds);
        decks = new Button[3][3];
    }

    /*
     * (non-Javadoc)
     * 
     * @see states.State#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        if(data == null){
            System.out.println("data");
        } else if(data.getDecks() == null){
            System.out.println("decks");
        } else if(data.getDecks().size() == 0){
            System.out.println("0");
        }
        allKeys = Arrays
                .asList(data.getDecks().keySet().toArray(new String[1]));
        prev = new Button(0, getHeight() * 2 / 5, getWidth() / 5,
                getHeight() / 5, "Previous");
        add(prev);
        prev.addActionListener(this);
        next = new Button(getWidth() * 4 / 5, getHeight() * 2 / 5,
                getWidth() / 5, getHeight() / 5, "Next");
        add(next);
        next.addActionListener(this);
        loadPage();
    }

    /**
     * 
     */
    private void loadPage()
    {
        for (int r = 0; r < decks.length; r++)
        {
            for (int c = 0; c < decks[r].length; c++)
            {
                if (decks[r][c] != null)
                {
                    remove(decks[r][c]);
                    decks[r][c] = null;
                }
                int index = (page * 3 + r) * 3 + c;
                if (index < allKeys.size())
                {
                    decks[r][c] = new Button(getWidth() * (c + 1) / 5,
                            getHeight() * (1 + r) / 5, getWidth() / 5,
                            getHeight() / 5, allKeys.get(index));
                    decks[r][c].setActionCommand(allKeys.get(index));
                    add(decks[r][c]);
                }
            }
        }
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(prev)){
            if(page > 0){
                page--;
                loadPage();
            }
        } else if(e.getSource().equals(next)){
            page++;
            loadPage();
        } else {
            if(allKeys.contains(e.getActionCommand())){
                
            }
        }
    }

}
