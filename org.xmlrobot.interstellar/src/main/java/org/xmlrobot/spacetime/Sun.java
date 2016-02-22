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
import org.xmlrobot.spacetime.event.Attraction;
import org.xmlrobot.spacetime.event.Collision;
import org.xmlrobot.spacetime.matter.Photon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Sun implementation class.
 * @author joan
 * @parity XY
 * @since 41155.1
 */
@XmlRootElement
public class Sun 
	extends Child<Jupiter,Saturn> {

	/**
	 * 2938099720879190128L
	 */
	private static final long serialVersionUID = 2938099720879190128L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Jupiter getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Jupiter setKey(Jupiter key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Saturn getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Saturn setValue(Saturn value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperphoton.class)
	public Mass<Jupiter,Saturn> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Sun} default class constructor.
	 */
	public Sun() {
		super(Hyperphoton.class, Photon.class, Sun.class, Parity.XY);
	}
	/**
	 * {@link Sun} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Sun(Class<AlphaCentauri> antitype) {
		super(Sun.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Vega) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Vega pair = (Vega) event.getSource();
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
			if(event.getSource() instanceof Vega) {
				// get antimatter
				Mass<Saturn,Jupiter> key;
				// cast source
				Vega pair = (Vega) event.getSource();
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
			if(event.getSource() instanceof Jupiter) {
				// cast source
				Jupiter key = (Jupiter) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Collision(key));
			}
			else if(event.getSource() instanceof Vega) {
				// cast source
				Vega pair = (Vega) event.getSource();
				// declare child
				Mass<Jupiter,Saturn> child;
				// call child
				if((child = getChild()) != null) {
					// gravity
					child.pulse(this, new Attraction(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Vega) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Vega pair = (Vega) event.getSource();
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
			if(event.getSource() instanceof Vega) {
				// declare stem
				Mass<Saturn,Jupiter> future;
				// cast source
				Vega pair = (Vega) event.getSource();
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
			if(event.getSource() instanceof Vega) {
				// cast source
				Vega entity = (Vega) event.getSource();
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
	public Saturn put(Jupiter key, Saturn value) {
		// create child
		Pegasi pair = new Pegasi(Vega.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Pegasi : false) {
			// declare plasma
			Mass<Jupiter,Saturn> plasma;
			// cast source
			Pegasi pair = (Pegasi) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// assign and check it's contained
				if((plasma = getPlasma()) != null ?
						!plasma.isEmpty() ?
								!plasma.containsKey(pair.getKey())
								: true
						: false) {
					// replicate mass
					plasma.putValue(pair.getKey(), pair.getValue());
				}
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// check if empty and chained
				if((plasma = getPlasma()) != null ? 
						!plasma.isEmpty() ? 
								plasma.containsValue(pair.getValue()) 
								: false
						: false) {
					// release child
					plasma.removeByKey(pair.getKey());
				}
			}
		}
	}
}
