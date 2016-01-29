package org.xmlrobot.event;

import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Procreation 
	extends Graviton<Ribosoma,Tetraploid> {

	/**
	 * 5875387912613356461L
	 */
	private static final long serialVersionUID = 5875387912613356461L;

	/**
	 * @param source
	 */
	public Procreation(Mass<Ribosoma,Tetraploid> source) {
		super(source);
	}

}
