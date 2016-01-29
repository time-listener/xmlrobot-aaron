package org.xmlrobot.matter;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Proton;

public class Hypermind extends Proton<Subspace, Universe> {

	/**
	 * 2824932644399451406L
	 */
	private static final long serialVersionUID = 2824932644399451406L;
	/**
	 * @param type
	 * @param antitype
	 */
	public Hypermind(Class<? extends Mass<Universe,Subspace>> antitype) {
		super(Hypermind.class, antitype);
	}
	/**
	 * @param type
	 */
	public Hypermind() {
		super(Hypermind.class);
	}
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}
