package org.xmlrobot.antimatter;

import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Atom;
import org.xmlrobot.matter.Element;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hyperelement 
	extends Antiproton<Operon,Cell> {

	/**
	 * -7852359284485014885L
	 */
	private static final long serialVersionUID = -7852359284485014885L;

	/**
	 * 
	 */
	public Hyperelement() {
		super(Hyperelement.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperelement(Class<Element> antitype) {
		super(Hyperelement.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Atom) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Atom pair = (Atom) event.getSource();
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
	public Cell putValue(Operon key, Cell value) {
		// declare child
		Mass<Operon,Cell> child;
		// declare old value
		Cell oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hyperatom pair = new Hyperatom(Atom.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}