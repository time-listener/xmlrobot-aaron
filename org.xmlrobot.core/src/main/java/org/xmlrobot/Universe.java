/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hyperbaryon;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Dilatation;
import org.xmlrobot.event.Gravity;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Baryon;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Universe extends Screw<Spacetime,Minkowski> {

	/**
	 * 7786709043686394145L
	 */
	private static final long serialVersionUID = 7786709043686394145L;

	/**
	 * 
	 */
	public Universe() {
		super(Hyperbaryon.class, Baryon.class, Universe.class);
	}
	/**
	 * 
	 */
	public Universe(Class<Subspace> antitype) {

		super(Hyperbaryon.class, Baryon.class, Universe.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		// ancestral recall
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof BigBong) {
				BigBong pair = (BigBong) event.getSource();
				Mass<Minkowski,Spacetime> value;
				// check if empty and chained
				if((value = get()) != null ? 
						!value.isEmpty() ? 
								!value.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					value.add(pair);
				}
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Spacetime) {
				// cast source
				Spacetime key = (Spacetime) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Dilatation(key));
			}
			else if (event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
				// declare child
				Mass<Spacetime, Minkowski> child;
				// call child
				if((child = getChild()) != null) {
					// push gravity
					child.pulse(this, new Gravity(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
				// transfer message
				get().putValue(pair.getKey(), pair.getValue());
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
	public Minkowski putValue(Spacetime key, Minkowski value) {
		// declare child
		Mass<Spacetime,Minkowski> child;
		// declare old value
		Minkowski oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			BigBang pair = new BigBang(BigBong.class, key, value, this);
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
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof BigBang) {
			// cast source
			BigBang pair = (BigBang) source;
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