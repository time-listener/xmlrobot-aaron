/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypergas;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Homogenization;
import org.xmlrobot.event.Impact;
import org.xmlrobot.Biosphere;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.Organism;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Gas;
import org.xmlrobot.util.Command;

/**
 * Master of the Sky.
 * 
 * @author joan
 *
 */
@XmlRootElement
public class Jupiter 
	extends Screw<Ecosystem,Biosphere> {

	/**
	 * 6147224097482696400L
	 */
	private static final long serialVersionUID = 6147224097482696400L;

	/**
	 * {@link Jupiter} default class constructor.
	 */
	public Jupiter() {
		
		super(Hypergas.class, Gas.class, Jupiter.class);
	}
	/**
	 * {@link Jupiter} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Jupiter(Class<Saturn> antitype) {
		
		super(Hypergas.class, Gas.class, Jupiter.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Earth) {
				// give her the universe
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Ecosystem) {
				// cast source
				Ecosystem key = (Ecosystem) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Homogenization(key));
			}
			else if(event.getSource() instanceof Earth) {
				// cast source
				Earth earth = (Earth) event.getSource();
				// declare child
				Mass<Ecosystem,Biosphere> child;
				// call child
				if((child = getChild()) != null) {
					// send him a little asteroid
					child.pulse(this, new Impact(earth));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Earth) {
				// give her the universe
				event.stop(context());
			}
			else if(event.getSource() instanceof Organism) {
				// cast source
				Organism pair = (Organism) event.getSource();
				// set pair free
				pair.remove();
			} 
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#put(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Biosphere putValue(Ecosystem key, Biosphere value) {
		// declare child
		Mass<Ecosystem,Biosphere> child;
		// declare old value
		Biosphere oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Mars pair = new Mars(Earth.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#run()
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
		
	}
}
