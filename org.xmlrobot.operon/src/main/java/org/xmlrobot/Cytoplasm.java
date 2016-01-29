/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Groove;
import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Sperma;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Ovum;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Cytoplasm 
	extends ScrewDriver<Ribosoma,Tetraploid> {

	/**
	 * 2699555319928737598L
	 */
	private static final long serialVersionUID = 2699555319928737598L;


	/**
	 * {@link Cytoplasm} default class constructor.
	 */
	public Cytoplasm() {
		super(Sperma.class, Ovum.class, Cytoplasm.class, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Screw<Ribosoma,Tetraploid>} the parent
	 */
	public Cytoplasm(Ribosoma key, Tetraploid value, 
			Screw<Ribosoma,Tetraploid> parent) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, key, value, parent);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, antitype, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Screw<Ribosoma,Tetraploid>} the parent
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype, Ribosoma key, Tetraploid value, 
			Screw<Ribosoma,Tetraploid> parent) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, antitype, key, value, parent);
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
				// get antimatter
				ScrewDriver<Cromosoma,Diploid> key;
				// cast source
				Groove pair = (Groove) event.getSource();
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
			if(event.getSource() instanceof Groove) {
				// cast source
				Groove entity = (Groove) event.getSource();
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
