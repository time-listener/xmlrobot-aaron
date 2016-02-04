package org.xmlrobot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperintron;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Intron;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.Hyperpair;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Gene 
	extends ScrewDriver<Hypercube,Hyperchain> {

	/**
	 * -5629666980191745088L
	 */
	private static final long serialVersionUID = -5629666980191745088L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Hypercube getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void setKey(Hypercube key) {
		super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Hyperchain getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void setValue(Hyperchain value) {
		super.setValue(value);
	}
	/**
	 * {@link Gene} default class constructor.
	 */
	public Gene() {
		super(Hyperintron.class, Intron.class, Gene.class, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Hypercube key, Hyperchain value, Genomap parent) {
		super(Hyperintron.class, Intron.class, Gene.class, key, value, parent);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype) {
		super(Hyperintron.class, Intron.class, Gene.class, antitype, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype, Hypercube key, Hyperchain value) {
		super(Hyperintron.class, Intron.class, Gene.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype, Hypercube key, Hyperchain value, Genomap parent) {
		super(Hyperintron.class, Intron.class, Gene.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Hyperpair) {
				// cast source
				Hyperpair pair = (Hyperpair) event.getSource();
				// remove from hyperspace
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
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Gene) {
			// cast source
			Gene pair = (Gene) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hyperintron(Intron.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}