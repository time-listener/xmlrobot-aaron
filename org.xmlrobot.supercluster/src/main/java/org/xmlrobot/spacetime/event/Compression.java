package org.xmlrobot.spacetime.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;

/**
 * @author joan
 *
 */
public class Compression 
	extends Graviton<MilkyWay,Andromeda> {

	/**
	 * 324790219005599105L
	 */
	private static final long serialVersionUID = 324790219005599105L;

	/**
	 * @param source
	 */
	public Compression(Mass<MilkyWay,Andromeda> source) {
		super(source);
	}

}
