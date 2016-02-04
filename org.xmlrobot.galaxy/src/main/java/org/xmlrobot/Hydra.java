/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.HyperbosonW;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.BosonW;
import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.Vega;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Hydra 
	extends ScrewDriver<AlphaCentauri,Sun> {
	/**
	 * 8843376414708744759L
	 */
	private static final long serialVersionUID = 8843376414708744759L;

	/**
	 * {@link Hydra} default class constructor.
	 */
	public Hydra() {
		super(BosonW.class, HyperbosonW.class, Hydra.class, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	public Hydra(AlphaCentauri key, Sun value, ScrewDriver<AlphaCentauri,Sun> parent) {
		super(BosonW.class, HyperbosonW.class, Hydra.class, key, value, parent);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hydra(Class<Virgo> antitype) {
		super(BosonW.class, HyperbosonW.class, Hydra.class, antitype, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	public Hydra(Class<Virgo> antitype, AlphaCentauri key, Sun value, ScrewDriver<AlphaCentauri,Sun> parent) {
		super(BosonW.class, HyperbosonW.class, Hydra.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Vega) {
				// cast source
				Vega pair = (Vega) event.getSource();
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
		
		if(source instanceof Hydra) {
			// cast source
			Hydra pair = (Hydra) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new BosonW(HyperbosonW.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}
