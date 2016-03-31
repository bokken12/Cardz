package cards;

import java.util.List;
import java.util.Set;

import zones.Zone;
import abilities.Ability;
import gameplay.Combatable;

public class CreatureCard extends Card implements Combatable
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
    private List<String> subtypes;
    public CreatureCard(int mana, String name, String text, Set<Ability> abilities, List<String> subtypes, int power, int toughness)
    {
        super(mana, name, text, abilities);
        this.subtypes = subtypes;
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

    /* (non-Javadoc)
     * @see gameplay.Combatable#dealDamage(int)
     */
    @Override
    public boolean dealDamage(int damage)
    {
        toughness -= damage;
        return true;
    }

    /* (non-Javadoc)
     * @see gameplay.Combatable#getHealth()
     */
    @Override
    public int getHealth()
    {
        return toughness;
    }

    /* (non-Javadoc)
     * @see gameplay.Combatable#getPower()
     */
    @Override
    public int getPower()
    {
        return power;
    }

    /* (non-Javadoc)
     * @see gameplay.Combatable#setHealth(int)
     */
    @Override
    public void setHealth(int health)
    {
        toughness = health;
        
    }

    /* (non-Javadoc)
     * @see gameplay.Combatable#setPower(int)
     */
    @Override
    public void setPower(int power)
    {
        this.power = power;
    }

    /* (non-Javadoc)
     * @see gameplay.Combatable#destroy()
     */
    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see cards.Card#isListening(zones.Zone)
     */
    @Override
    public boolean isListening(Zone z)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
