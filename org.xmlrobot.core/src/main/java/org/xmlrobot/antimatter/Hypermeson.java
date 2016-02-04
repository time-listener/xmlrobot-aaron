/**
 * 
 */
package org.xmlrobot.antimatter;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.matter.Meson;
import org.xmlrobot.positron.Antineutron;

/**
 * @author joan
 *
 */
public class Hypermeson
	extends Antineutron<Spacetime,Minkowski> {

	/**
	 * 7790598228248897555L
	 */
	private static final long serialVersionUID = 7790598228248897555L;

	public Hypermeson(){
		
		super();
	}
	public Hypermeson(Spacetime key, Minkowski value) {
		
		super(Hypermeson.class, key, value);
	}
	public Hypermeson(Spacetime key, Minkowski value, Hyperbaryon parent) {
		
		super(Hypermeson.class, key, value, parent);
	}
	public Hypermeson(Class<Meson> antitype, Spacetime key, Minkowski value) {
		
		super(Hypermeson.class, antitype, key, value);
	}
	public Hypermeson(Class<Meson> antitype, Spacetime key, Minkowski value, Hyperbaryon parent) {
		
		super(Hypermeson.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Spacetime,Minkowski> o1, Mass<Spacetime,Minkowski> o2) {
		
		return o1.getValue().compareTo(o2.getKey());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
}
