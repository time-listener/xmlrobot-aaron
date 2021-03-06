package org.xmlrobot.dna.event;

import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Reproduction 
	extends Graviton<Tetraploid,Ribosoma> {

	/**
	 * -4039406850289259524L
	 */
	private static final long serialVersionUID = -4039406850289259524L;

	/**
	 * @param source
	 */
	public Reproduction(Mass<Tetraploid,Ribosoma> source) {
		super(source);
	}

}
