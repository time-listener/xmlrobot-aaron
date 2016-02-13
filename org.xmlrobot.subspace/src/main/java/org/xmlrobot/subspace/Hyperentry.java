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
import org.xmlrobot.util.Parity;

/**
 * Hyperentry implementation class.
 * @author joan
 * @parity XX
 * @since 1514.2
 */
@XmlRootElement
public class Hyperentry 
	extends Hyperinteger {

	/**
	 * 6404666831053501412L
	 */
	private static final long serialVersionUID = 6404666831053501412L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Integer getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Integer setKey(Integer key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Character getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Character setValue(Character value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperinteger#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperunit.class)
	public Mass<Integer,Character> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Hyperentry} default class constructor.
	 */
	public Hyperentry() {
		super(Hyperunit.class, Hyperline.class, Hyperentry.class);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperentry(Integer key, Character value) {
		super(Hyperunit.class, Hyperline.class, Hyperentry.class, key, value);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent {@link Hyperchain} the parent
	 */
	public Hyperentry(Integer key, Character value, Hyperchain parent) {
		super(Hyperunit.class, Hyperline.class, Hyperentry.class, key, value, parent);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	public Hyperentry(Class<Hyperpair> antitype) {
		super(Hyperunit.class, Hyperline.class, Hyperentry.class, antitype);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperentry(Class<Hyperpair> antitype, Integer key, Character value) {
		super(Hyperunit.class, Hyperline.class, Hyperentry.class, antitype, key, value);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent {@link Hyperchain} the parent
	 */
	public Hyperentry(Class<Hyperpair> antitype, Integer key, Character value, Hyperchain parent) {
		super(Hyperunit.class, Hyperline.class, Hyperentry.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperinteger#run()
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
			Hyperentry pair = (Hyperentry) child;
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hyperunit(Hyperline.class, pair.getKey(), pair.getValue()));
			} 
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
	
	public static void main(String[] args) {
		
		Hyperentry entry = new Hyperentry(Hyperpair.class, 1, 'a');
		
		System.out.print(entry);
	}
}