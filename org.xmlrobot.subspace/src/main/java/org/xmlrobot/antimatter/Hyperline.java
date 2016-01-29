package org.xmlrobot.antimatter;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Hyperletter;
import org.xmlrobot.positron.Antineutron;

public class Hyperline 
	extends Antineutron<Character,Integer> {

	/**
	 * -2316162769120745075L
	 */
	private static final long serialVersionUID = -2316162769120745075L;

	public Hyperline(Character key, Integer value) {
		
		super(Hyperline.class, key, value);
	}
	public Hyperline(Class<Hyperletter> antitype, Character key, Integer value) {
		
		super(Hyperline.class, key, value);
	}
	@Override
	public String name() {

		return null;
	}
	@Override
	public int compare(Mass<Character,Integer> o1, Mass<Character,Integer> o2) {

		return 0;
	}
}