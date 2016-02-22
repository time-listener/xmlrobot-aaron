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
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Pegasi;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.antimatter.HyperbosonW;
import org.xmlrobot.spacetime.matter.BosonW;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Virgo implementation class.
 * @author joan
 * @parity XY
 * @since 41158.1
 */
@XmlRootElement
public class Virgo 
	extends Parent<Sun,AlphaCentauri> {

	/**
	 * 465254906037303131L
	 */
	private static final long serialVersionUID = 465254906037303131L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Sun getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setKey(Sun key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setValue(AlphaCentauri value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=HyperbosonW.class)
	public Mass<Sun,AlphaCentauri> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Virgo} default class constructor.
	 */
	public Virgo() {
		super(HyperbosonW.class, BosonW.class, Virgo.class, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 */
	public Virgo(Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, BosonW.class, Virgo.class, key, value, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link MilkyWay} the parent
	 */
	public Virgo(Sun key, AlphaCentauri value, MilkyWay parent) {
		super(HyperbosonW.class, BosonW.class, Virgo.class, key, value, parent);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Virgo(Class<Hydra> antitype) {
		super(Virgo.class, antitype, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 */
	public Virgo(Class<Hydra> antitype, Sun key, AlphaCentauri value) {
		super(Virgo.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link MilkyWay} the parent
	 */
	public Virgo(Class<Hydra> antitype, Sun key, AlphaCentauri value, MilkyWay parent) {
		super(Virgo.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER:
			
			if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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