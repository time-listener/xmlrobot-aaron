package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.matter.Gas;
import org.xmlrobot.spacetime.matter.Metal;
import org.xmlrobot.util.Command;

/**
 * Hypergas implementation class.
 * @author joan
 * @parity XY
 * @since 41153.4
 */
@XmlRootElement
public class Hypergas 
	extends Antiproton<Ecosystem,Biosphere> {

	/**
	 * 4184946175192977516L
	 */
	private static final long serialVersionUID = 4184946175192977516L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Ecosystem getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Ecosystem setKey(Ecosystem key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Biosphere getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Biosphere setValue(Biosphere value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hypergas} default class constructor.
	 */
	public Hypergas() {
		
		super(Hypergas.class);
	}
	/**
	 * {@link Hypergas} class constructor.
	 * @param antitype the antitype
	 */
	public Hypergas(Class<Gas> antitype) {
		
		super(Hypergas.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Metal) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Metal pair = (Metal) event.getSource();
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
			if(event.getSource() instanceof Metal) {
				// declare stem
				Mass<Biosphere,Ecosystem> stem;
				// cast source
				Metal pair = (Metal) event.getSource();
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
			if(event.getSource() instanceof Metal) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Metal pair = (Metal) event.getSource();
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
			if(event.getSource() instanceof Metal) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Metal pair = (Metal) event.getSource();
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
	public Biosphere put(Ecosystem key, Biosphere value) {
		// declare child
		Mass<Ecosystem,Biosphere> child;
		// declare old value
		Biosphere oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? child.putValue(key,
				value) : null) == null) {
			// create child
			Hypermetal pair = new Hypermetal(Metal.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}