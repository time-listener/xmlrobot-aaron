/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Groove;
import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.dna.antimatter.Sperma;
import org.xmlrobot.dna.matter.Ovum;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Cytoplasm implementation class.
 * @author joan
 * @parity XY
 * @since 1522.1
 */
@XmlRootElement
public class Cytoplasm 
	extends Parent<Ribosoma,Tetraploid> {

	/**
	 * 2699555319928737598L
	 */
	private static final long serialVersionUID = 2699555319928737598L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Ribosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ribosoma setKey(Ribosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Tetraploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tetraploid setValue(Tetraploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Sperma.class)
	public Mass<Ribosoma,Tetraploid> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Cytoplasm} default class constructor.
	 */
	public Cytoplasm() {
		super(Sperma.class, Ovum.class, Cytoplasm.class, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 */
	public Cytoplasm(Ribosoma key, Tetraploid value) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, key, value, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Operon} the parent
	 */
	public Cytoplasm(Ribosoma key, Tetraploid value, Operon parent) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, key, value, parent);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype) {
		super(Cytoplasm.class, antitype, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Operon} the parent
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype, Ribosoma key, Tetraploid value) {
		super(Cytoplasm.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Operon} the parent
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype, Ribosoma key, Tetraploid value, Operon parent) {
		super(Cytoplasm.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Groove) { 
				// cast source
				Groove pair = (Groove) event.getSource();
				// see you next life
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
