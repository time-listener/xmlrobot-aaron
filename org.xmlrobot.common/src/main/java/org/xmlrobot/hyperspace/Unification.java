/**
 * 
 */
package org.xmlrobot.hyperspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.Hypergenesis;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Parity;

/**
 * The unification of everything. 
 * <br>
 * All implementing instances in the {@code hyperspace} 
 * will inherit the opposite instance. So, all inheriting instances
 * will have an opposite instance and they will be the 
 * same, just equals as matter and antimatter. They together
 * will be ONE.
 * <br><br>
 * Avoid matter and antimatter contact. Or an 
 * {@link StackOverflowError} will be thrown. I.e, pure energy.
 * <br><br>
 * The unification of {@link Time}.
 * <br<br<
 * @author joan
 *
 */
@XmlTransient
public abstract class Unification
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Hypergenesis<K,V> {

	/**
	 * 365643710555900753L
	 */
	private static final long serialVersionUID = 365643710555900753L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#uuid()
	 */
	@XmlElement
	public java.util.UUID getUUID() {
		
		return dna().getUUID();
	}
	/**
     * {@link Unification} default class constructor.
     */
	public Unification() {
    	super();
    }
	/**
     * {@link Unification} class constructor.
	 * @param type the type
     * @param gen {@link Parity} the gender
     * @throws Abort when something is wrong
	 */
	public Unification(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
 	/**
     * {@link Unification} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public Unification(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
		// the unification of everything
		value.set(type.cast(this));
		value.setAntitype(type);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public synchronized void execute(Runnable entity) {

		newThread(entity).start();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Love#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		try {
			Unification<K,V> message = (Unification<K,V>) super.clone();
			return message;
		} catch (ClassCastException | NullPointerException e) {			
			return null;
		}
	}
}