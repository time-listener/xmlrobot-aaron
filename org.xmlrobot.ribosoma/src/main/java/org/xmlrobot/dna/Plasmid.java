/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Allele;
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
 * Plasmid implementation class.
 * @author joan
 * @parity XX
 * @since 1520.2
 */
@XmlRootElement
public class Plasmid 
	extends Parent<Diploid,Cromosoma> {

	/**
	 * 2106329525287215569L
	 */
	private static final long serialVersionUID = 2106329525287215569L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Diploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Diploid setKey(Diploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Cromosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cromosoma setValue(Cromosoma value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Rna.class)
	public Mass<Diploid,Cromosoma> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Plasmid} default class constructor.
	 */
	public Plasmid() {
		super(Rna.class, Hyperrna.class, Plasmid.class, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 */
	public Plasmid(Diploid key, Cromosoma value) {
		super(Rna.class, Hyperrna.class, Plasmid.class, key, value, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link Tetraploid} the parent
	 */
	public Plasmid(Diploid key, Cromosoma value, Tetraploid parent) {
		super(Rna.class, Hyperrna.class, Plasmid.class, key, value, parent);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Plasmid(Class<Ribosoma> antitype) {
		super(Plasmid.class, antitype, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 */
	public Plasmid(Class<Groove> antitype, Diploid key, Cromosoma value) {
		super(Plasmid.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link Tetraploid} the parent
	 */
	public Plasmid(Class<Groove> antitype, Diploid key, Cromosoma value, Tetraploid parent) {
		super(Plasmid.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Cromosoma) {
				// process
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Cromosoma) {
				// free
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Allele) {
				// cast source
				Allele pair = (Allele) event.getSource();
				// transfer message across the future
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