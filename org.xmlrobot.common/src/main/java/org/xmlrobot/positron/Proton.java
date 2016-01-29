/**
 * 
 */
package org.xmlrobot.positron;

import org.xmlrobot.genesis.Chain;
import org.xmlrobot.genesis.Mass;

/**
 * The proton of the hyperspace.
 * 
 * @author joan
 */
public abstract class Proton<K,V>
	extends Electron<K,V> 
		implements Chain<K,V> {

	/**
	 * 3867156400697822097L
	 */
	private static final long serialVersionUID = 3867156400697822097L;
	
	/**
     * {@link Proton} default class constructor.
	 */
	public Proton() {
		
		super();
	}
	public Proton(Class<? extends Mass<K,V>> type) {
		
		super(type);
	}
	public Proton(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype) {
		
		super(type);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<K,V> o1, Mass<K,V> o2) {

		// typical recursive composition
		if (o1 != null) {

			if (o2 != null) {
				// get current identifier pairs difference
				int cmp = o1.compareTo(o2.get());
				// call recursion and append computation result
				cmp += compare(o1.getChild(), o2.getChild());
				// return result
				return cmp;
			} else {
				return 1;
			}
		} else if (o2 != null) {

			return -1;
		} else {
			// starting-finishing
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}
}