package org.xmlrobot.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.positron.Antineutron;

/**
 * Hyperneuron implementation class.
 * @author joan
 * @parity YY
 * @since 41166.4
 */
@XmlRootElement
public class Hyperneuron 
	extends Antineutron<Universe,Subspace> {

	/**
	 * -4548799042014185239L
	 */
	private static final long serialVersionUID = -4548799042014185239L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Universe getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Universe setKey(Universe key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Subspace getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Subspace setValue(Subspace value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperneuron} default class constructor.
	 */
	public Hyperneuron() {
		super(Hyperneuron.class);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hyperneuron(Universe key, Subspace value) {
		super(Hyperneuron.class, key, value);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 * @param parent {@link Hyperbrain} the parent
	 */
	public Hyperneuron(Universe key, Subspace value, Hyperbrain parent) {
		super(Hyperneuron.class, key, value, parent);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperneuron(Class<Hyperxml> antitype) {
		super(Hyperneuron.class, antitype);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hyperneuron(Class<Hyperxml> antitype,
			Universe key, Subspace value) {
		super(Hyperneuron.class, antitype, key, value);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 * @param parent {@link Hyperbrain} the parent
	 */
	public Hyperneuron(Class<Hyperxml> antitype,
			Universe key, Subspace value, Hyperbrain parent) {
		super(Hyperneuron.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Universe,Subspace> o1, Mass<Universe,Subspace> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
}