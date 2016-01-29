/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Galaxy;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hyperbaryon;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Dilatation;
import org.xmlrobot.event.Gravity;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Baryon;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Universe extends Screw<Spacetime,Minkowski> {

	/**
	 * 7786709043686394145L
	 */
	private static final long serialVersionUID = 7786709043686394145L;

	/**
	 * 
	 */
	public Universe() {
		super(Hyperbaryon.class, Baryon.class, Universe.class);
	}
	/**
	 * 
	 */
	public Universe(Class<Subspace> antitype) {

		super(Hyperbaryon.class, Baryon.class, Universe.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		// ancestral recall
		super.mass(sender, event);
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof BigBong){
				// tick
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Spacetime) {
				// cast source
				Spacetime key = (Spacetime) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Dilatation(key));
			}
			else if (event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
				// declare child
				Mass<Spacetime, Minkowski> child;
				// call child
				if((child = getChild()) != null) {
					// push gravity
					child.pulse(this, new Gravity(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof BigBong){
				// tack
				event.stop(context());
			}
			else if(event.getSource() instanceof Galaxy) {
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
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
	public Minkowski putValue(Spacetime key, Minkowski value) {
		// declare child
		Mass<Spacetime,Minkowski> child;
		// declare old value
		Minkowski oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			BigBang pair = new BigBang(BigBong.class, key, value, this);
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
		push(Command.RESURRECTION);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}
}