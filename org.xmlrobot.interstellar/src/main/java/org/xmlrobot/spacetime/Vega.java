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
import org.xmlrobot.spacetime.Earth;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hypergluon;
import org.xmlrobot.spacetime.matter.Gluon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Vega implementation class. 
 * @author joan
 * @parity XX
 * @since 41156.2
 */
@XmlRootElement
public class Vega 
	extends Parent<Saturn,Jupiter> {

	/**
	 * 4236681231104503993L
	 */
	private static final long serialVersionUID = 4236681231104503993L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Saturn getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setKey(Saturn key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Jupiter getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setValue(Jupiter value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Gluon.class)
	public Mass<Saturn,Jupiter> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Vega} default class constructor.
	 */
	public Vega() {
		super(Gluon.class, Hypergluon.class, Vega.class, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 */
	public Vega(Saturn key, Jupiter value) {
		super(Gluon.class, Hypergluon.class, Vega.class, key, value, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 * @param parent {@link AlphaCentauri} the parent
	 */
	public Vega(Saturn key, Jupiter value, AlphaCentauri parent) {
		super(Gluon.class, Hypergluon.class, Vega.class, key, value, parent);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Vega(Class<Pegasi> antitype) {
		super(Vega.class, antitype, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 */
	public Vega(Class<Pegasi> antitype, Saturn key, Jupiter value) {
		super(Vega.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 * @param parent {@link AlphaCentauri} the parent
	 */
	public Vega(Class<Pegasi> antitype, Saturn key, Jupiter value, AlphaCentauri parent) {
		super(Vega.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER:
			if (event.getSource() instanceof Earth) {
				// cast source
				Earth pair = (Earth) event.getSource();
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
