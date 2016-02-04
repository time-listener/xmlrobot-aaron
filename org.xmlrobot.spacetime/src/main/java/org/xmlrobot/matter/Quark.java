package org.xmlrobot.matter;

import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.antimatter.Hyperlepton;
import org.xmlrobot.antimatter.Hyperquark;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

public class Quark 
	extends Proton<Columbia,Fornax> {

	/**
	 * -2083467336455485338L
	 */
	private static final long serialVersionUID = -2083467336455485338L;
	
	/**
	 * 
	 */
	public Quark() {
		super(Quark.class);
	}
	/**
	 * @param antitype
	 */
	public Quark(Class<Hyperquark> antitype) {
		super(Quark.class, antitype);
	}


	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperlepton) {
				// declare stem
				Mass<Fornax,Columbia> stem;
				// cast source
				Hyperlepton pair = (Hyperlepton) event.getSource();
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
	public Fornax putValue(Columbia key, Fornax value) {
		// declare child
		Mass<Columbia,Fornax> child;
		// declare old value
		Fornax oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Lepton pair = new Lepton(Hyperlepton.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
