package org.xmlrobot.event;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Impact 
	extends Graviton<Biosphere,Ecosystem> {

	/**
	 * 1235528762151659077L
	 */
	private static final long serialVersionUID = 1235528762151659077L;

	/**
	 * @param source
	 */
	public Impact(Mass<Biosphere,Ecosystem> source) {
		super(source);
	}

}
