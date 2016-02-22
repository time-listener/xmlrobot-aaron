package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hypertype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

/**
 * Karyotype implementation class.
 * @author joan
 * @parity XX
 * @since 1518.3
 */
@XmlRootElement
public class Karyotype 
	extends Antineutron<Haploid,Genomap> {

	/**
	 * 4103982669151647889L
	 */
	private static final long serialVersionUID = 4103982669151647889L;
	
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
	public Haploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Haploid setKey(Haploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Genomap getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Genomap setValue(Genomap value) {
		return super.setValue(value);
	}

	/**
	 * {@link Karyotype} default class constructor.
	 */
	public Karyotype() {
		super(Karyotype.class);
	}
	/**
	 * {@link Karyotype} class constructor.
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
	 */
	public Karyotype(Class<Hypertype> antitype) {
		super(Karyotype.class, antitype);
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
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Haploid,Genomap> o1, Mass<Haploid,Genomap> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}