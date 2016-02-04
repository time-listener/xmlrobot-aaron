/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.antimatter.Hyperphoton;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Collision;
import org.xmlrobot.event.Attraction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Photon;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Sun 
	extends Screw<Jupiter,Saturn> {

	/**
	 * 2938099720879190128L
	 */
	private static final long serialVersionUID = 2938099720879190128L;

	/**
	 * {@link Sun} default class constructor.
	 */
	public Sun() {
		
		super(Hyperphoton.class, Photon.class, Sun.class);
	}
	/**
	 * {@link Sun} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Sun(Class<AlphaCentauri> antitype) {
		
		super(Hyperphoton.class, Photon.class, Sun.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Vega) {
				// get antimatter
				Mass<Saturn,Jupiter> key;
				// cast source
				Vega pair = (Vega) event.getSource();
				// check if empty and chained
				if((key = get()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Jupiter) {
				// cast source
				Jupiter key = (Jupiter) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Collision(key));
			}
			else if(event.getSource() instanceof Vega) {
				// cast source
				Vega pair = (Vega) event.getSource();
				// declare child
				Mass<Jupiter,Saturn> child;
				// call child
				if((child = getChild()) != null) {
					// gravity
					child.pulse(this, new Attraction(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Vega) {
				// cast source
				Vega entity = (Vega) event.getSource();
				// transfer message contents
				get().putValue(entity.getKey(), entity.getValue());
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
	public Saturn putValue(Jupiter key, Saturn value) {
		// declare child
		Mass<Jupiter,Saturn> child;
		// declare old value
		Saturn oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Pegasi pair = new Pegasi(Vega.class, key, value, this);
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
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Pegasi) {
			// cast source
			Pegasi pair = (Pegasi) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}
