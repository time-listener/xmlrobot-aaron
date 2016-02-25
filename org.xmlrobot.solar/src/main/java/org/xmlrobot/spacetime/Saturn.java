/**
 * 
 */
package org.xmlrobot.spacetime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.nature.Organism;
import org.xmlrobot.nature.event.Dispersion;
import org.xmlrobot.spacetime.antimatter.Hypergas;
import org.xmlrobot.spacetime.event.Collision;
import org.xmlrobot.spacetime.matter.Gas;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Saturn implementation class.
 * @author joan
 * @parity XX
 * @since 41153.2
 */
@XmlRootElement
public class Saturn 
	extends Child<Biosphere,Ecosystem> {

	/**
	 * 4330760345935660326L
	 */
	private static final long serialVersionUID = 4330760345935660326L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Biosphere getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Biosphere setKey(Biosphere key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Ecosystem getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ecosystem setValue(Ecosystem value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Gas.class)
	public Mass<Biosphere,Ecosystem> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Saturn} default class constructor.
	 */
	public Saturn() {
		
		super(Gas.class, Hypergas.class, Saturn.class, Parity.XX);
	}
	/**
	 * {@link Saturn} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Saturn(Class<Jupiter> antitype) {
		
		super(Saturn.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Biosphere) {
				// cast source
				Biosphere entity = (Biosphere) event.getSource();
				// insert entity
				put(entity, (Ecosystem) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Mars) {
				// declare stem
				Mass<Ecosystem,Biosphere> future;
				// cast source
				Mars pair = (Mars) event.getSource();
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
			if(event.getSource() instanceof Mars) {
				// get antimatter
				Mass<Ecosystem,Biosphere> future;
				// cast source
				Mars pair = (Mars) event.getSource();
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
			if(event.getSource() instanceof Biosphere) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Biosphere key = (Biosphere) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Dispersion(key));
				}
			}
			else if(event.getSource() instanceof Mars) {
				// call child
				if(!isEmpty()) {
					// cast source
					Mars earth = (Mars) event.getSource();
					// send him a little asteroid
					getChild().pulse(this, new Collision(earth));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Mars) {
				// declare stem
				Mass<Ecosystem,Biosphere> future;
				// cast source
				Mars pair = (Mars) event.getSource();
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
			if(event.getSource() instanceof Mars) {
				// declare stem
				Mass<Ecosystem,Biosphere> future;
				// cast source
				Mars pair = (Mars) event.getSource();
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
			if(event.getSource() instanceof Organism) {
				// cast source
				Organism pair = (Organism) event.getSource();
				// set pair free
				pair.remove();
			}
			else if(event.getSource() instanceof Mars) {
				// rip
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
	public Ecosystem put(Biosphere key, Ecosystem value) {
		// create child
		Earth pair = new Earth(Mars.class, key, value, this);
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
				child instanceof Earth : false) {
			// cast source
			Earth pair = (Earth) child;
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}