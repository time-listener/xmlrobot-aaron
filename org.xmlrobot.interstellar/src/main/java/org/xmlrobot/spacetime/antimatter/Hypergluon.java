package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.matter.Gluon;

/**
 * Hypergluon implementation class.
 * @author joan
 * @parity XY
 * @since 41156.4
 */
@XmlRootElement
public class Hypergluon 
	extends Antineutron<Jupiter,Saturn> {

	/**
	 * -5441851407783395899L
	 */
	private static final long serialVersionUID = -5441851407783395899L;

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
	public Jupiter getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Jupiter setKey(Jupiter key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Saturn getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Saturn setValue(Saturn value) {
		return super.setValue(value);
	}

	/**
	 * {@link Hypergluon} default class constructor.
	 */
	public Hypergluon() {
		super(Hypergluon.class);
	}
	/**
	 * {@link Hypergluon} class constructor.
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 */
	public Hypergluon(Jupiter key, Saturn value) {
		super(Hypergluon.class, key, value);
	}
	/**
	 * {@link Hypergluon} class constructor.
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Hyperphoton} the parent
	 */
	public Hypergluon(Jupiter key, Saturn value, Hyperphoton parent) {
		super(Hypergluon.class, key, value, parent);
	}
	/**
	 * {@link Hypergluon} class constructor.
	 * @param antitype the antitype
	 */
	public Hypergluon(Class<Gluon> antitype) {
		super(Hypergluon.class, antitype);
	}
	/**
	 * {@link Hypergluon} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 */
	public Hypergluon(Class<Gluon> antitype, Jupiter key, Saturn value) {
		super(Hypergluon.class, antitype, key, value);
	}
	/**
	 * {@link Hypergluon} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Hyperphoton} the parent
	 */
	public Hypergluon(Class<Gluon> antitype, Jupiter key, Saturn value, Hyperphoton parent) {
		super(Hypergluon.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Jupiter,Saturn> o1, Mass<Jupiter,Saturn> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}