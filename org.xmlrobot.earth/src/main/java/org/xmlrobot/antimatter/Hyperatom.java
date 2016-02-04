package org.xmlrobot.antimatter;

import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Atom;
import org.xmlrobot.positron.Antineutron;

public class Hyperatom 
	extends Antineutron<Operon,Cell> {

	/**
	 * 4058808614266793154L
	 */
	private static final long serialVersionUID = 4058808614266793154L;

	/**
	 * 
	 */
	public Hyperatom() {
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hyperatom(Operon key, Cell value) {
		
		super(Hyperatom.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperatom(Operon key, Cell value, Hyperelement parent) {
		
		super(Hyperatom.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hyperatom(Class<Atom> antitype, Operon key, Cell value) {
		
		super(Hyperatom.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperatom(Class<Atom> antitype, Operon key, Cell value, Hyperelement parent) {
		
		super(Hyperatom.class, antitype, key, value, parent);
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
	public int compare(Mass<Operon,Cell> o1, Mass<Operon,Cell> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}

}
