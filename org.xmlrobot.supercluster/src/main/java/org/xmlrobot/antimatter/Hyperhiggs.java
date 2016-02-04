package org.xmlrobot.antimatter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Higgs;
import org.xmlrobot.positron.Antineutron;

/**
 * @author joan
 *
 */
public class Hyperhiggs 
	extends Antineutron<MilkyWay,Andromeda> {

	/**
	 * -7362327731493805890L
	 */
	private static final long serialVersionUID = -7362327731493805890L;

	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs() {
		
		super();
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs(MilkyWay key, Andromeda value) {
		
		super(Hyperhiggs.class, key, value);
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs(MilkyWay key, Andromeda value, Hypermuon parent) {
		
		super(Hyperhiggs.class, key, value, parent);
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs(Class<Higgs> antitype, MilkyWay key, Andromeda value) {
		
		super(Hyperhiggs.class, antitype, key, value);
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs(Class<Higgs> antitype, MilkyWay key, Andromeda value, Hypermuon parent) {
		
		super(Hyperhiggs.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<MilkyWay,Andromeda> o1, Mass<MilkyWay,Andromeda> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
