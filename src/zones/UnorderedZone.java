package zones;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import cards.Card;

public class UnorderedZone extends Zone
{
    private Set<Card> cards;
    public UnorderedZone(){
        super();
        cards = new HashSet<Card>();
    }
    /**
     * @param action
     * @see java.lang.Iterable#forEach(java.util.function.Consumer)
     */
    public void forEach(Consumer<? super Card> action)
    {
        cards.forEach(action);
    }
    /**
     * @return
     * @see java.util.Set#size()
     */
    public int size()
    {
        return cards.size();
    }
    /**
     * @return
     * @see java.util.Set#isEmpty()
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
    /**
     * @param o
     * @return
     * @see java.util.Set#contains(java.lang.Object)
     */
    public boolean contains(Object o)
    {
        return cards.contains(o);
    }
    /**
     * @return
     * @see java.util.Set#iterator()
     */
    public Iterator<Card> iterator()
    {
        return cards.iterator();
    }
    /**
     * @return
     * @see java.util.Set#toArray()
     */
    public Object[] toArray()
    {
        return cards.toArray();
    }
    /**
     * @param a
     * @return
     * @see java.util.Set#toArray(java.lang.Object[])
     */
    public <T> T[] toArray(T[] a)
    {
        return cards.toArray(a);
    }
    /**
     * @param e
     * @return
     * @see java.util.Set#add(java.lang.Object)
     */
    public boolean add(Card e)
    {
        return cards.add(e);
    }
    /**
     * @param o
     * @return
     * @see java.util.Set#remove(java.lang.Object)
     */
    public boolean remove(Object o)
    {
        return cards.remove(o);
    }
    /**
     * @param c
     * @return
     * @see java.util.Set#containsAll(java.util.Collection)
     */
    public boolean containsAll(Collection<?> c)
    {
        return cards.containsAll(c);
    }
    /**
     * @param c
     * @return
     * @see java.util.Set#addAll(java.util.Collection)
     */
    public boolean addAll(Collection<? extends Card> c)
    {
        return cards.addAll(c);
    }
    /**
     * @param c
     * @return
     * @see java.util.Set#retainAll(java.util.Collection)
     */
    public boolean retainAll(Collection<?> c)
    {
        return cards.retainAll(c);
    }
    /**
     * @param c
     * @return
     * @see java.util.Set#removeAll(java.util.Collection)
     */
    public boolean removeAll(Collection<?> c)
    {
        return cards.removeAll(c);
    }
    /**
     * 
     * @see java.util.Set#clear()
     */
    public void clear()
    {
        cards.clear();
    }
    /**
     * @param o
     * @return
     * @see java.util.Set#equals(java.lang.Object)
     */
    public boolean equals(Object o)
    {
        return cards.equals(o);
    }
    /**
     * @return
     * @see java.util.Set#hashCode()
     */
    public int hashCode()
    {
        return cards.hashCode();
    }
    /**
     * @return
     * @see java.util.Set#spliterator()
     */
    public Spliterator<Card> spliterator()
    {
        return cards.spliterator();
    }
    /**
     * @param filter
     * @return
     * @see java.util.Collection#removeIf(java.util.function.Predicate)
     */
    public boolean removeIf(Predicate<? super Card> filter)
    {
        return cards.removeIf(filter);
    }
    /**
     * @return
     * @see java.util.Collection#stream()
     */
    public Stream<Card> stream()
    {
        return cards.stream();
    }
    /**
     * @return
     * @see java.util.Collection#parallelStream()
     */
    public Stream<Card> parallelStream()
    {
        return cards.parallelStream();
    }
    
}
