/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Earth;
import org.xmlrobot.Jupiter;
import org.xmlrobot.Saturn;
import org.xmlrobot.antimatter.Hypergluon;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.driver.ScrewNut;
import org.xmlrobot.event.Impact;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.Biosphere;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Gluon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Vega 
	extends ScrewDriver<Saturn,Jupiter> {

	/**
	 * 4236681231104503993L
	 */
	private static final long serialVersionUID = 4236681231104503993L;
	
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
	 * @param parent {@link ScrewNut<Saturn,Jupiter>} the parent
	 */
	public Vega(Saturn key, Jupiter value, ScrewNut<Saturn,Jupiter> parent) {
		super(Gluon.class, Hypergluon.class, Vega.class, key, value, parent);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Vega(Class<Pegasi> antitype) {
		super(Gluon.class, Hypergluon.class, Vega.class, antitype, Parity.XX);
	}
	/**
	 * {@link Vega} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Saturn} the key
	 * @param value {@link Jupiter} the value
	 * @param parent {@link ScrewNut<Saturn,Jupiter>} the parent
	 */
	public Vega(Class<Pegasi> antitype, Saturn key, Jupiter value, ScrewNut<Saturn,Jupiter> parent) {
		super(Gluon.class, Hypergluon.class, Vega.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Earth) {
				// get matter
				ScrewDriver<Biosphere,Ecosystem> key;
				// cast source
				Earth pair = (Earth) event.getSource();
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
		case GENESIS:
			if(event.getSource() instanceof Earth) {
				// cast  source
				Earth string = (Earth) event.getSource();
				// send pulse across the future
				getValue().pulse(this, new Impact(string));
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Earth) {
				// cast source
				Earth entity = (Earth) event.getSource();
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
