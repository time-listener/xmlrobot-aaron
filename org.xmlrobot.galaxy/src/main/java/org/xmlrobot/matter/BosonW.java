package org.xmlrobot.matter;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.antimatter.HyperbosonW;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class BosonW 
	extends Neutron<AlphaCentauri,Sun> {

	/**
	 * 4014918301790036086L
	 */
	private static final long serialVersionUID = 4014918301790036086L;
	
	public BosonW() {
		super();
	}
	public BosonW(AlphaCentauri key, Sun value) {
		super(BosonW.class, key, value);
	}
	public BosonW(AlphaCentauri key, Sun value, BosonZ parent) {
		super(BosonW.class, key, value, parent);
	}
	public BosonW(Class<HyperbosonW> antitype, AlphaCentauri key, Sun value) {
		super(BosonW.class, antitype, key, value);
	}
	public BosonW(Class<HyperbosonW> antitype, AlphaCentauri key, Sun value, BosonZ parent) {
		super(BosonW.class, antitype, key, value, parent);
	}
	
	@Override
	public String getName() {

		return getKey().getName();
	}
	@Override
	public int compare(Mass<AlphaCentauri, Sun> o1, Mass<AlphaCentauri, Sun> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}