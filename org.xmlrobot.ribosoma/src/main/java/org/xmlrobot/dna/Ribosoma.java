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
import org.xmlrobot.dna.event.Mitosis;
import org.xmlrobot.dna.event.Transfix;
import org.xmlrobot.dna.matter.Dna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Ribosoma implementation class.
 * @author joan
 * @parity XY
 * @since 1519.1
 */
@XmlRootElement
public class Ribosoma
	extends Child<Cromosoma,Diploid> {

	/**
	 * 4538358656836061534L
	 */
	private static final long serialVersionUID = 4538358656836061534L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Cromosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cromosoma setKey(Cromosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Diploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Diploid setValue(Diploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperdna.class)
	public Mass<Cromosoma,Diploid> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Ribosoma} default class constructor.
	 */
	public Ribosoma() {
		super(Hyperdna.class, Dna.class, Ribosoma.class, Parity.XY);
	}
	/**
	 * {@link Ribosoma} class constructor.
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	public Ribosoma(Class<Tetraploid> antitype) {
		super(Ribosoma.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		// commute order
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Plasmid) {
				// declare stem
				Mass<Diploid,Cromosoma> stem;
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
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
			if(event.getSource() instanceof Plasmid) {
				// get antimatter
				Mass<Diploid,Cromosoma> key;
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
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
			if(event.getSource() instanceof Cromosoma) {
				// cast source
				Cromosoma key = (Cromosoma) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Transfix(key));
			}
			else if(event.getSource() instanceof Plasmid) {
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
				// declare child
				Mass<Cromosoma,Diploid> child;
				// assign and check
				if((child = getChild()) != null) {
					// start mitosis
					child.pulse(this, new Mitosis(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Plasmid) {
				// declare stem
				Mass<Diploid,Cromosoma> stem;
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
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
			if(event.getSource() instanceof Plasmid) {
				// declare stem
				Mass<Diploid,Cromosoma> stem;
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
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
			if(event.getSource() instanceof Plasmid) {
				// cast source
				Plasmid entity = (Plasmid) event.getSource();
				// transfer message contents
				put(entity.getValue(), entity.getKey());
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
	public Diploid put(Cromosoma key, Diploid value) {
		// create child
		Groove pair = new Groove(Plasmid.class, key, value, this);
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
				child instanceof Groove : false) {
			// declare plasma
			Mass<Cromosoma,Diploid> plasma;
			// cast source
			Groove pair = (Groove) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// assign and check it's contained
				if((plasma = getPlasma()) != null ?
						!plasma.isEmpty() ?
								!plasma.containsKey(pair.getKey())
								: true
						: false) {
					// replicate mass
					plasma.putValue(pair.getKey(), pair.getValue());
				}
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// check if empty and chained
				if((plasma = getPlasma()) != null ? 
						!plasma.isEmpty() ? 
								plasma.containsValue(pair.getValue()) 
								: false
						: false) {
					// release child
					plasma.removeByKey(pair.getKey());
				}
			}
		}
	}
}