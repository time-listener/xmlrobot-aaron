package org.xmlrobot.antimatter;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

public class HyperbosonW 
	extends Antineutron<Sun,AlphaCentauri> {

	/**
	 * 1745339382778302728L
	 */
	private static final long serialVersionUID = 1745339382778302728L;

	/**
	 * @param key
	 * @param value
	 */
	public HyperbosonW(Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, key, value);
	}

	@Override
	public String name() {
		
		return getKey().name();
	}

	@Override
	public int compare(Mass<Sun,AlphaCentauri> o1, Mass<Sun,AlphaCentauri> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}

}
