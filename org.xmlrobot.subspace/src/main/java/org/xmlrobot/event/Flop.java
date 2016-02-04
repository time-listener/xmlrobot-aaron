/**
 * 
 */
package org.xmlrobot.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

/**
 * Floating-point operation per second (used as a measure of computing power).
 * <br>
 * @author joan
 *
 */
public class Flop 
	extends Graviton<Integer,String> {

	/**
	 * -9223046735358244192L
	 */
	private static final long serialVersionUID = -9223046735358244192L;

	/**
	 * {@link Flop} default class constructor
	 * @param source
	 */
	public Flop(Mass<Integer,String> source) {
		super(source);
	}

}
