package org.xmlrobot.antimatter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Rna;
import org.xmlrobot.positron.Antineutron;

/**
 * @author joan
 *
 */
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
	 * @param key
	 * @param value
	 */
	public Hyperrna(Cromosoma key, Diploid value, Hyperdna parent) {
		
		super(Hyperrna.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hyperrna(Class<Rna> antitype, Cromosoma key, Diploid value) {
		
		super(Hyperrna.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hyperrna(Class<Rna> antitype, Cromosoma key, Diploid value, Hyperdna parent) {
		
		super(Hyperrna.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Cromosoma,Diploid> o1, Mass<Cromosoma,Diploid> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
