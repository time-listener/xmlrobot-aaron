/**
 * 
 */
package org.xmlrobot.spacetime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
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
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setKey(AlphaCentauri key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Sun getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setValue(Sun value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
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
		super(BosonW.class, HyperbosonW.class, Hydra.class, antitype, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 */
	public Hydra(Class<Virgo> antitype, AlphaCentauri key, Sun value) {
		super(BosonW.class, HyperbosonW.class, Hydra.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Hydra} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 * @param parent {@link Andromeda} the parent
	 */
	public Hydra(Class<Virgo> antitype, AlphaCentauri key, Sun value, Andromeda parent) {
		super(BosonW.class, HyperbosonW.class, Hydra.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Vega) {
				// cast source
				Vega pair = (Vega) event.getSource();
				// free from inheritance
				pair.remove();
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
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Hydra : false) {
			// cast source
			Hydra pair = (Hydra) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new BosonW(HyperbosonW.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}
