package org.xmlrobot.antimatter;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Metal;
import org.xmlrobot.positron.Antineutron;

/**
 * Sideral heavy metal: ACDC.
 * 
 * @author joan
 *
 */
public class Hypermetal 
	extends Antineutron<Ecosystem,Biosphere> {

	/**
	 * -2195434403508136782L
	 */
	private static final long serialVersionUID = -2195434403508136782L;
	
	/**
	 * @param key
	 * @param value
	 */
	public Hypermetal() {
		
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hypermetal(Ecosystem key, Biosphere value) {
		
		super(Hypermetal.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hypermetal(Ecosystem key, Biosphere value, Hypergas parent) {
		
		super(Hypermetal.class, key, value, parent);
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hypermetal(Class<Metal> antitype, Ecosystem key, Biosphere value) {
		
		super(Hypermetal.class, antitype, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hypermetal(Class<Metal> antitype, Ecosystem key, Biosphere value, Hypergas parent) {
		
		super(Hypermetal.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Ecosystem,Biosphere> o1, Mass<Ecosystem,Biosphere> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
