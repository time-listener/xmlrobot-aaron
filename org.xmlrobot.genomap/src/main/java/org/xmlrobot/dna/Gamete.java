/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.antimatter.Hyperintron;
import org.xmlrobot.dna.matter.Intron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.subspace.Hyperentry;
import org.xmlrobot.util.Parity;

/**
 * Gamete implementation class.
 * @author joan
 * @parity XX
 * @since 1516.2
 */
@XmlRootElement
public class Gamete 
	extends Parent<Hyperchain,Hypercube> {

	/**
	 * 6313328582512099749L
	 */
	private static final long serialVersionUID = 6313328582512099749L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Hyperchain getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hyperchain setKey(Hyperchain key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Hypercube getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hypercube setValue(Hypercube value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Intron.class)
	public Mass<Hyperchain,Hypercube> getReplicator() {
		return super.getReplicator();
	}
	/**
	 * {@link Gamete} default class constructor.
	 */
	public Gamete() {
		super(Intron.class, Hyperintron.class, Gamete.class, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Hyperchain key, Hypercube value) {
		super(Intron.class, Hyperintron.class, Gamete.class, key, value, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Hyperchain key, Hypercube value, Haploid parent) {
		super(Intron.class, Hyperintron.class, Gamete.class, key, value, parent);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Class<Gene> antitype) {
		super(Intron.class, Hyperintron.class, Gamete.class, antitype, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Class<Gene> antitype, Hyperchain key, Hypercube value) {
		super(Intron.class, Hyperintron.class, Gamete.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Class<Gene> antitype, Hyperchain key, Hypercube value, Haploid  parent) {
		super(Intron.class, Hyperintron.class, Gamete.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry gear = (Hyperentry) event.getSource();
				// get free
				gear.remove();
			}
			break;
		default:
			break;
		}
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
				child instanceof Gamete : false) {
			// cast source
			Gamete pair = (Gamete) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Intron(Hyperintron.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}