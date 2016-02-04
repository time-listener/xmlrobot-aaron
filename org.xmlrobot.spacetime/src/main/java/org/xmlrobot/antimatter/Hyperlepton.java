package org.xmlrobot.antimatter;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Lepton;
import org.xmlrobot.positron.Antineutron;

public class Hyperlepton 
	extends Antineutron<Fornax,Columbia> {

	/**
	 * 5334316184698114845L
	 */
	private static final long serialVersionUID = 5334316184698114845L;
	
	/**
	 * 
	 */
	public Hyperlepton() {
		super();
	}
	public Hyperlepton(Fornax key, Columbia value) {
		super(Hyperlepton.class, key, value);
	}
	public Hyperlepton(Fornax key, Columbia value, Hyperquark parent) {
		super(Hyperlepton.class, key, value, parent);
	}
	public Hyperlepton(Class<Lepton> antitype, Fornax key, Columbia value) {
		super(Hyperlepton.class, antitype, key, value);
	}
	public Hyperlepton(Class<Lepton> antitype, Fornax key, Columbia value, Hyperquark parent) {
		super(Hyperlepton.class, antitype, key, value, parent);
	}
	@Override
	public String getName() {

		return getKey().getName();
	}
	@Override
	public int compare(Mass<Fornax, Columbia> o1, Mass<Fornax, Columbia> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
