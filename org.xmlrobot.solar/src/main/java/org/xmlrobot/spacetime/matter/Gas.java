package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.antimatter.Hypergas;
import org.xmlrobot.spacetime.antimatter.Hypermetal;
import org.xmlrobot.util.Command;

/**
 * Gas implementation class.
 * @author joan
 * @parity XX
 * @since 41153.3
 */
@XmlRootElement
public class Gas 
	extends Antiproton<Biosphere,Ecosystem> {

	/**
	 * -3602380595804343582L
	 */
	private static final long serialVersionUID = -3602380595804343582L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public Biosphere getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public Biosphere setKey(Biosphere key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public Ecosystem getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public Ecosystem setValue(Ecosystem value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Gas} default class constructor.
	 */
	public Gas() {
		super(Gas.class);
	}
	/**
	 * {@link Gas} class constructor.
	 * @param antitype the antitype
	 */
	public Gas(Class<Hypergas> antitype) { 
		super(Gas.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hypermetal) {
				// declare stem
				Mass<Ecosystem,Biosphere> future;
				// cast source
				Hypermetal pair = (Hypermetal) event.getSource();
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
			if(event.getSource() instanceof Hypermetal) {
				// declare stem
				Mass<Ecosystem,Biosphere> stem;
				// cast source
				Hypermetal pair = (Hypermetal) event.getSource();
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
			if(event.getSource() instanceof Hypermetal) {
				// declare stem
				Mass<Ecosystem,Biosphere> future;
				// cast source
				Hypermetal pair = (Hypermetal) event.getSource();
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
			if(event.getSource() instanceof Hypermetal) {
				// declare stem
				Mass<Ecosystem,Biosphere> future;
				// cast source
				Hypermetal pair = (Hypermetal) event.getSource();
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
	 * @see org.xmlrobot.positron.Proton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Ecosystem put(Biosphere key, Ecosystem value) {
		// declare child
		Mass<Biosphere,Ecosystem> child;
		// declare old value
		Ecosystem oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Metal pair = new Metal(Hypermetal.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}
