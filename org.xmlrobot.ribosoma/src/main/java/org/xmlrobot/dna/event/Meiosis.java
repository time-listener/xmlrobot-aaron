package org.xmlrobot.dna.event;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Meiosis 
	extends Graviton<Cromosoma,Diploid> {

	/**
	 * -6988448218238742232L
	 */
	private static final long serialVersionUID = -6988448218238742232L;

	/**
	 * @param source
	 */
	public Meiosis(Mass<Cromosoma,Diploid> source) {
		
		super(source);
	}

}
