/**
 * 
 */
package org.xmlrobot.subspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
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
	 * @see org.xmlrobot.time.Time#getName()
	 */
	@Override
	@XmlElement
	public String getName() {

		return getKey().toString();
	}
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
	@XmlElement
	public Hyperline getReplicator() {
		return (Hyperline) super.getReplicator();
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
		super(Hyperpair.class, antitype);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperpair(Class<Hyperentry> antitype, Character key, Integer value) {
		super(Hyperpair.class, antitype, key, value);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent {@link Hypercube} the parent
	 */
	public Hyperpair(Class<Hyperentry> antitype, Character key, Integer value, Hypercube parent) {
		super(Hyperpair.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized int compare(Mass<Character,Integer> o1, Mass<Character,Integer> o2) {

		return Integer.compare(o1.getValue(), o2.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#run()
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
}