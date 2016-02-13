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
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.Hydra;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.antimatter.Hyperhiggs;
import org.xmlrobot.spacetime.matter.Higgs;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Perseus implementation class.
 * @author joan
 * @parity XX
 * @since 41160.2
 */
@XmlRootElement
public class Perseus
	extends Parent<Andromeda,MilkyWay> {

	/**
	 * -1403736829977393602L
	 */
	private static final long serialVersionUID = -1403736829977393602L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Andromeda getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setKey(Andromeda key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public MilkyWay getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setValue(MilkyWay value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Higgs.class)
	public Mass<Andromeda,MilkyWay> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Perseus} default class constructor.
	 */
	public Perseus() {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 */
	public Perseus(Andromeda key, MilkyWay value) {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, key, value, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link Columbia} the parent
	 */
	public Perseus(Andromeda key, MilkyWay value, Columbia parent) {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, key, value, parent);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Perseus(Class<Capricornus> antitype) {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, antitype, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 */
	public Perseus(Class<Capricornus> antitype, Andromeda key, MilkyWay value) {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link Columbia} the parent
	 */
	public Perseus(Class<Capricornus> antitype, Andromeda key, MilkyWay value, Columbia parent) {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		
		super.mass(sender, event);
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra pair = (Hydra) event.getSource();
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
				child instanceof Perseus : false) {
			// cast source
			Perseus pair = (Perseus) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Higgs(Hyperhiggs.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}