package org.xmlrobot.antimatter;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.matter.Photon;
import org.xmlrobot.positron.Antiproton;

/**
 * @author joan
 *
 */
public class Hyperphoton 
	extends Antiproton<Jupiter,Saturn> {

	/**
	 * 2292921025393458451L
	 */
	private static final long serialVersionUID = 2292921025393458451L;

	/**
	 * 
	 */
	public Hyperphoton() {
		super(Hyperphoton.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperphoton(Class<Photon> antitype) {
		super(Hyperphoton.class, antitype);
	}
}
