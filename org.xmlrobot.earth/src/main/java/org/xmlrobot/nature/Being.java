/**
 * 
 */
package org.xmlrobot.nature;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Cytoplasm;
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
 * Being implementation class.
 * @author joan
 * @parity XY
 * @since 1524.1
 */
@XmlRootElement
public class Being 
	extends Parent<Operon,Cell> {

	/**
	 * -2219408315913205280L
	 */
	private static final long serialVersionUID = -2219408315913205280L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Operon getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Operon setKey(Operon key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Cell getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cell setValue(Cell value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperatom.class)
	public Mass<Operon,Cell> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Being} default class constructor.
	 */
	public Being() {
		super(Hyperatom.class, Atom.class, Being.class, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Ecosystem} the parent
	 */
	public Being(Operon key, Cell value) {
		super(Hyperatom.class, Atom.class, Being.class, key, value, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Ecosystem} the parent
	 */
	public Being(Operon key, Cell value, Ecosystem parent) {
		super(Hyperatom.class, Atom.class, Being.class, key, value, parent);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Being(Class<Organism> antitype) {
		super(Being.class, antitype, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 */
	public Being(Class<Organism> antitype, Operon key, Cell value) {
		super(Being.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Being} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Operon} the key
	 * @param value {@link Cell} the value
	 * @param parent {@link Ecosystem} the parent
	 */
	public Being(Class<Organism> antitype, Operon key, Cell value, Ecosystem parent) {
		super(Being.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Cell) {
				// start listening time
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Cell) {
				// stop listening time
				event.start(getContext());
			}
			else if(event.getSource() instanceof Cytoplasm) {
				// cast source
				Cytoplasm pair = (Cytoplasm) event.getSource();
				// transfer contents
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