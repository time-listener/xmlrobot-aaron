package org.xmlrobot.antimatter;

import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Karyotype;
import org.xmlrobot.positron.Antineutron;

/**
 * @author joan
 *
 */
public class Hypertype 
	extends Antineutron<Genomap,Haploid> {

	/**
	 * 6091215784939139007L
	 */
	private static final long serialVersionUID = 6091215784939139007L;

	/**
	 * @param key
	 * @param value
	 */
	public Hypertype(Genomap key, Haploid value) {
		super(Hypertype.class, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hypertype(Class<Karyotype> antitype, Genomap key, Haploid value) {
		super(Hypertype.class, antitype, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hypertype(Genomap key, Haploid value, Mass<Genomap,Haploid> parent) {
		super(Hypertype.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hypertype(Class<Karyotype> antitype, Genomap key, Haploid value, Mass<Genomap,Haploid> parent) {
		super(Hypertype.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String name() {
		// implemented be your name
		Genomap key;
		return (key = getKey()) != null ? key.name() : new String();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Genomap,Haploid> o1, Mass<Genomap,Haploid> o2) {

		return 0;
	}

}
