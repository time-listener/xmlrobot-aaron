/**
 * 
 */
package org.xmlrobot.positron;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Chain;
import org.xmlrobot.genesis.Mass;

/**
 * The proton of the hyperspace.
 * 
 * @author joan
 */
@XmlTransient
public abstract class Proton<K,V>
	extends Electron<K,V> 
		implements Chain<K,V> {

	/**
	 * 3867156400697822097L
	 */
	private static final long serialVersionUID = 3867156400697822097L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	public K getKey() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getKey() : null ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	public V getValue() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getValue() : null ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public void setKey(K key) {
		Mass<K,V> child;
		if ((child = getChild()) != null ) 
			child.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(V value) {
		Mass<K,V> child;
		if ((child = getChild()) != null ) 
			child.setValue(value);
	}
	
	/**
     * {@link Proton} default class constructor.
	 */
	public Proton() {
		
		super();
	}
	/**
	 * @param type
	 */
	public Proton(Class<? extends Mass<K,V>> type) {
		
		super(type);
	}
	/**
	 * @param type
	 * @param antitype
	 */
	public Proton(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype) {
		
		super(type, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<V,K> o) {

		return get().matrix().reproduce(o.getChild(), call().getChild());
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
	 * @see org.xmlrobot.positron.Electron#compareTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compareTo(Mass<V,K> o) {
	
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getName() : new String();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	public abstract V putValue(K key, V value);
}