package org.xmlrobot.matter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Hyperdna;
import org.xmlrobot.antimatter.Hyperrna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Dna 
	extends Proton<Diploid,Cromosoma> {

	/**
	 * 6271069892701220397L
	 */
	private static final long serialVersionUID = 6271069892701220397L;
	
	/**
	 * 
	 */
	public Dna() {
		super(Dna.class);
	}
	/**
	 * @param antitype
	 */
	public Dna(Class<Hyperdna> antitype) {
		super(Dna.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperrna) {
				// declare stem
				Mass<Cromosoma,Diploid> stem;
				// cast source
				Hyperrna pair = (Hyperrna) event.getSource();
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
	public Cromosoma putValue(Diploid key, Cromosoma value) {
		// declare child
		Mass<Diploid,Cromosoma> child;
		// declare old value
		Cromosoma oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Rna pair = new Rna(Hyperrna.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}