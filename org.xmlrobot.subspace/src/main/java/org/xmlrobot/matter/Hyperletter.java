package org.xmlrobot.matter;

import org.xmlrobot.antimatter.Hyperline;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Hyperletter 
	extends Neutron<Integer,Character>{

	/**
	 * -3417172843256231611L
	 */
	private static final long serialVersionUID = -3417172843256231611L;

	public Hyperletter(Integer key, Character value) {
		super(Hyperletter.class, key, value);
	}
	public Hyperletter(Class<Hyperline> antitype, Integer key, Character value) {
		super(Hyperletter.class, antitype, key, value);
	}

	@Override
	public String name() {
		return null;
	}

	@Override
	public int compare(Mass<Integer,Character> o1, Mass<Integer,Character> o2) {

		return 0;
	}

}
