/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hypermuon;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.Andromeda;
import org.xmlrobot.Hydra;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Muon;
import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Sun;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The {@code hyperspace mass} implementation class.
 * <br><br>
 * @author joan
 *
 */
public class Perseus 
	extends ScrewDriver<Andromeda,MilkyWay> {

	/**
	 * -1403736829977393602L
	 */
	private static final long serialVersionUID = -1403736829977393602L;
	
	/**
	 * {@link Perseus} default class constructor.
	 */
	public Perseus() {
		
		super(Muon.class, Hypermuon.class, Perseus.class, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link ScrewNut<Andromeda,MilkyWay>} the parent
	 */
	public Perseus(Andromeda key, MilkyWay value, ScrewNut<Andromeda,MilkyWay> parent) {
		
		super(Muon.class, Hypermuon.class, Perseus.class, key, value, parent);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Perseus(Class<Capricornus> antitype) {
		
		super(Muon.class, Hypermuon.class, Perseus.class, antitype, Parity.XX);
	}
	/**
	 * {@link Perseus} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link ScrewNut<Andromeda,MilkyWay>} the parent
	 */
	public Perseus(Class<Capricornus> antitype, Andromeda key, MilkyWay value, ScrewNut<Andromeda,MilkyWay> parent) {
		
		super(Muon.class, Hypermuon.class, Perseus.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		
		super.mass(sender, event);
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Hydra) {
				// declare stem
				ScrewDriver<AlphaCentauri,Sun> key;
				// cast source
				Hydra pair = (Hydra) event.getSource();
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
			if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra entity = (Hydra) event.getSource();
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
	@Override
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