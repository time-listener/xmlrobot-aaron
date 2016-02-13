/**
 * 
 */
package org.xmlrobot.core.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.antimatter.Hyperbaryon;
import org.xmlrobot.core.antimatter.Hypermeson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Baryon implementation class.
 * @author joan
 * @parity XX
 * @since 41163.3
 */
@XmlRootElement
public class Baryon 
	extends Antiproton<Minkowski,Spacetime>{

	/**
	 * 1954608923464352324L
	 */
	private static final long serialVersionUID = 1954608923464352324L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Minkowski getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Minkowski setKey(Minkowski key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Spacetime getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Spacetime setValue(Spacetime value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Baryon} default class constructor.
	 */
	public Baryon() {
		super(Baryon.class);
	}
	/**
	 * {@link Baryon} class constructor.
	 * @param antitype the antitype
	 */
	public Baryon(Class<Hyperbaryon> antitype) {
		super(Baryon.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
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
		// ancestral recall
		super.mass(sender, event);
		// commute order
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hypermeson) {
				// declare future
				Mass<Spacetime,Minkowski> future;
				// cast source
				Hypermeson pair = (Hypermeson) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// release child
					future.order(pair);
				}
			}
			break;
		case PUSH:
			if (event.getSource() instanceof Hypermeson) {
				// declare future
				Mass<Spacetime,Minkowski> future;
				// cast source
				Hypermeson pair = (Hypermeson) event.getSource();
				// check if empty and chained
				if ((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					future.add(pair);
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hypermeson) {
				// declare stem
				Mass<Spacetime,Minkowski> future;
				// cast source
				Hypermeson pair = (Hypermeson) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								future.contains(pair) 
								: false
						: false) {
					// release child
					future.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Hypermeson) {
				// declare stem
				Mass<Spacetime,Minkowski> future;
				// cast source
				Hypermeson pair = (Hypermeson) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// push child
					future.submit(pair);
				}
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Spacetime put(Minkowski key, Spacetime value) {
		// create child
		Meson pair = new Meson(Hypermeson.class, key, value, this);
		// push child
		pair.push(Command.PUSH);
		return null;
	}
}