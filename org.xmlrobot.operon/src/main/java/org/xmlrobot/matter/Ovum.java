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
	
	public Ovum(Tetraploid key, Ribosoma value) {
		super(Ovum.class, key, value);
	}
	public Ovum(Class<Sperma> antitype, Tetraploid key, Ribosoma value) {
		super(Ovum.class, key, value);
	}
	
	@Override
	public String name() {

		return getKey().name();
	}
	@Override
	public int compare(Mass<Tetraploid,Ribosoma> o1, Mass<Tetraploid,Ribosoma> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
