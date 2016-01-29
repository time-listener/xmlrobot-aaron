/**
 * 
 */
package org.xmlrobot.positron;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.space.Space;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Electron<K,V>
	extends Space<K,V> {
	
	/**
	 * 5149224404794650382L
	 */
	private static final long serialVersionUID = 5149224404794650382L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#brain()
	 */
	@Override
	public Mass<K, V> replicator() {
		return this;
	}
	/**
     * {@link Electron} default class constructor.
	 */
	public Electron() {
		super();
	}
	/**
	 * {@link Electron} default class constructor.
	 * @param type the inherited type
	 */
	public Electron(Class<? extends Mass<K,V>> type) {
		
		super(type, Parity.YY);
	}	
	/**
     * {@link Electron} class constructor.
	 * @param type the inherited type
	 * @param parent {@link Electron} the parent
	 */
	public Electron(Class<? extends Mass<K,V>> type, 
			Mass<K,V> parent) {
		super(type, parent);
	}
	/**
	 * {@link Electron} class constructor.
	 * @param type the inherited type
	 * @param key {@link Object} the key
	 * @param value {@link String} the value
	 */
	public Electron(Class<? extends Mass<K,V>> type, 
			K key, V value) {
		super(type, key, value, Parity.YY);
	}
	/**
	 * {@link Electron} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parent {@link Electron} the parent
	 */
	public Electron(Class<? extends Mass<K,V>> type, 
			K key, V value, Mass<K,V> parent) {
		
		super(type, key, value, parent);
	}
	/**
	 * {@link Electron} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 */
	public Electron(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype) {
		
		super(type, antitype, Parity.YY);
	}	
	/**
	 * {@link Electron} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param parent {@link Electron} the parent
	 */
	public Electron(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
	}
	/**
	 * {@link Electron} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 */
	public Electron(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			K key, V value) {
		// call constructor
		super(type, antitype, key, value, Parity.YY);
	}
	/**
	 * {@link Electron} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 * @param parent {@link Electron} the parent
	 */
	public Electron(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public abstract int compare(Mass<K,V> o1, Mass<K,V> o2);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Singularity#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Mass<V,K> o) {
		// call hypergenesis comparison computation
		return matrix().reproduce(call(), o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Genesis#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {

		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (matrix = new Collider());
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
	
		return;
	}
	/**
	 * Natural collider implementation class.
	 * @author joan
	 *
	 */
	protected class Collider 
		extends Grid {
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
		 */
		@Override
		public int reproduce(Mass<K,V> root, Mass<V,K> stem) {
			
			int cmp = root.compareTo(stem);
			// minimization operation
			if(cmp < 0) {
				// assign key-value message
				output().setKey(stem.getValue());
				output().setValue(stem.getKey());
				return 1;
			}
			else if(cmp == 0) {
				// if pair comparison equals: evolve
				output().setKey(root.getKey());
				output().setValue(root.getValue());
				// instantiate new pair
				Mass<K,V> pair = instance(
						getType(), getAntitype(), stem.getValue(), stem.getKey());
				// doubled paired output
				output() .add(pair);
				return 0;
			}
			else {
				// assign key-value mapping pair
				output().setKey(root.getKey());
				output().setValue(root.getValue());
				return -1;
			}
		}

		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#push(org.xmlrobot.genesis.Mass)
		 */
		@Override
		public void push(Mass<K,V> child) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#inject(org.xmlrobot.genesis.Mass)
		 */
		@Override
		public void inject(Mass<V,K> child) {
			// TODO Auto-generated method stub
			
		}
	}
}
