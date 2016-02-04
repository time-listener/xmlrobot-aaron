/**
 * 
 */
package org.xmlrobot.matter;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hypermeson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

/**
 * @author joan
 *
 */
public class Meson 
	extends Neutron<Minkowski,Spacetime> { 

	/**
	 * 3659396910430609141L
	 */
	private static final long serialVersionUID = 3659396910430609141L;
	
	public Meson() {
		super();
	}
	public Meson(Minkowski key, Spacetime value) {
		super(Meson.class, key, value);
	}
	public Meson(Minkowski key, Spacetime value, Baryon parent) {
		super(Meson.class, key, value, parent);
	}
	public Meson(Class<Hypermeson> antitype, Minkowski key, Spacetime value) {
		super(Meson.class, antitype, key, value);
	}
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
