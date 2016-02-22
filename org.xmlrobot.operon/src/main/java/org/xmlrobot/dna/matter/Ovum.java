package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.dna.antimatter.Sperma;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

/**
 * Ovum implementation class.
 * @author joan
 * @parity XX
 * @since 1522.3
 */
@XmlRootElement
public class Ovum
	extends Antineutron<Tetraploid,Ribosoma> {

	/**
	 * 7582069425323316687L
	 */
	private static final long serialVersionUID = 7582069425323316687L;
	
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
	public Tetraploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Tetraploid setKey(Tetraploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Ribosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Ribosoma setValue(Ribosoma value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Ovum} default class constructor.
	 */
	public Ovum() {
		super(Ovum.class);
	}
	/**
	 * {@link Ovum} class constructor.
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 */
	public Ovum(Tetraploid key, Ribosoma value) {
		super(Ovum.class, key, value);
	}
	/**
	 * {@link Ovum} class constructor.
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Eva} the parent
	 */
	public Ovum(Tetraploid key, Ribosoma value, Eva parent) {
		super(Ovum.class, key, value, parent);
	}
	/**
	 * {@link Ovum} class constructor.
	 * @param antitype the antitype
	 */
	public Ovum(Class<Sperma> antitype) {
		super(Ovum.class, antitype);
	}
	/**
	 * {@link Ovum} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 */
	public Ovum(Class<Sperma> antitype, Tetraploid key, Ribosoma value) {
		super(Ovum.class, key, value);
	}
	/**
	 * {@link Ovum} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Eva} the parent
	 */
	public Ovum(Class<Sperma> antitype, Tetraploid key, Ribosoma value, Eva parent) {
		super(Ovum.class, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Tetraploid,Ribosoma> o1, Mass<Tetraploid,Ribosoma> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}