package org.xmlrobot.matter;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Gluon 
	extends Neutron<Saturn,Jupiter> {

	/**
	 * 9027202948697242639L
	 */
	private static final long serialVersionUID = 9027202948697242639L;
	
	public Gluon(Saturn key, Jupiter value) {
		
		super(Gluon.class, key, value);
	}
	@Override
	public String name() {

		return getKey().name();
	}
	@Override
	public int compare(Mass<Saturn,Jupiter> o1, Mass<Saturn,Jupiter> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}