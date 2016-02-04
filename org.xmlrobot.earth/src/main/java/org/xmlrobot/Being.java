/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperatom;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Atom;
import org.xmlrobot.Cell;
import org.xmlrobot.Cytoplasm;
import org.xmlrobot.Operon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Being 
	extends ScrewDriver<Operon,Cell> {

	/**
	 * -2219408315913205280L
	 */
	private static final long serialVersionUID = -2219408315913205280L;
	
	/**
	 * {@link Being} default class constructor.
	 */
	public Being() {
		super(Hyperatom.class, Atom.class, Being.class, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Screw<Operon,Cell>} the parent
	 */
	public Being(Operon key, Cell value, Screw<Operon,Cell> parent) {
		super(Hyperatom.class, Atom.class, Being.class, key, value, parent);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Being(Class<Organism> antitype) {
		super(Hyperatom.class, Atom.class, Being.class, antitype, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Screw<Operon,Cell>} the parent
	 */
	public Being(Class<Organism> antitype, Operon key, Cell value, Screw<Operon,Cell> parent) {
		super(Hyperatom.class, Atom.class, Being.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Cytoplasm) {
				// cast
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// free
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#run()
	 */
	@Override
	public void run() {
		super.run();
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Being) {
			// cast source
			Being pair = (Being) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hyperatom(Atom.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}