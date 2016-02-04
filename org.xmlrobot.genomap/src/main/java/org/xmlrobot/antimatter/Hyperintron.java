package org.xmlrobot.antimatter;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Intron;
import org.xmlrobot.positron.Antineutron;

/**
 * @author joan
 *
 */
public class Hyperintron 
	extends Antineutron<Hypercube,Hyperchain> {

	/**
	 * 4517820012623779722L
	 */
	private static final long serialVersionUID = 4517820012623779722L;

	/**
	 * {@link Hyperintron} default class constructor.
	 */
	public Hyperintron() {
		super();
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 */
	public Hyperintron(Hypercube key, Hyperchain value) {
		super(Hyperintron.class, key, value);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Hyperexon} the parent
	 */
	public Hyperintron(Hypercube key, Hyperchain value, Hyperexon parent) {
		super(Hyperintron.class, key, value, parent);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 */
	public Hyperintron(Class<Intron> antitype, Hypercube key, Hyperchain value) {
		super(Hyperintron.class, key, value);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Hyperexon} the parent
	 */
	public Hyperintron(Class<Intron> antitype, Hypercube key, Hyperchain value, Hyperexon parent) {
		super(Hyperintron.class, key, value, parent);
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
	public int compare(Mass<Hypercube,Hyperchain> o1, Mass<Hypercube,Hyperchain> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
