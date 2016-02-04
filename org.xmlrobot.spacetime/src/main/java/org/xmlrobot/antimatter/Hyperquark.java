package org.xmlrobot.antimatter;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Lepton;
import org.xmlrobot.matter.Quark;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hyperquark 
	extends Antiproton<Fornax,Columbia> {

	/**
	 * -6954372698317451289L
	 */
	private static final long serialVersionUID = -6954372698317451289L;
	
	/**
	 * 
	 */
	public Hyperquark() {
		super(Hyperquark.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperquark(Class<Quark> antitype) {
		super(Hyperquark.class, antitype);
	}
	

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Lepton) {
				// declare stem
				Mass<Columbia,Fornax> stem;
				// cast source
				Lepton pair = (Lepton) event.getSource();
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
	public Columbia putValue(Fornax key, Columbia value) {
		// declare child
		Mass<Fornax,Columbia> child;
		// declare old value
		Columbia oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hyperlepton pair = new Hyperlepton(Lepton.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
