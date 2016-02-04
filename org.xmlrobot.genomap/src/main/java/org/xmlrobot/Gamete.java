/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperintron;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Intron;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Gamete 
	extends ScrewDriver<Hyperchain,Hypercube> {

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
	public void setKey(Hyperchain key) {
		super.setKey(key);
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
	public void setValue(Hypercube value) {
		super.setValue(value);
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
	 * @param parent {@link ScrewNut} the parent
	 */
	public Gamete(Hyperchain key, Hypercube value) {
		super(Intron.class, Hyperintron.class, Gamete.class, key, value, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Gamete(Hyperchain key, Hypercube value, Haploid parent) {
		super(Intron.class, Hyperintron.class, Gamete.class, key, value, parent);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Gamete(Class<Gene> antitype) {
		super(Intron.class, Hyperintron.class, Gamete.class, antitype, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Gamete(Class<Gene> antitype, Hyperchain key, Hypercube value) {
		super(Intron.class, Hyperintron.class, Gamete.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link ScrewNut} the parent
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
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Gamete) {
			// cast source
			Gamete pair = (Gamete) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Intron(Hyperintron.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}