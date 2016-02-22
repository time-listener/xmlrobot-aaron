/**
 * 
 */
package org.xmlrobot.space;

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
 * @since 24
 */
@XmlTransient
public abstract class Compression<K,V>
		extends Attraction<K,V> {
	
	/**
	 * 6778033923929257030L
	 */
	private static final long serialVersionUID = 6778033923929257030L;
	
	/**
	 * {@link Compression} default class constructor.
	 */
	public Compression() {
		super();
	}
	/**
	 * Compression default class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Compression(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		super(type, antitype, key, value, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callPositive(java.lang.Object)
	 */
	@Override
	public Mass<K,V> call(K key) {

		if(key.equals(getKey())) {
			
			return call(); // a.k.a. this
		}
		else if(!isEmpty()) {
			
			return getChild().call(key);
		}
		else {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callNegative(java.lang.Object)
	 */
	@Override
	public Mass<V,K> callReversed(V value) {

		if(value.equals(getValue())) {
			
			return get(); // a.k.a. stem
		}
		else if(!isEmpty()) {
			
			return getChild().callReversed(value);
		}
		else {
			return null;
		}
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getNegative(java.lang.Object)
     */
    public V getValue(K key) {
    	
        if(key.equals(getKey())) {
        	
        	return getValue();
        }
        else if(!isEmpty()) {
        	
        	return getChild().getValue(key);
        }
        else {
        	return null;
        }
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getPositive(java.lang.Object)
     */
    public K getKey(V value) {

        if(value.equals(getValue())) {
        	
        	return getKey();
        }
        else if(!isEmpty()) {
        	
        	return getChild().getKey(value);
        }
        else {
        	return null;
        }
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getOrDefault(java.lang.Object, java.lang.Object)
     */
    public V getValueOrDefault(K key, V defaultValue) {
        V v;
        return (((v = getValue(key)) != null) || containsKey(key))
            ? v
            : defaultValue;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getOrDefault(java.lang.Object, java.lang.Object)
     */
    public K getKeyOrDefault(V value, K defaultKey) {
    	K k;
        return (((k = getKey(value)) != null) || containsValue(value))
            ? k
            : defaultKey;
    }
}