/**
 * 
 */
package networking;

import general.Game;

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
            in = sock.getInputStream();
            out = sock.getOutputStream();
            ois = new ObjectInputStream(in);
            oos = new ObjectOutputStream(out);
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
