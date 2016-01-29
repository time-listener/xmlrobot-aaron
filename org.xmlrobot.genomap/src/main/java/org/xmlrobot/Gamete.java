/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperintron;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Intron;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.Hyperentry;
import org.xmlrobot.Hyperinteger;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Gamete 
	extends ScrewDriver<Hyperchain,Hypercube> {

	/**
	 * 6313328582512099749L
	 */
	private static final long serialVersionUID = 6313328582512099749L;

	/**
	 * {@link Gamete} default class constructor.
	 */
	public Gamete() {
		super(Intron.class, Hyperintron.class, Gamete.class, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Gamete(Hyperchain key, Hypercube value,
			ScrewNut<Hyperchain,Hypercube> parent) {
		super(Intron.class, Hyperintron.class, Gamete.class, key, value, parent);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Gamete(Class<Gene> antitype) {
		super(Intron.class, Hyperintron.class, Gamete.class, antitype, Parity.XX);
	}
	/**
	 * {@link Gamete} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link ScrewNut} the parent
	 */
	public Gamete(Class<Gene> antitype, Hyperchain key, Hypercube value, 
			ScrewNut<Hyperchain,Hypercube> parent) {
		super(Intron.class, Hyperintron.class, Gamete.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperentry) {
				// declare key
				Hyperinteger key;
				// cast source
				Hyperentry pair = (Hyperentry) event.getSource();
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
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry entity = (Hyperentry) event.getSource();
				// transfer message contents
				getValue().put(entity.getValue(), entity.getKey());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {
		
		return getKey().name();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
}
