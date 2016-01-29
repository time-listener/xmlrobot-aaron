/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Cluster;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
import org.xmlrobot.antimatter.Hypermeson;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.genesis.Genesis;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Meson;
import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Everything starts here,
 * <br>
 * @author joan
 * @parity XY
 *
 * @since now
 */
@XmlRootElement
public class BigBang 
	extends ScrewDriver<Spacetime,Minkowski> 
		implements Genesis {
	
	/**
	 * 2800389938473591910L
	 */
	private static final long serialVersionUID = 2800389938473591910L;
	
	/**
	 * {@link BigBang} default class constructor.
	 */
	public BigBang() {
		super(Hypermeson.class, Meson.class, BigBang.class, Parity.YY);
	}
	/**
	 * {@link BigBang} class constructor.
	 */
	public BigBang(Spacetime key, Minkowski value,
			ScrewDriver<Spacetime,Minkowski> parent) {
		super(Hypermeson.class, Meson.class, BigBang.class, key, value, parent);
	}
	/**
	 * {@link BigBang} class constructor.
	 * @param antitype the inherited antitype
	 */
	public BigBang(Class<BigBong> antitype) {
		super(Hypermeson.class, Meson.class, BigBang.class, antitype, Parity.YY);
	}
	/**
	 * {@link BigBang} class constructor.
	 */
	public BigBang(Class<BigBong> antitype, Spacetime key, Minkowski value, 
			ScrewDriver<Spacetime,Minkowski> parent) {
		super(Hypermeson.class, Meson.class, BigBang.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);

		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Cluster) {
				// get antimatter
				ScrewDriver<Fornax,Columbia> key;
				// cast source
				Cluster pair = (Cluster) event.getSource();
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
			if(event.getSource() instanceof Cluster) {
				// cast source
				Cluster entity = (Cluster) event.getSource();
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
