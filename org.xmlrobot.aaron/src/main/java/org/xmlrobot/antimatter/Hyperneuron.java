package org.xmlrobot.antimatter;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;

public class Hyperneuron 
	extends Antineutron<Universe,Subspace> {

	/**
	 * -4548799042014185239L
	 */
	private static final long serialVersionUID = -4548799042014185239L;

	/**
	 * 
	 */
	public Hyperneuron() {
	}

	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperneuron(Universe key, Subspace value, Mass<Universe, Subspace> parent) {
		super(Hyperneuron.class, key, value, parent);
	}

	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperneuron(Class<? extends Mass<Subspace, Universe>> antitype,
			Universe key, Subspace value, Mass<Universe, Subspace> parent) {
		super(Hyperneuron.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Universe,Subspace> o1, Mass<Universe,Subspace> o2) {
		return o1.getValue().compareTo(o2.getKey());
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String name() {

		return getKey().name();
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}

}
