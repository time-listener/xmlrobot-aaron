package org.xmlrobot.matter;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.antimatter.Hyperintron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Intron 
	extends Neutron<Hyperchain,Hypercube>{

	/**
	 * -2718890842282738451L
	 */
	private static final long serialVersionUID = -2718890842282738451L;
	
	/**
	 * {@link Intron} default class constructor.
	 */
	public Intron() {
		super();
	}
	/**
	 * {@link Intron} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 */
	public Intron(Hyperchain key, Hypercube value) {
		super(Intron.class, key, value);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Exon} the parent
	 */
	public Intron(Hyperchain key, Hypercube value, Exon parent) {
		super(Intron.class, key, value, parent);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 */
	public Intron(Class<Hyperintron> antitype, Hyperchain key, Hypercube value) {
		super(Intron.class, antitype, key, value);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Exon} the parent
	 */
	public Intron(Class<Hyperintron> antitype, Hyperchain key, Hypercube value, Exon parent) {
		super(Intron.class, antitype, key, value, parent);
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
	public int compare(Mass<Hyperchain,Hypercube> o1,
			Mass<Hyperchain,Hypercube> o2) {
		
		return o1.getKey().compareTo(o2.getValue());
	}

}
