/**
 * 
 */
package org.xmlrobot.nature;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Nucleoplasm;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.nature.antimatter.Hyperatom;
import org.xmlrobot.nature.matter.Atom;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Organism implementation class.
 * @author joan
 * @parity XX
 * @since 1524.2
 */
@XmlRootElement
public class Organism 
	extends Parent<Cell,Operon> {

	/**
	 * -7117477549689157202L
	 */
	private static final long serialVersionUID = -7117477549689157202L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Cell getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cell setKey(Cell key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Operon getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Operon setValue(Operon value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Atom.class)
	public Mass<Cell,Operon> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Organism} default class constructor.
	 */
	public Organism() {
		super(Atom.class, Hyperatom.class, Organism.class, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 */
	public Organism(Cell key, Operon value) {
		super(Atom.class, Hyperatom.class, Organism.class, key, value, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link Biosphere} the parent
	 */
	public Organism(Cell key, Operon value, Biosphere parent) {
		super(Atom.class, Hyperatom.class, Organism.class, key, value, parent);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Organism(Class<Being> antitype) {
		super(Organism.class, antitype, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 */
	public Organism(Class<Being> antitype, Cell key, Operon value) {
		super(Organism.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Organism} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cell} the key
	 * @param value {@link Operon} the value
	 * @param parent {@link Biosphere} the parent
	 */
	public Organism(Class<Being> antitype, Cell key, Operon value, Biosphere parent) {
		super(Organism.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Operon) {
				// begin listening time
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Operon) {
				// finish listening time
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Nucleoplasm) {
				// cast source
				Nucleoplasm entity = (Nucleoplasm) event.getSource();
				// transfer contents
				getValue().put(entity.getValue(), entity.getKey());
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
