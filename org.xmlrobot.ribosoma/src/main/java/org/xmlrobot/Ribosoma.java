/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperdna;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Mitosis;
import org.xmlrobot.event.Transfix;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Dna;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Ribosoma
	extends Screw<Cromosoma,Diploid> {

	/**
	 * 4538358656836061534L
	 */
	private static final long serialVersionUID = 4538358656836061534L;

	/**
	 * {@link Ribosoma} default class constructor.
	 */
	public Ribosoma() {
		
		super(Hyperdna.class, Dna.class, Ribosoma.class);
	}
	/**
	 * {@link Ribosoma} class constructor.
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	public Ribosoma(Class<Tetraploid> antitype) {
		
		super(Hyperdna.class, Dna.class, Ribosoma.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Plasmid) {
				// get antimatter
				Mass<Diploid,Cromosoma> key;
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
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
			if(event.getSource() instanceof Cromosoma) {
				// cast source
				Cromosoma key = (Cromosoma) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Transfix(key));
			}
			else if(event.getSource() instanceof Plasmid) {
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
				// declare child
				Mass<Cromosoma,Diploid> child;
				// assign and check
				if((child = getChild()) != null) {
					// start mitosis
					child.pulse(this, new Mitosis(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Plasmid) {
				// cast source
				Plasmid entity = (Plasmid) event.getSource();
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
	public Diploid putValue(Cromosoma key, Diploid value) {
		// declare child
		Mass<Cromosoma, Diploid> child;
		// declare old value
		Diploid oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Groove pair = new Groove(Plasmid.class, key, value, this);
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
		
		if(source instanceof Groove) {
			// cast source
			Groove pair = (Groove) source;
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