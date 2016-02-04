package org.xmlrobot.antimatter;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Hyperletter;
import org.xmlrobot.positron.Antineutron;

public class Hyperline 
	extends Antineutron<String,Integer> {

	/**
	 * -2316162769120745075L
	 */
	private static final long serialVersionUID = -2316162769120745075L;

	/**
	 * 
	 */
	public Hyperline() {
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hyperline(String key, Integer value) {
		super(Hyperline.class, key, value);
	}
	/**
	 * @param type
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperline(String key, Integer value, Hyperdatagram parent) {
		super(Hyperline.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hyperline(Class<Hyperletter> antitype, 
			String key, Integer value) {
		super(Hyperline.class, key, value);
	}
	/**
	 * @param type
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperline(Class<Hyperletter> antitype, 
			String key, Integer value, Hyperdatagram parent) {
		super(Hyperline.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {

		return get().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<String,Integer> o1, Mass<String,Integer> o2) {

		return Integer.compare(o1.getValue(), o2.getValue());
	}
}