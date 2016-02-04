/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hyperbaryon;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Antigravity;
import org.xmlrobot.event.Contraction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Baryon;
import org.xmlrobot.util.Command;

/**
 * The BigBong Theory: everything ends here.
 * <p>Peace, love & BigBong
 * @author joan
 *
 */
public class Subspace 
	extends ScrewNut<Minkowski,Spacetime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2561064391674188730L;
	/**
	 * 
	 */
	public Subspace() {
		super(Baryon.class, Hyperbaryon.class, Subspace.class);
	}
	/**
	 * 
	 */
	public Subspace(Class<Universe> antitype) {
		super(Baryon.class, Hyperbaryon.class, Subspace.class, antitype);
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
			if (event.getSource() instanceof BigBang) {
				BigBang pair = (BigBang) event.getSource();
				Mass<Spacetime,Minkowski> key;
				// check if empty and chained
				if ((key = get()) != null ? 
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
			if(event.getSource() instanceof Minkowski) {
				// cast source
				Minkowski key = (Minkowski) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Contraction(key));
			}
			else if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// declare child
				Mass<Minkowski,Spacetime> child;
				// call child
				if((child = getChild()) != null) {
					// push gravity
					child.pulse(this, new Antigravity(pair));
				}
			}
			break;
		case TRANSFER:
			if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// transfer key-value indexing pair mapping entry message
				get().putValue(pair.getKey(), pair.getValue());
			}
			break;

		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#putValue(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Spacetime putValue(Minkowski key, Spacetime value) {
		// declare child
		Mass<Minkowski,Spacetime> child;
		// declare old value
		Spacetime oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			BigBong pair = new BigBong(BigBang.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#run()
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
		
		if(source instanceof BigBong) {
			// cast source
			BigBong pair = (BigBong) source;
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