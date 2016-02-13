/**
 * 
 */
package org.xmlrobot.nature;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Nucleoplasm;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.nature.antimatter.Hyperatom;
import org.xmlrobot.nature.matter.Atom;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Organism implementation class.
 * @author joan
 * @parity XX
 * @since 1524.2
 */
@XmlRootElement
public class Organism 
	extends Parent<Cell,Operon> {

	/**
	 * -7117477549689157202L
	 */
	private static final long serialVersionUID = -7117477549689157202L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Cell getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cell setKey(Cell key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Operon getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Operon setValue(Operon value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Atom.class)
	public Mass<Cell,Operon> getReplicator() {
		return super.getReplicator();
	}
	
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
	 */
	public Organism(Cell key, Operon value) {
		super(Atom.class, Hyperatom.class, Organism.class, key, value, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link Biosphere} the parent
	 */
	public Organism(Cell key, Operon value, Biosphere parent) {
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
	 */
	public Organism(Class<Being> antitype, Cell key, Operon value) {
		super(Atom.class, Hyperatom.class, Organism.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link Biosphere} the parent
	 */
	public Organism(Class<Being> antitype, Cell key, Operon value, Biosphere parent) {
		super(Atom.class, Hyperatom.class, Organism.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Nucleoplasm) {
				// cast source
				Nucleoplasm entity = (Nucleoplasm) event.getSource();
				// free
				entity.remove();
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
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Organism : false) {
			// cast source
			Organism pair = (Organism) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Atom(Hyperatom.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}
