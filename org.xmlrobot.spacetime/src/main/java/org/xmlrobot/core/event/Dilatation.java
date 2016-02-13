package org.xmlrobot.core.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;

/**
 * @author joan
 *
 */
public class Dilatation 
	extends Graviton<Fornax,Columbia> {

	/**
	 * -7893893106725053770L
	 */
	private static final long serialVersionUID = -7893893106725053770L;

	/**
	 * @param source
	 */
	public Dilatation(Mass<Fornax,Columbia> source) {
		super(source);
	}

}
