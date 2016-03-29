package player;
import gameplay.Combatable;

import java.awt.Image;

/**
 * 
 */

/**
 * @author joelmanning
 *
 */
public class Portrait implements Combatable
{
    private Image image;
    private int life;
    private int attack;
    /* (non-Javadoc)
     * @see gameplay.Combatable#dealDamage(int)
     */
    @Override
    public boolean dealDamage(int damage)
    {
        // TODO Auto-generated method stub
        return false;
    }
    /* (non-Javadoc)
     * @see gameplay.Combatable#getHealth()
     */
    @Override
    public int getHealth()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    /* (non-Javadoc)
     * @see gameplay.Combatable#getPower()
     */
    @Override
    public int getPower()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    /* (non-Javadoc)
     * @see gameplay.Combatable#setHealth(int)
     */
    @Override
    public void setHealth(int health)
    {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see gameplay.Combatable#setPower(int)
     */
    @Override
    public void setPower(int power)
    {
        // TODO Auto-generated method stub
        
    }
    /* (non-Javadoc)
     * @see gameplay.Combatable#destroy()
     */
    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
        
    }
}
