/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperlepton;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.Andromeda;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Lepton;
import org.xmlrobot.Columbia;
import org.xmlrobot.Fornax;
import org.xmlrobot.Perseus;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 * @parity XX
 */
@XmlRootElement
public class Galaxy 
	extends ScrewDriver<Columbia,Fornax> {

	/**
	 * -2596731065653123335L
	 */
	private static final long serialVersionUID = -2596731065653123335L;

	/**
	 * {@link Galaxy} default class constructor.
	 */
	public Galaxy() {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, Parity.XX);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 * @param parent {@link ScrewDriver<Columbia,Fornax>} the parent
	 */
	public Galaxy(Columbia key, Fornax value, ScrewDriver<Columbia,Fornax> parent) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, key, value, parent);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Galaxy(Class<Cluster> antitype) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, antitype, Parity.XX);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 * @param parent {@link ScrewDriver<Columbia,Fornax>} the parent
	 */
	public Galaxy(Class<Cluster> antitype, Columbia key, Fornax value, ScrewDriver<Columbia,Fornax> parent) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Perseus) {
				// get antimatter
				ScrewDriver<Andromeda,MilkyWay> stem;
				// cast source
				Perseus pair = (Perseus) event.getSource();
				// check if empty and chained
				if((stem = getKey()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					stem.add(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Perseus) {
				// cast source
				Perseus entity = (Perseus) event.getSource();
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
