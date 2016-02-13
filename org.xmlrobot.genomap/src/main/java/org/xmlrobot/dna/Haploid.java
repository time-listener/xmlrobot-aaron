/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.antimatter.Hyperexon;
import org.xmlrobot.dna.event.Transduction;
import org.xmlrobot.dna.matter.Exon;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.subspace.event.Flop;
import org.xmlrobot.util.Command;

/**
 * Haploid implementation class.
 * @author joan
 * @parity XX
 * @since 1515.2
 */
@XmlRootElement
public class Haploid
	extends Child<Hyperchain,Hypercube> {

	/**
	 * -9119555421755471045L
	 */
	private static final long serialVersionUID = -9119555421755471045L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getKey(java.lang.Object)
	 */
	@Override
	@XmlElement
	public Hyperchain getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hyperchain setKey(Hyperchain key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	@XmlElement
	public Hypercube getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hypercube setValue(Hypercube value) {
		return super.setValue(value);
	}
	@Override
	@XmlElement(type=Exon.class)
	public Mass<Hyperchain,Hypercube> getReplicator() {

		return super.getReplicator();
	}
	/**
	 * {@link Haploid} default class constructor.
	 */
	public Haploid() {
		super(Exon.class, Hyperexon.class, Haploid.class);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Haploid(Class<Genomap> antitype) {
		super(Exon.class, Hyperexon.class, Haploid.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		// call ancestral method
		super.mass(sender, event);
		// commute entity's command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Gene pair = (Gene) event.getSource();
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
		case PUSH:
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// declare and assign pair source
				Gene pair = (Gene) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ?
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true  
							: false) {
					// push child
					stem.add(pair);
				}
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Hyperchain) {
				// cast source
				Hyperchain key = (Hyperchain) event.getSource();
				Hypercube value;
				// assign and check
				if((value = getValue()) != null) {
					// pulse to the future
					value.pulse(this, new Flop(key));	
				}
			}
			else if(event.getSource() instanceof Gene) {
				// cast source
				Gene pair = (Gene) event.getSource();
				// declare child
				Mass<Hyperchain,Hypercube> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Transduction(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Gene pair = (Gene) event.getSource();
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
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Gene pair = (Gene) event.getSource();
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
			if(event.getSource() instanceof Gene) {
				// cast source
				Gene entity = (Gene) event.getSource();
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
	public Hypercube put(Hyperchain key, Hypercube value) {
		// declare child
		Mass<Hyperchain,Hypercube> child;
		// declare old value
		Hypercube oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) 
				: null) == null) {
			// create child
			Gamete pair = new Gamete(Gene.class, key, value, this);
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
				child instanceof Gamete : false) {
			// cast source
			Gamete pair = (Gamete) child;
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