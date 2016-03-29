/**
 * 
 */
package gameplay;

/**
 * @author joelmanning
 *
 */
public interface Combatable
{
    public boolean dealDamage(int damage);

    public int getHealth();

    public int getPower();

    public void setHealth(int health);

    public void setPower(int power);

    public void destroy();
}
