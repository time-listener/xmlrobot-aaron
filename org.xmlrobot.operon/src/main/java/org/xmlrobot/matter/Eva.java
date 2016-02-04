package org.xmlrobot.matter;

import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.antimatter.Adam;
import org.xmlrobot.antimatter.Sperma;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Eva 
	extends Antiproton<Tetraploid,Ribosoma> {

	/**
	 * -6997122399197352077L
	 */
	private static final long serialVersionUID = -6997122399197352077L;
	
	/**
	 * 
	 */
	public Eva() {
		super(Eva.class);
	}
	/**
	 * @param antitype
	 */
	public Eva(Class<Adam> antitype) {
		super(Eva.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Sperma) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Sperma pair = (Sperma) event.getSource();
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
	public Ribosoma putValue(Tetraploid key, Ribosoma value) {
		// declare child
		Mass<Tetraploid,Ribosoma> child;
		// declare old value
		Ribosoma oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Ovum pair = new Ovum(Sperma.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
