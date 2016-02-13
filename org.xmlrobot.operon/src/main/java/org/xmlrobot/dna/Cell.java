/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.dna.antimatter.Adam;
import org.xmlrobot.dna.event.Mitosis;
import org.xmlrobot.dna.event.Procreation;
import org.xmlrobot.dna.matter.Eva;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;

/**
 * Stem cell implementation class.
 * @author joan
 * @parity XX
 * @since 1521.2
 */
@XmlRootElement
public class Cell 
	extends Child<Tetraploid,Ribosoma> {

	/**
	 * 4563541624913178342L
	 */
	private static final long serialVersionUID = 4563541624913178342L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getKey()
	 */
	@Override
	@XmlElement
	public Tetraploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tetraploid setKey(Tetraploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getValue()
	 */
	@Override
	@XmlElement
	public Ribosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ribosoma setValue(Ribosoma value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Eva.class)
	public Mass<Tetraploid,Ribosoma> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Cell} default class constructor.
	 */
	public Cell() {
		super(Eva.class, Adam.class, Cell.class);
	}
	/**
	 * {@link Cell} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cell(Class<Operon> antitype) {
		super(Eva.class, Adam.class, Cell.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Cytoplasm) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// release child
					stem.order(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Cytoplasm) {
				// get antimatter
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					stem.add(pair);
				}
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Tetraploid) {
				// cast source
				Tetraploid key = (Tetraploid) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Mitosis(key));
			}
			else if(event.getSource() instanceof Cytoplasm) {
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// declare child
				Mass<Tetraploid,Ribosoma> child;
				// assign and check
				if((child = getChild()) != null) {
					// procreate, now
					child.pulse(this, new Procreation(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Cytoplasm) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								stem.contains(pair) 
								: false
						: false) {
					// release child
					stem.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Cytoplasm) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.submit(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Cytoplasm) {
				// cast source
				Cytoplasm entity = (Cytoplasm) event.getSource();
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
	public Ribosoma put(Tetraploid key, Ribosoma value) {
		// declare child
		Mass<Tetraploid,Ribosoma> child;
		// declare old value
		Ribosoma oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Nucleoplasm pair = new Nucleoplasm(Cytoplasm.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
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
				child instanceof Nucleoplasm : false) {
			// cast source
			Nucleoplasm pair = (Nucleoplasm) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}