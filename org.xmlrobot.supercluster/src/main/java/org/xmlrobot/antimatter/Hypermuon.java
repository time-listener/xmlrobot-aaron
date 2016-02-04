package org.xmlrobot.antimatter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Higgs;
import org.xmlrobot.matter.Muon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hypermuon 
	extends Antiproton<MilkyWay,Andromeda> {

	/**
	 * -1305023019879315282L
	 */
	private static final long serialVersionUID = -1305023019879315282L;

	/**
	 * 
	 */
	public Hypermuon() {
		super(Hypermuon.class);
	}
	/**
	 * @param antitype
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
		case SUBMIT:
			if(event.getSource() instanceof Higgs) {
				// declare stem
				Mass<Andromeda,MilkyWay> stem;
				// cast source
				Higgs pair = (Higgs) event.getSource();
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
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Andromeda putValue(MilkyWay key, Andromeda value) {
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
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
