package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Subspace;
import org.xmlrobot.Universe;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.BigBang;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.event.Hyperfission;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.util.Parity;

public class Hyperplasma extends ScrewDriver<Subspace, Universe> {

	/**
	 * -8573055740709003708L
	 */
	private static final long serialVersionUID = -8573055740709003708L;

	/**
	 * 
	 */
	public Hyperplasma() {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, Parity.YY);
	}
	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperplasma(Subspace key, Universe value, ScrewDriver<Subspace,Universe> parent) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, key, value, parent);
	}
	/**
	 * @param antitype
	 */
	public Hyperplasma(Class<? extends ScrewDriver<Universe,Subspace>> antitype) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, antitype, Parity.YY);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Hyperplasma(Class<? extends ScrewDriver<Universe,Subspace>> antitype,
			Subspace key, Universe value, ScrewDriver<Subspace,Universe> parent) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		// do something
		switch (event.command()) {
		case SUBMIT:
			if (event.getSource() instanceof BigBang) {
				BigBang pair = (BigBang) event.getSource();
				ScrewDriver<Spacetime, Minkowski> key;
				// check if empty and chained
				if ((key = getValue()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case TRANSFER:
			if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// free from inheritance
				pair.remove();
				// transfer key-value indexing pair mapping entry message
				getValue().putValue(pair.getKey(), pair.getValue());
			}
			break;
		case RESURRECTION:
			if (event.getSource() instanceof Universe) {
				event.start(context());
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}
}