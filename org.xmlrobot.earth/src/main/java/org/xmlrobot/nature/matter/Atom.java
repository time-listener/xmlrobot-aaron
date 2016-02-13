package org.xmlrobot.nature.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.nature.antimatter.Hyperatom;
import org.xmlrobot.positron.Antineutron;

/**
 * Atom implementation class.
 * @author joan
 * @parity XX
 * @since 1524.3
 */
@XmlRootElement
public class Atom
	extends Antineutron<Cell,Operon> {

	/**
	 * -4298462132719102245L
	 */
	private static final long serialVersionUID = -4298462132719102245L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Cell getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Cell setKey(Cell key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Operon getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Operon setValue(Operon value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Atom} default class constructor.
	 */
	public Atom() {
		super(Atom.class);
	}	
	/**
	 * {@link Atom} class constructor.
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 */
	public Atom(Cell key, Operon value) {
		super(Atom.class, key, value);
	}
	/**
	 * {@link Atom} class constructor.
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link Element} the parent
	 */
	public Atom(Cell key, Operon value, Element parent) {
		super(Atom.class, key, value, parent);
	}
	/**
	 * {@link Atom} class constructor.
	 * @param antitype the antitype
	 */
	public Atom(Class<Hyperatom> antitype) {
		super(Atom.class, antitype);
	}
	/**
	 * {@link Atom} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 */
	public Atom(Class<Hyperatom> antitype, Cell key, Operon value) {
		super(Atom.class, antitype, key, value);
	}
	/**
	 * {@link Atom} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link Element} the parent
	 */
	public Atom(Class<Hyperatom> antitype, Cell key, Operon value, Element parent) {
		super(Atom.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Cell,Operon> o1, Mass<Cell,Operon> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}
