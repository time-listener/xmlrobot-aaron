/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperphenotype;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Transfix;
import org.xmlrobot.event.Transmission;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Phenotype;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Diploid 
	extends ScrewNut<Haploid,Genomap> {

	/**
	 * 1603750231206900779L
	 */
	private static final long serialVersionUID = 1603750231206900779L;

	/**
	 * {@link Diploid} default class constructor.
	 */
	public Diploid() {
		
		super(Phenotype.class, Hyperphenotype.class, Diploid.class);
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Diploid(Class<Cromosoma> antitype) {
		
		super(Phenotype.class, Hyperphenotype.class, Diploid.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof BasePair) {
				// give her the universe
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Haploid) {
				// cast source
				Haploid key = (Haploid) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Transmission(key));
			}
			else if(event.getSource() instanceof BasePair) {
				// cast source
				BasePair pair = (BasePair) event.getSource();
				// declare child
				Mass<Haploid,Genomap> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Transfix(pair));
				}
			}
			break;

		case TRANSFER:
			if(event.getSource() instanceof BasePair) {
				// rip
				event.stop(context());
			}
			else if(event.getSource() instanceof Gene) {
				// cast source
				Gene pair = (Gene) event.getSource();
				// get free
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
	public Genomap putValue(Haploid key, Genomap value) {
		// declare child
		Mass<Haploid,Genomap> child;
		// declare old value
		Genomap oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Allele pair = new Allele(BasePair.class, key, value, this);
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
		
	}
}