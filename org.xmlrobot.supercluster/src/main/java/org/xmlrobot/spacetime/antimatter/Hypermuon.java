package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.Perseus;
import org.xmlrobot.spacetime.matter.Higgs;
import org.xmlrobot.spacetime.matter.Muon;
import org.xmlrobot.util.Command;

/**
 * Hypermuon implementation class.
 * @author joan
 * @parity XY
 * @since 41159.4
 */
@XmlRootElement
public class Hypermuon 
	extends Antiproton<MilkyWay,Andromeda> {

	/**
	 * -1305023019879315282L
	 */
	private static final long serialVersionUID = -1305023019879315282L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public MilkyWay getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public MilkyWay setKey(MilkyWay key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Andromeda getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Andromeda setValue(Andromeda value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hypermuon} default class constructor.
	 */
	public Hypermuon() {
		super(Hypermuon.class);
	}
	/**
	 * {@link Hypermuon} class constructor.
	 * @param antitype the antitype
	 */
	public Hypermuon(Class<Muon> antitype) {
		super(Hypermuon.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Higgs) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Higgs pair = (Higgs) event.getSource();
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
			if(event.getSource() instanceof Higgs) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Higgs pair = (Higgs) event.getSource();
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
			if(event.getSource() instanceof Higgs) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
			if(event.getSource() instanceof Higgs) {
				// declare stem
				Mass<Andromeda,MilkyWay> future;
				// cast source
				Perseus pair = (Perseus) event.getSource();
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
	public Andromeda put(MilkyWay key, Andromeda value) {
		// declare child
		Mass<MilkyWay, Andromeda> child;
		// declare old value
		Andromeda oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hyperhiggs pair = new Hyperhiggs(Higgs.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}
