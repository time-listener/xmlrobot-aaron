package org.xmlrobot.matter;

import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.antimatter.Hypertype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Karyotype 
	extends Neutron<Haploid,Genomap> {

	/**
	 * 4103982669151647889L
	 */
	private static final long serialVersionUID = 4103982669151647889L;

	public Karyotype(Haploid key,Genomap value) {
		super(Karyotype.class, key, value);
	}
	public Karyotype(Haploid key,Genomap value, Mass<Haploid,Genomap> parent) {
		super(Karyotype.class, key, value, parent);
	}
	public Karyotype(Class<Hypertype> antitype, Haploid key,Genomap value) {
		super(Karyotype.class, antitype, key, value);
	}
	public Karyotype(Class<Hypertype> antitype, Haploid key,Genomap value, Mass<Haploid,Genomap> parent) {
		super(Karyotype.class, antitype, key, value, parent);
	}
	@Override
	public String name() {
		Haploid key;
		return (key = getKey()) != null ? key.name() : new String();
	}
	@Override
	public int compare(Mass<Haploid, Genomap> o1, Mass<Haploid, Genomap> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
