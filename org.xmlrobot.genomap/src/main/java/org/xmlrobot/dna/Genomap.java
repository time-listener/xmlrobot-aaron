/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.antimatter.Hyperexon;
import org.xmlrobot.dna.event.Transmission;
import org.xmlrobot.dna.matter.Exon;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.subspace.Hyperentry;
import org.xmlrobot.subspace.event.Instant;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Genomap implementation class.
 * 
 * <p>This class is just another member of the<br>
 * {@code hyperspace congregation framework}.
 * 
 * @author joan
 * @parity XY
 * @since 1515.1
 */
@XmlRootElement
public class Genomap
	extends Child<Hypercube,Hyperchain> {

	/**
	 * -1116284261599707252L
	 */
	private static final long serialVersionUID = -1116284261599707252L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Hypercube getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hypercube setKey(Hypercube key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Hyperchain getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hyperchain setValue(Hyperchain value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperexon.class)
	public Mass<Hypercube,Hyperchain> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Genomap} default class constructor.
	 */
	public Genomap() {
		super(Hyperexon.class, Exon.class, Genomap.class, Parity.XY);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Genomap(Class<Haploid> antitype) {
		super(Genomap.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// call ancestral method
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Hypercube) {
				// cast source
				Hypercube entity = (Hypercube) event.getSource();
				// create pair
				put(entity, (Hyperchain) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Gamete) {
				// declare stem
				Mass<Hyperchain,Hypercube> stem;
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// release child
					stem.order(pair);
				}
			}
			break;
		case SEND:
			if(event.getSource() instanceof Gamete) {
				// get antimatter
				Mass<Hyperchain,Hypercube> stem;
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ?
						!stem.isEmpty() ?
								!stem.contains(pair)
								: true
						: false) {
					// submit child to the inheritance cycle
					stem.add(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Hypercube) {
				// assign and check
				if(!isEmpty()) {
					// cast source
					Hypercube key = (Hypercube) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Instant(key));
				}
			}
			else if(event.getSource() instanceof Gamete) {
				// assign and check
				if(!isEmpty()) {
					// cast source
					Gamete pair = (Gamete) event.getSource();
					// send message to the future
					getChild().pulse(this, new Transmission(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Gamete) {
				// declare stem
				Mass<Hyperchain,Hypercube> stem;
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								stem.contains(pair) 
								: false
						: false) {
					// release child
					stem.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Gamete) {
				// declare stem
				Mass<Hyperchain,Hypercube> stem;
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.submit(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry pair = (Hyperentry) event.getSource();
				// get free
				pair.remove();
			}
			else if (event.getSource() instanceof Gamete) {
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
	public Hyperchain put(Hypercube key, Hyperchain value) {
		// create child
		Gene pair = new Gene(Gamete.class, key, value, this);
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
				child instanceof Gene : false) {
			// cast source
			Gene pair = (Gene) child;
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