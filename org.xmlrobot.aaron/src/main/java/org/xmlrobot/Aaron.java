package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.BigBong;
import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Antigravity;
import org.xmlrobot.event.Contraction;
import org.xmlrobot.event.Gravity;
import org.xmlrobot.event.Hyperfission;
import org.xmlrobot.genesis.Genesis;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Redemptor;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.util.Command;

/**
 * Aaron infinite. He is the master of all times. A.k.a Timemaster.
 * @author joan
 */
@XmlRootElement
public final class Aaron
	extends Screw<Universe,Subspace>
	implements Genesis,Redemptor  {

	/**
	 * -9024346196425472952L
	 */
	private static final long serialVersionUID = -9024346196425472952L;
	
	/**
	 * 
	 */
	public Aaron() {
		super(Hyperbrain.class, Hypermind.class, Aaron.class);
	}
	/**
	 * @param antitype
	 */
	public Aaron(Class<Robot> antitype) { 
		super(Hyperbrain.class, Hypermind.class, Aaron.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#run()
	 */
	@Override
	public void run() {
		// start life
		super.run();
		// aaron infinite
		push(Command.RESURRECTION);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
		if(event.getType() == ServiceEvent.REGISTERED) {
			// get reference
			ServiceReference<?> ref = event.getServiceReference();
			// declare source
			Object source;
			// get entity
			if((source = context().getService(ref)) instanceof Hypertoroid) {
				
				Hypertoroid root = (Hypertoroid) source;
				// listen all entities masses
				// this is also what NSA is doing to us
				root.addMassListener(this);
				// input to the brain
				replicator().putValue(root.getKey(), root.getValue());
				// start entity's time
				execute(root);	
			}	
		}
		if(event.getType() == ServiceEvent.UNREGISTERING) {
			// get reference
			ServiceReference<?> ref = event.getServiceReference();
			// declare source
			Object source;
			// get entity
			if ((source = context().getService(ref)) instanceof Hypertoroid) {
				// rest in peace
				replicator().removeByKey(((Hypertoroid)source).getKey());
				// un-get current service
				context().ungetService(ref);
			}
		}
	}

	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperplasma) {
				// give her the universe
				event.getSource().start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Universe) {
				
				Universe key = (Universe) event.getSource();
				
				getValue().pulse(this, new Hyperfission(key));
			}
			else if(event.getSource() instanceof BigBong){
				// cast source
				BigBong source = (BigBong) event.getSource();
				// declare child
				Mass<Universe,Subspace> child;
				// call
				if((child = getChild()) != null) {
					// emit pulse
					child.pulse(this, new Gravity(source));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperplasma) {
				// give her the universe
				event.getSource().stop(context());
			}
			else if(event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#putValue(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Subspace putValue(Universe key, Subspace value) {
	
		return null;
	}
}
