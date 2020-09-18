/*
 * Project 1 - BagADT
 * Data Structures
 *
 * Iver Macaulay
 * 17 September 2020
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * FixedArrayBagADT
 *
 * Wrapper implementation of a BagADT using a fixed-size array
 *
 * @author Iver Macaulay
 */
public class FixedArrayBagADT<T> implements BagADT<T>
{
    /** Array of items */
    private final T[] _items;
    /** Number of items in bag */
    private int _size = 0;
    /** Default size of bag if not specified */
    private static final int _DEFAULT_SIZE = 10;

    /**
     * Creates empty bag with initial capacity of 10
     */
    public FixedArrayBagADT()
    {
        // Unchecked cast
        @SuppressWarnings("unchecked")
        T[] tempItems = (T[]) new Object[_DEFAULT_SIZE];
        _items = tempItems;
    }

    /**
     * Adds specified entry to bag
     * @param entry The entry to be added to the bag
     * @return True or false if the operation was successful
     */
    @Override
    public boolean add(T entry)
    {
        // Check if entry is valid
        if( null == entry )
        {
            return false;
        }

        // Determines whether item was successfully added
        boolean success;
        // If bag is NOT full, add item
        if( !isFull() )
        {
            _items[_size] = entry;
            // Increase size of bag
            _size++;
            // Addition to bag was successful
            success = true;
        }
        // If bag is full..
        else
        {
            // The operation was unsuccessful
            success = false;
        }
        return success;
    }

    /**
     * Removes specified entry from bag
     * @param entry The entry to remove
     * @return The entry that was removed
     */
    @Override
    public T remove(T entry)
    {
        // Keep track of the index of the object
        int index = 0;
        // Placeholder for the object that is removed
        T object = null;
        // Variable that determines if item was found
        boolean found = false;

        // Iterate through Bag to find item
        for ( int i = 0; i < _size; i++)
        {
            // If item is found, remove it
            if( entry.equals(_items[i]))
            {
                found = true;
                object = _items[i];
                index = i;
                _items[index] = null;
                break;
            }
        }
        // Once object is removed..
        if ( found )
        {
            // Move all objects after 'found' object up 1 index
            for (int i = index; i < (_size - 1); i++)
            {
                _items[i] = _items[i + 1];
                _items[i + 1] = null;
            }
            // Decrease size of bag
            _size--;
        }
        return object;
    }

    /**
     * Checks if the bag contains a specific entry
     * @param entry The entry
     * @return True or false depending on if the bag contains
     * specified entry
     */
    @Override
    public boolean contains(T entry)
    {
        boolean found = false;

        // Iterate through bag
        for ( int i = 0; i < _size; i++)
        {
            // If item is found, return true
            if (entry.equals(_items[i])) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Count the number of times a specified entry is in the bag
     * @param entry The entry
     * @return An integer that represents the number of times
     * an entry occurs jn the bag
     */
    @Override
    public int getCount(T entry)
    {
        int count = 0;

        // Iterate through bag
        for(int i = 0; i < _size; i++)
        {
            // If item is correct item..
            if( entry.equals(_items[i]))
            {
                // Increase count
                count++;
            }
        }
        return count;
    }

    /**
     * Converts bag into a unique set with no duplicates
     * @return A set of unique entries from the bag
     */
    @Override
    public Set<T> getUniqueSet()
    {
        // Initialize new set
        Set<T> uniqueSet = new HashSet<>();

        uniqueSet.addAll(Arrays.asList(_items));

        return uniqueSet;
    }

    /**
     * Converts bag into an array of size, _size
     * @return An array of all of the entries in the bag
     */
    @Override
    public T[] toArray()
    {
        // Unchecked cast
        @SuppressWarnings("unchecked")
        T[] tempItems = (T[]) new Object[_size];

        for( int i = 0; i < _size; i++)
        {
            tempItems[i]= _items[i];
        }
        return tempItems;
    }

    /**
     * Checks if the bag has no entries
     * @return True or false depending on if the bag has entries
     * or not
     */
    @Override
    public boolean isEmpty()
    {
        // If first item is null, then bag is empty
        return _items[0] == null;

    }

    /**
     * Check if the bag is full
     * @return True or false depending if the bag is full
     */
    @Override
    public boolean isFull()
    {
        // If last item in array is NOT null, bag is full
        return _items[_DEFAULT_SIZE - 1] != null;

    }

    /**
     * Gets how many entries are in the bag
     * @return An integer that represents how many entries are in the bag
     */
    @Override
    public int size()
    {
        return _size;
    }

    /**
     * Removes all entries from the bag
     */
    @Override
    public void clear()
    {
        // Iterate through bag and set each item as null
        for( int i = 0; i < _size; i++)
        {
            _items[i] = null;
        }
        _size = 0;
    }

    /**
     * Converts bag into a string
     * @return A formatted string that represents the bag
     */
    @Override
    public String toFormattedString() {
        return String.valueOf(_items);
    }
}

