package org.xmlrobot.antimatter;

import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Karyotype;
import org.xmlrobot.matter.Phenotype;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

public class Hyperphenotype 
	extends Antiproton<Genomap,Haploid> {

	/**
	 * -6334977979600214973L
	 */
	private static final long serialVersionUID = -6334977979600214973L;
	
	/**
	 * 
	 */
	public Hyperphenotype() {
		super(Hyperphenotype.class);
	}
	/**
	 * @param antitype
	 */
	public Hyperphenotype(Class<Phenotype> antitype) {
		super(Hyperphenotype.class, antitype);
	}

	/**
	 * @param sender
	 * @param event
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Karyotype) {
				// declare stem
				Mass<Haploid,Genomap> stem;
				// cast source
				Karyotype pair = (Karyotype) event.getSource();
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
	/**
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public Haploid putValue(Genomap key, Haploid value) {
		// declare child
		Mass<Genomap,Haploid> child;
		// declare old value
		Haploid oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hypertype pair = new Hypertype(Karyotype.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
}