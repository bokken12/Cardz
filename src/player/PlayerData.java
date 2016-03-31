/**
 * 
 */
package player;

import java.io.Serializable;
import java.util.Set;

/**
 * @author joelmanning
 *
 */
public class PlayerData implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 6276070848435567157L;
    
    private String username;
    private Set<String> friends;

}
