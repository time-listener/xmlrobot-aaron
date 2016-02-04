package org.xmlrobot.antimatter;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Gas;
import org.xmlrobot.matter.Metal;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hypergas 
	extends Antiproton<Ecosystem,Biosphere> {

	/**
	 * 4184946175192977516L
	 */
	private static final long serialVersionUID = 4184946175192977516L;

	/**
	 * 
	 */
	public Hypergas() {
		
		super(Hypergas.class);
	}
	/**
	 * @param antitype
	 */
	public Hypergas(Class<Gas> antitype) {
		
		super(Hypergas.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Metal) {
				// declare stem
				Mass<Biosphere,Ecosystem> stem;
				// cast source
				Metal pair = (Metal) event.getSource();
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
	public Biosphere putValue(Ecosystem key, Biosphere value) {
		// declare child
		Mass<Ecosystem,Biosphere> child;
		// declare old value
		Biosphere oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? child.putValue(key,
				value) : null) == null) {
			// create child
			Hypermetal pair = new Hypermetal(Metal.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}

}
