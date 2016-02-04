/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Hyperdna;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Meiosis;
import org.xmlrobot.event.Translocation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Dna;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Tetraploid
	extends ScrewNut<Diploid,Cromosoma> {

	/**
	 * 6764168527555084043L
	 */
	private static final long serialVersionUID = 6764168527555084043L;

	/**
	 * {@link Tetraploid} default class constructor.
	 */
	public Tetraploid() {
		
		super(Dna.class, Hyperdna.class, Tetraploid.class);
	}
	/**
	 * {@link Tetraploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Tetraploid(Class<Ribosoma> antitype) {
		
		super(Dna.class, Hyperdna.class, Tetraploid.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Groove) {
				// get antimatter
				Mass<Cromosoma,Diploid> stem;
				// cast source
				Groove pair = (Groove) event.getSource();
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
			if(event.getSource() instanceof Diploid) {
				// cast source
				Diploid key = (Diploid) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Translocation(key));
			}
			else if(event.getSource() instanceof Groove) {
				// cast source
				Groove pair = (Groove) event.getSource();
				// declare child
				Mass<Diploid,Cromosoma> child;
				// assign and check
				if((child = getChild()) != null) {
					// start mitosis
					child.pulse(this, new Meiosis(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Groove) {
				// cast source
				Groove entity = (Groove) event.getSource();
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
	public Cromosoma putValue(Diploid key, Cromosoma value) {
		// declare child
		Mass<Diploid,Cromosoma> child;
		// declare old value
		Cromosoma oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Plasmid pair = new Plasmid(Groove.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#run()
	 */
	@Override
	public void run() {
		// life starts
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
		
		if(source instanceof Plasmid) {
			// cast source
			Plasmid pair = (Plasmid) source;
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