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
import org.xmlrobot.subspace.Hyperpair;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Gene implementation class.
 * @author joan
 * @parity XY
 * @since 1516.1
 */
@XmlRootElement
public class Gene 
	extends Parent<Hypercube,Hyperchain> {

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
	public Hypercube setKey(Hypercube key) {
		return super.setKey(key);
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
	public Hyperchain setValue(Hyperchain value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperintron.class)
	public Mass<Hypercube,Hyperchain> getReplicator() {
		return super.getReplicator();
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
	 */
	public Gene(Hypercube key, Hyperchain value) {
		super(Hyperintron.class, Intron.class, Gene.class, key, value, Parity.XY);
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
		// avoid concurrent calls to run
		if (!message.compareAndSet(RUNNER, null, Thread.currentThread())) {
			// because is already running
			return;
		} 
		else {
			// life starts here
			super.run();
			// life ends here
			push(Command.TRANSFER);
		}
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
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Gene : false) {
			// cast source
			Gene pair = (Gene) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hyperintron(Intron.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}