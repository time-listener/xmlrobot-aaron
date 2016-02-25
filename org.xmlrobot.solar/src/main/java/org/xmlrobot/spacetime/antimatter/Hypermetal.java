package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.spacetime.matter.Metal;

/**
 * Sideral heavy metal implementation class.
 * @author joan
 * @parity XY
 * @since 41154.4
 */
@XmlRootElement
public class Hypermetal 
	extends Positron<Ecosystem,Biosphere> {

	/**
	 * -2195434403508136782L
	 */
	private static final long serialVersionUID = -2195434403508136782L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Ecosystem getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Ecosystem setKey(Ecosystem key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Biosphere getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Biosphere setValue(Biosphere value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hypermetal} default class constructor.-
	 */
	public Hypermetal() {
		
		super(Hypermetal.class);
	}
	/**
	 * {@link Hypermetal} class constructor.
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 */
	public Hypermetal(Ecosystem key, Biosphere value) {
		
		super(Hypermetal.class, key, value);
	}
	/**
	 * {@link Hypermetal} class constructor.
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Hypergas} the parent
	 */
	public Hypermetal(Ecosystem key, Biosphere value, Hypergas parent) {
		
		super(Hypermetal.class, key, value, parent);
	}
	/**
	 * {@link Hypermetal} class constructor.
	 * @param antitype the antitype
	 */
	public Hypermetal(Class<Metal> antitype) {
		
		super(Hypermetal.class, antitype);
	}
	/**
	 * {@link Hypermetal} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 */
	public Hypermetal(Class<Metal> antitype, Ecosystem key, Biosphere value) {
		
		super(Hypermetal.class, antitype, key, value);
	}
	/**
	 * {@link Hypermetal} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Hypergas} the parent
	 */
	public Hypermetal(Class<Metal> antitype, Ecosystem key, Biosphere value, Hypergas parent) {
		
		super(Hypermetal.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Ecosystem,Biosphere> o1, Mass<Ecosystem,Biosphere> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
