/**
 * 
 */
package org.xmlrobot.positron;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Mass;

/**
 * @author joan
 * 
 */
@XmlTransient
public abstract class Antineutron<K,V>
	extends Positron<K,V> {

	/**
	 * -96707186309422778L
	 */
	private static final long serialVersionUID = -96707186309422778L;
	
	/**
	 * {@link Antineutron} default class constructor.
	 */
	public Antineutron() {
		
		super();
	}
	/**
	 * {@link Antineutron} default class constructor.
	 */
	public Antineutron(Class<? extends Mass<K,V>> type, 
			K key, V value) {
		super(type, key, value);
	}
	/**
	 * @param type
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Antineutron(Class<? extends Mass<K,V>> type, 
			K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);		
	}
	/**
	 * {@link Antineutron} default class constructor.
	 */
	public Antineutron(Class<? extends Mass<K,V>> type,
			Class<? extends Mass<V,K>> antitype, 
					K key, V value) {
		super(type, key, value);
	}
	/**
	 * @param type
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Antineutron(Class<? extends Mass<K,V>> type,
			Class<? extends Mass<V,K>> antitype, 
					K key, V value, 
					Mass<K,V> parent) {
		super(type, antitype, key, value, parent);		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public abstract String getName() ;
}
