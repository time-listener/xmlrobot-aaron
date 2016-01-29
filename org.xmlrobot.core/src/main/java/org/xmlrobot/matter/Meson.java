/**
 * 
 */
package org.xmlrobot.matter;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
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

	/**
	 * 
	 */
	public Meson(Minkowski key, Spacetime value) {
		super(Meson.class, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {

		return getKey().name();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Minkowski,Spacetime> o1, Mass<Minkowski,Spacetime> o2) {

		return o1.getValue().compareTo(o2.getKey());
	}
}
