package org.xmlrobot.matter;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Lepton
	extends Neutron<Columbia,Fornax> {

	/**
	 * -6065172273899408059L
	 */
	private static final long serialVersionUID = -6065172273899408059L;
	
	public Lepton(Columbia key, Fornax value) {
		
		super(Lepton.class, key, value);
	}
	@Override
	public String name() {

		return getKey().name();
	}
	@Override
	public int compare(Mass<Columbia, Fornax> o1, Mass<Columbia, Fornax> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}

}
