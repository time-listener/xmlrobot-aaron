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
import org.xmlrobot.spacetime.event.Compression;
import org.xmlrobot.spacetime.event.Revolution;
import org.xmlrobot.spacetime.matter.Muon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Columbia implementation class.
 * @author joan
 * @parity XX
 * @since 41159.2
 */
@XmlRootElement
public class Columbia
	extends Child<Andromeda,MilkyWay> {

	/**
	 * 7104570102230102161L
	 */
	private static final long serialVersionUID = 7104570102230102161L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Andromeda getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setKey(Andromeda key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public MilkyWay getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setValue(MilkyWay value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Muon.class)
	public Mass<Andromeda,MilkyWay> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Columbia} default class constructor.
	 */
	public Columbia() {
		
		super(Muon.class, Hypermuon.class, Columbia.class, Parity.XX);
	}
	/**
	 * {@link Columbia} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Columbia(Class<Fornax> antitype) {
		
		super(Columbia.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Andromeda) {
				// cast source
				Andromeda entity = (Andromeda) event.getSource();
				// push galaxy into hyperspace
				put(entity, (MilkyWay) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Capricornus) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
			if(event.getSource() instanceof Capricornus) {
				// get antimatter
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
			if(event.getSource() instanceof Andromeda) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Andromeda key = (Andromeda) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Revolution(key));
				}
			}
			else if(event.getSource() instanceof Capricornus) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Capricornus pair = (Capricornus) event.getSource();
					// send pulse to the future
					getChild().pulse(this, new Compression(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Capricornus) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
			if(event.getSource() instanceof Capricornus) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
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
				Virgo pair = (Virgo) event.getSource();
				// free from inheritance
				pair.remove();
			}
			else if(event.getSource() instanceof Capricornus) {
				// stop supercluster
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
	public MilkyWay put(Andromeda key, MilkyWay value) {
		// create child
		Perseus pair = new Perseus(Capricornus.class, key, value, this);
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
				child instanceof Perseus : false) {
			// cast source
			Perseus pair = (Perseus) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putKey(pair.getValue(), pair.getKey());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByValue(pair.getValue());
			}
		}
	}
}
