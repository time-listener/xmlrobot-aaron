/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperexon;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Instant;
import org.xmlrobot.event.Transmission;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Exon;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Genomap 
	extends Screw<Hypercube,Hyperchain> {

	/**
	 * -1116284261599707252L
	 */
	private static final long serialVersionUID = -1116284261599707252L;

	/**
	 * {@link Genomap} default class constructor.
	 */
	public Genomap() {
		
		super(Hyperexon.class, Exon.class, Genomap.class);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Genomap(Class<Haploid> antitype) {
		
		super(Hyperexon.class, Exon.class, Genomap.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
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
		case GENESIS:
			if(event.getSource() instanceof Hypercube) {
				// cast source
				Hypercube key = (Hypercube) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Instant(key));
			}
			else if(event.getSource() instanceof Gamete) {
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// declare child
				Mass<Hypercube,Hyperchain> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Transmission(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Gamete) {
				// cast source
				Gamete entity = (Gamete) event.getSource();
				// transfer message contents
				get().putValue(entity.getKey(), entity.getValue());
			}
			break;
		default:
			break;
		}
	}	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hyperstring#name()
	 */
	@Override
	public String getName() {
		
		Mass<Hypercube,Hyperchain> child;
		return (child = getChild()) != null ? child.getName() : new String();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#put(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Hyperchain putValue(Hypercube key, Hyperchain value) {
		// declare child
		Mass<Hypercube,Hyperchain> child;
		// declare old value
		Hyperchain oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Gene pair = new Gene(Gamete.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#run()
	 */
	@Override
	public void run() {
		super.run();
		// message transfer
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Gene) {
			// cast source
			Gene pair = (Gene) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());			}
		}
	}
}