package org.xmlrobot.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Parity;

/**
 * Hyperxml implementation class.
 * @author joan
 * @parity YY
 * @since 41166.3
 */
@XmlRootElement
public class Hyperxml 
	extends Positron<Subspace,Universe> {

	/**
	 * -2455024941563105083L
	 */
	private static final long serialVersionUID = -2455024941563105083L;

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
	
	/**
	 * {@link Hyperxml} default class constructor.
	 */
	public Hyperxml() {
		super(Hyperxml.class);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 */
	public Hyperxml(Subspace key, Universe value) {
		super(Hyperxml.class, key, value);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 * @param parent {@link Hypermind} the parent
	 */
	public Hyperxml(Subspace key, Universe value, Hypermind parent) {
		super(Hyperxml.class, key, value, parent);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 */
	public Hyperxml(Class<Hyperneuron> antitype) {
		super(Hyperxml.class, antitype);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 */
	public Hyperxml(Class<Hyperneuron> antitype, Subspace key, Universe value) {
		super(Hyperxml.class, antitype, key, value);
	}
	/**
	 * {@link Hyperxml} default class constructor.
	 * @param antitype the antitype
	 * @param key {@link Subspace} the key
	 * @param value {@link Universe} the value
	 * @param parent {@link Hypermind} the parent
	 */
	public Hyperxml(Class<Hyperneuron> antitype, Subspace key, Universe value, Hypermind parent) {
		super(Hyperxml.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Subspace,Universe> o1, Mass<Subspace,Universe> o2) {
		return o1.getValue().compareTo(o2.getKey());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?, ?> event) {
		super.mass(sender, event);
		// commute command
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperneuron) {
				// declare future
				Mass<Universe,Subspace> future;
				// cast source
				Hyperneuron pair = (Hyperneuron) event.getSource();
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
			if(event.getSource() instanceof Hyperneuron) {
				
				Hyperneuron pair = (Hyperneuron) event.getSource();
				
				Mass<Universe,Subspace> future;
				
				if((future = get()) != null ? 
						!future.isEmpty() ?
								! future.contains(pair)
								: false 
						: false) {
					// add pair
					future.add(pair);
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hyperneuron) {
				// declare stem
				Mass<Universe,Subspace> future;
				// cast source
				Hyperneuron pair = (Hyperneuron) event.getSource();
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
			if(event.getSource() instanceof Hyperneuron) {
				// declare stem
				Mass<Universe,Subspace> future;
				// cast source
				Hyperneuron pair = (Hyperneuron) event.getSource();
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
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public Mass.Transmuter<Subspace,Universe> matrix() {

		Mass.Transmuter<Subspace,Universe> m;
 		return (m = (Mass.Transmuter<Subspace,Universe>) matrix) != null ? 
 				m : (Mass.Transmuter<Subspace,Universe>) (matrix = new Hyperloop());
	}
	/**
	 * {@link Hyperloop} implementation class.
	 * @author joan
	 *
	 */
	protected class Hyperloop 
		extends Comparator
			implements Mass.Transmuter<Subspace,Universe> {
		
		/**
		 * {@link Hyperloop} default class constructor.
		 */
		public Hyperloop() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#reproduce(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public int reproduce(Mass<Subspace,Universe> key, Mass<Universe,Subspace> value) {
			int cmp = super.reproduce(key, value);
			
			if(key.getGen().equals(Parity.XY) ? cmp > 0 : cmp < 0) {
				put(value.getValue(), value.getKey());
				return -1;
			}
			else if(cmp == 0) {
				put(key.getKey(), key.getValue());
				// doubled paired output: evolve
				put(value.getValue(), value.getKey());
				return 0;
			}
			else {
				put(key.getKey(), key.getValue());
				return 1;
			}
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Mass.Transmuter#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(Subspace key, Universe value) {
			if(get() == null)
				super.set(instance(getAntitype(), getType(), value, key));
			else inject(instance(getType(), getAntitype(), key, value));
		}
	}
}