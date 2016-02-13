package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.antimatter.HyperbosonW;
import org.xmlrobot.spacetime.antimatter.HyperbosonZ;
import org.xmlrobot.util.Command;

/**
 * BosonZ implementation class.
 * @author joan
 * @parity XX
 * @since 41157.3
 */
@XmlRootElement
public class BosonZ 
	extends Antiproton<AlphaCentauri,Sun> {

	/**
	 * -368306173123213628L
	 */
	private static final long serialVersionUID = -368306173123213628L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public AlphaCentauri setKey(AlphaCentauri key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public Sun getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public Sun setValue(Sun value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link BosonZ} default class constructor.
	 */
	public BosonZ() {
		super(BosonZ.class);
	}
	/**
	 * {@link BosonZ} default constructor.
	 * @param antitype the antitype
	 */
	public BosonZ(Class<HyperbosonZ> antitype) {
		super(BosonZ.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof HyperbosonW) {
				// declare stem
				Mass<Sun,AlphaCentauri> future;
				// cast source
				HyperbosonW pair = (HyperbosonW) event.getSource();
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
			if(event.getSource() instanceof HyperbosonW) {
				// declare stem
				Mass<Sun,AlphaCentauri> future;
				// cast source
				HyperbosonW pair = (HyperbosonW) event.getSource();
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
			if(event.getSource() instanceof HyperbosonW) {
				// declare stem
				Mass<Sun,AlphaCentauri> future;
				// cast source
				HyperbosonW pair = (HyperbosonW) event.getSource();
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
			if(event.getSource() instanceof HyperbosonW) {
				// declare stem
				Mass<Sun,AlphaCentauri> future;
				// cast source
				HyperbosonW pair = (HyperbosonW) event.getSource();
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
	public Sun put(AlphaCentauri key, Sun value) {
		// declare child
		Mass<AlphaCentauri,Sun> child;
		// declare old value
		Sun oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			BosonW pair = new BosonW(HyperbosonW.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}