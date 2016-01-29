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
import org.xmlrobot.Pegasi;
import org.xmlrobot.Sun;
import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Virgo 
	extends ScrewDriver<Sun,AlphaCentauri> {

	/**
	 * 465254906037303131L
	 */
	private static final long serialVersionUID = 465254906037303131L;

	/**
	 * {@link Virgo} default class constructor.
	 */
	public Virgo() {
		super(HyperbosonW.class, BosonW.class, Virgo.class, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link Screw<Sun,AlphaCentauri>} the parent
	 */
	public Virgo(Sun key, AlphaCentauri value, ScrewDriver<Sun,AlphaCentauri> parent) {
		
		super(HyperbosonW.class, BosonW.class, Virgo.class, key, value, parent);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Virgo(Class<Hydra> antitype) {
		
		super(HyperbosonW.class, BosonW.class, Virgo.class, antitype, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link Screw<Sun,AlphaCentauri>} the parent
	 */
	public Virgo(Class<Hydra> antitype, Sun key, AlphaCentauri value, ScrewDriver<Sun,AlphaCentauri> parent) {
		
		super(HyperbosonW.class, BosonW.class, Virgo.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.command()) {
		case SUBMIT:
			
			if(event.getSource() instanceof Pegasi) {
				// get antimatter
				ScrewDriver<Jupiter,Saturn> key;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi entity = (Pegasi) event.getSource();
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
