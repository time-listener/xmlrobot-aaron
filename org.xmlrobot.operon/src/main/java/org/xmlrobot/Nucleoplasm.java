/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Plasmid;
import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Sperma;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Ovum;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Nucleoplasm 
	extends ScrewDriver<Tetraploid,Ribosoma> {

	/**
	 * 3057140414113756471L
	 */
	private static final long serialVersionUID = 3057140414113756471L;
	
	/**
	 * {@link Nucleoplasm} default class constructor.
	 */
	public Nucleoplasm() {
		
		super(Ovum.class, Sperma.class, Nucleoplasm.class, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link ScrewNut<Tetraploid,Ribosoma>} the parent
	 */
	public Nucleoplasm(Tetraploid key, Ribosoma value, 
			ScrewNut<Tetraploid,Ribosoma> parent) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, key, value, parent);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, antitype, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link ScrewNut<Tetraploid,Ribosoma>} the parent
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype, Tetraploid key, Ribosoma value, 
			ScrewNut<Tetraploid,Ribosoma> parent) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, antitype, key, value, parent);
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
				// get antimatter
				ScrewDriver<Diploid,Cromosoma> key;
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
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
			if(event.getSource() instanceof Plasmid) {
				// cast source
				Plasmid entity = (Plasmid) event.getSource();
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
