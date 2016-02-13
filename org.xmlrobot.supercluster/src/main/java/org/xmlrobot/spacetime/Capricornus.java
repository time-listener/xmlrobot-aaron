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
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.Virgo;
import org.xmlrobot.spacetime.antimatter.Hyperhiggs;
import org.xmlrobot.spacetime.matter.Higgs;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Capricornus implementation class.
 * @author joan
 * @parity XY
 * @since 41160.1
 */
@XmlRootElement
public class Capricornus 
	extends Parent<MilkyWay,Andromeda>  {
	
	/**
	 * 2287183649427568656L
	 */
	private static final long serialVersionUID = 2287183649427568656L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public MilkyWay getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setKey(MilkyWay key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Andromeda getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setValue(Andromeda value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperhiggs.class)
	public Mass<MilkyWay,Andromeda> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Capricornus} default class constructor.
	 */
	public Capricornus() {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Capricornus(MilkyWay key, Andromeda value) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, key, value, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Fornax} the parent
	 */
	public Capricornus(MilkyWay key, Andromeda value, Fornax parent) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, key, value, parent);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Capricornus(Class<Perseus> antitype) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, antitype, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Capricornus(Class<Perseus> antitype, MilkyWay key, Andromeda value) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Fornax} the parent
	 */
	public Capricornus(Class<Perseus> antitype, MilkyWay key, Andromeda value, Fornax parent) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
				child instanceof Capricornus : false) {
			// cast source
			Capricornus pair = (Capricornus) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hyperhiggs(Higgs.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}
