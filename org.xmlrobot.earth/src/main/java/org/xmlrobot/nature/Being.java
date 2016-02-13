/**
 * 
 */
package org.xmlrobot.nature;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Cytoplasm;
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
 * Being implementation class.
 * @author joan
 * @parity XY
 * @since 1524.1
 */
@XmlRootElement
public class Being 
	extends Parent<Operon,Cell> {

	/**
	 * -2219408315913205280L
	 */
	private static final long serialVersionUID = -2219408315913205280L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Operon getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Operon setKey(Operon key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Cell getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cell setValue(Cell value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperatom.class)
	public Mass<Operon,Cell> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Being} default class constructor.
	 */
	public Being() {
		super(Hyperatom.class, Atom.class, Being.class, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Ecosystem} the parent
	 */
	public Being(Operon key, Cell value) {
		super(Hyperatom.class, Atom.class, Being.class, key, value, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Ecosystem} the parent
	 */
	public Being(Operon key, Cell value, Ecosystem parent) {
		super(Hyperatom.class, Atom.class, Being.class, key, value, parent);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Being(Class<Organism> antitype) {
		super(Hyperatom.class, Atom.class, Being.class, antitype, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 */
	public Being(Class<Organism> antitype, Operon key, Cell value) {
		super(Hyperatom.class, Atom.class, Being.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Ecosystem} the parent
	 */
	public Being(Class<Organism> antitype, Operon key, Cell value, Ecosystem parent) {
		super(Hyperatom.class, Atom.class, Being.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Cytoplasm) {
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
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Being : false) {
			// cast source
			Being pair = (Being) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hyperatom(Atom.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}