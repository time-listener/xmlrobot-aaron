package org.xmlrobot.antimatter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.matter.Higgs;
import org.xmlrobot.positron.Antiproton;

public class Hyperhiggs 
	extends Antiproton<MilkyWay,Andromeda> {

	/**
	 * -1305023019879315282L
	 */
	private static final long serialVersionUID = -1305023019879315282L;

	/**
	 * 
	 */
	public Hyperhiggs() {
		super(Hyperhiggs.class);
	}
	/**
	 * @param antitype
	 */
	/**
	 * @param antitype
	 */
	public Hyperhiggs(Class<Higgs> antitype) {
		super(Hyperhiggs.class, antitype);
	}
}
