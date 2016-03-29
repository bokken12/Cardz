/**
 * 
 */
package zones;

import java.util.Collection;

import cards.Card;
import exceptions.LimitedSpaceException;

/**
 * @author joelmanning
 *
 */
public class LimitedZone extends OrderedZone
{
    private int max;
    public LimitedZone(int maximum){
        super();
        max = maximum;
    }
    @Override
    public boolean add(Card e){
        if(size() < max){
            return super.add(e);
        }
        throw new LimitedSpaceException();
    }

    @Override
    public void add(int index, Card e){
        if(size() < max){
            super.add(index, e);
        } else {
            throw new LimitedSpaceException();
        }
    }
    /* (non-Javadoc)
     * @see zones.OrderedZone#addAll(java.util.Collection)
     */
    @Override
    public boolean addAll(Collection<? extends Card> c)
    {
        if(size() + c.size() <= max){
            return super.addAll(c);
        }
        throw new LimitedSpaceException();
    }
    /* (non-Javadoc)
     * @see zones.OrderedZone#addAll(int, java.util.Collection)
     */
    @Override
    public boolean addAll(int index, Collection<? extends Card> c)
    {
        if(size() + c.size() <= max){
            return super.addAll(index, c);
        }
        throw new LimitedSpaceException();
    }


}
