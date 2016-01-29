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

	public Hyperatom(Operon key, Cell value) {
		
		super(Hyperatom.class, key, value);
	}
	public Hyperatom(Class<Atom> antitype, Operon key, Cell value) {
		
		super(Hyperatom.class, antitype, key, value);
	}

	@Override
	public String name() {

		return getKey().name();
	}

	@Override
	public int compare(Mass<Operon, Cell> o1, Mass<Operon, Cell> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}

}
