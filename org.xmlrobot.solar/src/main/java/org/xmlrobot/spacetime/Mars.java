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
import org.xmlrobot.nature.Being;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.spacetime.antimatter.Hypermetal;
import org.xmlrobot.spacetime.matter.Metal;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Mars implementation class.
 * @author joan
 * @parity XY
 * @since 41154.1
 */
@XmlRootElement
public class Mars 
	extends Parent<Ecosystem,Biosphere> {

	/**
	 * 5496849604846314737L
	 */
	private static final long serialVersionUID = 5496849604846314737L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Ecosystem getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ecosystem setKey(Ecosystem key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Biosphere getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Biosphere setValue(Biosphere value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hypermetal.class)
	public Mass<Ecosystem,Biosphere> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Mars} default class constructor.
	 */
	public Mars() {
		super(Hypermetal.class, Metal.class, Mars.class, Parity.XY);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 */
	public Mars(Ecosystem key, Biosphere value) {
		super(Hypermetal.class, Metal.class, Mars.class, key, value, Parity.XX);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Jupiter} the parent
	 */
	public Mars(Ecosystem key, Biosphere value,	Jupiter parent) {
		super(Hypermetal.class, Metal.class, Mars.class, key, value, parent);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Mars(Class<Earth> antitype) {
		super(Mars.class, antitype, Parity.XY);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 */
	public Mars(Class<Earth> antitype, Ecosystem key, Biosphere value) {
		super(Mars.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Mars} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ecosystem} the key
	 * @param value {@link Biosphere} the value
	 * @param parent {@link Jupiter} the parent
	 */
	public Mars(Class<Earth> antitype, Ecosystem key, Biosphere value, Jupiter parent) {
		super(Mars.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
	
		super.mass(sender, event);
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Biosphere) {
				// begin new organism platform
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Biosphere) {
				// finish old organism platform
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Being) {
				// cast source
				Being pair = (Being) event.getSource();
				// keep message alive
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
