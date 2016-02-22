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
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

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
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Diploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Diploid setKey(Diploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Cromosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cromosoma setValue(Cromosoma value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Dna.class)
	public Mass<Diploid,Cromosoma> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Tetraploid} default class constructor.
	 */
	public Tetraploid() {
		super(Dna.class, Hyperdna.class, Tetraploid.class, Parity.XX);
	}
	/**
	 * {@link Tetraploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Tetraploid(Class<Ribosoma> antitype) {
		super(Tetraploid.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
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
		case SEND:
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
		case PUSH:
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
	public Cromosoma put(Diploid key, Cromosoma value) {
		// create child
		Plasmid pair = new Plasmid(Groove.class, key, value, this);
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
				child instanceof Plasmid : false) {
			// declare plasma
			Mass<Diploid,Cromosoma> plasma;
			// cast source
			Plasmid pair = (Plasmid) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// assign and check it's contained
				if((plasma = getPlasma()) != null ?
						!plasma.isEmpty() ?
								!plasma.containsValue(pair.getValue())
								: true
						: false) {
					// replicate mass
					plasma.putKey(pair.getValue(), pair.getKey());
				}
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// check if empty and chained
				if((plasma = getPlasma()) != null ? 
						!plasma.isEmpty() ? 
								plasma.containsKey(pair.getKey())
								: false
						: false) {
					// release child
					plasma.removeByValue(pair.getValue());
				}
			}
		}
	}
}