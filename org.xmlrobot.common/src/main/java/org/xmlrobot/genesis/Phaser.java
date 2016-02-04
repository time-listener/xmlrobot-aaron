/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;

/**
 * Antimatter phaser<V> implementation interface.
 * 
 * Phasers are the most common and standard directed energy weapon 
 * in the arsenal of Starfleet and several other powers. 
 * Most phasers are classified as particle weapons and fire nadion 
 * particle beams, but some like the Ferengi hand phaser 
 * are classified as plasma weapons and fire forced plasma beams. 
 * Based on the intensity and field of the beam and a variety of 
 * adjustments, a wide variety of effects can be achieved.
 * 
 * <p>The root interface in the <i>phaser hierarchy</i>.
 * A {@link RunnableFuture} {@link ExecutorService} that is {@link Reproducible}.
 * I.e, the implementation of tick-tack, tick-tack, tick-tack...
 * Or maybe, run-run, run-run, run-run. Key is the value. And value is the TIME.
 * 
 * <p>This interface is a member of the {@code hyperspace congregation framework}.
 * @author joan
 */
public interface Phaser<V>
	extends ExecutorService, RunnableFuture<V>, Reproducible<V> {
	
	/**
	 * {@inheritDoc}
     * Returns the value corresponding to this hypergenesis.  If the mapping
     * has been removed from the backing hypergenesis (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     * @return the value corresponding to this hypergenesis
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypergenesis has been
     *         removed from the backing hypergenesis.
     */
	V get();
	
	/**
	 * {@inheritDoc}
     * Returns the value corresponding to this hypergenesis.  If the mapping
     * has been removed from the backing hypergenesis (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     * @return the value corresponding to this hypergenesis
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypergenesis has been
     *         removed from the backing hypergenesis.
     */
	V get(long timeout, java.util.concurrent.TimeUnit unit);
	
	/**
     * Replaces the value corresponding to this hypergenesis with the specified
     * value (optional operation). (Writes through to the hypergenesis.) The
     * behavior of this call is undefined if the mapping has already been
     * removed from the hypergenesis (by the iterator's <tt>remove</tt> operation).
     *
     * @param value new value to be stored in this hypergenesis
     * @return old antimatter corresponding to the hypergenesis
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing hypergenesis
     * @throws ClassCastException if the class of the specified antimatter
     *         prevents it from being stored in the backing hypergenesis
     * @throws NullPointerException if the backing hypergenesis does not permit
     *         null antimatter, and the specified antimatter is null
     * @throws IllegalArgumentException if some property of this antimatter
     *         prevents it from being stored in the backing hypergenesis
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypergenesis has been
     *         removed from the backing hypergenesis.
     */
	void set(V value);
	
    /**
     * Submits a value-returning task for execution and returns a
     * Future representing the pending results of the task. The
     * Future's {@code get} method will return the task's result upon
     * successful completion.
     *
     * <p>
     * If you would like to immediately block waiting
     * for a task, you can use constructions of the form
     * {@code result = exec.submit(aCallable).get();}
     *
     * <p>Note: The {@link Executors} class includes a set of methods
     * that can convert some other common closure-like objects,
     * for example, {@link java.security.PrivilegedAction} to
     * {@link Callable} form so they can be submitted.
     *
     * @param task the task to submit
     * @param <T> the type of the task's result
     * @return a Future representing pending completion of the task
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     * @throws NullPointerException if the task is null
     */
    <X> Phaser<X> submit(Callable<X> task);

    /**
     * 
     * Submits a Runnable task for execution and returns a Future
     * representing that task. The Future's {@code get} method will
     * return the given result upon successful completion.
     *
     * @param task the task to submit
     * @param result the result to return
     * @param <T> the type of the result
     * @return a Future representing pending completion of the task
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     * @throws NullPointerException if the task is null
     */
    <X> Phaser<X> submit(Runnable task, X result);

    /**
     * Submits a Runnable task for execution and returns a Future
     * representing that task. The Future's {@code get} method will
     * return {@code null} upon <em>successful</em> completion.
     *
     * @param task the task to submit
     * @return a Future representing pending completion of the task
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     * @throws NullPointerException if the task is null
     */
    Phaser<?> submit(Runnable task);
}