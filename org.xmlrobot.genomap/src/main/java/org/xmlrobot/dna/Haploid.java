/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.antimatter.Hyperexon;
import org.xmlrobot.dna.event.Synapsis;
import org.xmlrobot.dna.matter.Exon;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.subspace.event.Flop;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Haploid implementation class.
 * @author joan
 * @parity XX
 * @since 1515.2
 */
@XmlRootElement
public class Haploid
	extends Child<Hyperchain,Hypercube> {

	/**
	 * -9119555421755471045L
	 */
	private static final long serialVersionUID = -9119555421755471045L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Hyperchain getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hyperchain setKey(Hyperchain key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Hypercube getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hypercube setValue(Hypercube value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Exon.class)
	public Mass<Hyperchain,Hypercube> getPlasma() {

		return super.getPlasma();
	}
	/**
	 * {@link Haploid} default class constructor.
	 */
	public Haploid() {
		super(Exon.class, Hyperexon.class, Haploid.class, Parity.XX);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Haploid(Class<Genomap> antitype) {
		super(Haploid.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// call ancestral method
		super.mass(sender, event);
		// commute entity's command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Gene pair = (Gene) event.getSource();
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
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// declare and assign pair source
				Gene pair = (Gene) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ?
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true  
							: false) {
					// push child
					stem.add(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Hyperchain) {
				// cast source
				Hyperchain key = (Hyperchain) event.getSource();
				Hypercube value;
				// assign and check
				if((value = getValue()) != null) {
					// pulse to the future
					value.pulse(this, new Flop(key));	
				}
			}
			else if(event.getSource() instanceof Gene) {
				// cast source
				Gene pair = (Gene) event.getSource();
				// declare child
				Mass<Hyperchain,Hypercube> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Synapsis(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Gene pair = (Gene) event.getSource();
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
			if(event.getSource() instanceof Gene) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Gene pair = (Gene) event.getSource();
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
			if(event.getSource() instanceof Gene) {
				// cast source
				Gene entity = (Gene) event.getSource();
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
	public Hypercube put(Hyperchain key, Hypercube value) {
		// create child
		Gamete pair = new Gamete(Gene.class, key, value, this);
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
				child instanceof Gamete : false) {
			// declare plasma
			Mass<Hyperchain,Hypercube> plasma;
			// cast source
			Gamete pair = (Gamete) child;
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