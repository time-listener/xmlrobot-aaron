package org.xmlrobot.matter;

import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.antimatter.Hyperhiggs;
import org.xmlrobot.antimatter.Hypermuon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

public class Muon 
	extends Proton<Andromeda,MilkyWay> {

	/**
	 * 6427629947698898606L
	 */
	private static final long serialVersionUID = 6427629947698898606L;

	/**
	 * 
	 */
	public Muon() {
		super(Muon.class);
	}
	/**
	 * @param antitype
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
		case SUBMIT:
			if(event.getSource() instanceof Hyperhiggs) {
				// declare stem
				Mass<MilkyWay,Andromeda> stem;
				// cast source
				Hyperhiggs pair = (Hyperhiggs) event.getSource();
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
	 * @see org.xmlrobot.positron.Proton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public MilkyWay putValue(Andromeda key, MilkyWay value) {
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
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
