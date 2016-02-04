/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypertype;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.Gene;
import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Karyotype;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class BasePair 
	extends ScrewDriver<Genomap,Haploid> {

	/**
	 * -7944087613705943766L
	 */
	private static final long serialVersionUID = -7944087613705943766L;
	
	/**
	 * {@link BasePair} default class constructor.
	 */
	public BasePair() {
		super(Hypertype.class, Karyotype.class, BasePair.class, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link ScrewDriver<Genomap,Haploid>} the parent
	 */
	public BasePair(Genomap key, Haploid value, 
			ScrewDriver<Genomap,Haploid> parent) {
		super(Hypertype.class, Karyotype.class, BasePair.class, key, value, parent);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 */
	public BasePair(Class<Allele> antitype) {
		super(Hypertype.class, Karyotype.class, BasePair.class, antitype, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link ScrewDriver<Genomap,Haploid>} the parent
	 */
	public BasePair(Class<Allele> antitype, Genomap key, Haploid value, 
			ScrewDriver<Genomap,Haploid> parent) {
		super(Hypertype.class, Karyotype.class, BasePair.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Gene) {
				// cast source
				Gene pair = (Gene) event.getSource();
				// rest in peace
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
		// do genesis
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
		
		if(source instanceof BasePair) {
			// cast source
			BasePair pair = (BasePair) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hypertype(Karyotype.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}