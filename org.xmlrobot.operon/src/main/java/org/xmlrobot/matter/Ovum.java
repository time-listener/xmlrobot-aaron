package org.xmlrobot.matter;

import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.antimatter.Sperma;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

public class Ovum 
	extends Antineutron<Tetraploid,Ribosoma> {

	/**
	 * 7582069425323316687L
	 */
	private static final long serialVersionUID = 7582069425323316687L;
	
	/**
	 * 
	 */
	public Ovum() {
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Ovum(Tetraploid key, Ribosoma value) {
		super(Ovum.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Ovum(Tetraploid key, Ribosoma value, Eva parent) {
		super(Ovum.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Ovum(Class<Sperma> antitype, Tetraploid key, Ribosoma value) {
		super(Ovum.class, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Ovum(Class<Sperma> antitype, Tetraploid key, Ribosoma value, Eva parent) {
		super(Ovum.class, key, value, parent);
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
	public int compare(Mass<Tetraploid,Ribosoma> o1, Mass<Tetraploid,Ribosoma> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
