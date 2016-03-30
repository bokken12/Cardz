/**
 * 
 */
package networking;

import general.Game;
import general.Mode;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author joelmanning
 *
 */
public class Client extends Thread
{
    private Socket sock;
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public Client()
    {
        try
        {
            sock = new Socket(Networking.HOST, Networking.PORT);
            if(Mode.DEBUG){
                System.out.println("Created the socket");
            }
            in = sock.getInputStream();
            if(Mode.DEBUG){
                System.out.println("Got input");
            }
            out = sock.getOutputStream();
            if(Mode.DEBUG){
                System.out.println("Got output");
            }
            oos = new ObjectOutputStream(out);
            oos.flush();
            if(Mode.DEBUG){
                System.out.println("Got oos");
            }
            ois = new ObjectInputStream(in);
            if(Mode.DEBUG){
                System.out.println("Got ois");
            }
            if(Mode.DEBUG){
                System.out.println("Initialized connection");
            }
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        if(Mode.DEBUG){
            System.out.println("Beginning to read objects");
        }
        while(true){
            try
            {
                Game.getGame().getSm().objectRecieved(ois.readObject());
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void write(Object o){
        try
        {
            oos.writeObject(o);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
