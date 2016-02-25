/**
 * 
 */
package org.xmlrobot.spacetime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.nature.Organism;
import org.xmlrobot.spacetime.antimatter.Hypermetal;
import org.xmlrobot.spacetime.matter.Metal;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Home implementation class.
 * @author joan
 * @parity XX
 * @since 41154.2
 */
@XmlRootElement
public class Earth 
	extends Parent<Biosphere,Ecosystem> {

	/**
	 * 3239165432095598794L
	 */
	private static final long serialVersionUID = 3239165432095598794L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Biosphere getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Biosphere setKey(Biosphere key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Ecosystem getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ecosystem setValue(Ecosystem value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Metal.class)
	public Mass<Biosphere,Ecosystem> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Earth} default class constructor.
	 */
	public Earth() {
		super(Metal.class, Hypermetal.class, Earth.class, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 */
	public Earth(Biosphere key, Ecosystem value) {
		super(Metal.class, Hypermetal.class, Earth.class, key, value, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link Saturn} the parent
	 */
	public Earth(Biosphere key, Ecosystem value, Saturn parent) {
		super(Metal.class, Hypermetal.class, Earth.class, key, value, parent);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Earth(Class<Mars> antitype) {
		super(Earth.class, antitype, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 */
	public Earth(Class<Mars> antitype, Biosphere key, Ecosystem value) {
		super(Earth.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Earth} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link Saturn} the parent
	 */
	public Earth(Class<Mars> antitype, Biosphere key, Ecosystem value, Saturn parent) {
		super(Earth.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Ecosystem) {
				// start new being environment
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Ecosystem) {
				// stop old being environment
				event.start(getContext());
			}
			else if(event.getSource() instanceof Organism) {
				// cast source
				Organism pair = (Organism) event.getSource();
				// transfer hypermass
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
