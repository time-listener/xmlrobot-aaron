/**
 * 
 */
package org.xmlrobot.matter;

import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hyperbaryon;
import org.xmlrobot.antimatter.Hypermeson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

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
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Minkowski,Spacetime> o1, Mass<Minkowski,Spacetime> o2) {
		return super.compare(o1, o2);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Spacetime putValue(Minkowski key, Spacetime value) {
		// declare child
		Mass<Minkowski,Spacetime> child;
		// declare old value
		Spacetime oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? child.putValue(key,
				value) : null) == null) {
			// create child
			Meson pair = new Meson(Hypermeson.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}