package org.xmlrobot.event;

import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Dispersion 
	extends Graviton<Cell,Operon> {

	/**
	 * 6945510594153488052L
	 */
	private static final long serialVersionUID = 6945510594153488052L;

	public Dispersion(Mass<Cell,Operon> source) {
		
		super(source);
	}

}
