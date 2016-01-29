package org.xmlrobot.matter;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Hyperxml 
	extends Neutron<Subspace,Universe> {

	/**
	 * -2455024941563105083L
	 */
	private static final long serialVersionUID = -2455024941563105083L;

	public Hyperxml() {
		super();
	}
	/**
	 * @param type
	 * @param key
	 * @param value
	 * @param parent
	 */
	protected Hyperxml(Subspace key, Universe value, Mass<Subspace,Universe> parent) {
		
		super(Hyperxml.class, key, value, parent);
	}
	/**
	 * @param type
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	protected Hyperxml(Class<? extends Mass<Universe,Subspace>> antitype,
			Subspace key, Universe value, Mass<Subspace,Universe> parent) {
		super(Hyperxml.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {
		
		return getKey().name();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Subspace,Universe> o1, Mass<Subspace,Universe> o2) {

		return o1.getValue().compareTo(o2.getKey());
	}
	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}

}
