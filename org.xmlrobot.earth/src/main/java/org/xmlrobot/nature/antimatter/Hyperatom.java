package org.xmlrobot.nature.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.nature.matter.Atom;
import org.xmlrobot.positron.Antineutron;

/**
 * Hyperatom implementation class.
 * @author joan
 * @parity XY
 * @since 1524.4
 */
@XmlRootElement
public class Hyperatom 
	extends Antineutron<Operon,Cell> {

	/**
	 * 4058808614266793154L
	 */
	private static final long serialVersionUID = 4058808614266793154L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Operon getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Operon setKey(Operon key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Cell getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Cell setValue(Cell value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperatom} default class constructor.
	 */
	public Hyperatom() {
		super(Hyperatom.class);
	}
	/**
	 * {@link Hyperatom} class constructor.
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 */
	public Hyperatom(Operon key, Cell value) {
		super(Hyperatom.class, key, value);
	}
	/**
	 * {@link Hyperatom} class constructor.
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Hyperelement} the parent
	 */
	public Hyperatom(Operon key, Cell value, Hyperelement parent) {
		super(Hyperatom.class, key, value, parent);
	}
	/**
	 * {@link Hyperatom} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperatom(Class<Atom> antitype) {
		super(Hyperatom.class, antitype);
	}
	/**
	 * {@link Hyperatom} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 */
	public Hyperatom(Class<Atom> antitype, Operon key, Cell value) {
		super(Hyperatom.class, antitype, key, value);
	}
	/**
	 * {@link Hyperatom} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Hyperelement} the parent
	 */
	public Hyperatom(Class<Atom> antitype, Operon key, Cell value, Hyperelement parent) {
		super(Hyperatom.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Operon,Cell> o1, Mass<Operon,Cell> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}
