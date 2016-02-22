package org.xmlrobot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.core.BigBong;
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
 * @since 41166.2
 */
@XmlRootElement
public class Hyperplasma 
	extends Parent<Subspace,Universe> {

	/**
	 * -8573055740709003708L
	 */
	private static final long serialVersionUID = -8573055740709003708L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Subspace getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	
	@Override
	public Subspace setKey(Subspace key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Universe getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Universe setValue(Universe value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperxml.class)
	public Mass<Subspace,Universe> getPlasma() {
		return super.getPlasma();
	}
	
	/**
	 * {@link Hyperplasma} default class constructor.
	 */
	public Hyperplasma() {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 */
	public Hyperplasma(Subspace key, Universe value) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, key, value, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 * @param parent {@link Robot} the parent
	 */
	public Hyperplasma(Subspace key, Universe value, Robot parent) {
		super(Hyperxml.class, Hyperneuron.class, Hyperplasma.class, key, value, parent);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperplasma(Class<Hypertoroid> antitype) {
		super(Hyperplasma.class, antitype, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 */
	public Hyperplasma(Class<Hypertoroid> antitype, Subspace key, Universe value) {
		super(Hyperplasma.class, antitype, key, value, Parity.YY);
	}
	/**
	 * {@link Hyperplasma} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} value
	 * @param parent {@link Robot} the parent
	 */
	public Hyperplasma(Class<Hypertoroid> antitype, Subspace key, Universe value, Robot parent) {
		super(Hyperplasma.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?, ?> event) {
		super.mass(sender, event);
		// do something
		switch (event.getCommand()) {
		case TRANSFER:
			if (event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
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
		Object child;
		// get entity
		if((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Hyperplasma : false) {
			// cast source
			Hyperplasma pair = (Hyperplasma) child;

			if (event.getType() == ServiceEvent.REGISTERED) {
				// instance xml
				Hyperxml xml = instance(Hyperxml.class, Hyperneuron.class, 
						pair.getKey(), pair.getValue(), getPlasma().getRoot());
				// input to the brain
				xml.push(Command.SUBMIT);
			}
			if (event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				getPlasma().release();
			}
		}
	}
}