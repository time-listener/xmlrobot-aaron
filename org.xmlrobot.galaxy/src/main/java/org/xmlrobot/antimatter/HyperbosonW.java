package org.xmlrobot.antimatter;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.BosonW;
import org.xmlrobot.positron.Antineutron;

public class HyperbosonW 
	extends Antineutron<Sun,AlphaCentauri> {

	/**
	 * 1745339382778302728L
	 */
	private static final long serialVersionUID = 1745339382778302728L;

	/**
	 * 
	 */
	public HyperbosonW() {
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public HyperbosonW(Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public HyperbosonW(Sun key, AlphaCentauri value, HyperbosonZ parent) {
		super(HyperbosonW.class, key, value, parent);
	}
	/**
	 * @param key
	 * @param value
	 */
	public HyperbosonW(Class<BosonW> antitype, Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, antitype, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public HyperbosonW(Class<BosonW> antitype, Sun key, AlphaCentauri value, HyperbosonZ parent) {
		super(HyperbosonW.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {
		
		return getKey().getName();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Sun,AlphaCentauri> o1, Mass<Sun,AlphaCentauri> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
