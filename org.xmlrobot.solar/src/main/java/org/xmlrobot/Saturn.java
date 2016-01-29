/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypergas;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Collision;
import org.xmlrobot.event.Dispersion;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Gas;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Saturn 
	extends ScrewNut<Biosphere,Ecosystem> {

	/**
	 * 4330760345935660326L
	 */
	private static final long serialVersionUID = 4330760345935660326L;

	/**
	 * {@link Saturn} default class constructor.
	 */
	public Saturn() {
		
		super(Gas.class, Hypergas.class, Saturn.class);
	}
	/**
	 * {@link Saturn} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Saturn(Class<Jupiter> antitype) {
		
		super(Gas.class, Hypergas.class, Saturn.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Mars) {
				// give her the universe
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Biosphere) {
				// cast source
				Biosphere key = (Biosphere) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Dispersion(key));
			}
			else if(event.getSource() instanceof Mars) {
				// cast source
				Mars earth = (Mars) event.getSource();
				// declare child
				Mass<Biosphere,Ecosystem> child;
				// call child
				if((child = getChild()) != null) {
					// send him a little asteroid
					child.pulse(this, new Collision(earth));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Mars) {
				// bye
				event.stop(context());
			}
			else if(event.getSource() instanceof Being) {
				// cast source
				Being pair = (Being) event.getSource();
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
	public Ecosystem putValue(Biosphere key, Ecosystem value) {
		// declare child
		Mass<Biosphere,Ecosystem> child;
		// declare old value
		Ecosystem oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Earth pair = new Earth(Mars.class, key, value, this);
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
