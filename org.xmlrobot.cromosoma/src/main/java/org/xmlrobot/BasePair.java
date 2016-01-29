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
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
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
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Gene) {
				// declare stem
				ScrewDriver<Hypercube,Hyperchain> key;
				// declare and assign pair source
				Gene pair = (Gene) event.getSource();
				// check if empty and chained
				if((key = getKey()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true  
							: false) {
					// push child
					key.add(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Gene) {
				// cast source
				Gene entity = (Gene) event.getSource();
				// transfer message contents
				getValue().putValue(entity.getValue(), entity.getKey());
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
		
	}
}