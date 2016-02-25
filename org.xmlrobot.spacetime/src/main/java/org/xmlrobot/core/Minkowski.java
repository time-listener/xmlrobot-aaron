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
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.spacetime.Capricornus;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.spacetime.event.Expansion;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

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
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Columbia getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Columbia setKey(Columbia key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Fornax getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Fornax setValue(Fornax value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
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
		super(Quark.class, Hyperquark.class, Minkowski.class, Parity.XX);
	}
	/**
	 * {@link Minkowski} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Minkowski(Class<Spacetime> antitype) {
		super(Minkowski.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Columbia) {
				// cast child
				Columbia entity = (Columbia) event.getSource();
				// push supercluster into hyperspace
				put(entity, (Fornax) entity.get());
			}
			break;
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
		case SEND:
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
		case PUSH:
			if(event.getSource() instanceof Columbia) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Columbia key = (Columbia) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Expansion(key));	
				}
			}
			else if(event.getSource() instanceof Cluster) {
				// call child
				if(!isEmpty()) {
					// cast source
					Cluster pair = (Cluster) event.getSource();
					// emit mass to the future
					getChild().pulse(this, new Dilatation(pair));
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
			if(event.getSource() instanceof Capricornus) {
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
				// make pair free
				pair.remove();
			}
			else if(event.getSource() instanceof Cluster) {
				// the funeral of cluster
				event.stop(getContext());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#put(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Fornax put(Columbia key, Fornax value) {
		// create child
		Galaxy pair = new Galaxy(Cluster.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#serviceChanged(org.osgi.framework.ServiceEvent)
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
				// release child
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}