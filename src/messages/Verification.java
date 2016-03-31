/**
 * 
 */
package messages;

import java.io.Serializable;

/**
 * @author joelmanning
 *
 */
public class Verification implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -1319718077706386184L;
    private int verificationNumber;

    public Verification(int verificationNumber)
    {
        super();
        this.verificationNumber = verificationNumber;
    }

    /**
     * @return the verificationNumber
     */
    public int getVerificationNumber()
    {
        return verificationNumber;
    }

    /**
     * @param verificationNumber
     *            the verificationNumber to set
     */
    public void setVerificationNumber(int verificationNumber)
    {
        this.verificationNumber = verificationNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + verificationNumber;
        return result;
    }

    /*
     * (non-Javadoc)
     * 
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
        Verification other = (Verification) obj;
        if (verificationNumber != other.verificationNumber)
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Verification [verificationNumber=" + verificationNumber + "]";
    }

}
