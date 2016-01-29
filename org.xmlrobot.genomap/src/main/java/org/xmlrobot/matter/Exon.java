package org.xmlrobot.matter;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.antimatter.Hyperexon;
import org.xmlrobot.positron.Proton;

public class Exon 
	extends Proton<Hyperchain,Hypercube>{

	/**
	 * 6635269652339700640L
	 */
	private static final long serialVersionUID = 6635269652339700640L;

	/**
	 * {@link Exon} default class constructor.
	 */
	public Exon() {
		super(Exon.class);
	}
	/**
	 * {@link Exon} class constructor.
	 * @param antitype the antitype
	 */
	public Exon(Class<Hyperexon> antitype) {
		super(Exon.class, antitype);
	}

}
