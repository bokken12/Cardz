/**
 * 
 */
package events;

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

/**
 * @author joelmanning
 *
 */
public class TreeNode<K, V>
{
    private List<TreeNode<K, V>> children;
    private K key;
    private V value;

    public TreeNode(List<TreeNode<K, V>> children, K key, V value)
    {
        super();
        this.children = children;
        this.key = key;
        this.value = value;
    }

    public TreeNode(K key, V value)
    {
        this(null, key, value);
    }

    /**
     * @return the children
     */
    public List<TreeNode<K, V>> getChildren()
    {
        return children;
    }

    /**
     * @param children
     *            the children to set
     */
    public void setChildren(List<TreeNode<K, V>> children)
    {
        this.children = children;
    }

    /**
     * @return the key
     */
    public K getKey()
    {
        return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(K key)
    {
        this.key = key;
    }

    /**
     * @return the value
     */
    public V getValue()
    {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(V value)
    {
        this.value = value;
    }

    /**
     * @param action
     * @see java.lang.Iterable#forEach(java.util.function.Consumer)
     */
    public void forEach(Consumer<? super TreeNode<K, V>> action)
    {
        children.forEach(action);
    }

    /**
     * @return
     * @see java.util.List#size()
     */
    public int size()
    {
        return children.size();
    }

    /**
     * @return
     * @see java.util.List#isEmpty()
     */
    public boolean isEmpty()
    {
        return children.isEmpty();
    }

    /**
     * @param o
     * @return
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Object o)
    {
        return children.contains(o);
    }

    /**
     * @return
     * @see java.util.List#iterator()
     */
    public Iterator<TreeNode<K, V>> iterator()
    {
        return children.iterator();
    }

    /**
     * @return
     * @see java.util.List#toArray()
     */
    public Object[] toArray()
    {
        return children.toArray();
    }

    /**
     * @param a
     * @return
     * @see java.util.List#toArray(java.lang.Object[])
     */
    public <T> T[] toArray(T[] a)
    {
        return children.toArray(a);
    }

    /**
     * @param e
     * @return
     * @see java.util.List#add(java.lang.Object)
     */
    public boolean add(TreeNode<K, V> e)
    {
        return children.add(e);
    }

    /**
     * @param o
     * @return
     * @see java.util.List#remove(java.lang.Object)
     */
    public boolean remove(Object o)
    {
        return children.remove(o);
    }

    /**
     * @param c
     * @return
     * @see java.util.List#containsAll(java.util.Collection)
     */
    public boolean containsAll(Collection<?> c)
    {
        return children.containsAll(c);
    }

    /**
     * @param c
     * @return
     * @see java.util.List#addAll(java.util.Collection)
     */
    public boolean addAll(Collection<? extends TreeNode<K, V>> c)
    {
        return children.addAll(c);
    }

    /**
     * @param index
     * @param c
     * @return
     * @see java.util.List#addAll(int, java.util.Collection)
     */
    public boolean addAll(int index, Collection<? extends TreeNode<K, V>> c)
    {
        return children.addAll(index, c);
    }

    /**
     * @param c
     * @return
     * @see java.util.List#removeAll(java.util.Collection)
     */
    public boolean removeAll(Collection<?> c)
    {
        return children.removeAll(c);
    }

    /**
     * @param c
     * @return
     * @see java.util.List#retainAll(java.util.Collection)
     */
    public boolean retainAll(Collection<?> c)
    {
        return children.retainAll(c);
    }

    /**
     * @param operator
     * @see java.util.List#replaceAll(java.util.function.UnaryOperator)
     */
    public void replaceAll(UnaryOperator<TreeNode<K, V>> operator)
    {
        children.replaceAll(operator);
    }

    /**
     * @param filter
     * @return
     * @see java.util.Collection#removeIf(java.util.function.Predicate)
     */
    public boolean removeIf(Predicate<? super TreeNode<K, V>> filter)
    {
        return children.removeIf(filter);
    }

    /**
     * @param c
     * @see java.util.List#sort(java.util.Comparator)
     */
    public void sort(Comparator<? super TreeNode<K, V>> c)
    {
        children.sort(c);
    }

    /**
     * 
     * @see java.util.List#clear()
     */
    public void clear()
    {
        children.clear();
    }

    /**
     * @param index
     * @return
     * @see java.util.List#get(int)
     */
    public TreeNode<K, V> get(int index)
    {
        return children.get(index);
    }

    /**
     * @param index
     * @param element
     * @return
     * @see java.util.List#set(int, java.lang.Object)
     */
    public TreeNode<K, V> set(int index, TreeNode<K, V> element)
    {
        return children.set(index, element);
    }

    /**
     * @param index
     * @param element
     * @see java.util.List#add(int, java.lang.Object)
     */
    public void add(int index, TreeNode<K, V> element)
    {
        children.add(index, element);
    }

    /**
     * @return
     * @see java.util.Collection#stream()
     */
    public Stream<TreeNode<K, V>> stream()
    {
        return children.stream();
    }

    /**
     * @param index
     * @return
     * @see java.util.List#remove(int)
     */
    public TreeNode<K, V> remove(int index)
    {
        return children.remove(index);
    }

    /**
     * @return
     * @see java.util.Collection#parallelStream()
     */
    public Stream<TreeNode<K, V>> parallelStream()
    {
        return children.parallelStream();
    }

    /**
     * @param o
     * @return
     * @see java.util.List#indexOf(java.lang.Object)
     */
    public int indexOf(Object o)
    {
        return children.indexOf(o);
    }

    /**
     * @param o
     * @return
     * @see java.util.List#lastIndexOf(java.lang.Object)
     */
    public int lastIndexOf(Object o)
    {
        return children.lastIndexOf(o);
    }

    /**
     * @return
     * @see java.util.List#listIterator()
     */
    public ListIterator<TreeNode<K, V>> listIterator()
    {
        return children.listIterator();
    }

    /**
     * @param index
     * @return
     * @see java.util.List#listIterator(int)
     */
    public ListIterator<TreeNode<K, V>> listIterator(int index)
    {
        return children.listIterator(index);
    }

    /**
     * @param fromIndex
     * @param toIndex
     * @return
     * @see java.util.List#subList(int, int)
     */
    public List<TreeNode<K, V>> subList(int fromIndex, int toIndex)
    {
        return children.subList(fromIndex, toIndex);
    }

    /**
     * @return
     * @see java.util.List#spliterator()
     */
    public Spliterator<TreeNode<K, V>> spliterator()
    {
        return children.spliterator();
    }

}
