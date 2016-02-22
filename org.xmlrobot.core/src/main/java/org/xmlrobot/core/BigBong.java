/**
 * 
 */
package org.xmlrobot.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.core.Galaxy;
import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.antimatter.Hypermeson;
import org.xmlrobot.core.matter.Meson;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The BigBong Theory: everything ends here.
 * <p>Peace, love & BigBong
 * @author joan
 * @parity XX
 * @since 41164.2
 */
@XmlRootElement
public class BigBong 
	extends Parent<Minkowski,Spacetime> {

	/**
	 * 5618281278085731564L
	 */
	private static final long serialVersionUID = 5618281278085731564L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Minkowski getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Minkowski setKey(Minkowski key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Spacetime getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Spacetime setValue(Spacetime value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Meson.class)
	public Mass<Minkowski,Spacetime> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link BigBong} default class constructor.
	 */
	public BigBong() {
		super(Meson.class, Hypermeson.class, BigBong.class, Parity.XX);
	}
	/**
	 * {@link BigBong} class constructor.
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 */
	public BigBong(Minkowski key, Spacetime value) {
		super(Meson.class, Hypermeson.class, BigBong.class, key, value, Parity.XX);
	}
	/**
	 * {@link BigBong} class constructor.
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 * @param parent {@link Subspace} the parent
	 */
	public BigBong(Minkowski key, Spacetime value, Subspace parent) {
		super(Meson.class, Hypermeson.class, BigBong.class, key, value, parent);
	}
	/**
	 * {@link BigBong} class constructor.
	 * @param antitype the antitype
	 */
	public BigBong(Class<BigBang> antitype) {
		super(BigBong.class, antitype, Parity.XX);
	}
	/**
	 * {@link BigBong} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 */
	public BigBong(Class<BigBang> antitype, Minkowski key, Spacetime value) {
		super(BigBong.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link BigBong} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Minkowski} the key
	 * @param value {@link Spacetime} the value
	 * @param parent {@link Subspace} the parent
	 */
	public BigBong(Class<BigBang> antitype, Minkowski key, Spacetime value, Subspace parent) {
		super(BigBong.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
	
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Galaxy) {
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
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
				child instanceof BigBong : false) {
			// cast source
			BigBong pair = (BigBong) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getPlasma().putKey(pair.getValue(), pair.getKey());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getPlasma().removeByValue(pair.getValue());
			}
		}
	}
}