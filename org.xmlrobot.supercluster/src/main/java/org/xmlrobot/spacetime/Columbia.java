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
import org.xmlrobot.spacetime.event.Compression;
import org.xmlrobot.spacetime.event.Revolution;
import org.xmlrobot.spacetime.matter.Muon;
import org.xmlrobot.util.Command;

/**
 * Columbia implementation class.
 * @author joan
 * @parity XX
 * @since 41159.2
 */
@XmlRootElement
public class Columbia
	extends Child<Andromeda,MilkyWay> {

	/**
	 * 7104570102230102161L
	 */
	private static final long serialVersionUID = 7104570102230102161L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getKey()
	 */
	@Override
	@XmlElement
	public Andromeda getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setKey(Andromeda key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getValue()
	 */
	@Override
	@XmlElement
	public MilkyWay getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setValue(MilkyWay value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Muon.class)
	public Mass<Andromeda,MilkyWay> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Columbia} default class constructor.
	 */
	public Columbia() {
		
		super(Muon.class, Hypermuon.class, Columbia.class);
	}
	/**
	 * {@link Columbia} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Columbia(Class<Fornax> antitype) {
		
		super(Muon.class, Hypermuon.class, Columbia.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Capricornus) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
			if(event.getSource() instanceof Capricornus) {
				// get antimatter
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
			if(event.getSource() instanceof Andromeda) {
				// cast source
				Andromeda key = (Andromeda) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Revolution(key));
			}
			else if(event.getSource() instanceof Capricornus) {
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
				// declare child
				Mass<Andromeda,MilkyWay> child;
				// call
				if((child = getChild()) != null) {
					// send pulse to the future
					child.pulse(this, new Compression(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Capricornus) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
			if(event.getSource() instanceof Capricornus) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
			if(event.getSource() instanceof Capricornus) {
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
				// transfer message contents
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
	public MilkyWay put(Andromeda key, MilkyWay value) {
		// declare child
		Mass<Andromeda, MilkyWay> child;
		// declare old value
		MilkyWay oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? child.putValue(key,
				value) : null) == null) {
			// create child
			Perseus pair = new Perseus(Capricornus.class, key, value, this);
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
				child instanceof Perseus : false) {
			// cast source
			Perseus pair = (Perseus) child;
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
