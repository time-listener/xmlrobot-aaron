/**
 * 
 */
package org.xmlrobot.matter;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hyperbaryon;
import org.xmlrobot.positron.Proton;

/**
 * @author joan
 *
 */
public class Baryon 
	extends Proton<Minkowski,Spacetime>{

	/**
	 * 1954608923464352324L
	 */
	private static final long serialVersionUID = 1954608923464352324L;

	/**
	 * 
	 */
	public Baryon() {
		super(Baryon.class);
	}
	/**
	 * 
	 */
	public Baryon(Class<Hyperbaryon> antitype) {
		super(Baryon.class, antitype);
	}
}
