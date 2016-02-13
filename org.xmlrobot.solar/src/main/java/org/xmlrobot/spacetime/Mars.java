/**
 * 
 */
package org.xmlrobot.spacetime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.nature.Being;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.spacetime.antimatter.Hypermetal;
import org.xmlrobot.spacetime.matter.Metal;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Mars implementation class.
 * @author joan
 * @parity XY
 * @since 41154.1
 */
@XmlRootElement
public class Mars 
	extends Parent<Ecosystem,Biosphere> {

	/**
	 * 5496849604846314737L
	 */
	private static final long serialVersionUID = 5496849604846314737L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Ecosystem getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ecosystem setKey(Ecosystem key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Biosphere getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Biosphere setValue(Biosphere value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypermetal.class)
	public Mass<Ecosystem,Biosphere> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Mars} default class constructor.
	 */
	public Mars() {
		super(Hypermetal.class, Metal.class, Mars.class, Parity.XY);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 */
	public Mars(Ecosystem key, Biosphere value) {
		super(Hypermetal.class, Metal.class, Mars.class, key, value, Parity.XX);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Jupiter} the parent
	 */
	public Mars(Ecosystem key, Biosphere value,	Jupiter parent) {
		super(Hypermetal.class, Metal.class, Mars.class, key, value, parent);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Mars(Class<Earth> antitype) {
		super(Hypermetal.class, Metal.class, Mars.class, antitype, Parity.XY);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 */
	public Mars(Class<Earth> antitype, Ecosystem key, Biosphere value) {
		super(Hypermetal.class, Metal.class, Mars.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Jupiter} the parent
	 */
	public Mars(Class<Earth> antitype, Ecosystem key, Biosphere value, Jupiter parent) {
		super(Hypermetal.class, Metal.class, Mars.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Being) {
				// cast source
				Being pair = (Being) event.getSource();
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
		// rip
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
				child instanceof Mars : false) {
			// cast source
			Mars pair = (Mars) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hypermetal(Metal.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}
