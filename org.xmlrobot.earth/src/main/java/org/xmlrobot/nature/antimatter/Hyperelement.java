package org.xmlrobot.nature.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.nature.matter.Atom;
import org.xmlrobot.nature.matter.Element;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Hyperelement implementation class.
 * @author joan
 * @parity XY
 * @since 1523.4
 */
@XmlRootElement
public class Hyperelement 
	extends Antiproton<Operon,Cell> {

	/**
	 * -7852359284485014885L
	 */
	private static final long serialVersionUID = -7852359284485014885L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Operon getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Operon setKey(Operon key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Cell getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Cell setValue(Cell value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperelement} default class constructor,
	 */
	public Hyperelement() {
		super(Hyperelement.class);
	}
	/**
	 * {@link Hyperelement} class constructor,
	 * @param antitype the antitype
	 */
	public Hyperelement(Class<Element> antitype) {
		super(Hyperelement.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Atom) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Atom pair = (Atom) event.getSource();
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
			if(event.getSource() instanceof Atom) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Atom pair = (Atom) event.getSource();
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
			if(event.getSource() instanceof Atom) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Atom pair = (Atom) event.getSource();
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
			if(event.getSource() instanceof Atom) {
				// declare stem
				Mass<Cell,Operon> stem;
				// cast source
				Atom pair = (Atom) event.getSource();
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
	public Cell put(Operon key, Cell value) {
		// create child
		Hyperatom pair = new Hyperatom(Atom.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}