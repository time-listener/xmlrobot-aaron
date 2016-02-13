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
public class Antigravity 
	extends Graviton<Spacetime,Minkowski> {

	/**
	 * -7893893106725053770L
	 */
	private static final long serialVersionUID = -7893893106725053770L;

	/**
	 * 
	 */
	public Antigravity(Mass<Spacetime,Minkowski> source) {
		super(source);
	}

}
