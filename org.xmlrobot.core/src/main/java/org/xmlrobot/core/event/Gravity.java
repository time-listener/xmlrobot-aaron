/**
 * 
 */
package org.xmlrobot.core.event;

import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

/**
 * @author joan
 *
 */
public class Gravity 
	extends Graviton<Minkowski,Spacetime> {

	/**
	 * 1570688599467981055L
	 */
	private static final long serialVersionUID = 1570688599467981055L;

	/**
	 * 
	 */
	public Gravity(Mass<Minkowski,Spacetime> source) {
		super(source);
	}

}
