/**
 * 
 */
package org.xmlrobot.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.core.antimatter.Hyperquark;
import org.xmlrobot.core.event.Dilatation;
import org.xmlrobot.core.matter.Quark;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.spacetime.event.Expansion;
import org.xmlrobot.util.Command;

/**
 * Minkowski implementation class.
 * @author joan
 * @parity XX
 * @since 41161.2
 */
@XmlRootElement
public class Minkowski 
	extends Child<Columbia,Fornax> {

	/**
	 * 4738550804821121680L
	 */
	private static final long serialVersionUID = 4738550804821121680L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getKey()
	 */
	@Override
	@XmlElement
	public Columbia getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Columbia setKey(Columbia key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getValue()
	 */
	@Override
	@XmlElement
	public Fornax getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Fornax setValue(Fornax value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Quark.class)
	public Mass<Columbia,Fornax> getReplicator() {
		return super.getReplicator();
	}
	
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
		case ORDER:
			if(event.getSource() instanceof Cluster) {
				// declare stem
				Mass<Fornax,Columbia> future;
				// cast source
				Cluster pair = (Cluster) event.getSource();
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
		case LISTEN:
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
		case RELEASE:
			if(event.getSource() instanceof Cluster) {
				// declare stem
				Mass<Fornax,Columbia> future;
				// cast source
				Cluster pair = (Cluster) event.getSource();
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
			if(event.getSource() instanceof Cluster) {
				// declare stem
				Mass<Fornax,Columbia> future;
				// cast source
				Cluster pair = (Cluster) event.getSource();
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
	public Fornax put(Columbia key, Fornax value) {
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
				child instanceof Galaxy : false) {
			// cast source
			Galaxy pair = (Galaxy) child;
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