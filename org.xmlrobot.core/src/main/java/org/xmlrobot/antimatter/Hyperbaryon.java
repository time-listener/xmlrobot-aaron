/**
 * 
 */
package org.xmlrobot.antimatter;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.matter.Baryon;
import org.xmlrobot.positron.Antiproton;

/**
 * @author joan
 *
 */
public class Hyperbaryon 
	extends Antiproton<Spacetime,Minkowski> {

	/**
	 * -456927415256227942L
	 */
	private static final long serialVersionUID = -456927415256227942L;

	/**
	 * 
	 */
	public Hyperbaryon() {
		super(Hyperbaryon.class);
	}
	/**
	 * 
	 */
	public Hyperbaryon(Class<Baryon> antitype) {
		super(Hyperbaryon.class, antitype);
	}
}
