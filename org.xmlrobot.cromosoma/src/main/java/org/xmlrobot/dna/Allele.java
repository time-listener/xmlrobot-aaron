/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Gamete;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hypertype;
import org.xmlrobot.dna.matter.Karyotype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Allele implementation class.
 * @author joan
 * @parity XX
 * @since 1518.2
 */
@XmlRootElement
public class Allele 
	extends Parent<Haploid,Genomap> {

	/**
	 * -119308544852621745L
	 */
	private static final long serialVersionUID = -119308544852621745L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Haploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Haploid setKey(Haploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Genomap getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Genomap setValue(Genomap value) {
		return super.setValue(value);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Karyotype.class)
	public Mass<Haploid,Genomap> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Allele} default class constructor.
	 */
	public Allele() {
		super(Karyotype.class, Hypertype.class, Allele.class, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Allele(Haploid key, Genomap value) {
		super(Karyotype.class, Hypertype.class, Allele.class, key, value, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link Diploid} the parent
	 */
	public Allele(Haploid key, Genomap value, Diploid parent) {
		super(Karyotype.class, Hypertype.class, Allele.class, key, value, parent);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Allele(Class<BasePair> antitype) {
		super(Karyotype.class, Hypertype.class, Allele.class, antitype, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Allele(Class<BasePair> antitype, Haploid key, Genomap value) {
		super(Karyotype.class, Hypertype.class, Allele.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link Diploid} the parent
	 */
	public Allele(Class<BasePair> antitype, Haploid key, Genomap value, Diploid parent) {
		super(Karyotype.class, Hypertype.class, Allele.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	public void mass(TimeListener<?,?> sender, Takion<?,?> event) {
		
		super.mass(sender, event);
		// commute event's command
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Gamete) {
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// free from inheritance
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
				child instanceof Allele : false) {
			// cast source
			Allele pair = (Allele) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Karyotype(Hypertype.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}