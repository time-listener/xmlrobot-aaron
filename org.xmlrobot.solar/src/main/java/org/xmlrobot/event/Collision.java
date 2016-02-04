package org.xmlrobot.event;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

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
