package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.matter.Gluon;
import org.xmlrobot.spacetime.matter.Photon;
import org.xmlrobot.util.Command;

/**
 * Hyperphoton implementation class.
 * @author joan
 * @parity XY
 * @since 41155.4
 */
@XmlRootElement
public class Hyperphoton 
	extends Antiproton<Jupiter,Saturn> {

	/**
	 * 2292921025393458451L
	 */
	private static final long serialVersionUID = 2292921025393458451L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Jupiter getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Jupiter setKey(Jupiter key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Saturn getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Saturn setValue(Saturn value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperphoton} default class constructor.
	 */
	public Hyperphoton() {
		super(Hyperphoton.class);
	}
	/**
	 * {@link Hyperphoton} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperphoton(Class<Photon> antitype) {
		super(Hyperphoton.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Gluon) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Gluon pair = (Gluon) event.getSource();
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
			if(event.getSource() instanceof Gluon) {
				// declare stem
				Mass<Saturn,Jupiter> stem;
				// cast source
				Gluon pair = (Gluon) event.getSource();
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
			if(event.getSource() instanceof Gluon) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Gluon pair = (Gluon) event.getSource();
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
			if(event.getSource() instanceof Gluon) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Gluon pair = (Gluon) event.getSource();
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
	public Saturn put(Jupiter key, Saturn value) {
		// declare child
		Mass<Jupiter,Saturn> child;
		// declare old value
		Saturn oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hypergluon pair = new Hypergluon(Gluon.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}