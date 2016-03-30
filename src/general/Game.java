package general;
import java.util.List;

import javax.swing.JFrame;

import networking.Client;
import display.Display;
import player.Player;
import states.StateMachine;

/**
 * @author joelmanning
 *
 */
public class Game extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = -803131150195009198L;
    private Client client;
    private StateMachine sm;
    private static Game game;
    
    public Game(){
        super();
        client = new Client();
        client.start();
        sm = new StateMachine();
        add(sm);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Joel's Game");
        setVisible(true);
        repaint();
    }
    
    public static void main(String[] args){
        game = new Game();
    }

    /**
     * @return the client
     */
    public Client getClient()
    {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client)
    {
        this.client = client;
    }

    /**
     * @return the sm
     */
    public StateMachine getSm()
    {
        return sm;
    }

    /**
     * @param sm the sm to set
     */
    public void setSm(StateMachine sm)
    {
        this.sm = sm;
    }

    /**
     * @return the game
     */
    public static Game getGame()
    {
        return game;
    }

    /**
     * @param game the game to set
     */
    public static void setGame(Game game)
    {
        Game.game = game;
    }
    
}
