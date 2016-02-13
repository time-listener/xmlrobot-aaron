package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.antimatter.Hyperhiggs;
import org.xmlrobot.spacetime.antimatter.Hypermuon;
import org.xmlrobot.util.Command;

/**
 * Muon implementation class.
 * @author joan
 * @parity XX
 * @since 41159.3
 */
@XmlRootElement
public class Muon 
	extends Antiproton<Andromeda,MilkyWay> {

	/**
	 * 6427629947698898606L
	 */
	private static final long serialVersionUID = 6427629947698898606L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public Andromeda getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public Andromeda setKey(Andromeda key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public MilkyWay getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public MilkyWay setValue(MilkyWay value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Muon} default class constructor.
	 */
	public Muon() {
		super(Muon.class);
	}
	/**
	 * {@link Muon} class constructor.
	 * @param antitype the antitype
	 */
	public Muon(Class<Hypermuon> antitype) {
		super(Muon.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperhiggs) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Hyperhiggs pair = (Hyperhiggs) event.getSource();
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
			if(event.getSource() instanceof Hyperhiggs) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Hyperhiggs pair = (Hyperhiggs) event.getSource();
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
			if(event.getSource() instanceof Hyperhiggs) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Hyperhiggs pair = (Hyperhiggs) event.getSource();
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
			if(event.getSource() instanceof Hyperhiggs) {
				// declare stem
				Mass<MilkyWay,Andromeda> future;
				// cast source
				Hyperhiggs pair = (Hyperhiggs) event.getSource();
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
	public MilkyWay put(Andromeda key, MilkyWay value) {
		// declare child
		Mass<Andromeda,MilkyWay> child;
		// declare old value
		MilkyWay oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Higgs pair = new Higgs(Hyperhiggs.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}