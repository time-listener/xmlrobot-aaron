package org.xmlrobot.matter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.antimatter.Hyperhiggs;
import org.xmlrobot.positron.Proton;

public class Higgs 
	extends Proton<Andromeda,MilkyWay> {

	/**
	 * 6427629947698898606L
	 */
	private static final long serialVersionUID = 6427629947698898606L;

	/**
	 * 
	 */
	public Higgs() {
		super(Higgs.class);
	}
	/**
	 * @param antitype
	 */
	public Higgs(Class<Hyperhiggs> antitype) {
		super(Higgs.class, antitype);
	}
}
