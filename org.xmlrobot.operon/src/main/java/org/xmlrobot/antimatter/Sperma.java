package org.xmlrobot.antimatter;

import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Ovum;
import org.xmlrobot.positron.Neutron;

public class Sperma 
	extends Neutron<Ribosoma,Tetraploid> {

	/**
	 * -8435276692988791855L
	 */
	private static final long serialVersionUID = -8435276692988791855L;
	
	public Sperma(Ribosoma key, Tetraploid value) {
		
		super(Sperma.class, key, value);
	}
	public Sperma(Class<Ovum> antitype, Ribosoma key, Tetraploid value) {
		
		super(Sperma.class, antitype, key, value);
	}
	@Override
	public String name() {

		return getKey().name();
	}
	@Override
	public int compare(Mass<Ribosoma,Tetraploid> o1, Mass<Ribosoma,Tetraploid> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
