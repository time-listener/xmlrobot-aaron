package org.xmlrobot.antimatter;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.matter.Exon;
import org.xmlrobot.positron.Antiproton;

public class Hyperexon 
	extends Antiproton<Hypercube,Hyperchain> {

	/**
	 * -4725035824910633738L
	 */
	private static final long serialVersionUID = -4725035824910633738L;

	/**
	 * {@link Hyperexon}
	 */
	public Hyperexon() {
		super(Hyperexon.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperexon(Class<Exon> antitype) {
		super(Hyperexon.class, antitype);
	}
}
