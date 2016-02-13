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
import org.xmlrobot.spacetime.event.Impact;
import org.xmlrobot.spacetime.event.Repulsion;
import org.xmlrobot.spacetime.matter.Photon;
import org.xmlrobot.util.Command;

/**
 * Alpha Centauri implementation class.
 * @author joan
 * @parity XX
 * @since 41155.2
 */
@XmlRootElement
public class AlphaCentauri 
	extends Child<Saturn,Jupiter> {

	/**
	 * -6537944481620207658L
	 */
	private static final long serialVersionUID = -6537944481620207658L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getKey()
	 */
	@Override
	@XmlElement
	public Saturn getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setKey(Saturn key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getValue()
	 */
	@Override
	@XmlElement
	public Jupiter getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setValue(Jupiter value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Photon.class)
	public Mass<Saturn,Jupiter> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link AlphaCentauri} default class constructor.
	 */
	public AlphaCentauri() {
		super(Photon.class, Hyperphoton.class, AlphaCentauri.class);
	}
	/**
	 * {@link AlphaCentauri} class constructor.
	 * @param antitype the inherited antitype
	 */
	public AlphaCentauri(Class<Sun> antitype) {
		super(Photon.class, Hyperphoton.class, AlphaCentauri.class, antitype);
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
			if(event.getSource() instanceof Pegasi) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Pegasi) {
				// get antimatter
				Mass<Jupiter,Saturn> key;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Saturn) {
				// cast source
				Saturn key = (Saturn) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Impact(key));
			}
			else if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
				// declare child
				Mass<Saturn,Jupiter> child;
				// call child
				if((child = getChild()) != null) {
					// antigravity
					child.pulse(this, new Repulsion(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Pegasi) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Pegasi) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi entity = (Pegasi) event.getSource();
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
	public Jupiter put(Saturn key, Jupiter value) {
		// declare child
		Mass<Saturn,Jupiter> child;
		// declare old value
		Jupiter oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Vega pair = new Vega(Pegasi.class, key, value, this);
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
				child instanceof Vega : false) {
			// cast source
			Vega pair = (Vega) child;
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