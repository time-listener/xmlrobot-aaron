package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.Subspace;
import org.xmlrobot.Universe;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.util.Parity;

/**
 * @author joan 
 */
public class Hypertoroid 
	extends ScrewDriver<Universe,Subspace>{
	
	/**
	 * 330147645066251184L
	 */
	private static final long serialVersionUID = 330147645066251184L;
	
	/**
	 * {@link Hypertoroid} default class constructor.
	 */
	public Hypertoroid() {
		super();
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Universe key, Subspace value) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, key, value, Parity.YY);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Universe key, Subspace value, Aaron parent) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, key, value, parent);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Class<Hyperplasma> antitype, Universe key, Subspace value) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, antitype, key, value, Parity.YY);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Class<Hyperplasma> antitype, Universe key, Subspace value, Aaron parent) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Hyperspace#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		// do something
		switch (event.getCommand()) {
		case TRANSFER:
			if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// free from inheritance
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare source
		Object source;
		// get entity
		if ((source = getContext().getService(ref)) instanceof Hypertoroid) {

			Hypertoroid pair = (Hypertoroid) source;

			if (event.getType() == ServiceEvent.REGISTERED) {
				// input to the brain
				replicator().add(new Hyperneuron(Hyperxml.class, pair.getKey(), pair.getValue()));
			}
			if (event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}