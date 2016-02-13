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
import org.xmlrobot.spacetime.Pegasi;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.antimatter.HyperbosonW;
import org.xmlrobot.spacetime.matter.BosonW;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Virgo implementation class.
 * @author joan
 * @parity XY
 * @since 41158.1
 */
@XmlRootElement
public class Virgo 
	extends Parent<Sun,AlphaCentauri> {

	/**
	 * 465254906037303131L
	 */
	private static final long serialVersionUID = 465254906037303131L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Sun getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setKey(Sun key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setValue(AlphaCentauri value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=HyperbosonW.class)
	public Mass<Sun,AlphaCentauri> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Virgo} default class constructor.
	 */
	public Virgo() {
		super(HyperbosonW.class, BosonW.class, Virgo.class, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 */
	public Virgo(Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, BosonW.class, Virgo.class, key, value, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link MilkyWay} the parent
	 */
	public Virgo(Sun key, AlphaCentauri value, MilkyWay parent) {
		super(HyperbosonW.class, BosonW.class, Virgo.class, key, value, parent);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Virgo(Class<Hydra> antitype) {
		super(HyperbosonW.class, BosonW.class, Virgo.class, antitype, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 */
	public Virgo(Class<Hydra> antitype, Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, BosonW.class, Virgo.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Virgo} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link MilkyWay} the parent
	 */
	public Virgo(Class<Hydra> antitype, Sun key, AlphaCentauri value, MilkyWay parent) {
		super(HyperbosonW.class, BosonW.class, Virgo.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER:
			
			if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
				child instanceof Virgo : false) {
			// cast source
			Virgo pair = (Virgo) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new HyperbosonW(BosonW.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}