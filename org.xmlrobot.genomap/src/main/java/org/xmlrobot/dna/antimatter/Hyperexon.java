package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.matter.Exon;
import org.xmlrobot.dna.matter.Intron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.util.Command;

/**
 * Hyperexon implementation class.
 * @author joan
 * @parity XY
 * @since 1515.4
 */
@XmlRootElement
public class Hyperexon 
	extends Antiproton<Hypercube,Hyperchain> {

	/**
	 * -4725035824910633738L
	 */
	private static final long serialVersionUID = -4725035824910633738L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Hypercube getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Hypercube setKey(Hypercube key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Hyperchain getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Hyperchain setValue(Hyperchain value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperexon} default class constructor.
	 */
	public Hyperexon() {
		super(Hyperexon.class);
	}
	/**
	 * {@link Hyperexon} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperexon(Class<Exon> antitype) {
		super(Hyperexon.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// call ancestral method
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case ORDER:
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
					// release child
					stem.order(pair);
				}
			}
			break;
		case SEND:
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
		case RELEASE:
			if(event.getSource() instanceof Intron) {
				// declare stem
				Mass<Hyperchain,Hypercube> stem;
				// cast source
				Intron pair = (Intron) event.getSource();
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
	public Hyperchain put(Hypercube key, Hyperchain value) {
		// create child
		Hyperintron pair = new Hyperintron(Intron.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}