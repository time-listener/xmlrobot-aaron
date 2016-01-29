package org.xmlrobot.event;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

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
