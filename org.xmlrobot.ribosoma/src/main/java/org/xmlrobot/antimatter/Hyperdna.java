package org.xmlrobot.antimatter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.matter.Dna;
import org.xmlrobot.positron.Antiproton;

public class Hyperdna 
	extends Antiproton<Cromosoma,Diploid> {

	/**
	 * -4553883262968730324L
	 */
	private static final long serialVersionUID = -4553883262968730324L;
	
	public Hyperdna() {
		super(Hyperdna.class);
	}
	public Hyperdna(Class<Dna> antitype) {
		super(Hyperdna.class, antitype);
	}

}
