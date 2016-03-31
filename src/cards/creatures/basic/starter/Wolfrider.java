/**
 * 
 */
package cards.creatures.basic.starter;

import java.util.HashSet;
import java.util.Set;

import abilities.Ability;
import abilities.Charge;
import cards.CreatureCard;

/**
 * @author joelmanning
 *
 */
public class Wolfrider extends CreatureCard
{

    /**
     * 
     */
    private static final long serialVersionUID = 5686135453521478364L;

    /**
     */
    public Wolfrider()
    {
        super(3, "Wolfrider", "Charge", abilities(), null, 3, 1);
    }

    /**
     * @return
     */
    private static Set<Ability> abilities()
    {
        HashSet<Ability> abilities = new HashSet<Ability>();
        abilities.add(new Charge());
        return abilities;
    }

}
