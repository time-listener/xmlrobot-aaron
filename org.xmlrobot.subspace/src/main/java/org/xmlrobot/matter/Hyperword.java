package org.xmlrobot.matter;

import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.antimatter.Hyperdatagram;
import org.xmlrobot.antimatter.Hyperline;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

@XmlRootElement
public class Hyperword 
	extends Proton<Integer,String>{

	/**
	 * -865307579647969933L
	 */
	private static final long serialVersionUID = -865307579647969933L;

	/**
	 * 
	 */
	public Hyperword() {
		
		super(Hyperword.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperword(Class<Hyperdatagram> antitype) {
		
		super(Hyperword.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperline) {
				// declare key
				Mass<String,Integer> key;
				// cast source
				Hyperline pair = (Hyperline) event.getSource();
				// check if empty and chained
				if((key = get()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true
						: false) {
					// push child
					key.add(pair);
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
	public String putValue(Integer key, String value) {
		// declare child
		Mass<Integer,String> child;
		// declare old value
		String oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hyperletter pair = new Hyperletter(Hyperline.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}