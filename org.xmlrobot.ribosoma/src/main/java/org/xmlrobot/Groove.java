/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.BasePair;
import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Hyperrna;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Rna;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Groove 
	extends ScrewDriver<Cromosoma,Diploid> {

	/**
	 * 5769021798206302143L
	 */
	private static final long serialVersionUID = 5769021798206302143L;

	/**
	 * {@link Groove} default class constructor.
	 */
	public Groove() {
		super(Hyperrna.class, Rna.class, Groove.class, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	protected Groove(Cromosoma key, Diploid value, 
			ScrewDriver<Cromosoma,Diploid> parent) {
		super(Hyperrna.class, Rna.class, Groove.class, key, value, parent);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Groove(Class<Plasmid> antitype) {
		super(Hyperrna.class, Rna.class, Groove.class, antitype, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	protected Groove(Class<Plasmid> antitype, Cromosoma key, Diploid value, 
			ScrewDriver<Cromosoma,Diploid> parent) {
		super(Hyperrna.class, Rna.class, Groove.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			
			if(event.getSource() instanceof BasePair) {
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
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Groove) {
			// cast source
			Groove pair = (Groove) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hyperrna(Rna.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}
