package org.xmlrobot.antimatter;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Exon;
import org.xmlrobot.matter.Intron;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 */
public class Hyperexon 
	extends Antiproton<Hypercube,Hyperchain> {

	/**
	 * -4725035824910633738L
	 */
	private static final long serialVersionUID = -4725035824910633738L;

	/**
	 * {@link Hyperexon}
	 */
	public Hyperexon() {
		super(Hyperexon.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperexon(Class<Exon> antitype) {
		super(Hyperexon.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Intron) {
				// declare stem
				Mass<Hyperchain,Hypercube> stem;
				// cast source
				Intron pair = (Intron) event.getSource();
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
	public Hyperchain putValue(Hypercube key, Hyperchain value) {
		// declare child
		Mass<Hypercube,Hyperchain> child;
		// declare old value
		Hyperchain oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hyperintron pair = new Hyperintron(Intron.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}