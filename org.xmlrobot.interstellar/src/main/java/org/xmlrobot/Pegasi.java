/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Jupiter;
import org.xmlrobot.Mars;
import org.xmlrobot.Saturn;
import org.xmlrobot.antimatter.Hypergluon;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Gluon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * 51 Pegasi.
 *  
 * @author joan
 *
 */
@XmlRootElement
public class Pegasi 
	extends ScrewDriver<Jupiter,Saturn> {

	/**
	 * 8604727878873857518L
	 */
	private static final long serialVersionUID = 8604727878873857518L;
	
	/**
	 * {@link Pegasi} default class constructor.
	 */
	public Pegasi() {
		super(Hypergluon.class, Gluon.class, Pegasi.class, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Screw<Jupiter,Saturn>} the parent
	 */
	public Pegasi(Jupiter key, Saturn value, Screw<Jupiter,Saturn> parent) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, key, value, parent);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Pegasi(Class<Vega> antitype) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, antitype, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Screw<Jupiter,Saturn>} the parent
	 */
	public Pegasi(Class<Vega> antitype, Jupiter key, Saturn value, 
			Screw<Jupiter,Saturn> parent) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Mars) {
				// cast source
				Mars pair = (Mars) event.getSource();
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
		
		if(source instanceof Pegasi) {
			// cast source
			Pegasi pair = (Pegasi) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hypergluon(Gluon.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}