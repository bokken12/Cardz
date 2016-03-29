/**
 * 
 */
package abilities;

import cards.Card;
import events.GameEvent;
import events.GameListener;

/**
 * @author joelmanning
 *
 */
public abstract class Ability implements GameListener
{
    private Card card;
    /* (non-Javadoc)
     * @see events.GameListener#passEvent(events.GameEvent)
     */
    @Override
    public boolean passEvent(GameEvent e)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
