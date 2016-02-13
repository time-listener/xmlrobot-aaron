package org.xmlrobot.nature.event;

import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Homogenization 
	extends Graviton<Operon,Cell> {

	/**
	 * -578078532066294255L
	 */
	private static final long serialVersionUID = -578078532066294255L;

	/**
	 * @param source
	 */
	public Homogenization(Mass<Operon,Cell> source) {
		super(source);
	}
}
