package org.xmlrobot.matter;

import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.antimatter.Hypertype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

/**
 * @author joan
 *
 */
public class Karyotype 
	extends Neutron<Haploid,Genomap> {

	/**
	 * 4103982669151647889L
	 */
	private static final long serialVersionUID = 4103982669151647889L;

	/**
	 * {@link Karyotype} default class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Karyotype(Haploid key, Genomap value) {
		super(Karyotype.class, key, value);
	}
	/**
	 * {@link Karyotype} class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link Phenotype} the parent
	 */
	public Karyotype(Haploid key, Genomap value, Phenotype parent) {
		super(Karyotype.class, key, value, parent);
	}
	/**
	 * {@link Karyotype} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Karyotype(Class<Hypertype> antitype, Haploid key, Genomap value) {
		super(Karyotype.class, antitype, key, value);
	}
	/**
	 * {@link Karyotype} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link Phenotype} the parent
	 */
	public Karyotype(Class<Hypertype> antitype, Haploid key, Genomap value, Phenotype parent) {
		super(Karyotype.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Haploid,Genomap> o1, Mass<Haploid,Genomap> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}