package org.xmlrobot.matter;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.antimatter.Hyperquark;
import org.xmlrobot.positron.Proton;

public class Quark 
	extends Proton<Columbia,Fornax> {

	/**
	 * -2083467336455485338L
	 */
	private static final long serialVersionUID = -2083467336455485338L;
	
	/**
	 * 
	 */
	public Quark() {
		super(Quark.class);
	}
	/**
	 * @param antitype
	 */
	public Quark(Class<Hyperquark> antitype) {
		super(Quark.class, antitype);
	}

}
