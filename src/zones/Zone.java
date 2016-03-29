package zones;

import cards.Card;

public abstract class Zone
{
    /**
     * puts a card in this zone
     * 
     * @param c
     *            the card to add
     */
    public abstract boolean add(Card c);
}
