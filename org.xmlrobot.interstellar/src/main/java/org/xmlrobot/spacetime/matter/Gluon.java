package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hypergluon;

/**
 * Gluon implementation class.
 * Gluons are elementary particles that act as the exchange particles for the strong force between quarks, 
 * analogous to the exchange of photons in the electromagnetic force between two charged particles. 
 * In layman terms, they "glue" quarks together, forming protons and neutrons.
 * 
 * @author joan
 * @parity XX
 * @since 41156.3
 */
@XmlRootElement
public class Gluon 
	extends Antineutron<Saturn,Jupiter> {

	/**
	 * 9027202948697242639L
	 */
	private static final long serialVersionUID = 9027202948697242639L;

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
	public Saturn getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Saturn setKey(Saturn key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Jupiter getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Jupiter setValue(Jupiter value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Gluon} default class constructor.
	 */
	public Gluon() {
		super(Gluon.class);
	}
	/**
	 * {@link Gluon} class constructor.
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 */
	public Gluon(Saturn key, Jupiter value) {
		super(Gluon.class, key, value);
	}
	/**
	 * {@link Gluon} class constructor.
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 * @param parent {@link Photon} the parent
	 */
	public Gluon(Saturn key, Jupiter value, Photon parent) {
		super(Gluon.class, key, value, parent);
	}
	/**
	 * {@link Gluon} class constructor.
	 * @param antitype the antitype
	 */
	public Gluon(Class<Hypergluon> antitype) {
		super(Gluon.class, antitype);
	}
	/**
	 * {@link Gluon} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 */
	public Gluon(Class<Hypergluon> antitype, Saturn key, Jupiter value) {
		super(Gluon.class, key, value);
	}
	/**
	 * {@link Gluon} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 * @param parent {@link Photon} the parent
	 */
	public Gluon(Class<Hypergluon> antitype, Saturn key, Jupiter value, Photon parent) {
		super(Gluon.class, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Saturn,Jupiter> o1, Mass<Saturn,Jupiter> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}