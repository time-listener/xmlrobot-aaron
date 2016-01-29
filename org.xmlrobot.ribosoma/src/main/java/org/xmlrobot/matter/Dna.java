package org.xmlrobot.matter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Hyperdna;
import org.xmlrobot.positron.Proton;

public class Dna 
	extends Proton<Diploid,Cromosoma> {

	/**
	 * 6271069892701220397L
	 */
	private static final long serialVersionUID = 6271069892701220397L;
	
	public Dna() {
		super(Dna.class);
	}
	public Dna(Class<Hyperdna> antitype) {
		super(Dna.class, antitype);
	}
}
