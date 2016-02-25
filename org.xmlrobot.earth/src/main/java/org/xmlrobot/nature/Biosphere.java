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
import org.xmlrobot.dna.event.Reproduction;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.nature.antimatter.Hyperelement;
import org.xmlrobot.nature.event.Homogenization;
import org.xmlrobot.nature.matter.Element;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Biosphere implementation class.
 * @author joan
 * @parity XX
 * @since 1523.2
 */
@XmlRootElement
public class Biosphere 
	extends Child<Cell,Operon> {

	/**
	 * 1440721915804238929L
	 */
	private static final long serialVersionUID = 1440721915804238929L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Cell getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cell setKey(Cell key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Operon getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Operon setValue(Operon value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Element.class)
	public Mass<Cell,Operon> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Biosphere} default class constructor.
	 */
	public Biosphere() {
		super(Element.class, Hyperelement.class, Biosphere.class, Parity.XX);
	}
	/**
	 * {@link Biosphere} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Biosphere(Class<Ecosystem> antitype) {
		super(Biosphere.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Cell) {
				// cast animal
				Cell entity = (Cell) event.getSource();
				// natural order injection
				put(entity, (Operon) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Being) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Being pair = (Being) event.getSource();
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
		case SEND:
			if(event.getSource() instanceof Being) {
				// get antimatter
				Mass<Operon,Cell> key;
				// cast source
				Being pair = (Being) event.getSource();
				// check if empty and chained
				if((key = get()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Cell) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Cell key = (Cell) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Reproduction(key));					
				}
			}
			else if(event.getSource() instanceof Being) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Being pair = (Being) event.getSource();
					// be careful
					getChild().pulse(this, new Homogenization(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Being) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Being pair = (Being) event.getSource();
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
			if(event.getSource() instanceof Being) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Being pair = (Being) event.getSource();
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
				// cast
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// free
				pair.remove();
			}
			else if(event.getSource() instanceof Being) {
				// stop
				event.stop(getContext());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#put(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Operon put(Cell key, Operon value) {
		// create child
		Organism pair = new Organism(Being.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
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
			if (event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putKey(pair.getValue(), pair.getKey());
			}
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByValue(pair.getValue());
			}
		}
	}
}