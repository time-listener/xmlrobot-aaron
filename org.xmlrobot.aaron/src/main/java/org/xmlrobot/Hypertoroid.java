package org.xmlrobot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.core.BigBang;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 * @parity YY
 * @since 41166.1
 */
@XmlRootElement
public class Hypertoroid 
	extends Parent<Universe,Subspace>{
	
	/**
	 * 330147645066251184L
	 */
	private static final long serialVersionUID = 330147645066251184L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Universe getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Universe setKey(Universe key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Subspace getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Subspace setValue(Subspace value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperneuron.class)
	public Mass<Universe,Subspace> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Hypertoroid} default class constructor.
	 */
	public Hypertoroid() {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, Parity.YY);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Universe key, Subspace value) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, key, value, Parity.YY);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Universe key, Subspace value, Aaron parent) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, key, value, parent);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param antitype the antitype
	 */
	public Hypertoroid(Class<Hyperplasma> antitype) {
		super(Hypertoroid.class, antitype, Parity.YY);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Class<Hyperplasma> antitype, Universe key, Subspace value) {
		super(Hypertoroid.class, antitype, key, value, Parity.YY);
	}
	/**
	 * {@link Hypertoroid} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hypertoroid(Class<Hyperplasma> antitype, Universe key, Subspace value, Aaron parent) {
		super(Hypertoroid.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Hyperspace#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		// do something
		switch (event.getCommand()) {
		case TRANSFER:
			if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// free from inheritance
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare source
		Object source;
		// get entity
		if((source = ref.getProperty(TimeListener.KEY)) != null ? 
				source instanceof Hypertoroid : false) {
			// cast source
			Hypertoroid child = (Hypertoroid) source;

			if (event.getType() == ServiceEvent.REGISTERED) {
			}
			if (event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				getPlasma().release();
			}
		}
	}
}