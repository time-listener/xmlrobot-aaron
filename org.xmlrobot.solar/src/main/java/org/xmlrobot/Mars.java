/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypermetal;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.Being;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.Biosphere;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Metal;
import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Mars 
	extends ScrewDriver<Ecosystem,Biosphere> {

	/**
	 * 5496849604846314737L
	 */
	private static final long serialVersionUID = 5496849604846314737L;

	/**
	 * {@link Mars} default class constructor.
	 */
	public Mars() {
		super(Hypermetal.class, Metal.class, Mars.class, Parity.XY);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Screw<Ecosystem,Biosphere>} the parent
	 */
	public Mars(Ecosystem key, Biosphere value,	
			Screw<Ecosystem,Biosphere> parent) {
		super(Hypermetal.class, Metal.class, Mars.class, key, value, parent);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Mars(Class<Earth> antitype) {
		super(Hypermetal.class, Metal.class, Mars.class, antitype, Parity.XY);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Screw<Ecosystem,Biosphere>} the parent
	 */
	public Mars(Class<Earth> antitype, Ecosystem key, Biosphere value, 
			Screw<Ecosystem,Biosphere> parent) {
		super(Hypermetal.class, Metal.class, Mars.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Being) {
				// get antimatter
				ScrewDriver<Operon,Cell> key;
				// cast source
				Being pair = (Being) event.getSource();
				// check if empty and chained
				if((key = getKey()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Being) {
				// cast source
				Being entity = (Being) event.getSource();
				// transfer message contents
				getValue().putValue(entity.getValue(), entity.getKey());
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
		// rip
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}
