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
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.Hydra;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.antimatter.Hyperhiggs;
import org.xmlrobot.spacetime.matter.Higgs;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Perseus implementation class.
 * @author joan
 * @parity XX
 * @since 41160.2
 */
@XmlRootElement
public class Perseus
	extends Parent<Andromeda,MilkyWay> {

	/**
	 * -1403736829977393602L
	 */
	private static final long serialVersionUID = -1403736829977393602L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Andromeda getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setKey(Andromeda key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public MilkyWay getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setValue(MilkyWay value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Higgs.class)
	public Mass<Andromeda,MilkyWay> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Perseus} default class constructor.
	 */
	public Perseus() {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 */
	public Perseus(Andromeda key, MilkyWay value) {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, key, value, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link Columbia} the parent
	 */
	public Perseus(Andromeda key, MilkyWay value, Columbia parent) {
		
		super(Higgs.class, Hyperhiggs.class, Perseus.class, key, value, parent);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Perseus(Class<Capricornus> antitype) {
		
		super(Perseus.class, antitype, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 */
	public Perseus(Class<Capricornus> antitype, Andromeda key, MilkyWay value) {
		
		super(Perseus.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link Columbia} the parent
	 */
	public Perseus(Class<Capricornus> antitype, Andromeda key, MilkyWay value, Columbia parent) {
		
		super(Perseus.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		
		super.mass(sender, event);
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof MilkyWay) {
				// submit galaxy into hyperspace
				event.start(getContext());
			}
			break;
		case INTERRUPTED:
		case TRANSFER:
			if(event.getSource() instanceof MilkyWay) {
				// release galaxy from hyperspace
				event.stop(getContext());
			}
			else if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// transfer galaxy contents
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