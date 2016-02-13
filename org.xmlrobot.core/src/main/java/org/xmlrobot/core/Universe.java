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
import org.xmlrobot.core.event.Dilatation;
import org.xmlrobot.core.event.Gravity;
import org.xmlrobot.core.matter.Baryon;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;

/**
 * Universe implementation class.
 * @author joan
 * @parity XY
 * @since 41163.1
 */
@XmlRootElement
public class Universe 
	extends Child<Spacetime,Minkowski> {

	/**
	 * 7786709043686394145L
	 */
	private static final long serialVersionUID = 7786709043686394145L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Spacetime getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Spacetime setKey(Spacetime key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Minkowski getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Minkowski setValue(Minkowski value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperbaryon.class)
	public Mass<Spacetime,Minkowski> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Universe} default class constructor.
	 */
	public Universe() {
		super(Hyperbaryon.class, Baryon.class, Universe.class);
	}
	/**
	 * {@link Universe} class constructor.
	 * @param antitype the antitype
	 */
	public Universe(Class<Subspace> antitype) {
		super(Hyperbaryon.class, Baryon.class, Universe.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		// ancestral recall
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof BigBong) {
				// declare future
				Mass<Minkowski,Spacetime> future;
				// cast source
				BigBong pair = (BigBong) event.getSource();
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
			if(event.getSource() instanceof BigBong) {
				// declare future
				Mass<Minkowski,Spacetime> future;
				// cast source
				BigBong pair = (BigBong) event.getSource();
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
			if(event.getSource() instanceof Spacetime) {
				// cast source
				Spacetime key = (Spacetime) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Dilatation(key));
			}
			else if (event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
				// declare child
				Mass<Spacetime, Minkowski> child;
				// call child
				if((child = getChild()) != null) {
					// push gravity
					child.pulse(this, new Gravity(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof BigBong) {
				// declare stem
				Mass<Minkowski,Spacetime> future;
				// cast source
				BigBong pair = (BigBong) event.getSource();
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
			if(event.getSource() instanceof BigBong) {
				// declare stem
				Mass<Minkowski,Spacetime> future;
				// cast source
				BigBong pair = (BigBong) event.getSource();
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
			if(event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
				// transfer message
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
	public Minkowski put(Spacetime key, Minkowski value) {
		// create child
		BigBang pair = new BigBang(BigBong.class, key, value, this);
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
		if((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof BigBang : false) {
			// cast source
			BigBang pair = (BigBang) child;
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