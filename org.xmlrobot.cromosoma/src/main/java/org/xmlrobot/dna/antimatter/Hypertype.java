package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.matter.Karyotype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

/**
 * Hypertype implementation class.
 * @author joan
 * @parity XY
 * @since 1518.4
 */
@XmlRootElement
public class Hypertype 
	extends Antineutron<Genomap,Haploid> {

	/**
	 * 6091215784939139007L
	 */
	private static final long serialVersionUID = 6091215784939139007L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Genomap getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Genomap setKey(Genomap key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Haploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Haploid setValue(Haploid value) {
		return super.setValue(value);
	}

	/**
	 * {@link Hypertype} default class constructor.
	 */
	public Hypertype() {
		super(Hypertype.class);
	}
	/**
	 * {@link Hypertype} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public Hypertype(Genomap key, Haploid value) {
		super(Hypertype.class, key, value);
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
	 * @param antitype the antitype
	 */
	public Hypertype(Class<Karyotype> antitype) {
		super(Hypertype.class, antitype);
	}
	/**
	 * {@link Hypertype} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public Hypertype(Class<Karyotype> antitype, Genomap key, Haploid value) {
		super(Hypertype.class, antitype, key, value);
	}
	/**
	 * {@link Hypertype} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Hyperphenotype} the parent
	 */
	public Hypertype(Class<Karyotype> antitype, Genomap key, Haploid value, Hyperphenotype parent) {
		super(Hypertype.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Genomap,Haploid> o1, Mass<Genomap,Haploid> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}