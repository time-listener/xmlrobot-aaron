/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Plasmid;
import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.antimatter.Adam;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Meiosis;
import org.xmlrobot.event.Reproduction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.Gamete;
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
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Nucleoplasm) {
				// begin
				event.start(context());
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
				// end
				event.stop(context());
			}
			else if(event.getSource() instanceof Plasmid) {
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// free from inheritance
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
		
	}
}