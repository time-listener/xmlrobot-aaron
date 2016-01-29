/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypermuon;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.Virgo;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Muon;
import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Capricornus 
	extends ScrewDriver<MilkyWay,Andromeda>  {
	
	/**
	 * 2287183649427568656L
	 */
	private static final long serialVersionUID = 2287183649427568656L;
	
	/**
	 * {@link Capricornus} default class constructor.
	 */
	public Capricornus() {
		
		super(Hypermuon.class, Muon.class, Capricornus.class, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Screw<MilkyWay,Andromeda>} the parent
	 */
	public Capricornus(MilkyWay key, Andromeda value, ScrewDriver<MilkyWay,Andromeda> parent) {
		
		super(Hypermuon.class, Muon.class, Capricornus.class, key, value, parent);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Capricornus(Class<Perseus> antitype) {
		
		super(Hypermuon.class, Muon.class, Capricornus.class, antitype, Parity.XY);
	}
	/**
	 * {@link Capricornus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Screw<MilkyWay,Andromeda>} the parent
	 */
	public Capricornus(Class<Perseus> antitype, MilkyWay key, Andromeda value, ScrewDriver<MilkyWay,Andromeda> parent) {
		
		super(Hypermuon.class, Muon.class, Capricornus.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			
			if(event.getSource() instanceof Virgo) {
				// get antimatter
				ScrewDriver<Sun,AlphaCentauri> key;
				// cast source
				Virgo pair = (Virgo) event.getSource();
				// check if empty and chained
				if((key = getKey()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Virgo) {
				// cast source
				Virgo entity = (Virgo) event.getSource();
				// transfer message contents
				getValue().putValue(entity.getValue(), entity.getKey());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#run()
	 */
	public void run() {
		super.run();
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}
