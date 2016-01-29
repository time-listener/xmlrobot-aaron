package org.xmlrobot.event;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

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
