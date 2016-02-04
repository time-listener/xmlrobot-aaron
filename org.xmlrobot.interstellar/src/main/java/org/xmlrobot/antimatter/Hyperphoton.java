package org.xmlrobot.antimatter;

import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Gluon;
import org.xmlrobot.matter.Photon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hyperphoton 
	extends Antiproton<Jupiter,Saturn> {

	/**
	 * 2292921025393458451L
	 */
	private static final long serialVersionUID = 2292921025393458451L;

	/**
	 * 
	 */
	public Hyperphoton() {
		super(Hyperphoton.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperphoton(Class<Photon> antitype) {
		super(Hyperphoton.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Gluon) {
				// declare stem
				Mass<Saturn,Jupiter> stem;
				// cast source
				Gluon pair = (Gluon) event.getSource();
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
	 * @see org.xmlrobot.positron.Antiproton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Saturn putValue(Jupiter key, Saturn value) {
		// declare child
		Mass<Jupiter,Saturn> child;
		// declare old value
		Saturn oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hypergluon pair = new Hypergluon(Gluon.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}