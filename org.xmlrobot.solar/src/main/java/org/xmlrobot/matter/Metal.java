package org.xmlrobot.matter;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Metal 
	extends Neutron<Biosphere,Ecosystem> {

	/**
	 * -359433908567036074L
	 */
	private static final long serialVersionUID = -359433908567036074L;

	public Metal(Biosphere key, Ecosystem value) {
		super(Metal.class, key, value);
	}

	@Override
	public String name() {

		return getKey().name();
	}

	@Override
	public int compare(Mass<Biosphere, Ecosystem> o1,
			Mass<Biosphere, Ecosystem> o2) {
		
		return getKey().compareTo(o2.getValue());
	}
}
