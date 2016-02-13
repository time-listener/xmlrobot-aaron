package org.xmlrobot.spacetime.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;

public class Collision 
	extends Graviton<Ecosystem,Biosphere> {

	/**
	 * 8553800134963835164L
	 */
	private static final long serialVersionUID = 8553800134963835164L;

	/**
	 * @param source
	 */
	public Collision(Mass<Ecosystem,Biosphere> source) {
		super(source);
	}
}
