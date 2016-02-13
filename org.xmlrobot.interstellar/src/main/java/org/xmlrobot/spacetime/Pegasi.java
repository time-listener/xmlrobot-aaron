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
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Mars;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hypergluon;
import org.xmlrobot.spacetime.matter.Gluon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * 51 Pegasi implementation class.
 * @author joan
 * @parity XY
 * @since 41156.1
 */
@XmlRootElement
public class Pegasi 
	extends Parent<Jupiter,Saturn> {

	/**
	 * 8604727878873857518L
	 */
	private static final long serialVersionUID = 8604727878873857518L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Jupiter getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setKey(Jupiter key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Saturn getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setValue(Saturn value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypergluon.class)
	public Mass<Jupiter,Saturn> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Pegasi} default class constructor.
	 */
	public Pegasi() {
		super(Hypergluon.class, Gluon.class, Pegasi.class, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 */
	public Pegasi(Jupiter key, Saturn value) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, key, value, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Sun} the parent
	 */
	public Pegasi(Jupiter key, Saturn value, Sun parent) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, key, value, parent);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Pegasi(Class<Vega> antitype) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, antitype, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 */
	public Pegasi(Class<Vega> antitype, Jupiter key, Saturn value) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Sun} the parent
	 */
	public Pegasi(Class<Vega> antitype, Jupiter key, Saturn value, Sun parent) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Mars) {
				// cast source
				Mars pair = (Mars) event.getSource();
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
				child instanceof Pegasi : false) {
			// cast source
			Pegasi pair = (Pegasi) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hypergluon(Gluon.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}