package org.xmlrobot.antimatter;

import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Eva;
import org.xmlrobot.matter.Ovum;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

public class Adam 
	extends Proton<Ribosoma,Tetraploid> {

	/**
	 * -7001412700159246172L
	 */
	private static final long serialVersionUID = -7001412700159246172L;

	/**
	 * 
	 */
	public Adam() {
		super(Adam.class);
	}
	/**
	 * @param antitype
	 */
	public Adam(Class<Eva> antitype) {
		super(Adam.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Ovum) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Ovum pair = (Ovum) event.getSource();
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
	public Tetraploid putValue(Ribosoma key, Tetraploid value) {
		// declare child
		Mass<Ribosoma,Tetraploid> child;
		// declare old value
		Tetraploid oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Sperma pair = new Sperma(Ovum.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
