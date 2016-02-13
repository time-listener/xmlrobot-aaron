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
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.nature.Organism;
import org.xmlrobot.spacetime.antimatter.Hypermetal;
import org.xmlrobot.spacetime.matter.Metal;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Home implementation class.
 * @author joan
 * @parity XX
 * @since 41154.2
 */
@XmlRootElement
public class Earth 
	extends Parent<Biosphere,Ecosystem> {

	/**
	 * 3239165432095598794L
	 */
	private static final long serialVersionUID = 3239165432095598794L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Biosphere getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Biosphere setKey(Biosphere key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Ecosystem getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ecosystem setValue(Ecosystem value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Metal.class)
	public Mass<Biosphere,Ecosystem> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Earth} default class constructor.
	 */
	public Earth() {
		super(Metal.class, Hypermetal.class, Earth.class, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 */
	public Earth(Biosphere key, Ecosystem value) {
		super(Metal.class, Hypermetal.class, Earth.class, key, value, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link Saturn} the parent
	 */
	public Earth(Biosphere key, Ecosystem value, Saturn parent) {
		super(Metal.class, Hypermetal.class, Earth.class, key, value, parent);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Earth(Class<Mars> antitype) {
		super(Metal.class, Hypermetal.class, Earth.class, antitype, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 */
	public Earth(Class<Mars> antitype, Biosphere key, Ecosystem value) {
		super(Metal.class, Hypermetal.class, Earth.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link Saturn} the parent
	 */
	public Earth(Class<Mars> antitype, Biosphere key, Ecosystem value, Saturn parent) {
		super(Metal.class, Hypermetal.class, Earth.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			 if(event.getSource() instanceof Organism) {
				// cast source
				Organism pair = (Organism) event.getSource();
				// set pair free
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
				child instanceof Earth : false) {
			// cast source
			Earth pair = (Earth) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Metal(Hypermetal.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}
