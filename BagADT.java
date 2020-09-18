/**
 * BagADT
 *
 * This interface describes the client interface to a bag abstract data
 * type.
 *
 * @author Brent Eskridge
 */
public interface BagADT<T>
{
    /**
     * Adds a new entry to the bag.
     *
     * @param entry The entry to be added to the bag
     * @return Returns <code>true</code> if successful, otherwise,
     *         <code>false</code>.
     */
    public boolean add( T entry );

    /**
     * Removes one occurrence of the specified entry from the bag,
     * if possible.
     * 
     * @param entry The entry to remove
     * @return Returns the removed entry if successful, otherwise,
     *         <code>null</code>.
     */
    public T remove( T entry );

    /**
     * Determines if the specified entry is in the bag.
     *
     * @param entry The entry
     * @return Returns <code>true</code> if the entry is in the bag,
     *         otherwise, <code>false</code>.
     */
    public boolean contains( T entry );

    /**
     * Returns the number of occurrences of the specified entry
     * in the bag.
     *
     * @param entry The entry
     * @return Returns the number of occurrences of the specified
     * entry in the bag.
     */
    public int getCount( T entry );

    /**
     * Returns a <code>Set</code> containing the unique entries
     * in the bag.
     *
     * @return Returns a <code>Set</code> containing the unique
     * entries in the bag.
     */
    public java.util.Set<T> getUniqueSet();

    /**
     * Returns an array containing all the entries in this bag
     *
     * @return An array containing all the entries in this bag
     */
    public T[] toArray();

    /**
     * Determines if the bag is empty.
     *
     * @return Returns <code>true</code> if the bag is empty,
     *         otherwise, <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Determines if the bag is full.
     *
     * @return Returns <code>true</code> if the bag is full,
     *         otherwise, <code>false</code>
     */
    public boolean isFull();

    /**
     * Returns the number of entries in the bag.
     *
     * @return The the number of entries in the bag
     */
    public int size();

    /**
     * Removes all entries from the bag.
     */
    public void clear();

    /**
     * Returns a formatted description of this bag.  The description
     * contains all of the entries in the bag in a random order.
     *
     * @return A formatted description of this bag
     */
    public String toFormattedString();

}
