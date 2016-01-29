package org.xmlrobot.antimatter;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.matter.BosonZ;
import org.xmlrobot.positron.Antiproton;

public class HyperbosonZ 
	extends Antiproton<Sun,AlphaCentauri> {

	/**
	 * -1388131279477719068L
	 */
	private static final long serialVersionUID = -1388131279477719068L;

	public HyperbosonZ() {
		super(HyperbosonZ.class);
	}
	public HyperbosonZ(Class<BosonZ> antitype) {
		super(HyperbosonZ.class, antitype);
	}

}
