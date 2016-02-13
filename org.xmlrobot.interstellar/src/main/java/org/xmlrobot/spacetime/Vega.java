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
import org.xmlrobot.spacetime.Earth;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hypergluon;
import org.xmlrobot.spacetime.matter.Gluon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Vega implementation class. 
 * @author joan
 * @parity XX
 * @since 41156.2
 */
@XmlRootElement
public class Vega 
	extends Parent<Saturn,Jupiter> {

	/**
	 * 4236681231104503993L
	 */
	private static final long serialVersionUID = 4236681231104503993L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Saturn getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setKey(Saturn key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Jupiter getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setValue(Jupiter value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Gluon.class)
	public Mass<Saturn,Jupiter> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Vega} default class constructor.
	 */
	public Vega() {
		super(Gluon.class, Hypergluon.class, Vega.class, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 */
	public Vega(Saturn key, Jupiter value) {
		super(Gluon.class, Hypergluon.class, Vega.class, key, value, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 * @param parent {@link AlphaCentauri} the parent
	 */
	public Vega(Saturn key, Jupiter value, AlphaCentauri parent) {
		super(Gluon.class, Hypergluon.class, Vega.class, key, value, parent);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Vega(Class<Pegasi> antitype) {
		super(Gluon.class, Hypergluon.class, Vega.class, antitype, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 */
	public Vega(Class<Pegasi> antitype, Saturn key, Jupiter value) {
		super(Gluon.class, Hypergluon.class, Vega.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 * @param parent {@link AlphaCentauri} the parent
	 */
	public Vega(Class<Pegasi> antitype, Saturn key, Jupiter value, AlphaCentauri parent) {
		super(Gluon.class, Hypergluon.class, Vega.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER:
			if (event.getSource() instanceof Earth) {
				// cast source
				Earth pair = (Earth) event.getSource();
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
				child instanceof Vega : false) {
			// cast source
			Vega pair = (Vega) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Gluon(Hypergluon.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}
