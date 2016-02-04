package org.xmlrobot.event;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

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
