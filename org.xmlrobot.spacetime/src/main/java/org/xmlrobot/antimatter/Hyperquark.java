package org.xmlrobot.antimatter;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.matter.Quark;
import org.xmlrobot.positron.Antiproton;

public class Hyperquark 
	extends Antiproton<Fornax,Columbia> {

	/**
	 * -6954372698317451289L
	 */
	private static final long serialVersionUID = -6954372698317451289L;
	
	/**
	 * 
	 */
	public Hyperquark() {
		super(Hyperquark.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperquark(Class<Quark> antitype) {
		super(Hyperquark.class, antitype);
	}
}
