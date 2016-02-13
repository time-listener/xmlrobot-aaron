package org.xmlrobot.spacetime.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;

public class Attraction 
	extends Graviton<Saturn,Jupiter> {

	/**
	 * -4098030654375393489L
	 */
	private static final long serialVersionUID = -4098030654375393489L;

	/**
	 * @param source
	 */
	public Attraction(Mass<Saturn,Jupiter> source) {
		super(source);
	}

}
