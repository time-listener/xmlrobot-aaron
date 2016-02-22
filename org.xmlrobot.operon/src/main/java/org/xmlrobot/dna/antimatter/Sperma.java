package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.dna.matter.Ovum;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

/**
 * Sperma implementation class.
 * @author joan
 * @parity XY
 * @since 1522.4
 */
@XmlRootElement
public class Sperma 
	extends Antineutron<Ribosoma,Tetraploid> {

	/**
	 * -8435276692988791855L
	 */
	private static final long serialVersionUID = -8435276692988791855L;
	
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
	public Ribosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Ribosoma setKey(Ribosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Tetraploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Tetraploid setValue(Tetraploid value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Sperma} default class constructor.
	 */
	public Sperma() {
		super(Sperma.class);
	}
	/**
	 * {@link Sperma} class constructor.
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 */
	public Sperma(Ribosoma key, Tetraploid value) {
		super(Sperma.class, key, value);
	}
	/**
	 * {@link Sperma} class constructor.
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Adam} the parent
	 */
	public Sperma(Ribosoma key, Tetraploid value, Adam parent) {
		super(Sperma.class, key, value, parent);
	}
	/**
	 * {@link Sperma} class constructor.
	 * @param antitype the antitype
	 */
	public Sperma(Class<Ovum> antitype) {
		super(Sperma.class, antitype);
	}
	/**
	 * {@link Sperma} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 */
	public Sperma(Class<Ovum> antitype, Ribosoma key, Tetraploid value) {
		super(Sperma.class, antitype, key, value);
	}
	/**
	 * {@link Sperma} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Adam} the parent
	 */
	public Sperma(Class<Ovum> antitype, Ribosoma key, Tetraploid value, Adam parent) {
		super(Sperma.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Ribosoma,Tetraploid> o1, Mass<Ribosoma,Tetraploid> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}