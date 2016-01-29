package org.xmlrobot.matter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.antimatter.Hypermuon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

/**
 * Muon implementation class.
 * @author joan
 *
 */
public class Muon 
	extends Neutron<Andromeda,MilkyWay> {

	/**
	 * 8168068608683637802L
	 */
	private static final long serialVersionUID = 8168068608683637802L;

	/**
	 * @param key
	 * @param value
	 */
	public Muon(Andromeda key, MilkyWay value) {
		super(Muon.class, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Muon(Class<Hypermuon> antitype, Andromeda key, MilkyWay value) {
		super(Muon.class, antitype, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String name() {

		return getKey().name();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Andromeda,MilkyWay> o1, Mass<Andromeda,MilkyWay> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}

}
