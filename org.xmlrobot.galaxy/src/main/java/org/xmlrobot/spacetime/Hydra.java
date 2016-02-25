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
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.Vega;
import org.xmlrobot.spacetime.antimatter.HyperbosonW;
import org.xmlrobot.spacetime.matter.BosonW;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Hydra implementation class.
 * @author joan
 * @parity XX
 * @since 41158.2
 */
@XmlRootElement
public class Hydra 
	extends Parent<AlphaCentauri,Sun> {
	/**
	 * 8843376414708744759L
	 */
	private static final long serialVersionUID = 8843376414708744759L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setKey(AlphaCentauri key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Sun getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setValue(Sun value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=BosonW.class)
	public Mass<AlphaCentauri,Sun> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Hydra} default class constructor.
	 */
	public Hydra() {
		super(BosonW.class, HyperbosonW.class, Hydra.class, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 */
	public Hydra(AlphaCentauri key, Sun value) {
		super(BosonW.class, HyperbosonW.class, Hydra.class, key, value, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 * @param parent {@link Andromeda} the parent
	 */
	public Hydra(AlphaCentauri key, Sun value, Andromeda parent) {
		super(BosonW.class, HyperbosonW.class, Hydra.class, key, value, parent);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hydra(Class<Virgo> antitype) {
		super(Hydra.class, antitype, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 */
	public Hydra(Class<Virgo> antitype, AlphaCentauri key, Sun value) {
		super(Hydra.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 * @param parent {@link Andromeda} the parent
	 */
	public Hydra(Class<Virgo> antitype, AlphaCentauri key, Sun value, Andromeda parent) {
		super(Hydra.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Sun) {
				// start new star
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof Sun) {
				// stop old star
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Vega) {
				// cast source
				Vega pair = (Vega) event.getSource();
				// transfer star contents
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
