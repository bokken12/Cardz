package cards;

import java.util.Set;

import abilities.Ability;
import gameplay.Combatable;

public abstract class CreatureCard extends Card implements Combatable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1068209460624128262L;
    private int power;
    private int basePower;
    private int toughness;
    private int baseToughness;
    private boolean canAttack;
    public CreatureCard(int mana, String name, String text, Set<Ability> abilities, int power, int toughness)
    {
        super(mana, name, text, abilities);
        this.power = power;
        basePower = power;
        this.toughness = toughness;
        baseToughness = toughness;
        canAttack = false;
    }

    @Override
    public void play()
    {
        // TODO Auto-generated method stub

    }

}
