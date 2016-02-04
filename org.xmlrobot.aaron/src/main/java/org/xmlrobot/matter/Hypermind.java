package org.xmlrobot.matter;

import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hypermind extends Proton<Subspace, Universe> {

	/**
	 * 2824932644399451406L
	 */
	private static final long serialVersionUID = 2824932644399451406L;
	
	/**
	 * @param type
	 * @param antitype
	 */
	public Hypermind(Class<? extends Mass<Universe,Subspace>> antitype) {
		
		super(Hypermind.class, antitype);
	}
	/**
	 * @param type
	 */
	public Hypermind() {
		
		super(Hypermind.class);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
	
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperneuron) {
				
				Hyperneuron pair = (Hyperneuron) event.getSource();
				
				Mass<Universe,Subspace> stem;
				
				if((stem = get()) != null ? 
						!stem.isEmpty() ?
								! stem.contains(pair)
								: false 
						: false) {
					// add pair
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
	public Universe putValue(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// declare old value
		Universe oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hyperxml pair = new Hyperxml(Hyperneuron.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}