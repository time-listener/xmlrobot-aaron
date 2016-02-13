package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hyperphenotype;
import org.xmlrobot.dna.antimatter.Hypertype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Phenotype implementation class.
 * @author joan
 * @parity XX
 * @since 1517.3
 */
@XmlRootElement
public class Phenotype 
	extends Antiproton<Haploid,Genomap> {

	/**
	 * -3552982948268784301L
	 */
	private static final long serialVersionUID = -3552982948268784301L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public Haploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public Haploid setKey(Haploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public Genomap getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public Genomap setValue(Genomap value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Phenotype} default class constructor.
	 */
	public Phenotype() {
		super(Phenotype.class);
	}
	/**
	 * {@link Phenotype} class constructor.
	 * @param antitype the antitype
	 */
	public Phenotype(Class<Hyperphenotype> antitype) {
		super(Phenotype.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case ORDER:
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
					// release child
					stem.order(pair);
				}
			}
			break;
		case PUSH:
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
		case RELEASE:
			if(event.getSource() instanceof Hypertype) {
				// declare stem
				Mass<Genomap,Haploid> stem;
				// cast source
				Hypertype pair = (Hypertype) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								stem.contains(pair) 
								: false
						: false) {
					// release child
					stem.remove(pair);
				}
			}
			break;
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
					stem.submit(pair);
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
	public Genomap put(Haploid key, Genomap value) {
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
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}