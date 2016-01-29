/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Cluster;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hyperbaryon;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Antigravity;
import org.xmlrobot.event.Contraction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Baryon;
import org.xmlrobot.util.Command;

/**
 * The BigBong Theory: everything ends here.
 * <p>Peace, love & BigBong
 * @author joan
 *
 */
public class Subspace 
	extends ScrewNut<Minkowski,Spacetime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2561064391674188730L;
	/**
	 * 
	 */
	public Subspace() {
		super(Baryon.class, Hyperbaryon.class, Subspace.class);
	}
	/**
	 * 
	 */
	public Subspace(Class<Universe> antitype) {
		super(Baryon.class, Hyperbaryon.class, Subspace.class, antitype);
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
			if(event.getSource() instanceof BigBang){
				// tack
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Minkowski) {
				// cast source
				Minkowski key = (Minkowski) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Contraction(key));
			}
			else if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// declare child
				Mass<Minkowski,Spacetime> child;
				// call child
				if((child = getChild()) != null) {
					// push gravity
					child.pulse(this, new Antigravity(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof BigBang){
				// tack
				event.stop(context());
			}
			else if(event.getSource() instanceof Cluster) {
				// cast source
				Cluster pair = (Cluster) event.getSource();
				// free from inheritance
				pair.remove();
			}
			break;

		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#putValue(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Spacetime putValue(Minkowski key, Spacetime value) {
		// declare child
		Mass<Minkowski,Spacetime> child;
		// declare old value
		Spacetime oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			BigBong pair = new BigBong(BigBang.class, key, value, this);
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