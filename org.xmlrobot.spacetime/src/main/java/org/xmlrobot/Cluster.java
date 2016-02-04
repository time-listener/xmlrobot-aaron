/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperlepton;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Lepton;
import org.xmlrobot.Capricornus;
import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 * @parity XY
 *
 */
@XmlRootElement
public class Cluster 
	extends ScrewDriver<Fornax,Columbia> {

	/**
	 * 2984591194160886042L
	 */
	private static final long serialVersionUID = 2984591194160886042L;

	/**
	 * {@link Cluster} default class constructor.
	 */
	public Cluster() {
		super(Hyperlepton.class, Lepton.class, Cluster.class, Parity.XY);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	public Cluster(Fornax key, Columbia value, ScrewDriver<Fornax,Columbia> parent) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, key, value, parent);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cluster(Class<Galaxy> antitype) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, antitype, Parity.XY);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 * @param parent {@link ScrewDriver} the parent
	 */
	public Cluster(Class<Galaxy> antitype, Fornax key, Columbia value, ScrewDriver<Fornax,Columbia> parent) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Capricornus) {
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
				// make pair free
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
		
		if(source instanceof Cluster) {
			// cast source
			Cluster pair = (Cluster) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hyperlepton(Lepton.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}
