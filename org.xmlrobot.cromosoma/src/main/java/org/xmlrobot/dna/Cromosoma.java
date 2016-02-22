package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hyperphenotype;
import org.xmlrobot.dna.event.Synapsis;
import org.xmlrobot.dna.event.Translocation;
import org.xmlrobot.dna.matter.Phenotype;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The cromosoma implementation class. It is a map of {@link Genomap}.
 * His chain is a {@link Diploid} and the gear is {@link Allele}.
 * @author joan
 * @parity XY
 * @since 1517.1
 */
@XmlRootElement
public class Cromosoma
	extends Child<Genomap,Haploid> {

	/**
	 * 780556985094652696L
	 */
	private static final long serialVersionUID = 780556985094652696L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Genomap getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Genomap setKey(Genomap key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Haploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Haploid setValue(Haploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperphenotype.class)
	public Mass<Genomap,Haploid> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Cromosoma} default class constructor.
	 */
	public Cromosoma() {
		super(Hyperphenotype.class, Phenotype.class, Cromosoma.class, Parity.XY);
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cromosoma(Class<Diploid> antitype) {
		super(Cromosoma.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// call supermethod
		super.mass(sender, event);
		// commute order
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Allele) {
				// declare stem
				Mass<Haploid,Genomap> stem;
				// cast source
				Allele pair = (Allele) event.getSource();
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
			if(event.getSource() instanceof Allele) {
				// get antimatter
				Mass<Haploid,Genomap> key;
				// cast source
				Allele pair = (Allele) event.getSource();
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
			if(event.getSource() instanceof Genomap) {
				// cast source
				Genomap key = (Genomap) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Synapsis(key));
			}
			else if(event.getSource() instanceof Allele) {
				// cast source
				Allele pair = (Allele) event.getSource();
				// declare child
				Mass<Genomap,Haploid> child;
				// assign and check
				if((child = getChild()) != null) {
					// send message to the future
					child.pulse(this, new Translocation(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Allele) {
				// declare stem
				Mass<Haploid,Genomap> stem;
				// cast source
				Allele pair = (Allele) event.getSource();
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
			if(event.getSource() instanceof Allele) {
				// declare stem
				Mass<Haploid,Genomap> stem;
				// cast source
				Allele pair = (Allele) event.getSource();
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
			if(event.getSource() instanceof Allele) {
				// cast source
				Allele entity = (Allele) event.getSource();
				// transfer message contents
				put(entity.getValue(), entity.getKey());
				// rip
				entity.stop(getContext());
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
	public Haploid put(Genomap key, Haploid value) {
		// create child
		BasePair pair = new BasePair(Allele.class, key, value, this);
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
				child instanceof BasePair : false) {
			// declare plasma
			Mass<Genomap,Haploid> plasma;
			// cast source
			BasePair pair = (BasePair) child;
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {
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
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
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