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
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.nature.event.Homogenization;
import org.xmlrobot.spacetime.antimatter.Hypergas;
import org.xmlrobot.spacetime.event.Impact;
import org.xmlrobot.spacetime.matter.Gas;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Master of the Sky.
 * @author joan
 * @parity XY
 * @since 41153.1
 */
@XmlRootElement
public class Jupiter 
	extends Child<Ecosystem,Biosphere> {

	/**
	 * 6147224097482696400L
	 */
	private static final long serialVersionUID = 6147224097482696400L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Ecosystem getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ecosystem setKey(Ecosystem key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Biosphere getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Biosphere setValue(Biosphere value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hypergas.class)
	public Mass<Ecosystem,Biosphere> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Jupiter} default class constructor.
	 */
	public Jupiter() {
		
		super(Hypergas.class, Gas.class, Jupiter.class, Parity.XY);
	}
	/**
	 * {@link Jupiter} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Jupiter(Class<Saturn> antitype) {
		
		super(Jupiter.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Earth) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
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
			if(event.getSource() instanceof Earth) {
				// get matter
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					future.add(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Ecosystem) {
				// cast source
				Ecosystem key = (Ecosystem) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Homogenization(key));
			}
			else if(event.getSource() instanceof Earth) {
				// cast source
				Earth earth = (Earth) event.getSource();
				// declare child
				Mass<Ecosystem,Biosphere> child;
				// call child
				if((child = getChild()) != null) {
					// send him a little asteroid
					child.pulse(this, new Impact(earth));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Earth) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
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
			if(event.getSource() instanceof Earth) {
				// declare stem
				Mass<Biosphere,Ecosystem> future;
				// cast source
				Earth pair = (Earth) event.getSource();
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
			if(event.getSource() instanceof Earth) {
				// cast source
				Earth entity = (Earth) event.getSource();
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
	public Biosphere put(Ecosystem key, Biosphere value) {
		// create child
		Mars pair = new Mars(Earth.class, key, value, this);
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
				child instanceof Mars : false) {
			// declare plasma
			Mass<Ecosystem,Biosphere> plasma;
			// cast source
			Mars pair = (Mars) child;
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {
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
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
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