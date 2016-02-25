/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.antimatter.Hyperintron;
import org.xmlrobot.dna.matter.Intron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.subspace.Hyperentry;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Gamete implementation class.
 * @author joan
 * @parity XX
 * @since 1516.2
 */
@XmlRootElement
public class Gamete 
	extends Parent<Hyperchain,Hypercube> {

	/**
	 * 6313328582512099749L
	 */
	private static final long serialVersionUID = 6313328582512099749L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Hyperchain getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hyperchain setKey(Hyperchain key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Hypercube getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hypercube setValue(Hypercube value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Intron.class)
	public Mass<Hyperchain,Hypercube> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Gamete} default class constructor.
	 */
	public Gamete() {
		super(Intron.class, Hyperintron.class, Gamete.class, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Hyperchain key, Hypercube value) {
		super(Intron.class, Hyperintron.class, Gamete.class, key, value, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Hyperchain key, Hypercube value, Haploid parent) {
		super(Intron.class, Hyperintron.class, Gamete.class, key, value, parent);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Class<Gene> antitype) {
		super(Gamete.class, antitype, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Class<Gene> antitype, Hyperchain key, Hypercube value) {
		super(Gamete.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Haploid} the parent
	 */
	public Gamete(Class<Gene> antitype, Hyperchain key, Hypercube value, Haploid  parent) {
		super(Gamete.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Hypercube) {
				// listen time
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Hypercube) {
				// stop listening
				event.stop(getContext());
			}
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry pair = (Hyperentry) event.getSource();
				// transfer contents to the future
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