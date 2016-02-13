package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.matter.BosonW;
import org.xmlrobot.spacetime.matter.BosonZ;
import org.xmlrobot.util.Command;

/**
 * HyperbosonZ implementation class.
 * @author joan
 * @parity XY
 * @since 41157.4
 */
@XmlRootElement
public class HyperbosonZ 
	extends Antiproton<Sun,AlphaCentauri> {

	/**
	 * -1388131279477719068L
	 */
	private static final long serialVersionUID = -1388131279477719068L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Sun getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Sun setKey(Sun key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public AlphaCentauri setValue(AlphaCentauri value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link HyperbosonZ} default class constructor.
	 */
	public HyperbosonZ() {
		super(HyperbosonZ.class);
	}
	/**
	 * {@link HyperbosonZ} class constructor.
	 * @param antitype the antitype
	 */
	public HyperbosonZ(Class<BosonZ> antitype) {
		super(HyperbosonZ.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof BosonW) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				BosonW pair = (BosonW) event.getSource();
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
			if(event.getSource() instanceof BosonW) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				BosonW pair = (BosonW) event.getSource();
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
			if(event.getSource() instanceof BosonW) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				BosonW pair = (BosonW) event.getSource();
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
			if(event.getSource() instanceof BosonW) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				BosonW pair = (BosonW) event.getSource();
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
	public AlphaCentauri put(Sun key, AlphaCentauri value) {
		// declare child
		Mass<Sun,AlphaCentauri> child;
		// declare old value
		AlphaCentauri oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			HyperbosonW pair = new HyperbosonW(BosonW.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}