package org.xmlrobot.antimatter;

import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.matter.Eva;
import org.xmlrobot.positron.Proton;

public class Adam 
	extends Proton<Ribosoma,Tetraploid> {

	/**
	 * -7001412700159246172L
	 */
	private static final long serialVersionUID = -7001412700159246172L;

	public Adam() {
		super(Adam.class);
	}
	public Adam(Class<Eva> antitype) {
		super(Adam.class, antitype);
	}
}
