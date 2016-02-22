package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.matter.Dna;
import org.xmlrobot.dna.matter.Rna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Hyperdna implementation class.
 * @author joan
 * @parity XY
 * @since 1519.4
 */
@XmlRootElement
public class Hyperdna 
	extends Antiproton<Cromosoma,Diploid> {

	/**
	 * -4553883262968730324L
	 */
	private static final long serialVersionUID = -4553883262968730324L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Cromosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Cromosoma setKey(Cromosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Diploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Diploid setValue(Diploid value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperdna} default class constructor.
	 */
	public Hyperdna() {
		super(Hyperdna.class);
	}
	/**
	 * {@link Hyperdna} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperdna(Class<Dna> antitype) {
		super(Hyperdna.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
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
					// release child
					stem.order(pair);
				}
			}
			break;
		case SEND:
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
		case RELEASE:
			if(event.getSource() instanceof Rna) {
				// declare stem
				Mass<Diploid,Cromosoma> stem;
				// cast source
				Rna pair = (Rna) event.getSource();
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
	public Diploid put(Cromosoma key, Diploid value) {
		// create child
		Hyperrna pair = new Hyperrna(Rna.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}
