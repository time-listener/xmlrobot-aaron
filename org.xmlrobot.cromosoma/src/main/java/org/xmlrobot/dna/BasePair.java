/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Gene;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.antimatter.Hypertype;
import org.xmlrobot.dna.matter.Karyotype;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Base pair implementation class.
 * @author joan
 * @parity XY
 * @since 1518.1
 */
@XmlRootElement
public class BasePair 
	extends Parent<Genomap,Haploid> {

	/**
	 * -7944087613705943766L
	 */
	private static final long serialVersionUID = -7944087613705943766L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Genomap getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Genomap setKey(Genomap key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Haploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Haploid setValue(Haploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hypertype.class)
	public Mass<Genomap,Haploid> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link BasePair} default class constructor.
	 */
	public BasePair() {
		super(Hypertype.class, Karyotype.class, BasePair.class, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public BasePair(Genomap key, Haploid value) {
		super(Hypertype.class, Karyotype.class, BasePair.class, key, value, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Cromosoma} the parent
	 */
	public BasePair(Genomap key, Haploid value, Cromosoma parent) {
		super(Hypertype.class, Karyotype.class, BasePair.class, key, value, parent);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 */
	public BasePair(Class<Allele> antitype) {
		super(BasePair.class, antitype, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public BasePair(Class<Allele> antitype, Genomap key, Haploid value) {
		super(BasePair.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link BasePair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Cromosoma} the parent
	 */
	public BasePair(Class<Allele> antitype, Genomap key, Haploid value, Cromosoma parent) {
		super(BasePair.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Gene) {
				// cast source
				Gene pair = (Gene) event.getSource();
				// rest in peace
				pair.remove();
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