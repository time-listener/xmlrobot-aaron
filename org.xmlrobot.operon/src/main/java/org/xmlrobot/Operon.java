/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.antimatter.Adam;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Meiosis;
import org.xmlrobot.event.Reproduction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Eva;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Operon
	extends Screw<Ribosoma,Tetraploid> {

	/**
	 * -5111668034670593344L
	 */
	private static final long serialVersionUID = -5111668034670593344L;

	/**
	 * {@link Operon} default class constructor.
	 */
	public Operon() {
		super(Adam.class, Eva.class, Operon.class);
	}
	/**
	 * {@link Operon} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Operon(Class<Cell> antitype) {
		super(Adam.class, Eva.class, Operon.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Nucleoplasm) {
				// get antimatter
				Mass<Tetraploid,Ribosoma> key;
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
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
			if(event.getSource() instanceof Ribosoma) {
				// cast source
				Ribosoma key = (Ribosoma) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Meiosis(key));
			}
			else if(event.getSource() instanceof Nucleoplasm) {
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
				// declare child
				Mass<Ribosoma,Tetraploid> child;
				// assign and check
				if((child = getChild()) != null) {
					// reproduce yourselves!
					child.pulse(this, new Reproduction(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Nucleoplasm) {
				// cast source
				Nucleoplasm entity = (Nucleoplasm) event.getSource();
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
	public Tetraploid putValue(Ribosoma key, Tetraploid value) {
		// declare child
		Mass<Ribosoma,Tetraploid> child;
		// declare old value
		Tetraploid oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Cytoplasm pair = new Cytoplasm(Nucleoplasm.class, key, value, this);
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
		
		if(source instanceof Cytoplasm) {
			// cast source
			Cytoplasm pair = (Cytoplasm) source;
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