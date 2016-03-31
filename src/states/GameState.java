/**
 * 
 */
package states;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import display.Button;
import player.PlayerData;

/**
 * @author joelmanning
 *
 */
public abstract class GameState extends State
{
    /**
     * 
     */
    private static final long serialVersionUID = 7230522136138680053L;
    protected static PlayerData data;
    private Button options;
    private Button friends;
    /**
     * @param bounds
     */
    public GameState(Rectangle bounds)
    {
        super(bounds);
        BasicListener listener = new BasicListener();
        options = new Button(getWidth() * 8 / 10, getHeight() * 9 / 10, getWidth() / 5, getHeight() / 10, "Options");
        add(options);
        options.addActionListener(listener);
        friends = new Button(0, getHeight() * 9 / 10, getWidth() / 5, getHeight() / 10, "Friends");
        add(friends);
        friends.addActionListener(listener);
    }
    /**
     * @return the data
     */
    public static PlayerData getData()
    {
        return data;
    }
    /**
     * @param data the data to set
     */
    public static void setData(PlayerData data)
    {
        GameState.data = data;
    }
    
    class BasicListener implements ActionListener {

        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource().equals(options)){
                addState(new OptionsState(getBounds()));
            }
        }
        
    }
}
