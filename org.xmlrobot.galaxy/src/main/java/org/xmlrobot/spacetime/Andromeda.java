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
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.antimatter.HyperbosonZ;
import org.xmlrobot.spacetime.event.Attraction;
import org.xmlrobot.spacetime.event.Rotation;
import org.xmlrobot.spacetime.matter.BosonZ;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

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
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setKey(AlphaCentauri key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Sun getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setValue(Sun value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
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
		super(BosonZ.class, HyperbosonZ.class, Andromeda.class, Parity.XX);
	}
	/**
	 * {@link Andromeda} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Andromeda(Class<MilkyWay> antitype) {
		super(Andromeda.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof AlphaCentauri) {
				// cast source
				AlphaCentauri entity = (AlphaCentauri) event.getSource();
				// inject star
				put(entity, (Sun) entity.get());
			}
			break;
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
		case SEND:
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
		case PUSH:
			if(event.getSource() instanceof AlphaCentauri) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					AlphaCentauri key = (AlphaCentauri) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Attraction(key));	
				}
			}
			else if(event.getSource() instanceof Virgo) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Virgo pair = (Virgo) event.getSource();
					// gravity
					getChild().pulse(this, new Rotation(pair));
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
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Vega) {
				// cast source
				Vega pair = (Vega) event.getSource();
				// free from inheritance
				pair.remove();
			}
			else if(event.getSource() instanceof Virgo) {
				// ending
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
	public Sun put(AlphaCentauri key, Sun value) {
		// create child
		Hydra pair = new Hydra(Virgo.class, key, value, this);
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
				child instanceof Hydra : false) {
			// cast source
			Hydra pair = (Hydra) child;
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
