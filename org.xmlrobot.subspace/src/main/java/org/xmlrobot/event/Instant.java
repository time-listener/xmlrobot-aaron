/**
 * 
 */
package org.xmlrobot.event;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.space.Space;
import org.xmlrobot.time.Time;

/**
 * {@link Space}{@link Time} instant class. 
 * The instant listened by {@link TimeListener}.
 * <br>
 * @author joan
 *
 */
public class Instant 
	extends Graviton<String,Integer> {

	/**
	 * 2799782642463826451L
	 */
	private static final long serialVersionUID = 2799782642463826451L;

	/**
	 * @param source
	 */
	public Instant(Mass<String,Integer> source) {
		
		super(source);
	}
}