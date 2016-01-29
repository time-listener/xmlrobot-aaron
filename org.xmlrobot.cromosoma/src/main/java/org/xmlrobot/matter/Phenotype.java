package org.xmlrobot.matter;

import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.antimatter.Hyperphenotype;
import org.xmlrobot.positron.Proton;

public class Phenotype 
	extends Proton<Haploid,Genomap> {

	/**
	 * -3552982948268784301L
	 */
	private static final long serialVersionUID = -3552982948268784301L;
	
	/**
	 * 
	 */
	public Phenotype() {
		super(Phenotype.class);
	}
	/**
	 * @param antitype
	 */
	public Phenotype(Class<Hyperphenotype> antitype) {
		super(Phenotype.class, antitype);
	}
}