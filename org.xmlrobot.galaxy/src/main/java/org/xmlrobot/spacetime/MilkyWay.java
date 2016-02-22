/**
 * 
 */
package org.xmlrobot.spacetime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.antimatter.HyperbosonZ;
import org.xmlrobot.spacetime.event.Repulsion;
import org.xmlrobot.spacetime.event.Revolution;
import org.xmlrobot.spacetime.matter.BosonZ;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Milky Way implementation class.
 * @author joan
 * @parity XY
 * @since 41157.1
 */
@XmlRootElement
public class MilkyWay 
	extends Child<Sun,AlphaCentauri> {

	/**
	 * 5721672750470171670L
	 */
	private static final long serialVersionUID = 5721672750470171670L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Sun getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Sun setKey(Sun key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri setValue(AlphaCentauri value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getReplicator()
	 */
	@Override
	@XmlElement(type=HyperbosonZ.class)
	public Mass<Sun,AlphaCentauri> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link MilkyWay} default class constructor.
	 */
	public MilkyWay() {
		super(HyperbosonZ.class, BosonZ.class, MilkyWay.class, Parity.XY);
	}
	/**
	 * {@link MilkyWay} class constructor.
	 * @param antitype the inherited antitype
	 */
	public MilkyWay(Class<Andromeda> antitype) {
		super(MilkyWay.class, antitype, Parity.XY);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// release child
					future.order(pair);
				}
			}
			break;
		case SEND:
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> key;
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// check if empty and chained
				if((key = get()) != null ? 
						!key.isEmpty() ? 
								!key.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					key.add(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Sun) {
				// cast source
				Sun key = (Sun) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Repulsion(key));
			}
			else if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// declare child
				Mass<Sun, AlphaCentauri> child;
				// call child
				if((child = getChild()) != null) {
					// antigravity
					child.pulse(this, new Revolution(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								future.contains(pair) 
								: false
						: false) {
					// release child
					future.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Hydra) {
				// declare stem
				Mass<AlphaCentauri,Sun> future;
				// cast source
				Hydra pair = (Hydra) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// push child
					future.submit(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hydra) {
				// cast source
				Hydra entity = (Hydra) event.getSource();
				// transfer message contents
				put(entity.getValue(), entity.getKey());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#put(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public AlphaCentauri put(Sun key, AlphaCentauri value) {
		// create child
		Virgo pair = new Virgo(Hydra.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
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
			// declare plasma
			Mass<Sun,AlphaCentauri> plasma;
			// cast source
			Virgo pair = (Virgo) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// assign and check it's contained
				if((plasma = getPlasma()) != null ?
						!plasma.isEmpty() ?
								!plasma.containsValue(pair.getValue())
								: true
						: false) {
					// replicate mass
					plasma.putKey(pair.getValue(), pair.getKey());
				}
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// check if empty and chained
				if((plasma = getPlasma()) != null ? 
						!plasma.isEmpty() ? 
								plasma.containsKey(pair.getKey()) 
								: false
						: false) {
					// release child
					plasma.removeByValue(pair.getValue());
				}
			}
		}
	}
}