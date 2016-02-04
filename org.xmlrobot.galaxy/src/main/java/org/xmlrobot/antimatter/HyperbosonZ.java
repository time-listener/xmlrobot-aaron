package org.xmlrobot.antimatter;

import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.BosonW;
import org.xmlrobot.matter.BosonZ;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class HyperbosonZ 
	extends Antiproton<Sun,AlphaCentauri> {

	/**
	 * -1388131279477719068L
	 */
	private static final long serialVersionUID = -1388131279477719068L;

	/**
	 * 
	 */
	public HyperbosonZ() {
		super(HyperbosonZ.class);
	}
	/**
	 * @param antitype
	 */
	public HyperbosonZ(Class<BosonZ> antitype) {
		super(HyperbosonZ.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof BosonW) {
				// declare stem
				Mass<AlphaCentauri,Sun> stem;
				// cast source
				BosonW pair = (BosonW) event.getSource();
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
	public AlphaCentauri putValue(Sun key, AlphaCentauri value) {
		// declare child
		Mass<Sun,AlphaCentauri> child;
		// declare old value
		AlphaCentauri oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			HyperbosonW pair = new HyperbosonW(BosonW.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
