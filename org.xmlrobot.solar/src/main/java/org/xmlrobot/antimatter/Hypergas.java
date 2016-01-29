package org.xmlrobot.antimatter;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.matter.Gas;
import org.xmlrobot.positron.Antiproton;

/**
 * Sideral heavy metal: ACDC.
 * 
 * @author joan
 *
 */
public class Hypergas 
	extends Antiproton<Ecosystem,Biosphere> {

	/**
	 * 4184946175192977516L
	 */
	private static final long serialVersionUID = 4184946175192977516L;

	/**
	 * 
	 */
	public Hypergas() {
		
		super(Hypergas.class);
	}
	/**
	 * @param antitype
	 */
	public Hypergas(Class<Gas> antitype) {
		
		super(Hypergas.class, antitype);
	}

}
