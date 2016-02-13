/**
 * 
 */
package org.xmlrobot.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.antimatter.Hyperbaryon;
import org.xmlrobot.core.event.Antigravity;
import org.xmlrobot.core.event.Contraction;
import org.xmlrobot.core.matter.Baryon;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;

/**
 * Subspace Interspecies Abstract Communications Protocol.
 * @author joan
 * @parity XX
 * @since 41163.2
 */
@XmlRootElement
public class Subspace 
	extends Child<Minkowski,Spacetime> {

	/**
	 * 2561064391674188730L
	 */
	private static final long serialVersionUID = 2561064391674188730L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Minkowski getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Minkowski setKey(Minkowski key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Spacetime getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Spacetime setValue(Spacetime value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Baryon.class)
	public Mass<Minkowski,Spacetime> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Subspace} default class constructor.
	 */
	public Subspace() {
		super(Baryon.class, Hyperbaryon.class, Subspace.class);
	}
	/**
	 * {@link Subspace} class constructor.
	 * @param antitype the antitype
	 */
	public Subspace(Class<Universe> antitype) {
		super(Baryon.class, Hyperbaryon.class, Subspace.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		// ancestral recall
		super.mass(sender, event);
		// commute order
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof BigBang) {
				// declare future
				Mass<Spacetime,Minkowski> future;
				// cast source
				BigBang pair = (BigBang) event.getSource();
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
			if (event.getSource() instanceof BigBang) {
				// declare future
				Mass<Spacetime,Minkowski> future;
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// check if empty and chained
				if ((future = get()) != null ? 
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
			if(event.getSource() instanceof Minkowski) {
				// cast source
				Minkowski key = (Minkowski) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Contraction(key));
			}
			else if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// declare child
				Mass<Minkowski,Spacetime> child;
				// call child
				if((child = getChild()) != null) {
					// push gravity
					child.pulse(this, new Antigravity(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof BigBang) {
				// declare stem
				Mass<Spacetime,Minkowski> future;
				// cast source
				BigBang pair = (BigBang) event.getSource();
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
			if(event.getSource() instanceof BigBang) {
				// declare stem
				Mass<Spacetime,Minkowski> future;
				// cast source
				BigBang pair = (BigBang) event.getSource();
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
			if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// transfer key-value indexing pair mapping entry message
				get().putValue(pair.getKey(), pair.getValue());
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
	public Spacetime put(Minkowski key, Spacetime value) {
		// create child
		BigBong pair = new BigBong(BigBang.class, key, value, this);
		// push child
		pair.push(Command.PUSH);
		return null;
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
				child instanceof BigBong : false) {
			// cast source
			BigBong pair = (BigBong) child;
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