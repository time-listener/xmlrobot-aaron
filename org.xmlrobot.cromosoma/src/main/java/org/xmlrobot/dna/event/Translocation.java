package org.xmlrobot.dna.event;

import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Translocation extends Graviton<Haploid,Genomap> {

	/**
	 * -7010523042874459944L
	 */
	private static final long serialVersionUID = -7010523042874459944L;

	public Translocation(Mass<Haploid, Genomap> source) {
		super(source);
	}

}
