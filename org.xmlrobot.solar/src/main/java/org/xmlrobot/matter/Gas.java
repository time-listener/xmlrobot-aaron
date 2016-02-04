package org.xmlrobot.matter;

import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.antimatter.Hypergas;
import org.xmlrobot.antimatter.Hypermetal;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Gas 
	extends Proton<Biosphere,Ecosystem> {

	/**
	 * -3602380595804343582L
	 */
	private static final long serialVersionUID = -3602380595804343582L;
	
	/**
	 * 
	 */
	public Gas() {
		super(Gas.class);
	}
	/**
	 * @param antitype
	 */
	public Gas(Class<Hypergas> antitype) { 
		super(Gas.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hypermetal) {
				// declare stem
				Mass<Ecosystem,Biosphere> stem;
				// cast source
				Hypermetal pair = (Hypermetal) event.getSource();
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
	public Ecosystem putValue(Biosphere key, Ecosystem value) {
		// declare child
		Mass<Biosphere,Ecosystem> child;
		// declare old value
		Ecosystem oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Metal pair = new Metal(Hypermetal.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
