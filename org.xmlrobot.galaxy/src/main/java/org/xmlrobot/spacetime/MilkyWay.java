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
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.antimatter.HyperbosonZ;
import org.xmlrobot.spacetime.event.Repulsion;
import org.xmlrobot.spacetime.event.Revolution;
import org.xmlrobot.spacetime.matter.BosonZ;
import org.xmlrobot.util.Command;

/**
 * Milky Way implementation class.
 * @author joan
 * @parity XY
 * @since 41157.1
 */
@XmlRootElement
public class MilkyWay 
	extends Child<Sun,AlphaCentauri> {

	/**
	 * 5721672750470171670L
	 */
	private static final long serialVersionUID = 5721672750470171670L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getKey()
	 */
	@Override
	@XmlElement
	public Sun getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setKey(Sun key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getValue()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setValue(AlphaCentauri value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=HyperbosonZ.class)
	public Mass<Sun,AlphaCentauri> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link MilkyWay} default class constructor.
	 */
	public MilkyWay() {
		super(HyperbosonZ.class, BosonZ.class, MilkyWay.class);
	}
	/**
	 * {@link MilkyWay} class constructor.
	 * @param antitype the inherited antitype
	 */
	public MilkyWay(Class<Andromeda> antitype) {
		super(HyperbosonZ.class, BosonZ.class, MilkyWay.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				Hydra pair = (Hydra) event.getSource();
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
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> key;
				// cast source
				Hydra pair = (Hydra) event.getSource();
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
		case LISTEN:
			if(event.getSource() instanceof Sun) {
				// cast source
				Sun key = (Sun) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Repulsion(key));
			}
			else if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// declare child
				Mass<Sun, AlphaCentauri> child;
				// call child
				if((child = getChild()) != null) {
					// antigravity
					child.pulse(this, new Revolution(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				Hydra pair = (Hydra) event.getSource();
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
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				Hydra pair = (Hydra) event.getSource();
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
			if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra entity = (Hydra) event.getSource();
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
	public AlphaCentauri put(Sun key, AlphaCentauri value) {
		// declare child
		Mass<Sun,AlphaCentauri> child;
		// declare old value
		AlphaCentauri oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ?
				child.putValue(key,	value) : null) == null) {
			// create child
			Virgo pair = new Virgo(Hydra.class, key, value, this);
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
				child instanceof Virgo : false) {
			// cast source
			Virgo pair = (Virgo) child;
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