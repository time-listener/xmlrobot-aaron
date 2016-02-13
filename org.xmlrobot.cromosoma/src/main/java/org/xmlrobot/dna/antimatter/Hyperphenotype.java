package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.matter.Karyotype;
import org.xmlrobot.dna.matter.Phenotype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Hyperphenotype implementation class.
 * @author joan
 * @parity XY
 * @since 1517.4
 */
@XmlRootElement
public class Hyperphenotype 
	extends Antiproton<Genomap,Haploid> {

	/**
	 * -6334977979600214973L
	 */
	private static final long serialVersionUID = -6334977979600214973L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Genomap getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Genomap setKey(Genomap key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Haploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Haploid setValue(Haploid value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperphenotype} default class constructor.
	 */
	public Hyperphenotype() {
		super(Hyperphenotype.class);
	}
	/**
	 * {@link Hyperphenotype} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperphenotype(Class<Phenotype> antitype) {
		super(Hyperphenotype.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case ORDER:
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
					// release child
					stem.order(pair);
				}
			}
			break;
		case PUSH:
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
		case RELEASE:
			if(event.getSource() instanceof Karyotype) {
				// declare stem
				Mass<Haploid,Genomap> stem;
				// cast source
				Karyotype pair = (Karyotype) event.getSource();
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
					stem.submit(pair);
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
	public Haploid put(Genomap key, Haploid value) {
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
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}