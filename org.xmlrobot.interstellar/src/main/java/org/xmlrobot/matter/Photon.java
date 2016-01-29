package org.xmlrobot.matter;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.antimatter.Hyperphoton;
import org.xmlrobot.positron.Proton;

public class Photon 
	extends Proton<Saturn,Jupiter> {

	/**
	 * 8804208983784652129L
	 */
	private static final long serialVersionUID = 8804208983784652129L;

	/**
	 * {@link Photon} default class constructor.
	 */
	public Photon() {
		super(Photon.class);
	}
	/**
	 * @param antitype
	 */
	public Photon(Class<Hyperphoton> antitype) {
		super(Photon.class, antitype);
	}
}
