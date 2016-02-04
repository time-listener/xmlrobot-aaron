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
	 * {@link Hypertype} default class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public Hypertype(Genomap key, Haploid value) {
		super(Hypertype.class, key, value);
	}
	/**
	 * {@link Hypertype} class constructor.
	 * @param antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public Hypertype(Class<Karyotype> antitype, Genomap key, Haploid value) {
		super(Hypertype.class, antitype, key, value);
	}
	/**
	 * {@link Hypertype} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Hyperphenotype} the parent
	 */
	public Hypertype(Genomap key, Haploid value, Hyperphenotype parent) {
		super(Hypertype.class, key, value, parent);
	}
	/**
	 * {@link Hypertype} class constructor.
	 * @param antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Hyperphenotype} the parent
	 */
	public Hypertype(Class<Karyotype> antitype, Genomap key, Haploid value, Hyperphenotype parent) {
		super(Hypertype.class, antitype, key, value, parent);
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
	public int compare(Mass<Genomap,Haploid> o1, Mass<Genomap,Haploid> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}