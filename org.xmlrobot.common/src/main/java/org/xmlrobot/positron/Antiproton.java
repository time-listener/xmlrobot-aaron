/**
 * 
 */
package org.xmlrobot.positron;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.DNA;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;

/**
 * Positronic brain implementation class.
 * 
 * @author joan
 *
 */
public class Antiproton<K,V>
	extends Positron<K,V>
		implements DNA<K,V> {
	
	/**
	 * -5258262313814614511L
	 */
	private static final long serialVersionUID = -5258262313814614511L;

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
	public K setKey(K key) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.setKey(key) : null ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.setValue(value) : null ;
	}
	/**
     * {@link Antiproton} default class constructor.
	 */
	public Antiproton() {
		
		super();
	}
	
	/**
	 * @param type
	 */
	protected Antiproton(Class<? extends Mass<K,V>> type) {
		super(type);
	}
	/**
	 * @param type
	 * @param antitype
	 */
	protected Antiproton(Class<? extends Mass<K,V>> type,
			Class<? extends Mass<V,K>> antitype) {
		super(type, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compareTo(org.xmlrobot.positron.Electron)
	 */
	@Override
	public int compareTo(Mass<V,K> o) {
	
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.positron.Positron, org.xmlrobot.positron.Positron)
	 */
	@Override
	public int compare(Mass<K,V> o1, Mass<K,V> o2) {
		// typical recursive composition
		if (o1 != null) {

			if (o2 != null) {
				// get current identifier pairs difference
				int cmp = o1.compareTo(o2.get());
				// call recursion
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
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public V get(K key) {
		// declare child
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Neutron) {
				
				try {
					Mass<V,K> future;
					@SuppressWarnings("unchecked")
					Neutron<V,K> pair = (Neutron<V,K>) event.getSource();
					
					if((future = get()) != null ?
							!future.isEmpty() ?
									!future.contains(pair) 
									: false 
							: false) {
						
						future.add(pair);
					}	
				}
				catch(ClassCastException e) {	
					break;
				}
			}
			break;
		case TRANSFER:
			
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K key, V value) {

		return putValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValue(K key, V value) {
	
		return super.putValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(
			Atlas<? extends K, ? extends V, ? extends Mass<K,V>> m) {
		
		for(Mass<K,V> positron : m)
			put(positron.getKey(), positron.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#keySet()
	 */
	@Override
	public Congregation<K> keySet() {

		return keyView();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#values()
	 */
	@Override
	public Congregation<V> values() {
		
		return valueView();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<K,V>> entrySet() {

		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V getOrDefault(K key, V defaultValue) {

		return getValueOrDefault(key, defaultValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super K, ? super V> action) {
		
		forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putIfAbsent(K key, V value) {

		return putValueIfAbsent(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(K key, V value) {

		return removeByKey(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(K key, V oldValue, V newValue) {

		return replaceValue(key, oldValue, newValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V replace(K key, V value) {

		return replaceValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(
			BiFunction<? super K, ? super V, ? extends V> function) {
		
		replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {		
 		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (matrix = new Hadron());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.name() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// they belong to the hyperspace with me
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Plasma#replicator()
	 */
	@Override
	public Mass<K,V> replicator() {
		// this is the plasma
		return this;
	}

}
