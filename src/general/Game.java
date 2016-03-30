package general;

import java.util.List;

import javax.swing.JFrame;

import networking.Client;
import display.Display;
import display.Label;
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

    public Game()
    {
        super();
        if(Mode.DEBUG){
            System.out.println("Called super constructor");
        }
        client = new Client();
        if(Mode.DEBUG){
            System.out.println("Created client");
        }
        sm = new StateMachine(0, 0, 500, 500);
        if(Mode.DEBUG){
            System.out.println("Create sm");
        }
        if(Mode.DEBUG){
            System.out.println("Added sm");
        }
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Joel's Game");
        //setResizable(false);
        //add(new Label(0, -40, 100, 100, "Test"));
        sm.setBounds(0, 0, 500, 500);
        add(sm);
        //sm.add(new Label(0, 0, 100, 100, "Testing"), new Integer(-29999));
        setVisible(true);
    }

    public void run()
    {
        client.start();
        game.getSm().run();
    }

    public static void main(String[] args)
    {
        game = new Game();
        if (Mode.DEBUG)
        {
            System.out.println("Finished creating an instance of game");
        }
        game.run();
    }

    /**
     * @return the client
     */
    public Client getClient()
    {
        return client;
    }

    /**
     * @param client
     *            the client to set
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
     * @param sm
     *            the sm to set
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
     * @param game
     *            the game to set
     */
    public static void setGame(Game game)
    {
        Game.game = game;
    }

}
