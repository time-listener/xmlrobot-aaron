package org.xmlrobot.matter;

import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.antimatter.Hyperphenotype;
import org.xmlrobot.antimatter.Hypertype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Proton;
import org.xmlrobot.util.Command;

public class Phenotype 
	extends Proton<Haploid,Genomap> {

	/**
	 * -3552982948268784301L
	 */
	private static final long serialVersionUID = -3552982948268784301L;
	
	/**
	 * 
	 */
	public Phenotype() {
		super(Phenotype.class);
	}
	/**
	 * @param antitype
	 */
	public Phenotype(Class<Hyperphenotype> antitype) {
		super(Phenotype.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hypertype) {
				// declare stem
				Mass<Genomap,Haploid> stem;
				// cast source
				Hypertype pair = (Hypertype) event.getSource();
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
	public Genomap putValue(Haploid key, Genomap value) {
		// declare child
		Mass<Haploid,Genomap> child;
		// declare old value
		Genomap oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Karyotype pair = new Karyotype(Hypertype.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}