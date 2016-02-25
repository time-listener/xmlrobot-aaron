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
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hyperphoton;
import org.xmlrobot.spacetime.event.Impact;
import org.xmlrobot.spacetime.event.Repulsion;
import org.xmlrobot.spacetime.matter.Photon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Alpha Centauri implementation class.
 * @author joan
 * @parity XX
 * @since 41155.2
 */
@XmlRootElement
public class AlphaCentauri 
	extends Child<Saturn,Jupiter> {

	/**
	 * -6537944481620207658L
	 */
	private static final long serialVersionUID = -6537944481620207658L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Saturn getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setKey(Saturn key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Jupiter getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setValue(Jupiter value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Photon.class)
	public Mass<Saturn,Jupiter> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link AlphaCentauri} default class constructor.
	 */
	public AlphaCentauri() {
		super(Photon.class, Hyperphoton.class, AlphaCentauri.class, Parity.XX);
	}
	/**
	 * {@link AlphaCentauri} class constructor.
	 * @param antitype the inherited antitype
	 */
	public AlphaCentauri(Class<Sun> antitype) {
		super(AlphaCentauri.class, antitype, Parity.XX);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Saturn) {
				// cast source
				Saturn entity = (Saturn) event.getSource();
				// inject planet into hyperspace
				put(entity, (Jupiter) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Pegasi) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Pegasi) {
				// get antimatter
				Mass<Jupiter,Saturn> key;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Saturn) {
				// cast source
				Saturn key = (Saturn) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Impact(key));
			}
			else if(event.getSource() instanceof Pegasi) {
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
				// declare child
				Mass<Saturn,Jupiter> child;
				// call child
				if((child = getChild()) != null) {
					// antigravity
					child.pulse(this, new Repulsion(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Pegasi) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if(event.getSource() instanceof Pegasi) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Pegasi pair = (Pegasi) event.getSource();
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
			if (event.getSource() instanceof Earth) {
				// cast source
				Earth pair = (Earth) event.getSource();
				// free from inheritance
				pair.remove();
			}
			else if(event.getSource() instanceof Pegasi) {
				// finish life
				event.stop(getContext());
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
	public Jupiter put(Saturn key, Jupiter value) {
		// create child
		Vega pair = new Vega(Pegasi.class, key, value, this);
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
				child instanceof Vega : false) {
			// cast source
			Vega pair = (Vega) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putKey(pair.getValue(), pair.getKey());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByValue(pair.getValue());
			}
		}
	}
}