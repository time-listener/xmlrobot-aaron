package org.xmlrobot.antimatter;

import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.matter.Phenotype;
import org.xmlrobot.positron.Antiproton;

public class Hyperphenotype 
	extends Antiproton<Genomap,Haploid> {

	/**
	 * -6334977979600214973L
	 */
	private static final long serialVersionUID = -6334977979600214973L;
	
	/**
	 * 
	 */
	public Hyperphenotype() {
		super(Hyperphenotype.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperphenotype(Class<Phenotype> antitype) {
		super(Hyperphenotype.class, antitype);
	}

}
