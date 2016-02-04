/**
 * 
 */
package org.xmlrobot.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.xmlrobot.genesis.Congregation;

/**
 * Iterator of the past implementation class.
 * Iterates through time recurrently to the past.
 * @author joan
 *
 */
public class PastIterator
	<T extends Congregation<T>> 
		implements Iterator<T> {
	
	T current;
	T prev;
	int index;
	
	/**
	 * 
	 */
	public PastIterator(T entry) {
		current = prev = entry;
	}
	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {

		return prev != null;
	}
	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {

		return this.previousListener();
	}
	/**
	 * @return the next future gear
	 */
	final T previousListener() {
		
		T g = prev;

		if (g == null) {
			
			if (current == null) {
				
				throw new NoSuchElementException();
			}
		} 
		else {
			
			current = g;
			prev = g.getParent();
		}
		return g;
	}

}
