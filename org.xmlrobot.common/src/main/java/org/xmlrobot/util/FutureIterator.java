/**
 * 
 */
package org.xmlrobot.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.xmlrobot.genesis.Congregation;

/**
 * Iterator of the future implementation class.
 * Iterates over time concurrently to the future.
 * <br<br>
 * @author joan
 *
 */
public class FutureIterator
	<T extends Congregation<T>> 
		implements Iterator<T> {

	T current;
	T next;
	int index;
	
	/**
	 * 
	 */
	public FutureIterator(T entry) {

		current = next = entry;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		
		return next != null;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {

		return this.nextListener();
	}
	/**
	 * @return the next future gear
	 */
	final T nextListener() {
		
		T g = next;

		if (g == null) {
			
			if (current == null) {
				
				throw new NoSuchElementException();
			}
		} 
		else {
			current = g;
			next = g.getChild();
		}
		return g;
	}
}
