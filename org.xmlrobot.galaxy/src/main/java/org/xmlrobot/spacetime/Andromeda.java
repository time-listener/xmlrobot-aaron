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
import org.xmlrobot.spacetime.event.Attraction;
import org.xmlrobot.spacetime.event.Rotation;
import org.xmlrobot.spacetime.matter.BosonZ;
import org.xmlrobot.util.Command;

/**
 * Andromeda implementation class.
 * @author joan
 * @parity XX
 * @since 41157.2
 */
@XmlRootElement
public class Andromeda 
	extends Child<AlphaCentauri,Sun> {

	/**
	 * -2441587664117221210L
	 */
	private static final long serialVersionUID = -2441587664117221210L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getKey()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setKey(AlphaCentauri key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getValue()
	 */
	@Override
	@XmlElement
	public Sun getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setValue(Sun value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=BosonZ.class)
	public Mass<AlphaCentauri,Sun> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Andromeda} default class constructor.
	 */
	public Andromeda() {
		super(BosonZ.class, HyperbosonZ.class, Andromeda.class);
	}
	/**
	 * {@link Andromeda} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Andromeda(Class<MilkyWay> antitype) {
		super(BosonZ.class, HyperbosonZ.class, Andromeda.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Virgo) {
				// declare stem
				Mass<Sun,AlphaCentauri> future;
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
			if(event.getSource() instanceof Virgo) {
				// get antimatter
				Mass<Sun,AlphaCentauri> future;
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
			if(event.getSource() instanceof AlphaCentauri) {
				// cast source
				AlphaCentauri key = (AlphaCentauri) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Attraction(key));
			}
			else if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo pair = (Virgo) event.getSource();
				// declare child
				Mass<AlphaCentauri,Sun> child;
				// call child
				if((child = getChild()) != null) {
					// gravity
					child.pulse(this, new Rotation(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Virgo) {
				// declare stem
				Mass<Sun,AlphaCentauri> future;
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
			if(event.getSource() instanceof Virgo) {
				// declare stem
				Mass<Sun,AlphaCentauri> future;
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
			if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo entity = (Virgo) event.getSource();
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
	public Sun put(AlphaCentauri key, Sun value) {
		// declare child
		Mass<AlphaCentauri,Sun> child;
		// declare old value
		Sun oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hydra pair = new Hydra(Virgo.class, key, value, this);
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
				child instanceof Hydra : false) {
			// cast source
			Hydra pair = (Hydra) child;
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
