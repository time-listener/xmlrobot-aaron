/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperquark;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Compression;
import org.xmlrobot.event.Contraction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Quark;
import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.Perseus;
import org.xmlrobot.util.Command;

/**
 * @author joan
 * @parity XY
 *
 */
@XmlRootElement
public class Spacetime 
	extends Screw<Fornax,Columbia> {

	/**
	 * -4610931478020986617L
	 */
	private static final long serialVersionUID = -4610931478020986617L;

	/**
	 * {@link Spacetime} default class constructor.
	 */
	public Spacetime() {
		super(Hyperquark.class, Quark.class, Spacetime.class);
	}
	/**
	 * {@link Spacetime} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Spacetime(Class<Minkowski> antitype) {
		super(Hyperquark.class, Quark.class, Spacetime.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Galaxy) {
				// add universe
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Fornax) {
				// cast source
				Fornax key = (Fornax) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Compression(key));
			}
			else if(event.getSource() instanceof Galaxy) {
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
				// declare child
				Mass<Fornax,Columbia> child;
				// call child
				if((child = getChild()) != null) {
					// emit mass to the future
					child.pulse(this, new Contraction(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Galaxy) {
				// remove universe
				event.stop(context());
			}
			else if(event.getSource() instanceof Perseus) {
				// cast source
				Perseus pair = (Perseus) event.getSource();
				// rip
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
	public Columbia putValue(Fornax key, Columbia value) {
		// declare child
		Mass<Fornax,Columbia> child;
		// declare old value
		Columbia oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Cluster pair = new Cluster(Galaxy.class, key, value, this);
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