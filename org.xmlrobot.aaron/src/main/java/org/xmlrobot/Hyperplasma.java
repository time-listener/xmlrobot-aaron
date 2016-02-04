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
 *
 */
public class Hyperplasma 
	extends ScrewDriver<Subspace, Universe> {

	/**
	 * -8573055740709003708L
	 */
	private static final long serialVersionUID = -8573055740709003708L;

	/**
	 * {@link Hyperplasma} default class constructor.
	 */
	public Hyperplasma() {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 */
	public Hyperplasma(Subspace key, Universe value) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, key, value, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 * @param parent {@link Robot} the parent
	 */
	public Hyperplasma(Subspace key, Universe value, Robot parent) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, key, value, parent);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperplasma(Class<Hypertoroid> antitype) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, antitype, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 */
	public Hyperplasma(Class<Hypertoroid> antitype, Subspace key, Universe value) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, antitype, key, value, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 * @param parent {@link Robot} the parent
	 */
	public Hyperplasma(Class<Hypertoroid> antitype, Subspace key, Universe value, Robot parent) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		// do something
		switch (event.getCommand()) {
		case TRANSFER:
			if (event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
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
		if ((source = getContext().getService(ref)) instanceof Hyperplasma) {

			Hyperplasma pair = (Hyperplasma) source;

			if (event.getType() == ServiceEvent.REGISTERED) {
				// input to the brain
				replicator().add(new Hyperxml(Hyperneuron.class, pair.getKey(), pair.getValue()));
			}
			if (event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}