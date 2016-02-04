package org.xmlrobot.event;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

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
