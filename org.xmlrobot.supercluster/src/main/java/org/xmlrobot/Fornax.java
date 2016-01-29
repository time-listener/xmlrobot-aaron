/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperhiggs;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Expansion;
import org.xmlrobot.event.Rotation;
import org.xmlrobot.Andromeda;
import org.xmlrobot.Hydra;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Higgs;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Fornax 
	extends Screw<MilkyWay,Andromeda> {

	/**
	 * -8282005929352690501L
	 */
	private static final long serialVersionUID = -8282005929352690501L;

	/**
	 * {@link Fornax} default class constructor.
	 */
	public Fornax() {
		
		super(Hyperhiggs.class, Higgs.class, Fornax.class);
	}
	/**
	 * {@link Fornax} class constructor.
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	public Fornax(Class<Columbia> antitype) {
		
		super(Hyperhiggs.class, Higgs.class, Fornax.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Perseus) {
				// tick
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof MilkyWay) {
				// cast source
				MilkyWay key = (MilkyWay) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Rotation(key));
			}
			else if(event.getSource() instanceof Perseus) {
				// cast source
				Perseus pair = (Perseus) event.getSource();
				// declare child
				Mass<MilkyWay, Andromeda> child;
				// call
				if((child = getChild()) != null) {
					// send pulse to the future
					child.pulse(this, new Expansion(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Perseus) {
				// tack
				event.stop(context());
			}
			else if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// free from inheritance
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
	public Andromeda putValue(MilkyWay key, Andromeda value) {
		// declare child
		Mass<MilkyWay,Andromeda> child;
		// declare old value
		Andromeda oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Capricornus pair = new Capricornus(Perseus.class, key, value, this);
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