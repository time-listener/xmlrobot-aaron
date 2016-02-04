package org.xmlrobot.antimatter;

import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hyperbrain 
	extends Antiproton<Universe,Subspace> {

	/**
	 * 8426959343924822410L
	 */
	private static final long serialVersionUID = 8426959343924822410L;

	/**
	 * 
	 */
	public Hyperbrain() {
		super(Hyperbrain.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperbrain(Class<Hypermind> antitype) {
		
		super(Hyperbrain.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {

		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperxml) {
				
				Hyperxml pair = (Hyperxml) event.getSource();
				
				Mass<Subspace,Universe> stem;
				
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
	 * @see org.xmlrobot.positron.Antiproton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putValue(Universe key, Subspace value) {
		// declare child
		Mass<Universe,Subspace> child;
		// declare old value
		Subspace oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hyperneuron pair = new Hyperneuron(Hyperxml.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}