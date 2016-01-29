/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperexon;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.event.Instant;
import org.xmlrobot.event.Transmission;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Exon;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.Hyperentry;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Genomap 
	extends Screw<Hypercube,Hyperchain> {

	/**
	 * -1116284261599707252L
	 */
	private static final long serialVersionUID = -1116284261599707252L;

	/**
	 * {@link Genomap} default class constructor.
	 */
	public Genomap() {
		
		super(Hyperexon.class, Exon.class, Genomap.class);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Genomap(Class<Haploid> antitype) {
		
		super(Hyperexon.class, Exon.class, Genomap.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Gamete) {
				// give her the universe
				event.getSource().start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Hypercube) {
				// cast source
				Hypercube key = (Hypercube) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Instant(key));
			}
			else if(event.getSource() instanceof Gamete) {
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// declare child
				Mass<Hypercube,Hyperchain> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Transmission(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Gamete) {
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// free from inheritance
				pair.stop(context());
			}
			else if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry gear = (Hyperentry) event.getSource();
				// get free
				gear.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener, Takion<Y,X> event) {
		// call ancestral method
		super.pulse(listener, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#put(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Hyperchain putValue(Hypercube key, Hyperchain value) {
		// declare child
		Mass<Hypercube,Hyperchain> child;
		// declare old value
		Hyperchain oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Gene pair = new Gene(Gamete.class, key, value, this);
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
		// message transfer
		push(Command.TRANSFER);
	}
	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}
}