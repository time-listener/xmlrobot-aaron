/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Gamete;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hypertype;
import org.xmlrobot.dna.matter.Karyotype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Allele implementation class.
 * @author joan
 * @parity XX
 * @since 1518.2
 */
@XmlRootElement
public class Allele 
	extends Parent<Haploid,Genomap> {

	/**
	 * -119308544852621745L
	 */
	private static final long serialVersionUID = -119308544852621745L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Haploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Haploid setKey(Haploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Genomap getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Genomap setValue(Genomap value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Karyotype.class)
	public Mass<Haploid,Genomap> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Allele} default class constructor.
	 */
	public Allele() {
		super(Karyotype.class, Hypertype.class, Allele.class, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Allele(Haploid key, Genomap value) {
		super(Karyotype.class, Hypertype.class, Allele.class, key, value, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link Diploid} the parent
	 */
	public Allele(Haploid key, Genomap value, Diploid parent) {
		super(Karyotype.class, Hypertype.class, Allele.class, key, value, parent);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Allele(Class<BasePair> antitype) {
		super(Allele.class, antitype, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Allele(Class<BasePair> antitype, Haploid key, Genomap value) {
		super(Allele.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Allele} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 * @param parent {@link Diploid} the parent
	 */
	public Allele(Class<BasePair> antitype, Haploid key, Genomap value, Diploid parent) {
		super(Allele.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	public void mass(TimeListener<?,?> sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		// commute event's command
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Genomap) {
				// a new past starts
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Genomap) {
				// a new past starts
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Gamete) {
				// cast source
				Gamete pair = (Gamete) event.getSource();
				// send message to the future 
				getValue().put(pair.getValue(), pair.getKey());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#run()
	 */
	@Override
	public void run() {
		// avoid concurrent calls to run
		if (!message.compareAndSet(RUNNER, null, Thread.currentThread())) {
			// because is already running
			return;
		} 
		else {
			// life starts here
			super.run();
			// life ends here
			push(Command.TRANSFER);
		}
	}
}