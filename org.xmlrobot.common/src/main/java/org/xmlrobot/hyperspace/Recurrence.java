/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Phaser;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Parity;

/**
 * The mass of the past.
 * <br><br>
 * @author joan
 *
 */
@XmlTransient
public abstract class Recurrence
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Abstraction<K,V> {

	/**
	 * -4157408801054520292L
	 */
	private static final long serialVersionUID = -4157408801054520292L;

	/**
	 * The mass listeners.
	 */
	private transient LinkedHashSet<MassListener> massListeners;
	
	/**
     * {@link Recurrence} default class constructor.
     */
	public Recurrence() {
    	super();
		// initialize mass listeners set
		massListeners = new LinkedHashSet<MassListener>();
    }
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	public Recurrence(Class<? extends K> type, Parity gen) {
		super(type, gen);
		// initialize mass listeners set
		massListeners = new LinkedHashSet<MassListener>();
	}
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public Recurrence(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
		// initialize mass listeners set
		massListeners = new LinkedHashSet<MassListener>();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.Entity)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		
		synchronized (massListeners) {
			
			massListeners.add(listener);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Unification#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		// avoid antimatter contact
		if(!sender.equals(get()) && !sender.equals(this))
			// broadcast event
			push(event);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		
		Unification<K,V> unification = (Unification<K, V>) super.clone();
		
		if(unification != null) {
			Recurrence<K,V> abstraction = 
					(Recurrence<K,V>) unification;
			return abstraction;	
		}
		else {
			
			return null;
		}
	}
	/**
	 * Sends MASS to the past.
	 * @param sender {@link Source} the transmitter entity.
	 * @param event {@link Takion} the mass being sent.
	 */
	protected void push(Takion<?,?> event) {
		// a-synchronized
		for(MassListener listener : massListeners) {
			
			listener.mass(this, event);
		}
	}
    /**
     * @param runnable
     * @param output
     * @return
     */
    protected TimeListener<K,V> newMass(Runnable runnable, TimeListener<K,V> output)
    {
    	return null;
    }
	/**
     * Returns a {@code RunnableFuture} for the given runnable and default
     * value.
     *
     * @param runnable the runnable task being wrapped
     * @param output the default value for the returned future
     * @param <T> the type of the given value
     * @return a {@code RunnableFuture} which, when run, will run the
     * underlying runnable and which, as a {@code Future}, will yield
     * the given value as its result and provide for cancellation of
     * the underlying task
     * @since 1.6
     */
    @SuppressWarnings("unchecked")
	protected <T> Phaser<T> newPhaserFor(Runnable runnable, T output) {
    	
        return (Phaser<T>) new FutureTask<T>(runnable, output);
    }
    /**
     * Returns a {@code RunnableFuture} for the given callable task.
     *
     * @param callable the callable task being wrapped
     * @param <T> the type of the callable's result
     * @return a {@code RunnableFuture} which, when run, will call the
     * underlying callable and which, as a {@code Future}, will yield
     * the callable's result as its result and provide for
     * cancellation of the underlying task
     * @since 1.6
     */
    @SuppressWarnings("unchecked")
	protected <T> Phaser<T> newPhaserFor(Callable<T> callable) {
        return (Phaser<T>) new FutureTask<T>(callable);
    }
}