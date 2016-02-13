/**
 * 
 */
package org.xmlrobot.core.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.antimatter.Hypermeson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

/**
 * Meson implementation class.
 * @author joan
 * @parity XX
 * @since 41164.3
 */
@XmlRootElement
public class Meson 
	extends Antineutron<Minkowski,Spacetime> { 

	/**
	 * 3659396910430609141L
	 */
	private static final long serialVersionUID = 3659396910430609141L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Minkowski getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Minkowski setKey(Minkowski key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Spacetime getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Spacetime setValue(Spacetime value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Meson} default class constructor.
	 */
	public Meson() {
		super(Meson.class);
	}
	/**
	 * {@link Meson} class constructor.
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 */
	public Meson(Minkowski key, Spacetime value) {
		super(Meson.class, key, value);
	}
	/**
	 * {@link Meson} class constructor.
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 * @param parent {@link Baryon} the parent
	 */
	public Meson(Minkowski key, Spacetime value, Baryon parent) {
		super(Meson.class, key, value, parent);
	}
	/**
	 * {@link Meson} class constructor.
	 * @param antitype the antitype
	 */
	public Meson(Class<Hypermeson> antitype) {
		super(Meson.class, antitype);
	}
	/**
	 * {@link Meson} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 */
	public Meson(Class<Hypermeson> antitype, Minkowski key, Spacetime value) {
		super(Meson.class, antitype, key, value);
	}
	/**
	 * {@link Meson} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 * @param parent {@link Baryon} the parent
	 */
	public Meson(Class<Hypermeson> antitype, Minkowski key, Spacetime value, Baryon parent) {
		super(Meson.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Minkowski,Spacetime> o1, Mass<Minkowski,Spacetime> o2) {
		return o1.getValue().compareTo(o2.getKey());
	}
}
