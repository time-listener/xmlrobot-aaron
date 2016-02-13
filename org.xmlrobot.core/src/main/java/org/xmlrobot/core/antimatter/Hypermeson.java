/**
 * 
 */
package org.xmlrobot.core.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.matter.Meson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

/**
 * Hypermeson implementation class.
 * @author joan
 * @parity XY
 * @since 41164.4
 */
@XmlRootElement
public class Hypermeson
	extends Antineutron<Spacetime,Minkowski> {

	/**
	 * 7790598228248897555L
	 */
	private static final long serialVersionUID = 7790598228248897555L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Spacetime getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Spacetime setKey(Spacetime key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Minkowski getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Minkowski setValue(Minkowski value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hypermeson} default class constructor.
	 */
	public Hypermeson() {
		super(Hypermeson.class);
	}
	/**
	 * {@link Hypermeson} class constructor.
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 */
	public Hypermeson(Spacetime key, Minkowski value) {
		super(Hypermeson.class, key, value);
	}
	/**
	 * {@link Hypermeson} class constructor.
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 * @param parent {@link Hyperbaryon} the parent
	 */
	public Hypermeson(Spacetime key, Minkowski value, Hyperbaryon parent) {
		super(Hypermeson.class, key, value, parent);
	}
	/**
	 * {@link Hypermeson} class constructor.
	 * @param antitype the antitype
	 */
	public Hypermeson(Class<Meson> antitype) {
		super(Hypermeson.class, antitype);
	}
	/**
	 * {@link Hypermeson} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 */
	public Hypermeson(Class<Meson> antitype, Spacetime key, Minkowski value) {
		super(Hypermeson.class, antitype, key, value);
	}
	/**
	 * {@link Hypermeson} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 * @param parent {@link Hyperbaryon} the parent
	 */
	public Hypermeson(Class<Meson> antitype, Spacetime key, Minkowski value, Hyperbaryon parent) {
		super(Hypermeson.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Spacetime,Minkowski> o1, Mass<Spacetime,Minkowski> o2) {
		return o1.getValue().compareTo(o2.getKey());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
}
