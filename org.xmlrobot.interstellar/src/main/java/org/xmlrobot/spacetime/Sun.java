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
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hyperphoton;
import org.xmlrobot.spacetime.event.Attraction;
import org.xmlrobot.spacetime.event.Collision;
import org.xmlrobot.spacetime.matter.Photon;
import org.xmlrobot.util.Command;

/**
 * Sun implementation class.
 * @author joan
 * @parity XY
 * @since 41155.1
 */
@XmlRootElement
public class Sun 
	extends Child<Jupiter,Saturn> {

	/**
	 * 2938099720879190128L
	 */
	private static final long serialVersionUID = 2938099720879190128L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getKey()
	 */
	@Override
	@XmlElement
	public Jupiter getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setKey(Jupiter key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#getValue()
	 */
	@Override
	@XmlElement
	public Saturn getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setValue(Saturn value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperphoton.class)
	public Mass<Jupiter,Saturn> getReplicator() {
		return super.getReplicator();
	}
	
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
		// commute command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Vega) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Vega pair = (Vega) event.getSource();
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
		case LISTEN:
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
		case RELEASE:
			if(event.getSource() instanceof Vega) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Vega pair = (Vega) event.getSource();
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
			if(event.getSource() instanceof Vega) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Vega pair = (Vega) event.getSource();
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
	public Saturn put(Jupiter key, Saturn value) {
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
				child instanceof Pegasi : false) {
			// cast source
			Pegasi pair = (Pegasi) child;
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
