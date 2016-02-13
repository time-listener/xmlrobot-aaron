/**
 * 
 */
package org.xmlrobot.subspace.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.subspace.matter.Hyperpacket;
import org.xmlrobot.subspace.matter.Hyperunit;
import org.xmlrobot.util.Command;

/**
 * Hyperdatagram implementation class.
 * @author joan
 * @parity XY
 * @since 1513.4
 */
@XmlRootElement
public final class Hyperdatagram
	extends Antiproton<Character,Integer> {

	/**
	 * 8123876664920585604L
	 */
	private static final long serialVersionUID = 8123876664920585604L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Character getKey() {	
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Character setKey(Character key) { 
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Integer getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Integer setValue(Integer value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperdatagram} default class constructor.
	 */
	public Hyperdatagram() {
		super(Hyperdatagram.class);
	}
	/**
	 * {@link Hyperdatagram} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperdatagram(Class<Hyperpacket> antitype) {
		super(Hyperdatagram.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperunit) {
				// declare stem
				Mass<Integer,Character> stem;
				// cast source
				Hyperunit pair = (Hyperunit) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// release child
					stem.order(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Hyperunit) {
				// declare stem
				Mass<Integer,Character> stem;
				// cast source
				Hyperunit pair = (Hyperunit) event.getSource();
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
			if(event.getSource() instanceof Hyperunit) {
				// declare stem
				Mass<Integer,Character> stem;
				// cast source
				Hyperunit pair = (Hyperunit) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								stem.contains(pair) 
								: false
						: false) {
					// release child
					stem.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Hyperunit) {
				// declare stem
				Mass<Integer,Character> stem;
				// cast source
				Hyperunit pair = (Hyperunit) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.submit(pair);
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
	public Integer put(Character key, Integer value) {
		// declare child
		Mass<Character,Integer> child;
		// declare old value
		Integer oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hyperline pair = new Hyperline(Hyperunit.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}