/**
 * 
 */
package org.xmlrobot.subspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.subspace.antimatter.Hyperline;
import org.xmlrobot.subspace.matter.Hyperunit;
import org.xmlrobot.util.Command;

/**
 * Hyperpair implementation class.
 * @author joan
 * @parity XY
 * @since 1514.1
 */
@XmlRootElement
public class Hyperpair 
	extends Hyperstring {

	/**
	 * -8551753871097847645L
	 */
	private static final long serialVersionUID = -8551753871097847645L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Character getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Character setKey(Character key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Integer getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Integer setValue(Integer value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperline.class)
	public Mass<Character,Integer> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Hyperpair} default class constructor.
	 */
	public Hyperpair() {
		super(Hyperline.class, Hyperunit.class, Hyperpair.class);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperpair(Character key, Integer value) {
		super(Hyperline.class, Hyperunit.class, Hyperpair.class, key, value);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent {@link Hypercube} the parent
	 */
	public Hyperpair(Character key, Integer value, Hypercube parent) {
		super(Hyperline.class, Hyperunit.class, Hyperpair.class, key, value, parent);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hyperpair(Class<Hyperentry> antitype) {
		super(Hyperline.class, Hyperunit.class, Hyperpair.class, antitype);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperpair(Class<Hyperentry> antitype, Character key, Integer value) {
		super(Hyperline.class, Hyperunit.class, Hyperpair.class, antitype, key, value);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent {@link Hypercube} the parent
	 */
	public Hyperpair(Class<Hyperentry> antitype, Character key, Integer value, Hypercube parent) {
		super(Hyperline.class, Hyperunit.class, Hyperpair.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperstring#run()
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
				child instanceof Hyperpair : false) {
			// cast source
			Hyperpair pair = (Hyperpair) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().submit(new Hyperline(Hyperunit.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().release();
			}
		}
	}
}