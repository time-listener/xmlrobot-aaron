package org.xmlrobot.nature.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.nature.antimatter.Hyperatom;
import org.xmlrobot.nature.antimatter.Hyperelement;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Element implementation class.
 * @author joan
 * @parity XX
 * @since 1523.3
 */
@XmlRootElement
public class Element
	extends Antiproton<Cell,Operon> {

	/**
	 * -4054003935605395183L
	 */
	private static final long serialVersionUID = -4054003935605395183L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public Cell getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public Cell setKey(Cell key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public Operon getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public Operon setValue(Operon value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Element} default class constructor.
	 */
	public Element() {
		super(Element.class);
	}
	/**
	 * {@link Element} class constructor.
	 * @param antitype the antitype
	 */
	public Element(Class<Hyperelement> antitype) {
		super(Element.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperatom) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Hyperatom pair = (Hyperatom) event.getSource();
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
			if(event.getSource() instanceof Hyperatom) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Hyperatom pair = (Hyperatom) event.getSource();
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
			if(event.getSource() instanceof Hyperatom) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Hyperatom pair = (Hyperatom) event.getSource();
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
			if(event.getSource() instanceof Hyperatom) {
				// declare stem
				Mass<Operon,Cell> stem;
				// cast source
				Hyperatom pair = (Hyperatom) event.getSource();
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
	public Operon put(Cell key, Operon value) {
		// declare child
		Mass<Cell,Operon> child;
		// declare old value
		Operon oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Atom pair = new Atom(Hyperatom.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}