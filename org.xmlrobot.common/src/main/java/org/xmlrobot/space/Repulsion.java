/**
 * 
 */
package org.xmlrobot.space;

import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.function.BiFunction;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 22
 */
@XmlTransient
public abstract class Repulsion<K,V>
	extends Expansion<K,V> {
	
	/**
	 * 4746424582379869510L
	 */
	private static final long serialVersionUID = 4746424582379869510L;
	
	/**
	 * {@link Repulsion} default class constructor.
	 */
	public Repulsion() {
		super();
	}
	/**
	 * Repulsion default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * Repulsion class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * Repulsion class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, K key, V value, Parity gen)	{
		super(type, key, value, gen);
	}
	/**
	 * Repulsion class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param parity {@link Parity} the gender
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * Repulsion class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * Repulsion class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * Repulsion class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent)	{
		super(type, antitype, key, value, parent);
	}
	/**
	 * Repulsion class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Repulsion(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity parity) {
		super(type, antitype, key, value, parity);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
    public boolean replaceValue(K key, V oldValue, V newValue) {

    	if(key.equals(getKey())) {
    		return message.compareAndSet(Mass.VALUE, oldValue, newValue);
    	}
    	else if(!isEmpty()) {
    		return getChild().replaceValue(key, oldValue, newValue);
    	}
    	else {
    		return false;
    	}
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceKey(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
    public boolean replaceKey(V value, K oldKey, K newKey) {
    	return get().replaceValue(value, oldKey, newKey);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
    public void replaceAllValues(BiFunction<? super K, ? super V, ? extends V> function) {
    	Objects.requireNonNull(function);
        for (Mass<K,V> entry : this) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }

            // ise thrown from function is not a cme.
            v = function.apply(k, v);

            try {
                entry.setValue(v);
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
        }
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceAllKeys(java.util.function.BiFunction)
	 */
	@Override
    public void replaceAllKeys(BiFunction<? super V, ? super K, ? extends K> function) {
    	get().replaceAllValues(function);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
    public V replaceValue(K key, V value) {
    	
    	if(key.equals(getKey())) {
    		return message.putAndCast(Mass.VALUE, value);
    	}
    	else if(!isEmpty()) {
    		return getChild().replaceValue(key, value);
    	}
    	else {
    		return null;
    	}
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceKey(java.lang.Object, java.lang.Object)
	 */
	@Override
    public K replaceKey(V value, K key) {
    	return get().replaceValue(value, key);
    }
}
