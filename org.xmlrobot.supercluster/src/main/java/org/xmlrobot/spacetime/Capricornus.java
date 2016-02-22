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
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.Virgo;
import org.xmlrobot.spacetime.antimatter.Hyperhiggs;
import org.xmlrobot.spacetime.matter.Higgs;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Capricornus implementation class.
 * @author joan
 * @parity XY
 * @since 41160.1
 */
@XmlRootElement
public class Capricornus 
	extends Parent<MilkyWay,Andromeda>  {
	
	/**
	 * 2287183649427568656L
	 */
	private static final long serialVersionUID = 2287183649427568656L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public MilkyWay getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public MilkyWay setKey(MilkyWay key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Andromeda getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Andromeda setValue(Andromeda value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperhiggs.class)
	public Mass<MilkyWay,Andromeda> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Capricornus} default class constructor.
	 */
	public Capricornus() {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Capricornus(MilkyWay key, Andromeda value) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, key, value, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Fornax} the parent
	 */
	public Capricornus(MilkyWay key, Andromeda value, Fornax parent) {
		
		super(Hyperhiggs.class, Higgs.class, Capricornus.class, key, value, parent);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Capricornus(Class<Perseus> antitype) {
		
		super(Capricornus.class, antitype, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Capricornus(Class<Perseus> antitype, MilkyWay key, Andromeda value) {
		
		super(Capricornus.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Fornax} the parent
	 */
	public Capricornus(Class<Perseus> antitype, MilkyWay key, Andromeda value, Fornax parent) {
		
		super(Capricornus.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo pair = (Virgo) event.getSource();
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
