package org.xmlrobot.matter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.antimatter.Hyperhiggs;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

/**
 * Muon implementation class.
 * @author joan
 *
 */
public class Higgs 
	extends Neutron<Andromeda,MilkyWay> {

	/**
	 * 8168068608683637802L
	 */
	private static final long serialVersionUID = 8168068608683637802L;

	/**
	 * @param key
	 * @param value
	 */
	public Higgs() {
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Higgs(Andromeda key, MilkyWay value) {
		super(Higgs.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public Higgs(Andromeda key, MilkyWay value, Muon parent) {
		super(Higgs.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Higgs(Class<Hyperhiggs> antitype, Andromeda key, MilkyWay value) {
		super(Higgs.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Higgs(Class<Hyperhiggs> antitype, Andromeda key, MilkyWay value, Muon parent) {
		super(Higgs.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Andromeda,MilkyWay> o1, Mass<Andromeda,MilkyWay> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}

}
