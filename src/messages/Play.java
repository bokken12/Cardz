/**
 * 
 */
package messages;

import java.io.Serializable;
import java.util.List;

import cards.Card;

/**
 * @author joelmanning
 *
 */
public class Play implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -2759056915545470153L;
    private List<Card> deck;
    public Play(List<Card> deck)
    {
        super();
        this.deck = deck;
    }
    /**
     * @return the deck
     */
    public List<Card> getDeck()
    {
        return deck;
    }
    /**
     * @param deck the deck to set
     */
    public void setDeck(List<Card> deck)
    {
        this.deck = deck;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deck == null) ? 0 : deck.hashCode());
        return result;
    }
    /* (non-Javadoc)
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
        Play other = (Play) obj;
        if (deck == null)
        {
            if (other.deck != null)
                return false;
        }
        else if (!deck.equals(other.deck))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Play [deck=" + deck + "]";
    }
    
}
