package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperphenotype;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Hypergenesis;
import org.xmlrobot.event.Translocation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.Gamete;
import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Phenotype;
import org.xmlrobot.util.Command;

/**
 * The cromosoma implementation class. It is a map of {@link Genomap}.
 * His chain is a {@link Diploid} and the gear is {@link Allele}.
 * 
 * @author joan
 *
 */
@XmlRootElement
public class Cromosoma
	extends Screw<Genomap,Haploid> {

	/**
	 * 780556985094652696L
	 */
	private static final long serialVersionUID = 780556985094652696L;

	/**
	 * {@link Cromosoma} default class constructor.
	 */
	public Cromosoma() {
		super(Hyperphenotype.class, Phenotype.class, Cromosoma.class);
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cromosoma(Class<Diploid> antitype) {
		super(Hyperphenotype.class, Phenotype.class, Cromosoma.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Allele) {
				// give her the universe
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Genomap) {
				// cast source
				Genomap key = (Genomap) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Hypergenesis(key));
			}
			else if(event.getSource() instanceof Allele) {
				// cast source
				Allele pair = (Allele) event.getSource();
				// declare child
				Mass<Genomap,Haploid> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Translocation(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Allele) {
				// remove hyperspace
				event.stop(context());
			}
			else if(event.getSource() instanceof Gamete) {
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
	public Haploid putValue(Genomap key, Haploid value) {
		// declare child
		Mass<Genomap,Haploid> child;
		// declare old value
		Haploid oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			BasePair pair = new BasePair(Allele.class, key, value, this);
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