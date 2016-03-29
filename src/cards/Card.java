package cards;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import abilities.Ability;
import zones.Zone;

public abstract class Card implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -947564990345117355L;
    protected int mana;
    protected String name;
    protected String text;
    private Set<Ability> abilities;
    private static AtomicInteger nextInstanceId = new AtomicInteger(0);
    private int instanceId;

    public Card(int mana, String name, String text, Set<Ability> abilities)
    {
        super();
        this.mana = mana;
        this.name = name;
        this.text = text;
        this.abilities = abilities;
        this.instanceId = nextInstanceId.getAndIncrement();
    }

    /**
     * @return the mana
     */
    public int getMana()
    {
        return mana;
    }

    /**
     * @param mana
     *            the mana to set
     */
    public void setMana(int mana)
    {
        this.mana = mana;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the text
     */
    public String getText()
    {
        return text;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * @return the abilities
     */
    public Set<Ability> getAbilities()
    {
        return abilities;
    }

    /**
     * @param abilities the abilities to set
     */
    public void setAbilities(Set<Ability> abilities)
    {
        this.abilities = abilities;
    }

    /**
     * @param action
     * @see java.lang.Iterable#forEach(java.util.function.Consumer)
     */
    public void forEachAbility(Consumer<? super Ability> action)
    {
        abilities.forEach(action);
    }

    /**
     * @return
     * @see java.util.Set#size()
     */
    public int abilitiesSize()
    {
        return abilities.size();
    }

    /**
     * @return
     * @see java.util.Set#isEmpty()
     */
    public boolean abilitiesIsEmpty()
    {
        return abilities.isEmpty();
    }

    /**
     * @param o
     * @return
     * @see java.util.Set#contains(java.lang.Object)
     */
    public boolean abilitiesContains(Object o)
    {
        return abilities.contains(o);
    }

    /**
     * @return
     * @see java.util.Set#iterator()
     */
    public Iterator<Ability> abilityIterator()
    {
        return abilities.iterator();
    }

    /**
     * @return
     * @see java.util.Set#toArray()
     */
    public Object[] abilitiesToArray()
    {
        return abilities.toArray();
    }

    /**
     * @param a
     * @return
     * @see java.util.Set#toArray(java.lang.Object[])
     */
    public <T> T[] abilitiesToArray(T[] a)
    {
        return abilities.toArray(a);
    }

    /**
     * @param e
     * @return
     * @see java.util.Set#add(java.lang.Object)
     */
    public boolean addAbility(Ability e)
    {
        return abilities.add(e);
    }

    /**
     * @param o
     * @return
     * @see java.util.Set#remove(java.lang.Object)
     */
    public boolean removeAbility(Object o)
    {
        return abilities.remove(o);
    }

    /**
     * @param c
     * @return
     * @see java.util.Set#containsAll(java.util.Collection)
     */
    public boolean containsAllAbilities(Collection<?> c)
    {
        return abilities.containsAll(c);
    }

    /**
     * @param c
     * @return
     * @see java.util.Set#addAll(java.util.Collection)
     */
    public boolean addAllAbilities(Collection<? extends Ability> c)
    {
        return abilities.addAll(c);
    }

    /**
     * @param c
     * @return
     * @see java.util.Set#retainAll(java.util.Collection)
     */
    public boolean retainAllAbilities(Collection<?> c)
    {
        return abilities.retainAll(c);
    }

    /**
     * @param c
     * @return
     * @see java.util.Set#removeAll(java.util.Collection)
     */
    public boolean removeAllAbilities(Collection<?> c)
    {
        return abilities.removeAll(c);
    }

    /**
     * 
     * @see java.util.Set#clear()
     */
    public void clearAbilities()
    {
        abilities.clear();
    }

    /**
     * @return
     * @see java.util.Set#spliterator()
     */
    public Spliterator<Ability> abilitySpliterator()
    {
        return abilities.spliterator();
    }

    /**
     * @param filter
     * @return
     * @see java.util.Collection#removeIf(java.util.function.Predicate)
     */
    public boolean removeAbilityIf(Predicate<? super Ability> filter)
    {
        return abilities.removeIf(filter);
    }

    /**
     * @return
     * @see java.util.Collection#stream()
     */
    public Stream<Ability> abilityStream()
    {
        return abilities.stream();
    }

    /**
     * @return
     * @see java.util.Collection#parallelStream()
     */
    public Stream<Ability> parallelAbilityStream()
    {
        return abilities.parallelStream();
    }

    /**
     * @return the instanceId
     */
    public int getInstanceId()
    {
        return instanceId;
    }

    /**
     * @param instanceId
     *            the instanceId to set
     */
    public void setInstanceId(int instanceId)
    {
        this.instanceId = instanceId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Card [mana=" + mana + ", name=" + name + ", text=" + text
                + ", abilities=" + abilities + ", instanceId=" + instanceId
                + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((abilities == null) ? 0 : abilities.hashCode());
        result = prime * result + instanceId;
        result = prime * result + mana;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
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
        Card other = (Card) obj;
        if (abilities == null)
        {
            if (other.abilities != null)
                return false;
        }
        else if (!abilities.equals(other.abilities))
            return false;
        if (instanceId != other.instanceId)
            return false;
        if (mana != other.mana)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (text == null)
        {
            if (other.text != null)
                return false;
        }
        else if (!text.equals(other.text))
            return false;
        return true;
    }

    public abstract void play();

    public abstract boolean isListening(Zone z);
}
