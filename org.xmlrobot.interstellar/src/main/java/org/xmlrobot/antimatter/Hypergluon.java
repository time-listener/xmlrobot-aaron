package org.xmlrobot.antimatter;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Gluon;
import org.xmlrobot.positron.Antineutron;

public class Hypergluon 
	extends Antineutron<Jupiter,Saturn> {

	/**
	 * -5441851407783395899L
	 */
	private static final long serialVersionUID = -5441851407783395899L;
	
	/**
	 * @param key
	 * @param value
	 */
	public Hypergluon(Jupiter key, Saturn value) {
		
		super(Hypergluon.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hypergluon(Jupiter key, Saturn value, Hyperphoton parent) {
		
		super(Hypergluon.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hypergluon(Class<Gluon> antitype, Jupiter key, Saturn value) {
		
		super(Hypergluon.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hypergluon(Class<Gluon> antitype, Jupiter key, Saturn value, Hyperphoton parent) {
		
		super(Hypergluon.class, antitype, key, value, parent);
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
	public int compare(Mass<Jupiter,Saturn> o1, Mass<Jupiter,Saturn> o2) {
		
		return o1.getKey().compareTo(o2.getValue());
	}
}