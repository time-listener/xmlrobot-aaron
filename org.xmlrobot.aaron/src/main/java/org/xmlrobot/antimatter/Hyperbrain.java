package org.xmlrobot.antimatter;

import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.positron.Antiproton;

public class Hyperbrain 
	extends Antiproton<Universe,Subspace> {

	/**
	 * 8426959343924822410L
	 */
	private static final long serialVersionUID = 8426959343924822410L;

	/**
	 * 
	 */
	public Hyperbrain() {
		super(Hyperbrain.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperbrain(Class<Hypermind> antitype) {
		super(Hyperbrain.class, antitype);
	}
}
