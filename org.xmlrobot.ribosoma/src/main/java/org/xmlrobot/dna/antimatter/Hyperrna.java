package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.matter.Rna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

/**
 * Hyperrna implementation class.
 * @author joan
 * @parity XY
 * @since 1520.4
 */
@XmlRootElement
public class Hyperrna 
	extends Antineutron<Cromosoma,Diploid> {

	/**
	 * 6167402039482648711L
	 */
	private static final long serialVersionUID = 6167402039482648711L;
	
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
	public Cromosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Cromosoma setKey(Cromosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Diploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Diploid setValue(Diploid value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperrna} default class constructor.
	 */
	public Hyperrna() {
		super(Hyperrna.class);
	}
	/**
	 * {@link Hyperrna} class constructor.
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 */
	public Hyperrna(Cromosoma key, Diploid value) {
		super(Hyperrna.class, key, value);
	}
	/**
	 * {@link Hyperrna} class constructor.
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link Hyperdna} the parent
	 */
	public Hyperrna(Cromosoma key, Diploid value, Hyperdna parent) {
		super(Hyperrna.class, key, value, parent);
	}
	/**
	 * {@link Hyperrna} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperrna(Class<Rna> antitype) {
		super(Hyperrna.class, antitype);
	}
	/**
	 * {@link Hyperrna} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 */
	public Hyperrna(Class<Rna> antitype, Cromosoma key, Diploid value) {
		super(Hyperrna.class, antitype, key, value);
	}
	/**
	 * {@link Hyperrna} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link Hyperdna} the parent
	 */
	public Hyperrna(Class<Rna> antitype, Cromosoma key, Diploid value, Hyperdna parent) {
		super(Hyperrna.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Cromosoma,Diploid> o1, Mass<Cromosoma,Diploid> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}
