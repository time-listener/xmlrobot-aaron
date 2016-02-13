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
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.antimatter.Hypermuon;
import org.xmlrobot.spacetime.event.Expansion;
import org.xmlrobot.spacetime.event.Rotation;
import org.xmlrobot.spacetime.matter.Muon;
import org.xmlrobot.util.Command;

/**
 * Fornax implementation class.
 * @author joan
 * @parity XY
 * @since 41159.1
 */
@XmlRootElement
public class Fornax 
	extends Child<MilkyWay,Andromeda> {

	/**
	 * -8282005929352690501L
	 */
	private static final long serialVersionUID = -8282005929352690501L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getKey()
	 */
	@Override
	@XmlElement
	public MilkyWay getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setKey(MilkyWay key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getValue()
	 */
	@Override
	@XmlElement
	public Andromeda getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setValue(Andromeda value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypermuon.class)
	public Mass<MilkyWay,Andromeda> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Fornax} default class constructor.
	 */
	public Fornax() {
		
		super(Hypermuon.class, Muon.class, Fornax.class);
	}
	/**
	 * {@link Fornax} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Fornax(Class<Columbia> antitype) {
		
		super(Hypermuon.class, Muon.class, Fornax.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Perseus) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
			if(event.getSource() instanceof Perseus) {
				// get antimatter
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
		case RELEASE:
			if(event.getSource() instanceof Perseus) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
			if(event.getSource() instanceof Perseus) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
			if(event.getSource() instanceof Perseus) {
				// cast source
				Perseus pair = (Perseus) event.getSource();
				// transfer message contents
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
	public Andromeda put(MilkyWay key, Andromeda value) {
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
				child instanceof Capricornus : false) {
			// cast source
			Capricornus pair = (Capricornus) child;
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