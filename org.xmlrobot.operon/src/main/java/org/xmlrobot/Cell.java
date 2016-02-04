/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.antimatter.Adam;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Mitosis;
import org.xmlrobot.event.Procreation;
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
public class Cell 
	extends ScrewNut<Tetraploid,Ribosoma> {

	/**
	 * 4563541624913178342L
	 */
	private static final long serialVersionUID = 4563541624913178342L;

	/**
	 * {@link Cell} default class constructor.
	 */
	public Cell() {
		super(Eva.class, Adam.class, Cell.class);
	}
	/**
	 * {@link Cell} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cell(Class<Operon> antitype) {
		super(Eva.class, Adam.class, Cell.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Cytoplasm) {
				// get antimatter
				Mass<Ribosoma,Tetraploid> key;
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
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
			if(event.getSource() instanceof Tetraploid) {
				// cast source
				Tetraploid key = (Tetraploid) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Mitosis(key));
			}
			else if(event.getSource() instanceof Cytoplasm) {
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// declare child
				Mass<Tetraploid,Ribosoma> child;
				// assign and check
				if((child = getChild()) != null) {
					// procreate, now
					child.pulse(this, new Procreation(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Cytoplasm) {
				// cast source
				Cytoplasm entity = (Cytoplasm) event.getSource();
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
	public Ribosoma putValue(Tetraploid key, Ribosoma value) {
		// declare child
		Mass<Tetraploid,Ribosoma> child;
		// declare old value
		Ribosoma oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Nucleoplasm pair = new Nucleoplasm(Cytoplasm.class, key, value, this);
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
		
		if(source instanceof Nucleoplasm) {
			// cast source
			Nucleoplasm pair = (Nucleoplasm) source;
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