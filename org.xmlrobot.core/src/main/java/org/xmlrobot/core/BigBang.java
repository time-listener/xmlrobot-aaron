/**
 * 
 */
package org.xmlrobot.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.core.Cluster;
import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.antimatter.Hypermeson;
import org.xmlrobot.core.matter.Meson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Everything starts here.
 * @author joan
 * @parity XY
 * @since 41164.1
 */
@XmlRootElement
public class BigBang 
	extends Parent<Spacetime,Minkowski> {
	
	/**
	 * 2800389938473591910L
	 */
	private static final long serialVersionUID = 2800389938473591910L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Spacetime getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Spacetime setKey(Spacetime key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Minkowski getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Minkowski setValue(Minkowski value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypermeson.class)
	public Mass<Spacetime,Minkowski> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link BigBang} default class constructor.
	 */
	public BigBang() {
		super(Hypermeson.class, Meson.class, BigBang.class, Parity.XY);
	}
	/**
	 * {@link BigBang} class constructor.
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 */
	public BigBang(Spacetime key, Minkowski value) {
		super(Hypermeson.class, Meson.class, BigBang.class, key, value,  Parity.XY);
	}
	/**
	 * ç{@link BigBang} class constructor.
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 * @param parent {@link Universe} the parent
	 */
	public BigBang(Spacetime key, Minkowski value, Universe parent) {
		super(Hypermeson.class, Meson.class, BigBang.class, key, value, parent);
	}
	/**
	 * {@link BigBang} class constructor.
	 * @param antitype the inherited antitype
	 */
	public BigBang(Class<BigBong> antitype) {
		super(BigBang.class, antitype, Parity.XY);
	}
	/**
	 * {@link BigBang} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 */
	public BigBang(Class<BigBong> antitype, Spacetime key, Minkowski value) {
		super(BigBang.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link BigBang} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Spacetime} the key
	 * @param value {@link Minkowski} the value
	 * @param parent {@link Universe} the parent
	 */
	public BigBang(Class<BigBong> antitype, Spacetime key, Minkowski value, Universe parent) {
		super(BigBang.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
	
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER:
			if (event.getSource() instanceof Cluster) {
				// cast source
				Cluster pair = (Cluster) event.getSource();
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
				child instanceof BigBang : false) {
			// cast source
			BigBang pair = (BigBang) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getPlasma().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getPlasma().removeByKey(pair.getKey());
			}
		}
	}
}