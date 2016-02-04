/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperquark;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Dilatation;
import org.xmlrobot.event.Expansion;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Quark;
import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.util.Command;

/**
 * @author joan
 * @parity XX
 */
@XmlRootElement
public class Minkowski 
	extends ScrewNut<Columbia,Fornax> {

	/**
	 * 4738550804821121680L
	 */
	private static final long serialVersionUID = 4738550804821121680L;

	/**
	 * {@link Minkowski} default class constructor.
	 */
	public Minkowski() {
		
		super(Quark.class, Hyperquark.class, Minkowski.class);
	}
	/**
	 * {@link Minkowski} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Minkowski(Class<Spacetime> antitype) {
		
		super(Quark.class, Hyperquark.class, Minkowski.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Cluster) {
				// get antimatter
				Mass<Fornax,Columbia> future;
				// cast source
				Cluster pair = (Cluster) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					future.add(pair);
				}
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Columbia) {
				// cast source
				Columbia key = (Columbia) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Expansion(key));
			}
			else if(event.getSource() instanceof Cluster) {
				// cast source
				Cluster pair = (Cluster) event.getSource();
				// declare child
				Mass<Columbia,Fornax> child;
				// call child
				if((child = getChild()) != null) {
					// emit mass to the future
					child.pulse(this, new Dilatation(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Cluster) {
				// cast source
				Cluster entity = (Cluster) event.getSource();
				// transfer message contents
				get().putValue(entity.getKey(), entity.getValue());
			}
			break;
		default:
			break;
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Fornax putValue(Columbia key, Fornax value) {
		// declare child
		Mass<Columbia, Fornax> child;
		// declare old value
		Fornax oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Galaxy pair = new Galaxy(Cluster.class, key, value, this);
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
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Galaxy) {
			// cast source
			Galaxy pair = (Galaxy) source;
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