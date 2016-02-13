package org.xmlrobot.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Positron;

/**
 * Hyperxml implementation class.
 * @author joan
 * @parity YY
 * @since 41166.3
 */
@XmlRootElement
public class Hyperxml 
	extends Positron<Subspace,Universe> {

	/**
	 * -2455024941563105083L
	 */
	private static final long serialVersionUID = -2455024941563105083L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Subspace getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Subspace setKey(Subspace key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Universe getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Universe setValue(Universe value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperxml} default class constructor.
	 */
	public Hyperxml() {
		super(Hyperxml.class);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 */
	public Hyperxml(Subspace key, Universe value) {
		super(Hyperxml.class, key, value);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 * @param parent {@link Hypermind} the parent
	 */
	public Hyperxml(Subspace key, Universe value, Hypermind parent) {
		super(Hyperxml.class, key, value, parent);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 */
	public Hyperxml(Class<Hyperneuron> antitype) {
		super(Hyperxml.class, antitype);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 */
	public Hyperxml(Class<Hyperneuron> antitype, Subspace key, Universe value) {
		super(Hyperxml.class, antitype, key, value);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 * @param parent {@link Hypermind} the parent
	 */
	public Hyperxml(Class<Hyperneuron> antitype, Subspace key, Universe value, Hypermind parent) {
		super(Hyperxml.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Subspace,Universe> o1, Mass<Subspace,Universe> o2) {
		return o1.getValue().compareTo(o2.getKey());
	}
}