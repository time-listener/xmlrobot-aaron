package org.xmlrobot.matter;

import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.antimatter.Hyperatom;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Atom 
	extends Neutron<Cell,Operon> {

	/**
	 * -4298462132719102245L
	 */
	private static final long serialVersionUID = -4298462132719102245L;

	public Atom(Cell key, Operon value) {
		
		super(Atom.class, key, value);
	}
	public Atom(Cell key, Operon value, Element parent) {
		
		super(Atom.class, key, value, parent);
	}
	public Atom(Class<Hyperatom> antitype, Cell key, Operon value) {
		
		super(Atom.class, antitype, key, value);
	}
	public Atom(Class<Hyperatom> antitype, Cell key, Operon value, Element parent) {
		
		super(Atom.class, antitype, key, value, parent);
	}

	@Override
	public String getName() {

		return getKey().getName();
	}

	@Override
	public int compare(Mass<Cell,Operon> o1, Mass<Cell,Operon> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
