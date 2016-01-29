/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Allele;
import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Hyperrna;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Rna;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Plasmid 
	extends ScrewDriver<Diploid,Cromosoma> {

	/**
	 * 2106329525287215569L
	 */
	private static final long serialVersionUID = 2106329525287215569L;

	/**
	 * {@link Plasmid} default class constructor.
	 */
	public Plasmid() {
		super(Rna.class, Hyperrna.class, Plasmid.class, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	protected Plasmid(Diploid key, Cromosoma value, ScrewDriver<Diploid,Cromosoma> parent) {
		super(Rna.class, Hyperrna.class, Plasmid.class, key, value, parent);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Plasmid(Class<Ribosoma> antitype) {
		super(Rna.class, Hyperrna.class, Plasmid.class, antitype, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	protected Plasmid(Class<Groove> antitype, Diploid key, Cromosoma value, 
			ScrewDriver<Diploid,Cromosoma> parent) {
		super(Rna.class, Hyperrna.class, Plasmid.class, antitype, key, value, parent);
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
				// get antimatter
				ScrewDriver<Haploid,Genomap> key;
				// cast source
				Allele pair = (Allele) event.getSource();
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
			if(event.getSource() instanceof Allele) {
				// cast source
				Allele entity = (Allele) event.getSource();
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