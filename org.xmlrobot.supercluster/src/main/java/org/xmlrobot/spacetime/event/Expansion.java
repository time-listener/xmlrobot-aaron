package org.xmlrobot.spacetime.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;

/**
 * @author joan
 *
 */
public class Expansion 
	extends Graviton<Andromeda,MilkyWay> {

	/**
	 * -8431089086316588233L
	 */
	private static final long serialVersionUID = -8431089086316588233L;

	/**
	 * @param source
	 */
	public Expansion(Mass<Andromeda,MilkyWay> source) {
		
		super(source);
	}
}
