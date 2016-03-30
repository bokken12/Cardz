/**
 * 
 */
package serverstates;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import messages.Login;
import messages.LoginAccepted;
import messages.LoginRejected;
import server.Handler;
import server.Server;

/**
 * @author joelmanning
 *
 */
public class LoginServerState extends ServerState
{

    private static final String SALT = "b25eae51fd5a7c4f03e1b2fdd85cc017";

    /**
     * @param h
     */
    public LoginServerState(Handler h)
    {
        super(h);
    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onBegin()
     */
    @Override
    public void onBegin()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onLeave()
     */
    @Override
    public void onLeave()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see serverstates.ServerState#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        if(Login.class.isAssignableFrom(o.getClass())){
            Login login = (Login) o;
            if(Server.getServer().getOnlineusers().containsKey(login.getUsername())){
                send(new LoginRejected("A player with that username was already online"));
                printInfo("Rejected a login due to that player already being online");
            } else {
                try {
                    Statement stmt = Server.getServer().getCon().createStatement();
                    stmt.execute("USE MegaServer");
                    ResultSet rs = stmt.executeQuery("SELECT password FROM Users WHERE username = \"" + login.getUsername() + "\"");
                    if(rs.next()){
                        byte[] hashedPassword = Server.getServer().getDigester().digest((login.getPassword() + SALT).getBytes("UTF-8"));
                        if(rs.getString("password").equals(new String(hashedPassword))){
                            printInfo("Accepted a login from \"" + login.getUsername() + "\".");
                            send(new LoginAccepted());
                            Server.getServer().getOnlineusers().put(login.getUsername(), handle.getSock().getInetAddress());
                        } else {
                            send(new LoginRejected("Incorrect password, please try again."));
                            printInfo("Rejecting a login due to incorrect password.");
                        }
                    }
                    else{
                        send(new LoginRejected("An account with that username does not exist."));
                        printInfo("Rejecting a login due to nonexistant username.");
                    }
                } 
                catch (SQLException e) {
                    printError("MySQL error logging a player in."); 
                }
                catch (UnsupportedEncodingException e)
                {
                    printError("Error encoding a password.");
                }
            }
        }

    }
}
