/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.antimatter.Hyperdna;
import org.xmlrobot.dna.event.Meiosis;
import org.xmlrobot.dna.event.Translocation;
import org.xmlrobot.dna.matter.Dna;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;

/**
 * Tetraploid implementation class.
 * @author joan
 * @parity XX
 * @since 1519.2
 */
@XmlRootElement
public class Tetraploid
	extends Child<Diploid,Cromosoma> {

	/**
	 * 6764168527555084043L
	 */
	private static final long serialVersionUID = 6764168527555084043L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getKey()
	 */
	@Override
	@XmlElement
	public Diploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Diploid setKey(Diploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#getValue()
	 */
	@Override
	@XmlElement
	public Cromosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cromosoma setValue(Cromosoma value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Dna.class)
	public Mass<Diploid,Cromosoma> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Tetraploid} default class constructor.
	 */
	public Tetraploid() {
		super(Dna.class, Hyperdna.class, Tetraploid.class);
	}
	/**
	 * {@link Tetraploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Tetraploid(Class<Ribosoma> antitype) {
		super(Dna.class, Hyperdna.class, Tetraploid.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Groove) {
				// declare stem
				Mass<Cromosoma,Diploid> stem;
				// cast source
				Groove pair = (Groove) event.getSource();
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
			if(event.getSource() instanceof Groove) {
				// get antimatter
				Mass<Cromosoma,Diploid> stem;
				// cast source
				Groove pair = (Groove) event.getSource();
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
			if(event.getSource() instanceof Diploid) {
				// cast source
				Diploid key = (Diploid) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Translocation(key));
			}
			else if(event.getSource() instanceof Groove) {
				// cast source
				Groove pair = (Groove) event.getSource();
				// declare child
				Mass<Diploid,Cromosoma> child;
				// assign and check
				if((child = getChild()) != null) {
					// start mitosis
					child.pulse(this, new Meiosis(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Groove) {
				// declare stem
				Mass<Cromosoma,Diploid> stem;
				// cast source
				Groove pair = (Groove) event.getSource();
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
			if(event.getSource() instanceof Groove) {
				// declare stem
				Mass<Cromosoma,Diploid> stem;
				// cast source
				Groove pair = (Groove) event.getSource();
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
			if(event.getSource() instanceof Groove) {
				// cast source
				Groove entity = (Groove) event.getSource();
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
	public Cromosoma put(Diploid key, Cromosoma value) {
		// declare child
		Mass<Diploid,Cromosoma> child;
		// declare old value
		Cromosoma oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Plasmid pair = new Plasmid(Groove.class, key, value, this);
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
				child instanceof Plasmid : false) {
			// cast source
			Plasmid pair = (Plasmid) child;
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