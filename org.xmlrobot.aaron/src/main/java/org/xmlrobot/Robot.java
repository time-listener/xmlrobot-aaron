package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Antigravity;
import org.xmlrobot.event.Hyperfusion;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Robot 
	extends ScrewNut<Subspace,Universe> {

	/**
	 * -3478889532242260284L
	 */
	private static final long serialVersionUID = -3478889532242260284L;

	public Robot() {
		super(Hypermind.class, Hyperbrain.class, Robot.class);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);

		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Hypertoroid) {
				// give her the universe
				event.getSource().start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Subspace) {
				
				Subspace key = (Subspace) event.getSource();
				
				getValue().pulse(this, new Hyperfusion(key));
			}
			else if(event.getSource() instanceof BigBang){
				// cast source
				BigBang source = (BigBang) event.getSource();
				// declare child
				Mass<Subspace,Universe> child;
				// call
				if((child = getChild()) != null) {
					// emit pulse
					child.pulse(this, new Antigravity(source));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hypertoroid) {
				// retire universe
				event.getSource().stop(context());
			}
			else if(event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// free pair
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	@Override
	public void run() {
		// start life
		super.run();
		// aaron infinite
		push(Command.RESURRECTION);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#putValue(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Universe putValue(Subspace key, Universe value) {
		return null;
	}
	@Override
	public void serviceChanged(ServiceEvent event) {

	}
}
