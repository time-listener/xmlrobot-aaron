package org.xmlrobot.matter;

import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.antimatter.Hyperatom;
import org.xmlrobot.antimatter.Hyperelement;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Element
	extends Proton<Cell,Operon> {

	/**
	 * -4054003935605395183L
	 */
	private static final long serialVersionUID = -4054003935605395183L;

	/**
	 * 
	 */
	public Element() {

		super(Element.class);
	}
	/**
	 * @param antitype
	 */
	public Element(Class<Hyperelement> antitype) {

		super(Element.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperatom) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Hyperatom pair = (Hyperatom) event.getSource();
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
	public Operon putValue(Cell key, Operon value) {
		// declare child
		Mass<Cell,Operon> child;
		// declare old value
		Operon oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Atom pair = new Atom(Hyperatom.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}