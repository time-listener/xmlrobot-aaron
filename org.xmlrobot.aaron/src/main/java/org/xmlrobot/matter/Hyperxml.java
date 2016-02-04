package org.xmlrobot.matter;

import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

/**
 * @author joan
 *
 */
public class Hyperxml 
	extends Neutron<Subspace,Universe> {

	/**
	 * -2455024941563105083L
	 */
	private static final long serialVersionUID = -2455024941563105083L;

	/**
	 * 
	 */
	public Hyperxml() {
		
		super();
	}
	public Hyperxml(Subspace key, Universe value) {
		
		super(Hyperxml.class, key, value);
	}
	public Hyperxml(Subspace key, Universe value, Hypermind parent) {
		
		super(Hyperxml.class, key, value, parent);
	}
	public Hyperxml(Class<Hyperneuron> antitype, Subspace key, Universe value) {
		
		super(Hyperxml.class, antitype, key, value);
	}
	public Hyperxml(Class<Hyperneuron> antitype, Subspace key, Universe value, Hypermind parent) {
		
		super(Hyperxml.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Subspace,Universe> o1, Mass<Subspace,Universe> o2) {

		return o1.getValue().compareTo(o2.getKey());
	}
}
