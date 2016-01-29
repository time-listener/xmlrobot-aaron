package org.xmlrobot.antimatter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Muon;
import org.xmlrobot.positron.Antineutron;

/**
 * @author joan
 *
 */
public class Hypermuon 
	extends Antineutron<MilkyWay,Andromeda> {

	/**
	 * -7362327731493805890L
	 */
	private static final long serialVersionUID = -7362327731493805890L;
	
	/**
	 * {@link Hypermuon} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hypermuon(MilkyWay key, Andromeda value) {
		
		super(Hypermuon.class, key, value);
	}
	/**
	 * {@link Hypermuon} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hypermuon(Class<Muon> antitype, MilkyWay key, Andromeda value) {
		
		super(Hypermuon.class, antitype, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String name() {

		return getKey().name();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<MilkyWay,Andromeda> o1, Mass<MilkyWay,Andromeda> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
