/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.HyperbosonZ;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Attraction;
import org.xmlrobot.event.Rotation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.BosonZ;
import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Pegasi;
import org.xmlrobot.Sun;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Andromeda 
	extends ScrewNut<AlphaCentauri,Sun> {

	/**
	 * -2441587664117221210L
	 */
	private static final long serialVersionUID = -2441587664117221210L;

	/**
	 * {@link Andromeda} default class constructor.
	 */
	public Andromeda() {
		super(BosonZ.class, HyperbosonZ.class, Andromeda.class);
	}
	/**
	 * {@link Andromeda} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Andromeda(Class<MilkyWay> antitype) {
		super(BosonZ.class, HyperbosonZ.class, Andromeda.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Virgo) {
				// give her the universe
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof AlphaCentauri) {
				// cast source
				AlphaCentauri key = (AlphaCentauri) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Attraction(key));
			}
			else if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo pair = (Virgo) event.getSource();
				// declare child
				Mass<AlphaCentauri,Sun> child;
				// call child
				if((child = getChild()) != null) {
					// gravity
					child.pulse(this, new Rotation(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Virgo) {
				// give her the universe
				event.stop(context());
			}
			else if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
				// free from inheritance
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Sun putValue(AlphaCentauri key, Sun value) {
		// declare child
		Mass<AlphaCentauri,Sun> child;
		// declare old value
		Sun oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hydra pair = new Hydra(Virgo.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#run()
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
