/**
 * 
 */
package org.xmlrobot.util;

import org.xmlrobot.genesis.TimeListener;

/**
 * Abort exception implementation class.
 * 
 * <p>An <tt>abort</tt> will be thrown when something is wrong.
 * 
 * @author joan
 *
 */
public class Abort extends RuntimeException {

	/**
	 * -2997851168164530403L
	 */
	private static final long serialVersionUID = -2997851168164530403L;

	TimeListener<?,?> source;
	
	/**
	 * {@link Abort} default class constructor.
	 */
	public Abort() {
		super();
	}
	/**
	 * {@link Abort} class constructor.
	 * @param source {@link TimeListener} the source
	 */
	public Abort(TimeListener<?,?> source) {
		super();
		this.source = source;
	}
	/**
	 * {@link Abort} class constructor.
	 * @param cause {@link Throwable} the cause
	 */
	public Abort(Throwable cause) {
		super(cause);
	}
	/**
	 * {@link Abort} class constructor.
	 * @param cause {@link Throwable} the cause
	 * @param source {@link TimeListener} the source
	 */
	public Abort(Throwable cause, TimeListener<?,?> source) {
		super(cause);
		this.source = source;
	}
}