package org.xmlrobot.matter;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.antimatter.HyperbosonZ;
import org.xmlrobot.positron.Proton;

public class BosonZ 
	extends Proton<AlphaCentauri,Sun> {

	/**
	 * -368306173123213628L
	 */
	private static final long serialVersionUID = -368306173123213628L;

	public BosonZ() {
		super(BosonZ.class);
	}
	public BosonZ(Class<HyperbosonZ> antitype) {
		super(BosonZ.class, antitype);
	}

}
