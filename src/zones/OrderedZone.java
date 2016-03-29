/**
 * 
 */
package zones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import cards.Card;

/**
 * @author joelmanning
 *
 */
public class OrderedZone extends Zone
{
    private List<Card> cards;
    public OrderedZone(){
        cards = new ArrayList<Card>();
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
     * @see java.util.List#size()
     */
    public int size()
    {
        return cards.size();
    }
    /**
     * @return
     * @see java.util.List#isEmpty()
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
    /**
     * @param o
     * @return
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Object o)
    {
        return cards.contains(o);
    }
    /**
     * @return
     * @see java.util.List#iterator()
     */
    public Iterator<Card> iterator()
    {
        return cards.iterator();
    }
    /**
     * @return
     * @see java.util.List#toArray()
     */
    public Object[] toArray()
    {
        return cards.toArray();
    }
    /**
     * @param a
     * @return
     * @see java.util.List#toArray(java.lang.Object[])
     */
    public <T> T[] toArray(T[] a)
    {
        return cards.toArray(a);
    }
    /**
     * @param e
     * @return
     * @see java.util.List#add(java.lang.Object)
     */
    public boolean add(Card e)
    {
        return cards.add(e);
    }
    /**
     * @param o
     * @return
     * @see java.util.List#remove(java.lang.Object)
     */
    public boolean remove(Object o)
    {
        return cards.remove(o);
    }
    /**
     * @param c
     * @return
     * @see java.util.List#containsAll(java.util.Collection)
     */
    public boolean containsAll(Collection<?> c)
    {
        return cards.containsAll(c);
    }
    /**
     * @param c
     * @return
     * @see java.util.List#addAll(java.util.Collection)
     */
    public boolean addAll(Collection<? extends Card> c)
    {
        return cards.addAll(c);
    }
    /**
     * @param index
     * @param c
     * @return
     * @see java.util.List#addAll(int, java.util.Collection)
     */
    public boolean addAll(int index, Collection<? extends Card> c)
    {
        return cards.addAll(index, c);
    }
    /**
     * @param c
     * @return
     * @see java.util.List#removeAll(java.util.Collection)
     */
    public boolean removeAll(Collection<?> c)
    {
        return cards.removeAll(c);
    }
    /**
     * @param c
     * @return
     * @see java.util.List#retainAll(java.util.Collection)
     */
    public boolean retainAll(Collection<?> c)
    {
        return cards.retainAll(c);
    }
    /**
     * @param operator
     * @see java.util.List#replaceAll(java.util.function.UnaryOperator)
     */
    public void replaceAll(UnaryOperator<Card> operator)
    {
        cards.replaceAll(operator);
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
     * @param c
     * @see java.util.List#sort(java.util.Comparator)
     */
    public void sort(Comparator<? super Card> c)
    {
        cards.sort(c);
    }
    /**
     * 
     * @see java.util.List#clear()
     */
    public void clear()
    {
        cards.clear();
    }
    /**
     * @param o
     * @return
     * @see java.util.List#equals(java.lang.Object)
     */
    public boolean equals(Object o)
    {
        return cards.equals(o);
    }
    /**
     * @return
     * @see java.util.List#hashCode()
     */
    public int hashCode()
    {
        return cards.hashCode();
    }
    /**
     * @param index
     * @return
     * @see java.util.List#get(int)
     */
    public Card get(int index)
    {
        return cards.get(index);
    }
    /**
     * @param index
     * @param element
     * @return
     * @see java.util.List#set(int, java.lang.Object)
     */
    public Card set(int index, Card element)
    {
        return cards.set(index, element);
    }
    /**
     * @param index
     * @param element
     * @see java.util.List#add(int, java.lang.Object)
     */
    public void add(int index, Card element)
    {
        cards.add(index, element);
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
     * @param index
     * @return
     * @see java.util.List#remove(int)
     */
    public Card remove(int index)
    {
        return cards.remove(index);
    }
    /**
     * @return
     * @see java.util.Collection#parallelStream()
     */
    public Stream<Card> parallelStream()
    {
        return cards.parallelStream();
    }
    /**
     * @param o
     * @return
     * @see java.util.List#indexOf(java.lang.Object)
     */
    public int indexOf(Object o)
    {
        return cards.indexOf(o);
    }
    /**
     * @param o
     * @return
     * @see java.util.List#lastIndexOf(java.lang.Object)
     */
    public int lastIndexOf(Object o)
    {
        return cards.lastIndexOf(o);
    }
    /**
     * @return
     * @see java.util.List#listIterator()
     */
    public ListIterator<Card> listIterator()
    {
        return cards.listIterator();
    }
    /**
     * @param index
     * @return
     * @see java.util.List#listIterator(int)
     */
    public ListIterator<Card> listIterator(int index)
    {
        return cards.listIterator(index);
    }
    /**
     * @param fromIndex
     * @param toIndex
     * @return
     * @see java.util.List#subList(int, int)
     */
    public List<Card> subList(int fromIndex, int toIndex)
    {
        return cards.subList(fromIndex, toIndex);
    }
    /**
     * @return
     * @see java.util.List#spliterator()
     */
    public Spliterator<Card> spliterator()
    {
        return cards.spliterator();
    }
    
    public Card getRandom(){
        return get((int)(Math.random() * size()));
    }
    
    public Card removeRandom(){
        return remove((int)(Math.random() * size()));
    }
    
}
