package org.xmlrobot.matter;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.antimatter.Hypergas;
import org.xmlrobot.positron.Proton;

public class Gas 
	extends Proton<Biosphere,Ecosystem> {

	/**
	 * -3602380595804343582L
	 */
	private static final long serialVersionUID = -3602380595804343582L;
	
	/**
	 * 
	 */
	public Gas() {
		super(Gas.class);
	}
	/**
	 * @param antitype
	 */
	public Gas(Class<Hypergas> antitype) { 
		super(Gas.class, antitype);
	}
}
