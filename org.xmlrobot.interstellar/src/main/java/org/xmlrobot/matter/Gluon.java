package org.xmlrobot.matter;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.antimatter.Hypergluon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Gluon 
	extends Neutron<Saturn,Jupiter> {

	/**
	 * 9027202948697242639L
	 */
	private static final long serialVersionUID = 9027202948697242639L;
	
	/**
	 * 
	 */
	public Gluon() {
		
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Gluon(Saturn key, Jupiter value) {
		
		super(Gluon.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Gluon(Saturn key, Jupiter value, Photon parent) {
		
		super(Gluon.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Gluon(Class<Hypergluon> antitype, Saturn key, Jupiter value) {
		
		super(Gluon.class, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Gluon(Class<Hypergluon> antitype, Saturn key, Jupiter value, Photon parent) {
		
		super(Gluon.class, key, value, parent);
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
	public int compare(Mass<Saturn,Jupiter> o1, Mass<Saturn,Jupiter> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}