/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.BasePair;
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
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Groove) {
				// give him the universe
				event.start(context());
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
				// remove him the universe
				event.stop(context());
			}
			else if(event.getSource() instanceof BasePair) {
				// cast source
				BasePair pair = (BasePair) event.getSource();
				// free from inheritance
				pair.remove();
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
		
	}
}