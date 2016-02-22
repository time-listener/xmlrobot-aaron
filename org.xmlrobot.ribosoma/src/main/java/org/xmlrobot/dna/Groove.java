/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.BasePair;
import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.antimatter.Hyperrna;
import org.xmlrobot.dna.matter.Rna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Groove implementation class.
 * @author joan
 * @parity XY
 * @since 1520.1
 */
@XmlRootElement
public class Groove 
	extends Parent<Cromosoma,Diploid> {

	/**
	 * 5769021798206302143L
	 */
	private static final long serialVersionUID = 5769021798206302143L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Cromosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cromosoma setKey(Cromosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Diploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Diploid setValue(Diploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperrna.class)
	public Mass<Cromosoma,Diploid> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Groove} default class constructor.
	 */
	public Groove() {
		super(Hyperrna.class, Rna.class, Groove.class, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 */
	public Groove(Cromosoma key, Diploid value) {
		super(Hyperrna.class, Rna.class, Groove.class, key, value, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link Ribosoma} the parent
	 */
	public Groove(Cromosoma key, Diploid value, Ribosoma parent) {
		super(Hyperrna.class, Rna.class, Groove.class, key, value, parent);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Groove(Class<Plasmid> antitype) {
		super(Groove.class, antitype, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 */
	public Groove(Class<Plasmid> antitype, Cromosoma key, Diploid value) {
		super(Groove.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link Ribosoma} the parent
	 */
	public Groove(Class<Plasmid> antitype, Cromosoma key, Diploid value, Ribosoma parent) {
		super(Groove.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof BasePair) {
				// cast source
				BasePair pair = (BasePair) event.getSource();
				// free from inheritance
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