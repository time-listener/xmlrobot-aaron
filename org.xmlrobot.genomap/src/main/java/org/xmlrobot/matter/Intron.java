package org.xmlrobot.matter;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.antimatter.Hyperintron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Intron 
	extends Neutron<Hyperchain,Hypercube>{

	/**
	 * -2718890842282738451L
	 */
	private static final long serialVersionUID = -2718890842282738451L;

	public Intron(Hyperchain key, Hypercube value) {
		super(Intron.class, key, value);
	}
	public Intron(Class<Hyperintron> antitype, Hyperchain key, Hypercube value) {
		super(Intron.class, antitype, key, value);
	}
	@Override
	public String name() {
		
		return getKey().name();
	}

	@Override
	public int compare(Mass<Hyperchain,Hypercube> o1,
			Mass<Hyperchain,Hypercube> o2) {
		
		return o1.getKey().compareTo(o2.getValue());
	}

}
