/**
 * 
 */
package cards.creatures.basic.starter;

import java.util.List;
import java.util.Set;

import abilities.Ability;
import cards.CreatureCard;

/**
 * @author joelmanning
 *
 */
public class VoodooDoctor extends CreatureCard
{

    /**
     * @param mana
     * @param name
     * @param text
     * @param abilities
     * @param power
     * @param toughness
     */
    public VoodooDoctor(int mana, String name, String text,
            Set<Ability> abilities, List<String> subtypes, int power, int toughness)
    {
        super(mana, name, text, abilities, subtypes, power, toughness);
        // TODO Auto-generated constructor stub
    }

}
