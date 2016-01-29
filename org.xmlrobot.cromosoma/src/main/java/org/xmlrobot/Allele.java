/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypertype;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.Gamete;
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
public class Allele 
	extends ScrewDriver<Haploid,Genomap> {

	/**
	 * -119308544852621745L
	 */
	private static final long serialVersionUID = -119308544852621745L;

	/**
	 * {@link Allele} default class constructor.
	 */
	public Allele() {
		super(Karyotype.class, Hypertype.class, Allele.class, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link ScrewNut<Haploid,Genomap>} the parent
	 */
	public Allele(Haploid key, Genomap value, 
			ScrewNut<Haploid,Genomap> parent) {
		super(Karyotype.class, Hypertype.class, Allele.class, key, value, parent);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Allele(Class<BasePair> antitype) {
		super(Karyotype.class, Hypertype.class, Allele.class, antitype, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link ScrewNut<Haploid,Genomap>} the parent
	 */
	public Allele(Class<BasePair> antitype, Haploid key, Genomap value, 
			ScrewNut<Haploid,Genomap> parent) {
		super(Karyotype.class, Hypertype.class, Allele.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	public void mass(TimeListener<?,?> sender, Takion<?,?> event) {
		
		super.mass(sender, event);
		// declare event source
		TimeListener<?,?> source;
		// commute event's command
		switch (event.command()) {
		case SUBMIT:
			if((source = event.getSource()) instanceof Gamete) {
				// get antimatter
				ScrewDriver<Hyperchain,Hypercube> key;
				// cast source
				Gamete pair = (Gamete) source;
				// check if empty and chained
				if((key = getKey()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Gamete) {
				// cast source
				Gamete entity = (Gamete) event.getSource();
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