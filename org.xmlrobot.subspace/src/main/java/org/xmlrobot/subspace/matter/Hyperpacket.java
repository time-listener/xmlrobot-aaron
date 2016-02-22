package org.xmlrobot.subspace.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.subspace.antimatter.Hyperdatagram;
import org.xmlrobot.subspace.antimatter.Hyperline;
import org.xmlrobot.util.Command;

/**
 * Hyperpacket implementation class.
 * @author joan
 * @parity XX
 * @since 1513.3
 */
@XmlRootElement
public class Hyperpacket 
	extends Antiproton<Integer,Character>{

	/**
	 * -865307579647969933L
	 */
	private static final long serialVersionUID = -865307579647969933L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public Integer getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public Integer setKey(Integer key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public Character getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public Character setValue(Character value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperpacket} default class constructor.
	 */
	public Hyperpacket() {
		super(Hyperpacket.class);
	}
	/**
	 * {@link Hyperpacket} default class constructor.
	 * @param antitype the antitype
	 */
	public Hyperpacket(Class<Hyperdatagram> antitype) {
		super(Hyperpacket.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperline) {
				// declare stem
				Mass<Character,Integer> stem;
				// cast source
				Hyperline pair = (Hyperline) event.getSource();
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
		case SEND:
			if(event.getSource() instanceof Hyperline) {
				// declare key
				Mass<Character,Integer> stem;
				// cast source
				Hyperline pair = (Hyperline) event.getSource();
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
			if(event.getSource() instanceof Hyperline) {
				// declare stem
				Mass<Character,Integer> stem;
				// cast source
				Hyperline pair = (Hyperline) event.getSource();
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
			if(event.getSource() instanceof Hyperline) {
				// declare stem
				Mass<Character,Integer> stem;
				// cast source
				Hyperline pair = (Hyperline) event.getSource();
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
	 * @see org.xmlrobot.positron.Proton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character put(Integer key, Character value) {
		// create child
		Hyperunit pair = new Hyperunit(Hyperline.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}