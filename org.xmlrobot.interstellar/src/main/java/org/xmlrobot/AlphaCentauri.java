/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.antimatter.Hyperphoton;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Repulsion;
import org.xmlrobot.event.Impact;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Photon;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class AlphaCentauri 
	extends ScrewNut<Saturn,Jupiter> {

	/**
	 * -6537944481620207658L
	 */
	private static final long serialVersionUID = -6537944481620207658L;

	/**
	 * {@link AlphaCentauri} default class constructor.
	 */
	public AlphaCentauri() {
		
		super(Photon.class, Hyperphoton.class, AlphaCentauri.class);
	}
	/**
	 * {@link AlphaCentauri} class constructor.
	 * @param antitype the inherited antitype
	 */
	public AlphaCentauri(Class<Sun> antitype) {
		
		super(Photon.class, Hyperphoton.class, AlphaCentauri.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {

		super.mass(sender, event);
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Pegasi) {
				// get antimatter
				Mass<Jupiter,Saturn> key;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
				// check if empty and chained
				if((key = get()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Saturn) {
				// cast source
				Saturn key = (Saturn) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Impact(key));
			}
			else if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
				// declare child
				Mass<Saturn,Jupiter> child;
				// call child
				if((child = getChild()) != null) {
					// antigravity
					child.pulse(this, new Repulsion(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi entity = (Pegasi) event.getSource();
				// transfer message contents
				get().putValue(entity.getKey(), entity.getValue());
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
	public Jupiter putValue(Saturn key, Jupiter value) {
		// declare child
		Mass<Saturn,Jupiter> child;
		// declare old value
		Jupiter oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Vega pair = new Vega(Pegasi.class, key, value, this);
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
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Vega) {
			// cast source
			Vega pair = (Vega) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}