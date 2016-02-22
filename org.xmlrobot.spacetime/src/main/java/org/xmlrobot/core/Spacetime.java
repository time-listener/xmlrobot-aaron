/**
 * 
 */
package org.xmlrobot.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.core.antimatter.Hyperquark;
import org.xmlrobot.core.event.Contraction;
import org.xmlrobot.core.matter.Quark;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Child;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.spacetime.event.Compression;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Spacetime implementation class.
 * @author joan
 * @parity XY
 * @since 41161.1
 */
@XmlRootElement
public class Spacetime 
	extends Child<Fornax,Columbia> {

	/**
	 * -4610931478020986617L
	 */
	private static final long serialVersionUID = -4610931478020986617L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getKey()
	 */
	@Override
	@XmlElement
	public Fornax getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Fornax setKey(Fornax key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#getValue()
	 */
	@Override
	@XmlElement
	public Columbia getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Child#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Columbia setValue(Columbia value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getPlasma()
	 */
	@Override
	@XmlElement(type=Hyperquark.class)
	public Mass<Fornax,Columbia> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Spacetime} default class constructor.
	 */
	public Spacetime() {
		super(Hyperquark.class, Quark.class, Spacetime.class, Parity.XY);
	}
	/**
	 * {@link Spacetime} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Spacetime(Class<Minkowski> antitype) {
		super(Spacetime.class, antitype, Parity.XY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// ancestral recall
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Galaxy) {
				// declare stem
				Mass<Columbia,Fornax> future;
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
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
			if(event.getSource() instanceof Galaxy) {
				// get antimatter
				Mass<Columbia,Fornax> future;
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
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
			if(event.getSource() instanceof Fornax) {
				// cast source
				Fornax dna = (Fornax) event.getSource();
				// send pulse to child's value
				getValue().pulse(this, new Compression(dna));
			}
			else if(event.getSource() instanceof Galaxy) {
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
				// call child
				if(!isEmpty()) {
					// emit mass to the future
					getChild().pulse(this, new Contraction(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Galaxy) {
				// declare stem
				Mass<Columbia,Fornax> future;
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
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
			if(event.getSource() instanceof Galaxy) {
				// declare stem
				Mass<Columbia,Fornax> future;
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
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
			if(event.getSource() instanceof Galaxy) {
				// cast source
				Galaxy pair = (Galaxy) event.getSource();
				// transfer message contents
				put(pair.getValue(), pair.getKey());
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
	public Columbia put(Fornax key, Columbia value) {
		// create child
		Cluster pair = new Cluster(Galaxy.class, key, value, this);
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
				child instanceof Cluster : false) {
			// declare plasma
			Mass<Fornax,Columbia> plasma;
			// cast source
			Cluster pair = (Cluster) child;
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