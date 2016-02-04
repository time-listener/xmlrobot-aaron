package org.xmlrobot.matter;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.antimatter.HyperbosonW;
import org.xmlrobot.antimatter.HyperbosonZ;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class BosonZ 
	extends Proton<AlphaCentauri,Sun> {

	/**
	 * -368306173123213628L
	 */
	private static final long serialVersionUID = -368306173123213628L;

	/**
	 * 
	 */
	public BosonZ() {
		super(BosonZ.class);
	}
	/**
	 * @param antitype
	 */
	public BosonZ(Class<HyperbosonZ> antitype) {
		super(BosonZ.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof HyperbosonW) {
				// declare stem
				Mass<Sun,AlphaCentauri> stem;
				// cast source
				HyperbosonW pair = (HyperbosonW) event.getSource();
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
	public Sun putValue(AlphaCentauri key, Sun value) {
		// declare child
		Mass<AlphaCentauri,Sun> child;
		// declare old value
		Sun oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			BosonW pair = new BosonW(HyperbosonW.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}