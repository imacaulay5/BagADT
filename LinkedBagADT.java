/*
 * Project 1 - BagADT
 * Data Structures
 *
 * Iver Macaulay
 * 17 September 2020
 */

import java.util.Set;

/**
 * LinkedBagADT
 *
 * Wrapper implementation of a BagADT using a linked chain
 *
 * @author Iver Macaulay
 */
public class LinkedBagADT<T> implements BagADT<T>
{
    /** Nested 'Node' Class
     * @param <T>
     */
    private class Node<T>
    {
        /** Holds the information for the node */
        private T _data;

        /** Provides the link to the next node in the chain */
        private Node<T> _next;

        /** Node constructor
         * @param data Holds information for the node
         */
        private Node(T data)
        {
            _data = data;
        }

        /**
         * Node constructor
         * @param data Holds information to node
         * @param next Holds the link for the nest node in sequence
         */
        private Node(T data, Node<T> next)
        {
            _data = data;
            _next = next;
        }

        /**
         * Retrieves the link to the next node
         * @return Link to next node
         */
        private Node<T> getNext()
        {
            return _next;
        }

        /**
         * Retrieves the data that the node holds
         * @return object that node holds
         */
        private T getData()
        {
            return _data;
        }

        /**
         * Converts node into a string
         * @return A string that represents the node
         */
        public String toString()
        {
            return "["+ _data +"][->]" + _next;
        }
    }

    /** Holds information for the first node in the chain */
    private Node<T> _head;
    /** Holds the number of entries in bag */
    private int _size;

    /**
     * Creates the head of the chain for the bag
     */
    public LinkedBagADT()
    {
        _head = null;
        _size = 0;
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

        // Add each new entry to the beginning of chain
        Node newNode = new Node( entry );
        newNode._next = _head;
        _head = newNode;

        // Increase size of bag
        _size++;

        return true;
    }

    /**
     * Removes specified entry from bag
     * @param entry The entry to remove
     * @return The entry that was removed
     */
    @Override
    public T remove(T entry)
    {
        // Initialize variable to return
        T result = null;
        Node<T> currentNode = _head;

        boolean found = false;

        // Check if head equals entry
        if(entry.equals(currentNode.getData()))
        {
            found = true;
            _head = currentNode.getNext();
        }
        // Search through linked data until entry is found or end of chain
        while( currentNode.getData() != null && !found)
        {
            // If node data = entry, we have found the entry
            if(entry.equals( currentNode.getData() ))
            {
                found = true;
                result = currentNode.getData();
            }
            else
            {
                // Move to next entry
                currentNode = currentNode.getNext();
            }
        }
        // If entry is found..
        if( found )
        {
            // Replace entry with entry in the head node
            // Then, remove the head node
            currentNode._data = _head.getData();
            _head = _head.getNext();
            _size--;
        }
        return result;
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

        if(_head == null)
        {
            return found;
        }
        Node<T> currentNode = _head;

        // Iterate through linked chain until entry is found or end of chain
        while( !found && currentNode.getData() != null )
        {
            if( entry.equals(currentNode.getData()) )
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNext();
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
        // Keep track of occurrences of entry
        int count = 0;
        Node<T> currentNode = _head;

        // If bag is empty return count
        if( currentNode == null)
        {
            return count;
        }

        // Iterate through linked chain
        while( currentNode.getData() != null)
        {
            if(entry.equals(currentNode.getData()))
            {
                count++;
            }
            // Advance to next node
            currentNode = currentNode.getNext();
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
        Set<T> linkedSet = null;
        Node<T> currentNode = _head;
        while( currentNode.getData() != null)
        {
            linkedSet.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return linkedSet;
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
        Node<T> currentNode = _head;

        for( int i = 0; i < _size; i++)
        {
            // Copy each entry into array
            tempItems[i] = currentNode.getData();
            currentNode = currentNode.getNext();
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
        return _head == null;
    }

    /**
     * Check if the bag is full
     * @return True or false depending if the bag is full
     */
    @Override
    public boolean isFull()
    {
        return false;
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
        _head = null;
        _size = 0;
    }

    /**
     * Converts bag into a string
     * @return A formatted string that represents the bag
     */
    @Override
    public String toFormattedString()
    {
      return String.valueOf(_head);
    }
}

