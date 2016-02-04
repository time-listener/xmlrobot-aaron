/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypermetal;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.Biosphere;
import org.xmlrobot.Organism;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Metal;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Earth 
	extends ScrewDriver<Biosphere,Ecosystem> {

	/**
	 * 3239165432095598794L
	 */
	private static final long serialVersionUID = 3239165432095598794L;

	/**
	 * {@link Earth} default class constructor.
	 */
	public Earth() {
		super(Metal.class, Hypermetal.class, Earth.class, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Earth(Biosphere key, Ecosystem value, 
			ScrewNut<Biosphere,Ecosystem> parent) {
		super(Metal.class, Hypermetal.class, Earth.class, key, value, parent);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Earth(Class<Mars> antitype) {
		super(Metal.class, Hypermetal.class, Earth.class, antitype, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Earth(Class<Mars> antitype, Biosphere key, Ecosystem value, 
			ScrewNut<Biosphere,Ecosystem> parent) {
		super(Metal.class, Hypermetal.class, Earth.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			 if(event.getSource() instanceof Organism) {
				// cast source
				Organism pair = (Organism) event.getSource();
				// set pair free
				pair.remove();
			} 
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#run()
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
		
		if(source instanceof Earth) {
			// cast source
			Earth pair = (Earth) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Metal(Hypermetal.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}
