/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperelement;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Homogenization;
import org.xmlrobot.event.Reproduction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Element;
import org.xmlrobot.Cell;
import org.xmlrobot.Cytoplasm;
import org.xmlrobot.Operon;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Biosphere 
	extends ScrewNut<Cell,Operon> {

	/**
	 * 1440721915804238929L
	 */
	private static final long serialVersionUID = 1440721915804238929L;
	
	/**
	 * {@link Biosphere} default class constructor.
	 */
	public Biosphere() {
		
		super(Element.class, Hyperelement.class, Biosphere.class);
	}
	/**
	 * {@link Biosphere} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Biosphere(Class<Ecosystem> antitype) {
		
		super(Element.class, Hyperelement.class, Biosphere.class, antitype);
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
				// begin
				event.start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Cell) {
				// cast source
				Cell key = (Cell) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Reproduction(key));
			}
			else if(event.getSource() instanceof Being) {
				// cast source
				Being pair = (Being) event.getSource();
				// declare child
				Mass<Cell,Operon> child;
				// assign and check
				if((child = getChild()) != null) {
					// be careful
					child.pulse(this, new Homogenization(pair));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Being) {
				// end
				event.stop(context());
			}
			else if(event.getSource() instanceof Cytoplasm) {
				// cast
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// free
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
	public Operon putValue(Cell key, Operon value) {
		// declare child
		Mass<Cell,Operon> child;
		// declare old value
		Operon oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? child.putValue(key,
				value) : null) == null) {
			// create child
			Organism pair = new Organism(Being.class, key, value, this);
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
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}