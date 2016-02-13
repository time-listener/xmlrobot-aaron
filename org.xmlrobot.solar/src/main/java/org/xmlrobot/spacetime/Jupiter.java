/**
 * 
 */
package org.xmlrobot.spacetime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.nature.event.Homogenization;
import org.xmlrobot.spacetime.antimatter.Hypergas;
import org.xmlrobot.spacetime.event.Impact;
import org.xmlrobot.spacetime.matter.Gas;
import org.xmlrobot.util.Command;

/**
 * Master of the Sky.
 * @author joan
 * @parity XY
 * @since 41153.1
 */
@XmlRootElement
public class Jupiter 
	extends Child<Ecosystem,Biosphere> {

	/**
	 * 6147224097482696400L
	 */
	private static final long serialVersionUID = 6147224097482696400L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getKey()
	 */
	@Override
	@XmlElement
	public Ecosystem getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ecosystem setKey(Ecosystem key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getValue()
	 */
	@Override
	@XmlElement
	public Biosphere getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Biosphere setValue(Biosphere value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypergas.class)
	public Mass<Ecosystem,Biosphere> getReplicator() {
		return super.getReplicator();
	}
	
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

		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Earth) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// release child
					future.order(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Earth) {
				// get matter
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
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
		case LISTEN:
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
		case RELEASE:
			if(event.getSource() instanceof Earth) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								future.contains(pair) 
								: false
						: false) {
					// release child
					future.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Earth) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// push child
					future.submit(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Earth) {
				// cast source
				Earth entity = (Earth) event.getSource();
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
	public Biosphere put(Ecosystem key, Biosphere value) {
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
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Mars : false) {
			// cast source
			Mars pair = (Mars) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}