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
import org.xmlrobot.dna.event.Meiosis;
import org.xmlrobot.dna.event.Reproduction;
import org.xmlrobot.dna.matter.Eva;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Operon implementation class.
 * @author joan
 * @parity XY
 * @since 1521.1
 */
@XmlRootElement
public class Operon
	extends Child<Ribosoma,Tetraploid> {

	/**
	 * -5111668034670593344L
	 */
	private static final long serialVersionUID = -5111668034670593344L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Ribosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ribosoma setKey(Ribosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Tetraploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tetraploid setValue(Tetraploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Adam.class)
	public Mass<Ribosoma,Tetraploid> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Operon} default class constructor.
	 */
	public Operon() {
		super(Adam.class, Eva.class, Operon.class, Parity.XY);
	}
	/**
	 * {@link Operon} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Operon(Class<Cell> antitype) {
		super(Operon.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		// operate
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Nucleoplasm) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
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
			if(event.getSource() instanceof Nucleoplasm) {
				// get antimatter
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
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
			if(event.getSource() instanceof Ribosoma) {
				// cast source
				Ribosoma key = (Ribosoma) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Meiosis(key));
			}
			else if(event.getSource() instanceof Nucleoplasm) {
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
				// declare child
				Mass<Ribosoma,Tetraploid> child;
				// assign and check
				if((child = getChild()) != null) {
					// reproduce yourselves!
					child.pulse(this, new Reproduction(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Nucleoplasm) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
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
			if(event.getSource() instanceof Nucleoplasm) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Nucleoplasm pair = (Nucleoplasm) event.getSource();
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
	public Tetraploid put(Ribosoma key, Tetraploid value) {
		// create child
		Cytoplasm pair = new Cytoplasm(Nucleoplasm.class, key, value, this);
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
				child instanceof Cytoplasm : false) {
			// declare plasma
			Mass<Ribosoma,Tetraploid> plasma;
			// cast source
			Cytoplasm pair = (Cytoplasm) child;
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