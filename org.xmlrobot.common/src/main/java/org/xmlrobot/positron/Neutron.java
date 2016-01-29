/**
 * 
 */
package org.xmlrobot.positron;
import org.xmlrobot.genesis.Mass;
/**
 * 
 * @author joan
 *
 */
public abstract class Neutron<K,V>
	extends Electron<K,V> {

	/**
	 * -7916648326148727224L
	 */
	private static final long serialVersionUID = -7916648326148727224L;
	
	/**
     * {@link Neutron} default class constructor.
	 */
	public Neutron() {
		
		super();
	}
	/**
	 * @param type
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Neutron(Class<? extends Mass<K,V>> type, 
			K key, V value) {
		super(type, key, value);		
	}
	/**
	 * @param type
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Neutron(Class<? extends Mass<K,V>> type, 
			K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);		
	}
	/**
	 * @param type
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Neutron(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value) {
		super(type, antitype, key, value);		
	}
	/**
	 * @param type
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Neutron(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);		
	}
}