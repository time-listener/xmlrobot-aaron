package org.xmlrobot.event;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Mitosis extends Graviton<Diploid,Cromosoma> {

	/**
	 * -2289561162827937648L
	 */
	private static final long serialVersionUID = -2289561162827937648L;

	public Mitosis(Mass<Diploid,Cromosoma> source) {
		
		super(source);
	}
}
