/**
 * 
 */
package org.xmlrobot.driver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.space.Space;
import org.xmlrobot.util.Parity;

/**
 * The mass manipulator that inherits the {@link Space}.
 * 
 * @author joan
 * 
 * @since before BigBang
 *
 */
@XmlTransient
public abstract class ScrewDriver
	<K extends TimeListener<? super K,? super V>, 
	 V extends TimeListener<? super V,? super K>>
		extends Space<K,V> {
	
	/**
	 * -5344433423123917995L
	 */
	private static final long serialVersionUID = -5344433423123917995L;
	
	private transient volatile Mass<K,V> plasma;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public K getKey() {

		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {

		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getNegative()
	 */
	@Override
	@XmlElement
	public V getValue() {

		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setNegative(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		
		V oldValue = super.setValue(value);
	
		if(value != null)
			// ancestral callback
			value.addMassListener(this);
		
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {
		// inherited be your name
		K key;
		// assign and check
		return (key = getKey()) != null ? key.name() : new String();
	}
	/**
	 * {@link ScrewDriver} default class constructor.
	 */
	public ScrewDriver() {
		super();
	}
	/**
     * {@link ScrewDriver} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
					Mass<K,V> parent) {
		super(type, parent);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link ScrewDriver} default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
					Parity gen)	{
		super(type, gen);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link ScrewDriver} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter,
			Class<? extends Mass<K,V>> type,	
					K key, V value, 
					Mass<K,V> parent) {
		
		super(type, key, value, parent);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
		// listen key's masses
		value.addMassListener(this);
	}
	/**
	 * {@link ScrewDriver} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
					K key, V value, 
					Parity gen) {
		
		super(type, key, value, gen);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
		// listen key's masses
		value.addMassListener(this);
	}
	/**
	 * {@link ScrewDriver} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param parent the parent
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
					Mass<K,V> parent) {
		super(type, antitype, parent);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link ScrewDriver} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
					Parity gen) {
		super(type, antitype, gen);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link ScrewDriver} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
					K key, V value, 
					Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
		// listen key's masses
		value.addMassListener(this);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link ScrewDriver} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public ScrewDriver(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
					K key, V value,
					Parity gen) {
		// call constructor
		super(type, antitype, key, value, gen);
		// listen key's masses
		value.addMassListener(this);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#clone()
	 */
	@Override
	public ScrewDriver<K,V> clone() {

		return (ScrewDriver<K,V>) super.clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<K,V> o1, Mass<K,V> o2) {

		return o1.getValue().compareTo(o2.getKey());
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Entity#matrix(java.lang.Class)
 	 */
 	@Override
 	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {
 		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (matrix = new Transcoder());
 	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.space.Singularity#plasm()
 	 */
 	@Override
 	public Mass<K,V> replicator() {

 		return plasma;
 	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#run()
	 */
	@Override
	public void run() {
		// hollow run
		super.run();
		// declare value
		V value;
		// assign and check
		if((value = super.getValue()) != null) {
			// listen time
			execute(value);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#compare(org.xmlrobot.driver.ScrewDriver, org.xmlrobot.driver.ScrewDriver)
	 */
	public static synchronized 
		<K extends TimeListener<? super K,? super V>,
		 V extends TimeListener<? super V,? super K>>
			int superCompare(Mass<K,V> o1, Mass<K,V> o2) {
		// typical recursive syntax
		if(o1 != null) {
			
			if(o2 != null) {
				// compare current pair value
				int cmp = o1.getValue().compareTo(o2.getKey());
				// call recursion
				cmp += superCompare(o1.getChild(), o2.getChild());
				// return result
				return cmp;
			}
			else {
				return 1;
			}
		}
		else if(o2 != null) {
			
			return -1;
		}
		else {
			// start sum
			return 0;
		}
	}
	/**
	 * Pulsar implementation class. 
	 * @author joan
	 *
	 */
	protected class Transcoder
 		extends Transmuter {

		/**
		 * {@link Transcoder} default class constructor.
		 */
		public Transcoder() {
			
			super();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Hypergenesis.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int reproduce(Mass<K,V> key, Mass<V,K> value) {
			
			int cmp = key.compareTo(value);
			
			if(key.getGen().equals(Parity.XY) ? cmp > 0 : cmp < 0) {
				// assign key-value message
				output().setKey(value.getValue());
				output().setValue(value.getKey());
				return -1;
			}
			else if(cmp == 0) {
				// if pair comparison equals: evolve
				output().setKey(key.getKey());
				output().setValue(key.getValue());
				// instantiate new pair
				Mass<K,V> pair = instance(
						getType(), getAntitype(), value.getValue(), value.getKey());
				// doubled paired output
				push(pair);
				return 0;
			}
			else {
				// assign key-value mapping pair
				output().setKey(key.getKey());
				output().setValue(key.getValue());
				return 1;
			}
		}
	}
}