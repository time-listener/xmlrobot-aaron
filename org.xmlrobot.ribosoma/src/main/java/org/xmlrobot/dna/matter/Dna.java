package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.antimatter.Hyperdna;
import org.xmlrobot.dna.antimatter.Hyperrna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Dna implementation class.
 * @author joan
 * @parity XX
 * @since 1519.3
 */
@XmlRootElement
public class Dna 
	extends Antiproton<Diploid,Cromosoma> {

	/**
	 * 6271069892701220397L
	 */
	private static final long serialVersionUID = 6271069892701220397L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getKey()
	 */
	@Override
	@XmlElement
	public Diploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setKey(java.lang.Object)
	 */
	@Override
	public Diploid setKey(Diploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#getValue()
	 */
	@Override
	@XmlElement
	public Cromosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Proton#setValue(java.lang.Object)
	 */
	@Override
	public Cromosoma setValue(Cromosoma value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Dna} default class constructor.
	 */
	public Dna() {
		super(Dna.class);
	}
	/**
	 * {@link Dna} class constructor.
	 * @param antitype the antitype
	 */
	public Dna(Class<Hyperdna> antitype) {
		super(Dna.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		// obey
		switch (event.getCommand()) {
		case ORDER:
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
					// release child
					stem.order(pair);
				}
			}
			break;
		case PUSH:
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
		case RELEASE:
			if(event.getSource() instanceof Hyperrna) {
				// declare stem
				Mass<Cromosoma,Diploid> stem;
				// cast source
				Hyperrna pair = (Hyperrna) event.getSource();
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
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
	@Override
	public Cromosoma put(Diploid key, Cromosoma value) {
		// TODO Auto-generated method stub
		return null;
	}
}