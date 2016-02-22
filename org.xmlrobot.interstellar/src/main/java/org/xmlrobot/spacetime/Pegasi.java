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
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Mars;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hypergluon;
import org.xmlrobot.spacetime.matter.Gluon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * 51 Pegasi implementation class.
 * @author joan
 * @parity XY
 * @since 41156.1
 */
@XmlRootElement
public class Pegasi 
	extends Parent<Jupiter,Saturn> {

	/**
	 * 8604727878873857518L
	 */
	private static final long serialVersionUID = 8604727878873857518L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Jupiter getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setKey(Jupiter key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Saturn getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setValue(Saturn value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hypergluon.class)
	public Mass<Jupiter,Saturn> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Pegasi} default class constructor.
	 */
	public Pegasi() {
		super(Hypergluon.class, Gluon.class, Pegasi.class, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 */
	public Pegasi(Jupiter key, Saturn value) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, key, value, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Sun} the parent
	 */
	public Pegasi(Jupiter key, Saturn value, Sun parent) {
		super(Hypergluon.class, Gluon.class, Pegasi.class, key, value, parent);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Pegasi(Class<Vega> antitype) {
		super(Pegasi.class, antitype, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 */
	public Pegasi(Class<Vega> antitype, Jupiter key, Saturn value) {
		super(Pegasi.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Pegasi} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Jupiter} the key
	 * @param value {@link Saturn} the value
	 * @param parent {@link Sun} the parent
	 */
	public Pegasi(Class<Vega> antitype, Jupiter key, Saturn value, Sun parent) {
		super(Pegasi.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Mars) {
				// cast source
				Mars pair = (Mars) event.getSource();
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