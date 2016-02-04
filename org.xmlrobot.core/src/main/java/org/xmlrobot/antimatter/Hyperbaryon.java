/**
 * 
 */
package org.xmlrobot.antimatter;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Baryon;
import org.xmlrobot.matter.Meson;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hyperbaryon 
	extends Antiproton<Spacetime,Minkowski> {

	/**
	 * -456927415256227942L
	 */
	private static final long serialVersionUID = -456927415256227942L;

	/**
	 * 
	 */
	public Hyperbaryon() {
		super(Hyperbaryon.class);
	}
	/**
	 * 
	 */
	public Hyperbaryon(Class<Baryon> antitype) {
		super(Hyperbaryon.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Meson) {
				// declare stem
				Mass<Minkowski,Spacetime> stem;
				// cast source
				Meson pair = (Meson) event.getSource();
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
	public Minkowski putValue(Spacetime key, Minkowski value) {
		// declare child
		Mass<Spacetime,Minkowski> child;
		// declare old value
		Minkowski oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hypermeson pair = new Hypermeson(Meson.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}