/**
 * 
 */
package org.xmlrobot.photon;

import java.awt.Color;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.space.Space;

/**
 * @author joan
 *
 */
public abstract class Photon 
	extends Space<Object,Object> {

	/**
	 * 7273075983662852180L
	 */
	private static final long serialVersionUID = 7273075983662852180L;

	/**
	 * photonic beam color
	 */
	Color rgb;
	
	/**
	 * 
	 */
	public Photon() {
		// TODO light construction
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Object,Object> o1, Mass<Object,Object> o2) {
		// TODO color comparison
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<Object,Object>,Mass<Object,Object>> matrix() {
		// TODO light reproduction ?
		return null;
	}
}
