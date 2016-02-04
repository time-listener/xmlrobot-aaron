/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperhiggs;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Higgs;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Capricornus 
	extends ScrewDriver<MilkyWay,Andromeda>  {
	
	/**
	 * 2287183649427568656L
	 */
	private static final long serialVersionUID = 2287183649427568656L;
	
	/**
	 * {@link Capricornus} default class constructor.
	 */
	public Capricornus() {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Screw<MilkyWay,Andromeda>} the parent
	 */
	public Capricornus(MilkyWay key, Andromeda value, ScrewDriver<MilkyWay,Andromeda> parent) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, key, value, parent);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Capricornus(Class<Perseus> antitype) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, antitype, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Screw<MilkyWay,Andromeda>} the parent
	 */
	public Capricornus(Class<Perseus> antitype, MilkyWay key, Andromeda value, ScrewDriver<MilkyWay,Andromeda> parent) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
		
		if(source instanceof Capricornus) {
			// cast source
			Capricornus pair = (Capricornus) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hyperhiggs(Higgs.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}
