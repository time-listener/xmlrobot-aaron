/**
 * 
 */
package org.xmlrobot.core.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.matter.Baryon;
import org.xmlrobot.core.matter.Meson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Hyperbaryon implementation class.
 * @author joan
 * @parity XY
 * @since 41163.4
 */
@XmlRootElement
public class Hyperbaryon 
	extends Antiproton<Spacetime,Minkowski> {

	/**
	 * -456927415256227942L
	 */
	private static final long serialVersionUID = -456927415256227942L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Spacetime getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Spacetime setKey(Spacetime key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Minkowski getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Minkowski setValue(Minkowski value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperbaryon} default class constructor.
	 */
	public Hyperbaryon() {
		super(Hyperbaryon.class);
	}
	/**
	 * {@link Hyperbaryon} class constructor.
	 */
	public Hyperbaryon(Class<Baryon> antitype) {
		super(Hyperbaryon.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// ancestral recall
		super.mass(sender, event);
		// commute order
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Meson) {
				// declare future
				Mass<Minkowski,Spacetime> future;
				// cast source
				Meson pair = (Meson) event.getSource();
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
		case SEND:
			if(event.getSource() instanceof Meson) {
				// declare stem
				Mass<Minkowski,Spacetime> stem;
				// cast source
				Meson pair = (Meson) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.add(pair);
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Meson) {
				// declare stem
				Mass<Minkowski,Spacetime> future;
				// cast source
				Meson pair = (Meson) event.getSource();
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
			if(event.getSource() instanceof Meson) {
				// declare stem
				Mass<Minkowski,Spacetime> future;
				// cast source
				Meson pair = (Meson) event.getSource();
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
	 * @see org.xmlrobot.positron.Antiproton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Minkowski put(Spacetime key, Minkowski value) {
		// create child
		Hypermeson pair = new Hypermeson(Meson.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}