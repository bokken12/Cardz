/**
 * 
 */
package messages;

import java.io.Serializable;

import player.PlayerData;

/**
 * @author joelmanning
 *
 */
public class LoginAccepted implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -8315631926507991369L;
    
    private PlayerData data;

    public LoginAccepted(PlayerData data)
    {
        super();
        this.data = data;
    }

    /**
     * @return the data
     */
    public PlayerData getData()
    {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(PlayerData data)
    {
        this.data = data;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
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
        LoginAccepted other = (LoginAccepted) obj;
        if (data == null)
        {
            if (other.data != null)
                return false;
        }
        else if (!data.equals(other.data))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "LoginAccepted [data=" + data + "]";
    }

}
