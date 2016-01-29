package org.xmlrobot.antimatter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Rna;
import org.xmlrobot.positron.Antineutron;

public class Hyperrna 
	extends Antineutron<Cromosoma,Diploid> {

	/**
	 * 6167402039482648711L
	 */
	private static final long serialVersionUID = 6167402039482648711L;

	/**
	 * @param key
	 * @param value
	 */
	public Hyperrna(Cromosoma key, Diploid value) {
		
		super(Hyperrna.class, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hyperrna(Class<Rna> antitype, Cromosoma key, Diploid value) {
		
		super(Hyperrna.class, antitype, key, value);
	}
	@Override
	public String name() {

		return getKey().name();
	}
	@Override
	public int compare(Mass<Cromosoma,Diploid> o1, Mass<Cromosoma,Diploid> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
