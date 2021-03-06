/**
 * 
 */
package org.xmlrobot.space;

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
 * @since 20
 */
@XmlTransient
public abstract class Dilatation<K,V>
	extends Singularity<K,V> { 

	/**
	 * -7033015578655002583L
	 */
	private static final long serialVersionUID = -7033015578655002583L;
	
	/**
	 * {@link Dilatation} default class constructor.
	 */
	public Dilatation() {
		super();
	}
	/**
	 * {@link Dilatation} default class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param parity {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param parity {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param parity {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Mass#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
     */
	@Override
    public V merge(K key, V value,
            BiFunction<? super V,? super V,? extends V> remappingFunction) {
    	
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = getValue(key);
        V newValue = (oldValue == null) ? value :
                   remappingFunction.apply(oldValue, value);
        if(newValue == null) {
            remove(key);
        } 
        else {
            putValue(key, newValue);
        }
        return newValue;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Mass#mergeInverted(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
     */
	@Override
    public K mergeInverted(V value, K key,
            BiFunction<? super K,? super K,? extends K> remappingFunction) {
        return get().merge(value, key, remappingFunction);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Mass#removeByKey(java.lang.Object)
     */
	@Override
    public Mass<K,V> removeByKey(K key) {
    	if(key.equals(getKey())) {
    		remove();
    		return call(); //a.k.a getType().cast(this)
    	}
    	else if(!isEmpty()) {
    		return getChild().removeByKey(key);
    	}
    	else {

        	return null;
    	}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Mass#removeByValue(java.lang.Object)
     */
	@Override
    public Mass<V,K> removeByValue(V value) {
    	return get().removeByKey(value);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Mass#removeByKey(java.lang.Object, java.lang.Object)
     */
	@Override
    public boolean removeByKey(K key, V value) {
    	
    	if(key.equals(getKey())) {
    		if(value.equals(getValue())) {
    			remove();
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else if(!isEmpty()) {
    		return getChild().removeByKey(key, value);
    	}
    	else {
        	return false;
    	}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Mass#removeByValue(java.lang.Object, java.lang.Object)
     */
	@Override
    public boolean removeByValue(V value, K key) {
    	return get().removeByKey(value, key);
    }
}
