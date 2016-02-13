package org.xmlrobot.spacetime.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;

public class Repulsion 
	extends Graviton<Jupiter,Saturn> {

	/**
	 * 3601731228504556896L
	 */
	private static final long serialVersionUID = 3601731228504556896L;

	/**
	 * @param source
	 */
	public Repulsion(Mass<Jupiter,Saturn> source) {
		super(source);
	}

}
