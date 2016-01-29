/**
 * 
 */
package org.xmlrobot.event;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

/**
 * @author joan
 *
 */
public class Hyperfission extends Graviton<Spacetime,Minkowski> {

	/**
	 * -4350569297202290800L
	 */
	private static final long serialVersionUID = -4350569297202290800L;

	/**
	 * 
	 */
	public Hyperfission(Mass<Spacetime,Minkowski> source) {
		super(source);
	}

}
