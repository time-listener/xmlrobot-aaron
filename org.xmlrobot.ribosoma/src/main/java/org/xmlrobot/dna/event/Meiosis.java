package org.xmlrobot.dna.event;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

/**
 * Meiosis is a specialized type of cell division that reduces the chromosome number by half. 
 * This process occurs in all sexually reproducing single-celled and multicellular eukaryotes, 
 * including animals, plants, and fungi. Errors in meiosis resulting in aneuploidy are the 
 * leading known cause of miscarriage and the most frequent genetic cause of developmental 
 * disabilities.
 * 
 * @author joan
 */
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
