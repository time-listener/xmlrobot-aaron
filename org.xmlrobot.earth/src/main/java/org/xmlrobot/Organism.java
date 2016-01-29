/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Ribosoma;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.antimatter.Hyperatom;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Atom;
import org.xmlrobot.Cell;
import org.xmlrobot.Nucleoplasm;
import org.xmlrobot.Operon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Organism 
	extends ScrewDriver<Cell,Operon> {

	/**
	 * -7117477549689157202L
	 */
	private static final long serialVersionUID = -7117477549689157202L;
	
	/**
	 * {@link Organism} default class constructor.
	 */
	public Organism() {
		super(Atom.class, Hyperatom.class, Organism.class, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link ScrewNut<Cell,Operon>} the parent
	 */
	public Organism(Cell key, Operon value, ScrewNut<Cell,Operon> parent) {
		super(Atom.class, Hyperatom.class, Organism.class, key, value, parent);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Organism(Class<Being> antitype) {
		super(Atom.class, Hyperatom.class, Organism.class, antitype, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link ScrewNut<Cell,Operon>} the parent
	 */
	public Organism(Class<Being> antitype, Cell key, Operon value, 
			ScrewNut<Cell,Operon> parent) {
		super(Atom.class, Hyperatom.class, Organism.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Nucleoplasm) {
				// get antimatter
				ScrewDriver<Tetraploid,Ribosoma> key;
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
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
			if(event.getSource() instanceof Nucleoplasm) {
				// cast source
				Nucleoplasm entity = (Nucleoplasm) event.getSource();
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
		// rest in peace
		push(Command.TRANSFER);
	}
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}
