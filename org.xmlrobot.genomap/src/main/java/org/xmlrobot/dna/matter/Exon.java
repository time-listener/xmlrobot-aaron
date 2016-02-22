package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.antimatter.Hyperexon;
import org.xmlrobot.dna.antimatter.Hyperintron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.util.Command;

/**
 * Exon implementation class.
 * @author joan
 * @parity XX
 * @since 1515.3
 */
@XmlRootElement
public class Exon 
	extends Antiproton<Hyperchain,Hypercube>{

	/**
	 * 6635269652339700640L
	 */
	private static final long serialVersionUID = 6635269652339700640L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Hyperchain getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Hyperchain setKey(Hyperchain key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Hypercube getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Hypercube setValue(Hypercube value) {
		return super.setValue(value);
	}
	
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
	public void mass(MassListener sender, Tachyon<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
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
					// release child
					stem.order(pair);
				}
			}
			break;
		case SEND:
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
		case RELEASE:
			if(event.getSource() instanceof Hyperintron) {
				// declare stem
				Mass<Hypercube,Hyperchain> stem;
				// cast source
				Hyperintron pair = (Hyperintron) event.getSource();
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
					stem.submit(pair);
				}
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Hypercube put(Hyperchain key, Hypercube value) {
		// create child
		Intron pair = new Intron(Hyperintron.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}