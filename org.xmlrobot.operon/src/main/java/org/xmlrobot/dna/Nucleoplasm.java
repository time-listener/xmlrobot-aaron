/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Plasmid;
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
 * Nucleoplasm implementation class.
 * @author joan
 * @parity XX
 * @since 1522.2
 */
@XmlRootElement
public class Nucleoplasm 
	extends Parent<Tetraploid,Ribosoma> {

	/**
	 * 3057140414113756471L
	 */
	private static final long serialVersionUID = 3057140414113756471L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Tetraploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tetraploid setKey(Tetraploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Ribosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ribosoma setValue(Ribosoma value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Ovum.class)
	public Mass<Tetraploid,Ribosoma> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Nucleoplasm} default class constructor.
	 */
	public Nucleoplasm() {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Cell} the parent
	 */
	public Nucleoplasm(Tetraploid key, Ribosoma value) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, key, value, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Cell} the parent
	 */
	public Nucleoplasm(Tetraploid key, Ribosoma value, Cell parent) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, key, value, parent);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype) {
		super(Nucleoplasm.class, antitype, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype, Tetraploid key, Ribosoma value) {
		super(Nucleoplasm.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Cell} the parent
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype, Tetraploid key, Ribosoma value, Cell parent) {
		super(Nucleoplasm.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Ribosoma) {
				// start all times
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER: 
			if(event.getSource() instanceof Ribosoma) {
				// stop all times
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Plasmid) {
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
				// reincarnate message
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