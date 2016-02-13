package org.xmlrobot.core.matter;

import javax.xml.bind.annotation.XmlElement;

import org.xmlrobot.core.Cluster;
import org.xmlrobot.core.antimatter.Hyperlepton;
import org.xmlrobot.core.antimatter.Hyperquark;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.util.Command;

/**
 * Quark implementation class.
 * @author joan
 * @parity XX
 * @since 41161.3
 */
public class Quark 
	extends Antiproton<Columbia,Fornax> {

	/**
	 * -2083467336455485338L
	 */
	private static final long serialVersionUID = -2083467336455485338L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public Columbia getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public Columbia setKey(Columbia key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public Fornax getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public Fornax setValue(Fornax value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Quark} default class constructor.
	 */
	public Quark() {
		super(Quark.class);
	}
	/**
	 * {@link Quark} class constructor.
	 * @param antitype the antitype
	 */
	public Quark(Class<Hyperquark> antitype) {
		super(Quark.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperlepton) {
				// declare stem
				Mass<Fornax,Columbia> future;
				// cast source
				Hyperlepton pair = (Hyperlepton) event.getSource();
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
			if(event.getSource() instanceof Hyperlepton) {
				// declare stem
				Mass<Fornax,Columbia> future;
				// cast source
				Hyperlepton pair = (Hyperlepton) event.getSource();
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
			if(event.getSource() instanceof Hyperlepton) {
				// declare stem
				Mass<Fornax,Columbia> future;
				// cast source
				Hyperlepton pair = (Hyperlepton) event.getSource();
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
			if(event.getSource() instanceof Cluster) {
				// declare stem
				Mass<Fornax,Columbia> future;
				// cast source
				Hyperlepton pair = (Hyperlepton) event.getSource();
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
	public Fornax put(Columbia key, Fornax value) {
		// declare child
		Mass<Columbia,Fornax> child;
		// declare old value
		Fornax oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Lepton pair = new Lepton(Hyperlepton.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}