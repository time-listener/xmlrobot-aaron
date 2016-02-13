package org.xmlrobot.dna.event;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Mitosis extends Graviton<Diploid,Cromosoma> {

	/**
	 * -2289561162827937648L
	 */
	private static final long serialVersionUID = -2289561162827937648L;

	public Mitosis(Mass<Diploid,Cromosoma> source) {
		
		super(source);
	}
}
