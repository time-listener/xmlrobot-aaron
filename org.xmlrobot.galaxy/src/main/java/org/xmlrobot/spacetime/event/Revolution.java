package org.xmlrobot.spacetime.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;

public class Revolution 
	extends Graviton<AlphaCentauri,Sun> {

	/**
	 * 4380088512864682168L
	 */
	private static final long serialVersionUID = 4380088512864682168L;

	/**
	 * @param source
	 */
	public Revolution(Mass<AlphaCentauri,Sun> source) {
		super(source);
	}

}
