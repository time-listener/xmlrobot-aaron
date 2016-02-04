package org.xmlrobot.antimatter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Dna;
import org.xmlrobot.matter.Rna;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hyperdna 
	extends Antiproton<Cromosoma,Diploid> {

	/**
	 * -4553883262968730324L
	 */
	private static final long serialVersionUID = -4553883262968730324L;
	
	/**
	 * 
	 */
	public Hyperdna() {
		super(Hyperdna.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperdna(Class<Dna> antitype) {
		super(Hyperdna.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Rna) {
				// declare stem
				Mass<Diploid,Cromosoma> stem;
				// cast source
				Rna pair = (Rna) event.getSource();
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
	public Diploid putValue(Cromosoma key, Diploid value) {
		// declare child
		Mass<Cromosoma,Diploid> child;
		// declare old value
		Diploid oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hyperrna pair = new Hyperrna(Rna.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}
