package org.xmlrobot.core.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;

/**
 * @author joan
 *
 */
public class Contraction 
	extends Graviton<Columbia,Fornax> {

	/**
	 * 2243636072747739845L
	 */
	private static final long serialVersionUID = 2243636072747739845L;

	/**
	 * @param source
	 */
	public Contraction(Mass<Columbia,Fornax> source) {
		super(source);
	}
}
