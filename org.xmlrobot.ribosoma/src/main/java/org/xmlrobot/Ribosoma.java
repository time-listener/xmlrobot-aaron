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
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Plasmid) {
				// give her the universe
				event.start(context());
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
				// set universe to null
				event.stop(context());
			}
			else if(event.getSource() instanceof Allele) {
				// cast
				Allele pair = (Allele) event.getSource();
				// rip
				pair.remove();
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
		
	}
}