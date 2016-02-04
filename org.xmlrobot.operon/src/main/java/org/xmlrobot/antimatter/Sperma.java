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
	
	/**
	 * 
	 */
	public Sperma() {
		
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Sperma(Ribosoma key, Tetraploid value) {
		
		super(Sperma.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Sperma(Ribosoma key, Tetraploid value, Adam parent) {
		
		super(Sperma.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Sperma(Class<Ovum> antitype, Ribosoma key, Tetraploid value) {
		
		super(Sperma.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Sperma(Class<Ovum> antitype, Ribosoma key, Tetraploid value, Adam parent) {
		
		super(Sperma.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Ribosoma,Tetraploid> o1, Mass<Ribosoma,Tetraploid> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
