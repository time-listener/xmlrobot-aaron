package org.xmlrobot.event;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

public class Transmission 
	extends Graviton<Hyperchain,Hypercube> {

	/**
	 * -7257948843848880307L
	 */
	private static final long serialVersionUID = -7257948843848880307L;

	public Transmission(Mass<Hyperchain,Hypercube> source) {
		super(source);
	}

}
