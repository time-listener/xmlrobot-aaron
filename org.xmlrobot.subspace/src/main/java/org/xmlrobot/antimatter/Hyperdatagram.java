/**
 * 
 */
package org.xmlrobot.antimatter;

import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hyperletter;
import org.xmlrobot.matter.Hyperword;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public final class Hyperdatagram
	extends Antiproton<String,Integer> {

	/**
	 * 8123876664920585604L
	 */
	private static final long serialVersionUID = 8123876664920585604L;

	/**
	 * @param type
	 */
	public Hyperdatagram() {
		super(Hyperdatagram.class);
	}
	/**
	 * @param type
	 * @param antitype
	 */
	public Hyperdatagram(Class<Hyperword> antitype) {
		super(Hyperdatagram.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperletter) {
				// declare stem
				Mass<Integer,String> stem;
				// cast source
				Hyperletter pair = (Hyperletter) event.getSource();
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
	public Integer putValue(String key, Integer value) {
		// declare child
		Mass<String,Integer> child;
		// declare old value
		Integer oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hyperline pair = new Hyperline(Hyperletter.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}