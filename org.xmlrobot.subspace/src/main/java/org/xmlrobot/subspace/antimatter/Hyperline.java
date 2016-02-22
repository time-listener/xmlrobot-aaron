package org.xmlrobot.subspace.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.subspace.matter.Hyperunit;

/**
 * Hyperline implementation class.
 * @author joan
 * @parity XY
 * @since 1514.4
 */
@XmlRootElement
public class Hyperline 
	extends Antineutron<Character,Integer> {

	/**
	 * -2316162769120745075L
	 */
	private static final long serialVersionUID = -2316162769120745075L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {
		return getKey().toString();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Character getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Character setKey(Character key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Integer getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Integer setValue(Integer value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperline} default class constructor.
	 */
	public Hyperline() {
		super(Hyperline.class);
	}
	/**
	 * {@link Hyperline} class constructor.
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperline(Character key, Integer value) {
		super(Hyperline.class, key, value);
	}
	/**
	 * {@link Hyperline} class constructor.
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent {@link Hyperdatagram} the parent
	 */
	public Hyperline(Character key, Integer value, Hyperdatagram parent) {
		super(Hyperline.class, key, value, parent);
	}
	/**
	 * {@link Hyperline} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperline(Class<Hyperunit> antitype) {
		super(Hyperline.class, antitype);
	}
	/**
	 * {@link Hyperline} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperline(Class<Hyperunit> antitype, Character key, Integer value) {
		super(Hyperline.class, antitype, key, value);
	}
	/**
	 * {@link Hyperline} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent {@link Hyperdatagram} the parent
	 */
	public Hyperline(Class<Hyperunit> antitype, Character key, Integer value, Hyperdatagram parent) {
		super(Hyperline.class, antitype, key, value, parent);
	}
	

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Character,Integer> o1, Mass<Character,Integer> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}
}