/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Gene;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hypertype;
import org.xmlrobot.dna.matter.Karyotype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Base pair implementation class.
 * @author joan
 * @parity XY
 * @since 1518.1
 */
@XmlRootElement
public class BasePair 
	extends Parent<Genomap,Haploid> {

	/**
	 * -7944087613705943766L
	 */
	private static final long serialVersionUID = -7944087613705943766L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Genomap getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Genomap setKey(Genomap key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Haploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Haploid setValue(Haploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypertype.class)
	public Mass<Genomap,Haploid> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link BasePair} default class constructor.
	 */
	public BasePair() {
		super(Hypertype.class, Karyotype.class, BasePair.class, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public BasePair(Genomap key, Haploid value) {
		super(Hypertype.class, Karyotype.class, BasePair.class, key, value, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Cromosoma} the parent
	 */
	public BasePair(Genomap key, Haploid value, Cromosoma parent) {
		super(Hypertype.class, Karyotype.class, BasePair.class, key, value, parent);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 */
	public BasePair(Class<Allele> antitype) {
		super(Hypertype.class, Karyotype.class, BasePair.class, antitype, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public BasePair(Class<Allele> antitype, Genomap key, Haploid value) {
		super(Hypertype.class, Karyotype.class, BasePair.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Cromosoma} the parent
	 */
	public BasePair(Class<Allele> antitype, Genomap key, Haploid value, Cromosoma parent) {
		super(Hypertype.class, Karyotype.class, BasePair.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Gene) {
				// cast source
				Gene pair = (Gene) event.getSource();
				// rest in peace
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#run()
	 */
	@Override
	public void run() {
		// do genesis
		super.run();
		// rest in peace
		push(Command.TRANSFER);
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
				child instanceof BasePair : false) {
			// cast source
			BasePair pair = (BasePair) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hypertype(Karyotype.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}