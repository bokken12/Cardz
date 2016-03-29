/**
 * 
 */
package events;

/**
 * @author joelmanning
 *
 */
public class ListNode<K, V>
{
    private ListNode<K, V> next;
    private K key;
    private V value;

    public ListNode(ListNode<K, V> next, K key, V value)
    {
        super();
        this.next = next;
        this.key = key;
        this.value = value;
    }

    public ListNode(K key, V value)
    {
        this(null, key, value);
    }

    /**
     * @return the next
     */
    public ListNode<K, V> getNext()
    {
        return next;
    }

    /**
     * @param next
     *            the next to set
     */
    public void setNext(ListNode<K, V> next)
    {
        this.next = next;
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

}
