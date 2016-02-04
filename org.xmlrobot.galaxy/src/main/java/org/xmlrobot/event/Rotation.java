package org.xmlrobot.event;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

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
