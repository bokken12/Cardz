/**
 * 
 */
package server;

import general.Mode;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import serverstates.ServerStateMachine;

/**
 * @author joelmanning
 *
 */
public class Handler extends Thread
{
    private Socket sock;
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private ServerStateMachine sm;
    
    public Handler(Socket s){
        sock = s;
        try
        {
            in = sock.getInputStream();
            out = sock.getOutputStream();
            oos = new ObjectOutputStream(out);
            oos.flush();
            ois = new ObjectInputStream(in);
            sm = new ServerStateMachine(this);
            if(Mode.DEBUG){
                System.out.println("Successfully initialized handler");
            }
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
                sm.objectRecieved(ois.readObject());
                if(Mode.DEBUG){
                    System.out.println("Read an object");
                }
            }
            catch (ClassNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                break;
            }
            catch(EOFException e){
                e.printStackTrace();
                break;
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                break;
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @return the sock
     */
    public Socket getSock()
    {
        return sock;
    }

    /**
     * @param sock the sock to set
     */
    public void setSock(Socket sock)
    {
        this.sock = sock;
    }

    /**
     * @return the in
     */
    public InputStream getIn()
    {
        return in;
    }

    /**
     * @param in the in to set
     */
    public void setIn(InputStream in)
    {
        this.in = in;
    }

    /**
     * @return the out
     */
    public OutputStream getOut()
    {
        return out;
    }

    /**
     * @param out the out to set
     */
    public void setOut(OutputStream out)
    {
        this.out = out;
    }

    /**
     * @return the ois
     */
    public ObjectInputStream getOis()
    {
        return ois;
    }

    /**
     * @param ois the ois to set
     */
    public void setOis(ObjectInputStream ois)
    {
        this.ois = ois;
    }

    /**
     * @return the oos
     */
    public ObjectOutputStream getOos()
    {
        return oos;
    }

    /**
     * @param oos the oos to set
     */
    public void setOos(ObjectOutputStream oos)
    {
        this.oos = oos;
    }

    /**
     * @return the sm
     */
    public ServerStateMachine getSm()
    {
        return sm;
    }

    /**
     * @param sm the sm to set
     */
    public void setSm(ServerStateMachine sm)
    {
        this.sm = sm;
    }
    
}
