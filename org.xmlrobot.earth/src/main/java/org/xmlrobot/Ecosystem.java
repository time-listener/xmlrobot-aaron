/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperelement;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Dispersion;
import org.xmlrobot.event.Procreation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Element;
import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Ecosystem 
	extends Screw<Operon,Cell> {
	
	/**
	 * -6342325909526676593L
	 */
	private static final long serialVersionUID = -6342325909526676593L;
	
	/**
	 * {@link Ecosystem} default class constructor.
	 */
	public Ecosystem() {
		
		super(Hyperelement.class, Element.class, Ecosystem.class);
	}
	/**
	 * {@link Ecosystem} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Ecosystem(Class<Biosphere> antitype) {
		
		super(Hyperelement.class, Element.class, Ecosystem.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Organism) {
				// get antimatter
				Mass<Cell,Operon> key;
				// cast source
				Organism pair = (Organism) event.getSource();
				// check if empty and chained
				if((key = get()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Operon) {
				// cast source
				Operon key = (Operon) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Procreation(key));
			}
			else if(event.getSource() instanceof Organism) {
				// cast source
				Organism pair = (Organism) event.getSource();
				// declare child
				Mass<Operon,Cell> child;
				// assign and check
				if((child = getChild()) != null) {
					// dispersion across the known universe
					child.pulse(this, new Dispersion(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Organism) {
				// cast source
				Organism entity = (Organism) event.getSource();
				// transfer message contents
				get().putValue(entity.getKey(), entity.getValue());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#put(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Cell putValue(Operon key, Cell value) {
		// declare child
		Mass<Operon,Cell> child;
		// declare old value
		Cell oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Being pair = new Being(Organism.class, key, value, this);
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
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Being) {
			// cast source
			Being pair = (Being) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}