/**
 * 
 */
package messages;

import java.io.Serializable;

/**
 * @author joelmanning
 *
 */
public class AccountCreation implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 6085083773352210330L;
    private String username;
    private String password;
    private String email;
    public AccountCreation(String username, String password, String email)
    {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
    }
    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccountCreation other = (AccountCreation) obj;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (password == null)
        {
            if (other.password != null)
                return false;
        }
        else if (!password.equals(other.password))
            return false;
        if (username == null)
        {
            if (other.username != null)
                return false;
        }
        else if (!username.equals(other.username))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "AccountCreation [username=" + username + ", password="
                + password + ", email=" + email + "]";
    }
    
}
