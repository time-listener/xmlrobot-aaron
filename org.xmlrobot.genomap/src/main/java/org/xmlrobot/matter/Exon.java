package org.xmlrobot.matter;

import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.antimatter.Hyperexon;
import org.xmlrobot.antimatter.Hyperintron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Exon 
	extends Proton<Hyperchain,Hypercube>{

	/**
	 * 6635269652339700640L
	 */
	private static final long serialVersionUID = 6635269652339700640L;

	/**
	 * {@link Exon} default class constructor.
	 */
	public Exon() {
		super(Exon.class);
	}
	/**
	 * {@link Exon} class constructor.
	 * @param antitype the antitype
	 */
	public Exon(Class<Hyperexon> antitype) {
		super(Exon.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperintron) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Hyperintron pair = (Hyperintron) event.getSource();
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
	public Hypercube putValue(Hyperchain key, Hypercube value) {
		// declare child
		Mass<Hyperchain,Hypercube> child;
		// declare old value
		Hypercube oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Intron pair = new Intron(Hyperintron.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}