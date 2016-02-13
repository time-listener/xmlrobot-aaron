package org.xmlrobot.subspace.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.subspace.antimatter.Hyperline;

/**
 * Hyperunit implementation class.
 * @author joan
 * @parity XX
 * @since 1514.3
 */
@XmlRootElement
public class Hyperunit 
	extends Antineutron<Integer,Character> {

	/**
	 * -3417172843256231611L
	 */
	private static final long serialVersionUID = -3417172843256231611L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Integer getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Integer setKey(Integer key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Character getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Character setValue(Character value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	@XmlElement
	public String getName() {
		
		return getValue().toString();
	}
	
	/**
	 * {@link Hyperunit} default class constructor.
	 */
	public Hyperunit() {
		super(Hyperunit.class);
	}
	/**
	 * {@link Hyperunit} class constructor.
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperunit(Integer key, Character value) {
		super(Hyperunit.class, key, value);
	}
	/**
	 * {@link Hyperunit} class constructor.
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent {@link Hyperpacket} the parent
	 */
	public Hyperunit(Integer key, Character value, Hyperpacket parent) {
		super(Hyperunit.class, key, value, parent);
	}
	/**
	 * {@link Hyperunit} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperunit(Class<Hyperline> antitype) {
		super(Hyperunit.class, antitype);
	}
	/**
	 * {@link Hyperunit} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperunit(Class<Hyperline> antitype, Integer key, Character value) {
		super(Hyperunit.class, antitype, key, value);
	}
	/**
	 * {@link Hyperunit} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent {@link Hyperpacket} the parent
	 */
	public Hyperunit(Class<Hyperline> antitype, Integer key, Character value, Hyperpacket parent) {
		super(Hyperunit.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Integer,Character> o1, Mass<Integer,Character> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

}