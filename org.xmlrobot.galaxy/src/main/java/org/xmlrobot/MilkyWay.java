/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.HyperbosonZ;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Repulsion;
import org.xmlrobot.event.Revolution;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.BosonZ;
import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.Vega;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class MilkyWay 
	extends Screw<Sun,AlphaCentauri> {

	/**
	 * 5721672750470171670L
	 */
	private static final long serialVersionUID = 5721672750470171670L;
	
	/**
	 * {@link MilkyWay} default class constructor.
	 */
	public MilkyWay() {
		
		super(HyperbosonZ.class, BosonZ.class, MilkyWay.class);
	}
	/**
	 * {@link MilkyWay} class constructor.
	 * @param antitype the inherited antitype
	 */
	public MilkyWay(Class<Andromeda> antitype) {
		
		super(HyperbosonZ.class, BosonZ.class, MilkyWay.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Hydra) {
				// give her the universe
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Sun) {
				// cast source
				Sun key = (Sun) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Repulsion(key));
			}
			else if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// declare child
				Mass<Sun, AlphaCentauri> child;
				// call child
				if((child = getChild()) != null) {
					// antigravity
					child.pulse(this, new Revolution(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hydra) {
				// take universe out
				event.stop(context());
			}
			else if(event.getSource() instanceof Vega) {
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
	 * @see org.xmlrobot.driver.Screw#put(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public AlphaCentauri putValue(Sun key, AlphaCentauri value) {
		// declare child
		Mass<Sun,AlphaCentauri> child;
		// declare old value
		AlphaCentauri oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ?
				child.putValue(key,	value) : null) == null) {
			// create child
			Virgo pair = new Virgo(Hydra.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#run()
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