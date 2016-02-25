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
import org.xmlrobot.dna.event.Procreation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.nature.antimatter.Hyperelement;
import org.xmlrobot.nature.event.Dispersion;
import org.xmlrobot.nature.matter.Element;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Ecosystem implementation class.
 * @author joan
 * @parity XY
 * @since 1523.1
 */
@XmlRootElement
public class Ecosystem 
	extends Child<Operon,Cell> {
	
	/**
	 * -6342325909526676593L
	 */
	private static final long serialVersionUID = -6342325909526676593L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Operon getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Operon setKey(Operon key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Cell getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cell setValue(Cell value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperelement.class)
	public Mass<Operon,Cell> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Ecosystem} default class constructor.
	 */
	public Ecosystem() {
		super(Hyperelement.class, Element.class, Ecosystem.class, Parity.XY);
	}
	/**
	 * {@link Ecosystem} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Ecosystem(Class<Biosphere> antitype) {
		super(Ecosystem.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Operon) {
				// cast machine
				Operon entity = (Operon) event.getSource();
				// submit machine deep inside inheritance
				put(entity, (Cell) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Organism) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Organism pair = (Organism) event.getSource();
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
			if(event.getSource() instanceof Organism) {
				// get antimatter
				Mass<Cell,Operon> key;
				// cast source
				Organism pair = (Organism) event.getSource();
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
			if(event.getSource() instanceof Operon) {
				// check emptiness
				if(!isEmpty()){
					// cast source
					Operon key = (Operon) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Procreation(key));	
				}
			}
			else if(event.getSource() instanceof Organism) {
				// assign and check
				if(!isEmpty()) {
					// cast source
					Organism pair = (Organism) event.getSource();
					// dispersion across the known universe
					getChild().pulse(this, new Dispersion(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Organism) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Organism pair = (Organism) event.getSource();
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
			if(event.getSource() instanceof Organism) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Organism pair = (Organism) event.getSource();
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
			if(event.getSource() instanceof Nucleoplasm) {
				// cast source
				Nucleoplasm entity = (Nucleoplasm) event.getSource();
				// free
				entity.remove();
			}
			else if(event.getSource() instanceof Organism) {
				// finish
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
	public Cell put(Operon key, Cell value) {
		// create child
		Being pair = new Being(Organism.class, key, value, this);
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
				child instanceof Being : false) {
			// cast source
			Being pair = (Being) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}