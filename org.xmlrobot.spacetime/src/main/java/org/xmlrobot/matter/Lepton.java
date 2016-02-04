package org.xmlrobot.matter;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.antimatter.Hyperlepton;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Lepton
	extends Neutron<Columbia,Fornax> {

	/**
	 * -6065172273899408059L
	 */
	private static final long serialVersionUID = -6065172273899408059L;
	
	/**
	 * 
	 */
	public Lepton() {
		
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Lepton(Columbia key, Fornax value) {
		
		super(Lepton.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Lepton(Columbia key, Fornax value, Quark parent) {
		
		super(Lepton.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Lepton(Class<Hyperlepton> antitype, Columbia key, Fornax value) {
		
		super(Lepton.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Lepton(Class<Hyperlepton> antitype, Columbia key, Fornax value, Quark parent) {
		
		super(Lepton.class, antitype, key, value, parent);
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
	public int compare(Mass<Columbia, Fornax> o1, Mass<Columbia, Fornax> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}

}
