package org.xmlrobot.spacetime.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;

public class Rotation 
	extends Graviton<Sun,AlphaCentauri> {

	/**
	 * -1964012930157565718L
	 */
	private static final long serialVersionUID = -1964012930157565718L;

	/**
	 * @param source
	 */
	public Rotation(Mass<Sun,AlphaCentauri> source) {
		
		super(source);
	}

}
