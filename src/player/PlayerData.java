/**
 * 
 */
package player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cards.Card;
import cards.creatures.basic.starter.RiverCrocolisk;

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
    private Map<String, List<Card>> decks;
    /**
     * generates a default player data for testing purposes only
     */
    public PlayerData(){
        decks = new HashMap<String, List<Card>>();
        List<Card> deck = new ArrayList<Card>();
        for(int i = 0; i < 10; i++){
            deck.add(new RiverCrocolisk());
        }
        decks.put("Starter", deck);
    }
    /**
     * @return the decks
     */
    public Map<String, List<Card>> getDecks()
    {
        return decks;
    }
    /**
     * @param decks the decks to set
     */
    public void setDecks(Map<String, List<Card>> decks)
    {
        this.decks = decks;
    }
    
    
}
