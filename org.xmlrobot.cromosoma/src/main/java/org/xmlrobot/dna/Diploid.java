/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hyperphenotype;
import org.xmlrobot.dna.event.Transfix;
import org.xmlrobot.dna.event.Transmission;
import org.xmlrobot.dna.matter.Phenotype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Diploid implementation class.
 * @author joan
 * @parity XX
 * @since 1517.2
 */
@XmlRootElement
public class Diploid 
	extends Child<Haploid,Genomap> {

	/**
	 * 1603750231206900779L
	 */
	private static final long serialVersionUID = 1603750231206900779L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Haploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Haploid setKey(Haploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Genomap getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Genomap setValue(Genomap value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Phenotype.class)
	public Mass<Haploid,Genomap> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Diploid} default class constructor.
	 */
	public Diploid() {
		super(Phenotype.class, Hyperphenotype.class, Diploid.class, Parity.XX);
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Diploid(Class<Cromosoma> antitype) {
		super(Diploid.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// call ancestral method
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Haploid) {
				// cast source
				Haploid entity = (Haploid) event.getSource();
				// eat
				put(entity, (Genomap) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof BasePair) {
				// declare stem
				Mass<Genomap,Haploid> stem;
				// cast source
				BasePair pair = (BasePair) event.getSource();
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
			if(event.getSource() instanceof BasePair) {
				// get antimatter
				Mass<Genomap,Haploid> stem;
				// cast source
				BasePair pair = (BasePair) event.getSource();
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
			if(event.getSource() instanceof Haploid) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Haploid key = (Haploid) event.getSource();
					// send pulse to child's value
					getValue().pulse(this, new Transmission(key));	
				}
			}
			else if(event.getSource() instanceof BasePair) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					BasePair pair = (BasePair) event.getSource();
					// send message to the future
					getChild().pulse(this, new Transfix(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof BasePair) {
				// declare stem
				Mass<Genomap,Haploid> stem;
				// cast source
				BasePair pair = (BasePair) event.getSource();
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
			if(event.getSource() instanceof BasePair) {
				// declare stem
				Mass<Genomap,Haploid> stem;
				// cast source
				BasePair pair = (BasePair) event.getSource();
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
				Gene pair = (Gene) event.getSource();
				// rest in peace
				pair.remove();
			}
			else if(event.getSource() instanceof BasePair) {
				// see you next life
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
	public Genomap put(Haploid key, Genomap value) {
		// create child
		Allele pair = new Allele(BasePair.class, key, value, this);
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
				child instanceof Allele : false) {
			// cast source
			Allele pair = (Allele) child;
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putValue(pair.getKey(), pair.getValue());
			} 
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}