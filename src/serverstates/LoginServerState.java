/**
 * 
 */
package serverstates;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import networking.Networking;
import messages.AccountCreation;
import messages.AccountRejected;
import messages.Login;
import messages.LoginAccepted;
import messages.LoginRejected;
import messages.Verification;
import messages.VerificationRejected;
import messages.Verify;
import server.GoogleMail;
import server.Handler;
import server.Server;

/**
 * @author joelmanning
 *
 */
public class LoginServerState extends ServerState
{

    private static final String SALT = "b25eae51fd5a7c4f03e1b2fdd85cc017";

    private AccountCreation saved;
    private int verification;

    /**
     * @param h
     */
    public LoginServerState(Handler h)
    {
        super(h);
        saved = null;
        verification = -1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see serverstates.ServerState#onInitialize()
     */
    @Override
    public void onInitialize()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see serverstates.ServerState#onBegin()
     */
    @Override
    public void onBegin()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see serverstates.ServerState#onLeave()
     */
    @Override
    public void onLeave()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see serverstates.ServerState#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see serverstates.ServerState#objectRecieved(java.lang.Object)
     */
    @Override
    public void objectRecieved(Object o)
    {
        if (o instanceof Login)
        {
            Login login = (Login) o;
            printInfo("Got a login: " + login.toString());
            if (Server.getServer().getOnlineusers()
                    .containsKey(login.getUsername()))
            {
                send(new LoginRejected(
                        "A player with that username was already online"));
                printInfo("Rejected a login due to that player already being online");
            }
            else
            {
                try
                {
                    Statement stmt = Server.getServer().getCon()
                            .createStatement();
                    stmt.execute("USE MegaServer");
                    ResultSet rs = stmt
                            .executeQuery("SELECT password FROM Users WHERE username = \""
                                    + login.getUsername() + "\"");
                    if (rs.next())
                    {
                        //byte[] hashedPassword = Server
                        //        .getServer()
                        //        .getDigester()
                        //        .digest((login.getPassword() + SALT)
                        //                .getBytes("UTF-8"));
                        if (rs.getString("password").equals(
                                login.getPassword()))
                        {
                            printInfo("Accepted a login from \""
                                    + login.getUsername() + "\".");
                            send(new LoginAccepted());
                            Server.getServer()
                            .getOnlineusers()
                            .put(login.getUsername(),
                                    handle.getSock().getInetAddress());
                        }
                        else
                        {
                            System.out.println(login.getPassword() + " was not equal to " + rs.getString("password"));
                            send(new LoginRejected(
                                    "Incorrect password, please try again."));
                            printInfo("Rejecting a login due to incorrect password.");
                        }
                    }
                    else
                    {
                        send(new LoginRejected(
                                "An account with that username does not exist."));
                        printInfo("Rejecting a login due to nonexistant username.");
                    }
                }
                catch (SQLException e)
                {
                    printError("MySQL error logging a player in: "
                            + e.getMessage());
                }
//                catch (UnsupportedEncodingException e)
//                {
//                    printError("Error encoding a password: " + e.getMessage());
//                }
            }
        }
        else if (o instanceof AccountCreation)
        {
            saved = (AccountCreation) o;
            printInfo("Got an account creation: " + saved.toString());
            try
            {
                Statement stmt = Server.getServer().getCon().createStatement();
                stmt.execute("USE MegaServer");
                ResultSet rs;
                rs = stmt
                        .executeQuery("SELECT password FROM Users WHERE username = \""
                                + saved.getUsername() + "\"");

                if (rs.next())
                {
                    send(new AccountRejected(
                            "An account with that username already exists."));
                    saved = null;
                }
                else
                {
                    verification = 100000 + (int) (Math.random() * 900000);
                    try
                    {
                        GoogleMail.Send(Networking.EMAIL_USERNAME,
                                Networking.EMAIL_PASSWORD, saved.getEmail(),
                                "Account Verification",
                                "Your account verification number is "
                                        + verification
                                        + "\n\nThanks, the great game team");
                        send(new Verify());
                    }
                    catch (AddressException e)
                    {
                        printInfo("Could not find an email account: "
                                + e.getMessage());
                        send(new AccountRejected("That email does not exist."));
                    }
                    catch (MessagingException e)
                    {
                        printInfo("Had an error sending an email: "
                                + e.getMessage());
                        send(new AccountRejected(
                                "That email does not exist."));
                    }
                }
            }
            catch (SQLException e)
            {
                printError("MySQL error creating an account: " + e.getMessage());
            }
        } else if(o instanceof Verification){
            if(saved != null){
                Verification v = (Verification) o;
                if(v.getVerificationNumber() == verification){
                    try {
                        Statement stmt = Server.getServer().getCon().createStatement();
                        stmt.execute("USE MegaServer");
                        byte[] hashedPassword = Server.getServer().getDigester().digest((saved.getPassword() + SALT).getBytes("UTF-8"));
                        String InsertStatement = "INSERT INTO Users (username, password, email) VALUES(\"" + saved.getUsername() + "\", \"" +  
                                saved.getPassword() + "\", \"" + saved.getEmail() + "\")";
                        stmt.execute(InsertStatement);
                        printInfo("Created account \"" + saved.getUsername() + "\" with password \"" + saved.getPassword() + "\".");
                        objectRecieved(new Login(saved.getUsername(), saved.getPassword()));
                    } catch (SQLException e) {
                        send(new AccountRejected("That username is already in use."));
                        printInfo("Rejected a player trying to create an account with an already taken username.");
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        send(new AccountRejected("We are having trouble encoding at the moment, please try again later"));
                        printError("Could not encode password: " + e.getMessage());
                    }
                } else {
                    send(new VerificationRejected());
                    printInfo("A player failed to verify their account.");
                }
            }
            else
            {
                send(new AccountRejected("Could not find an account to verify"));
                printError("A player sent verification without having an account to verify");
            }
        }
    }
}
