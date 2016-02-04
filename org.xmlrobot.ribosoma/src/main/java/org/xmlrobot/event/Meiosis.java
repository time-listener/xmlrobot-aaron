package org.xmlrobot.event;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Meiosis 
	extends Graviton<Cromosoma,Diploid> {

	/**
	 * -6988448218238742232L
	 */
	private static final long serialVersionUID = -6988448218238742232L;

	/**
	 * @param source
	 */
	public Meiosis(Mass<Cromosoma,Diploid> source) {
		
		super(source);
	}

}
