package org.xmlrobot.core.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.matter.Lepton;
import org.xmlrobot.core.matter.Quark;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.util.Command;

/**
 * Hyperquark implementation class.
 * @author joan
 * @parity XY
 * @since 41161.4
 */
@XmlRootElement
public class Hyperquark 
	extends Antiproton<Fornax,Columbia> {

	/**
	 * -6954372698317451289L
	 */
	private static final long serialVersionUID = -6954372698317451289L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Fornax getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Fornax setKey(Fornax key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Columbia getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Columbia setValue(Columbia value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperquark} default class constructor.
	 */
	public Hyperquark() {
		super(Hyperquark.class);
	}
	/**
	 * {@link Hyperquark} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperquark(Class<Quark> antitype) {
		super(Hyperquark.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Lepton) {
				// declare stem
				Mass<Columbia,Fornax> future;
				// cast source
				Lepton pair = (Lepton) event.getSource();
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
			if(event.getSource() instanceof Lepton) {
				// declare stem
				Mass<Columbia,Fornax> future;
				// cast source
				Lepton pair = (Lepton) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// push child
					future.add(pair);
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Lepton) {
				// declare stem
				Mass<Columbia,Fornax> future;
				// cast source
				Lepton pair = (Lepton) event.getSource();
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
			if(event.getSource() instanceof Lepton) {
				// declare stem
				Mass<Columbia,Fornax> future;
				// cast source
				Lepton pair = (Lepton) event.getSource();
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
	public Columbia put(Fornax key, Columbia value) {
		// create child
		Hyperlepton pair = new Hyperlepton(Lepton.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}