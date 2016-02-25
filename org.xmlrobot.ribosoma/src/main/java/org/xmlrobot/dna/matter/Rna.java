package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.antimatter.Hyperrna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Positron;

/**
 * Rna implementation class.
 * @author joan
 * @parity XX
 * @since 1520.3
 */
@XmlRootElement
public class Rna 
	extends Positron<Diploid,Cromosoma>{

	/**
	 * -5814223426684491592L
	 */
	private static final long serialVersionUID = -5814223426684491592L;
	
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
	public Diploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Diploid setKey(Diploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Cromosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Cromosoma setValue(Cromosoma value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Rna} default class constructor.
	 */
	public Rna() {
		super(Rna.class);
	}
	/**
	 * {@link Rna} class constructor.
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 */
	public Rna(Diploid key, Cromosoma value) {
		super(Rna.class, key, value);
	}
	/**
	 * {@link Rna} class constructor.
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link Dna} the parent
	 */
	public Rna(Diploid key, Cromosoma value, Dna parent) {
		super(Rna.class, key, value, parent);
	}
	/**
	 * {@link Rna} class constructor.
	 * @param antitype the antitype
	 */
	public Rna(Class<Hyperrna> antitype) {
		super(Rna.class, antitype);
	}
	/**
	 * {@link Rna} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 */
	public Rna(Class<Hyperrna> antitype, Diploid key, Cromosoma value) {
		super(Rna.class, antitype, key, value);
	}
	/**
	 * {@link Rna} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link Dna} the parent
	 */
	public Rna(Class<Hyperrna> antitype, Diploid key, Cromosoma value, Dna parent) {
		super(Rna.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Diploid,Cromosoma> o1, Mass<Diploid,Cromosoma> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}