package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperintron;
import org.xmlrobot.driver.Screw;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Intron;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.Hyperpair;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Gene 
	extends ScrewDriver<Hypercube,Hyperchain> {

	/**
	 * -5629666980191745088L
	 */
	private static final long serialVersionUID = -5629666980191745088L;

	/**
	 * {@link Gene} default class constructor.
	 */
	public Gene() {
		super(Hyperintron.class, Intron.class, Gene.class, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Hypercube key, Hyperchain value, 
			Screw<Hypercube,Hyperchain> parent) {
		super(Hyperintron.class, Intron.class, Gene.class, key, value, parent);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype) {
		super(Hyperintron.class, Intron.class, Gene.class, antitype, Parity.XY);
	}
	/**
	 * {@link Gene} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Screw<Hypercube,Hyperchain>} the parent
	 */
	public Gene(Class<Gamete> antitype, Hypercube key, Hyperchain value, 
			Screw<Hypercube,Hyperchain> parent) {
		super(Hyperintron.class, Intron.class, Gene.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperpair) {
				// declare key
				Hypercube key;
				// cast source
				Hyperpair pair = (Hyperpair) event.getSource();
				// check if empty and chained
				if((key = getKey()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true
						: false) {
					// push child
					key.add(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperpair) {
				// cast source
				Hyperpair entity = (Hyperpair) event.getSource();
				// transfer message contents (to the future)
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
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {
		
		return getKey().name();
	}
	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}
}