/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperexon;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Flop;
import org.xmlrobot.event.Hypergenesis;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Exon;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.Hyperpair;
import org.xmlrobot.util.Command;

/**
 * {@link Gene} chain class.
 * @author joan
 *
 */
@XmlRootElement
public class Haploid 
	extends ScrewNut<Hyperchain,Hypercube> {

	/**
	 * -9119555421755471045L
	 */
	private static final long serialVersionUID = -9119555421755471045L;

	/**
	 * {@link Haploid} default class constructor.
	 */
	public Haploid() {
		
		super(Exon.class, Hyperexon.class, Haploid.class);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Haploid(Class<Genomap> antitype) {
		
		super(Exon.class, Hyperexon.class, Haploid.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		// commute entity's command
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Gene) {
				// give her the universe
				event.getSource().start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Hyperchain) {
				// cast source
				Hyperchain key = (Hyperchain) event.getSource();
				Hypercube value;
				// assign and check
				if((value = getValue()) != null) {
					// pulse to the future
					value.pulse(this, new Flop(key));	
				}
			}
			else if(event.getSource() instanceof Gene) {
				// cast source
				Gene pair = (Gene) event.getSource();
				// declare child
				Mass<Hyperchain,Hypercube> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Hypergenesis(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Gene) {
				// cast
				Gene pair = (Gene) event.getSource();
				// free
				pair.stop(context());
			}
			else if(event.getSource() instanceof Hyperpair) {
				
				Hyperpair pair = (Hyperpair) event.getSource();
				// rip
				pair.remove();
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
	public Hypercube putValue(Hyperchain key, Hypercube value) {
		// declare child
		Mass<Hyperchain,Hypercube> child;
		// declare old value
		Hypercube oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) 
				: null) == null) {
			// create child
			Gamete pair = new Gamete(Gene.class, key, value, this);
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
		// message transfer
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}