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
 * DynamicArrayBagADT
 *
 * Wrapper implementation of a BagADT using a dynamic array
 *
 * @author Iver Macaulay
 */
public class DynamicArrayBagADT<T> implements BagADT<T>
{
    /** Array of items */
    private T[] _items;
    /** Number of items in bag */
    private int _size = 0;
    /** Default size of bag if not specified */
    private static final int _DEFAULT_SIZE = 10;
    /** Current size of bag */
    private int _currentSize;


    /**
     * Creates empty bag with initial capacity of 10
     */
    public DynamicArrayBagADT()
    {
        // Unchecked cast
        @SuppressWarnings("unchecked")
        T[] tempItems = (T[]) new Object[_DEFAULT_SIZE];
        _items = tempItems;

        _currentSize = _DEFAULT_SIZE;
    }

    /**
     * Creates empty bag with given initial capacity
     */
    public DynamicArrayBagADT(int capacity)
    {
        // Unchecked cast
        @SuppressWarnings("unchecked")
        T[] tempItems = (T[]) new Object[capacity];
        _items = tempItems;

        _currentSize = capacity;
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
        boolean success = false;

        // If bag is full..
        if (isFull())
        {
            // Create bag twice as big as the previous
            @SuppressWarnings("unchecked")
            T[] tempItems = (T[]) new Object[_currentSize * 2];
            _currentSize *= 2;

            // Copy items into bigger bag
            for ( int i = 0; i < _size; i++)
            {
                tempItems[i] = _items[i];
            }
            // Add new item into bag and increase size
            tempItems[_size] = entry;
            _size++;

            _items = tempItems;
        }
        else
        {
            // If bag is not full, add item to bag
            _items[_size] = entry;
            // Increase size of bag
            _size++;
            success = true;
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
     * Checks if the bag contains a specific item
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
        Set<T> uniqueSet = new HashSet<T>();

        // Inputs unique entries form bag into the set
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
        return _items[_currentSize - 1] != null;
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
        // Reset _size to 0
        _size = 0;
    }

    /**
     * Converts bag into a string
     * @return A formatted string that represents the bag
     */
    @Override
    public String toFormattedString()
    {
        return String.valueOf(_items);
    }
}
