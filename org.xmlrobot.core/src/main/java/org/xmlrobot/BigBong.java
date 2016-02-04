/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Galaxy;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hypermeson;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Redemptor;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Meson;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Subspace Interspecies Communications Protocol.
 * 
 * @author joan
 * @parity XX
 */
@XmlRootElement
public class BigBong 
	extends ScrewDriver<Minkowski,Spacetime> 
		implements Redemptor {

	/**
	 * 5618281278085731564L
	 */
	private static final long serialVersionUID = 5618281278085731564L;
	
	/**
	 * @throws Abort
	 */
	public BigBong(Minkowski key, Spacetime value) {
		super(Meson.class, Hypermeson.class, BigBong.class, key, value, Parity.YY);
	}
	/**
	 * @throws Abort
	 */
	public BigBong(Minkowski key, Spacetime value, ScrewDriver<Minkowski,Spacetime> parent) {
		super(Meson.class, Hypermeson.class, BigBong.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @throws Abort
	 */
	public BigBong(Class<BigBang> antitype, Minkowski key, Spacetime value) {
		super(Meson.class, Hypermeson.class, BigBong.class, antitype, key, value, Parity.YY);
	}
	/**
	 * @param antitype
	 * @throws Abort
	 */
	public BigBong(Class<BigBang> antitype, Minkowski key, Spacetime value, 
			ScrewDriver<Minkowski,Spacetime> parent) {
		super(Meson.class, Hypermeson.class, BigBong.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Galaxy) {
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
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof BigBong) {
			// cast source
			BigBong pair = (BigBong) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Meson(Hypermeson.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}