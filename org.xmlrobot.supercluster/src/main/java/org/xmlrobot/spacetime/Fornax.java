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
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.antimatter.Hypermuon;
import org.xmlrobot.spacetime.event.Expansion;
import org.xmlrobot.spacetime.event.Rotation;
import org.xmlrobot.spacetime.matter.Muon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Fornax implementation class.
 * @author joan
 * @parity XY
 * @since 41159.1
 */
@XmlRootElement
public class Fornax 
	extends Child<MilkyWay,Andromeda> {

	/**
	 * -8282005929352690501L
	 */
	private static final long serialVersionUID = -8282005929352690501L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public MilkyWay getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setKey(MilkyWay key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Andromeda getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setValue(Andromeda value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hypermuon.class)
	public Mass<MilkyWay,Andromeda> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Fornax} default class constructor.
	 */
	public Fornax() {
		super(Hypermuon.class, Muon.class, Fornax.class, Parity.XY);
	}
	/**
	 * {@link Fornax} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Fornax(Class<Columbia> antitype) {
		super(Fornax.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof MilkyWay) {
				// cast source
				MilkyWay entity = (MilkyWay) event.getSource();
				// push galaxy into hyperspace
				put(entity, (Andromeda) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Perseus) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
			if(event.getSource() instanceof Perseus) {
				// get antimatter
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
			if(event.getSource() instanceof MilkyWay) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					MilkyWay key = (MilkyWay) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Rotation(key));	
				}
			}
			else if(event.getSource() instanceof Perseus) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Perseus pair = (Perseus) event.getSource();
					// send pulse to the future
					getChild().pulse(this, new Expansion(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Perseus) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
			if(event.getSource() instanceof Perseus) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
				Hydra pair = (Hydra) event.getSource();
				// set galaxy free from inheritance
				pair.remove();
			}
			if(event.getSource() instanceof Perseus) {
				// end supercluster
				event.stop(getContext());
			}
			break;
		default:
			break;
		}
	}
	@Override
	public Andromeda put(MilkyWay key, Andromeda value) {
		// create child
		Capricornus pair = new Capricornus(Perseus.class, key, value, this);
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
				child instanceof Capricornus : false) {
			// cast source
			Capricornus pair = (Capricornus) child;
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