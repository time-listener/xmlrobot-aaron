package org.xmlrobot.antimatter;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

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
	public Hypermetal(Ecosystem key, Biosphere value) {
		
		super(Hypermetal.class, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String name() {

		return getKey().name();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Ecosystem,Biosphere> o1, Mass<Ecosystem,Biosphere> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
