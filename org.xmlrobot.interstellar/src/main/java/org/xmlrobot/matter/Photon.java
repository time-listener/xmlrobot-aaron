package org.xmlrobot.matter;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.antimatter.Hypergluon;
import org.xmlrobot.antimatter.Hyperphoton;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Photon 
	extends Proton<Saturn,Jupiter> {

	/**
	 * 8804208983784652129L
	 */
	private static final long serialVersionUID = 8804208983784652129L;

	/**
	 * {@link Photon} default class constructor.
	 */
	public Photon() {
		super(Photon.class);
	}
	/**
	 * @param antitype
	 */
	public Photon(Class<Hyperphoton> antitype) {
		super(Photon.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hypergluon) {
				// declare stem
				Mass<Jupiter,Saturn> stem;
				// cast source
				Hypergluon pair = (Hypergluon) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.add(pair);
				}
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Jupiter putValue(Saturn key, Jupiter value) {
		// declare child
		Mass<Saturn,Jupiter> child;
		// declare old value
		Jupiter oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? child.putValue(key,
				value) : null) == null) {
			// create child
			Gluon pair = new Gluon(Hypergluon.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}