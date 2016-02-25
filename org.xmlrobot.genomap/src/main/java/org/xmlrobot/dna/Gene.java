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
import org.xmlrobot.subspace.Hyperpair;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Gene implementation class.
 * @author joan
 * @parity XY
 * @since 1516.1
 */
@XmlRootElement
public class Gene 
	extends Parent<Hypercube,Hyperchain> {

	/**
	 * -5629666980191745088L
	 */
	private static final long serialVersionUID = -5629666980191745088L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Hypercube getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hypercube setKey(Hypercube key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Hyperchain getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Hyperchain setValue(Hyperchain value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperintron.class)
	public Mass<Hypercube,Hyperchain> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Gene} default class constructor.
	 */
	public Gene() {
		super(Hyperintron.class, Intron.class, Gene.class, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 */
	public Gene(Hypercube key, Hyperchain value) {
		super(Hyperintron.class, Intron.class, Gene.class, key, value, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Hypercube key, Hyperchain value, Genomap parent) {
		super(Hyperintron.class, Intron.class, Gene.class, key, value, parent);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype) {
		super(Gene.class, antitype, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype, Hypercube key, Hyperchain value) {
		super(Gene.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype, Hypercube key, Hyperchain value, Genomap parent) {
		super(Gene.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Hyperchain) {
				// feel time
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Hyperchain) {
				// feel time
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Hyperpair) {
				// cast source
				Hyperpair pair = (Hyperpair) event.getSource();
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