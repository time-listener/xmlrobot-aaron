/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperhiggs;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Compression;
import org.xmlrobot.event.Revolution;
import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.Virgo;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Higgs;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Columbia
	extends ScrewNut<Andromeda,MilkyWay> {

	/**
	 * 7104570102230102161L
	 */
	private static final long serialVersionUID = 7104570102230102161L;

	/**
	 * {@link Columbia} default class constructor.
	 */
	public Columbia() {
		
		super(Higgs.class, Hyperhiggs.class, Columbia.class);
	}
	/**
	 * {@link Columbia} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Columbia(Class<Fornax> antitype) {
		
		super(Higgs.class, Hyperhiggs.class, Columbia.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Capricornus) {
				// tick
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Andromeda) {
				// cast source
				Andromeda key = (Andromeda) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Revolution(key));
			}
			else if(event.getSource() instanceof Capricornus) {
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
				// declare child
				Mass<Andromeda,MilkyWay> child;
				// call
				if((child = getChild()) != null) {
					// send pulse to the future
					child.pulse(this, new Compression(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Capricornus) {
				// tack
				event.stop(context());
			}
			else if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
	public MilkyWay putValue(Andromeda key, MilkyWay value) {
		// declare child
		Mass<Andromeda, MilkyWay> child;
		// declare old value
		MilkyWay oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? child.putValue(key,
				value) : null) == null) {
			// create child
			Perseus pair = new Perseus(Capricornus.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}
