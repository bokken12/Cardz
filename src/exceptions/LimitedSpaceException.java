/**
 * 
 */
package exceptions;

/**
 * @author joelmanning
 *
 */
public class LimitedSpaceException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 9119296487106321081L;

    public LimitedSpaceException()
    {
        super();
    }

    public LimitedSpaceException(String message)
    {
        super(message);
    }

    public LimitedSpaceException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
