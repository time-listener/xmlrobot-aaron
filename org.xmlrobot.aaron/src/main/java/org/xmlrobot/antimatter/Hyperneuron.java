package org.xmlrobot.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.util.Parity;

/**
 * Hyperneuron implementation class.
 * @author joan
 * @parity YY
 * @since 41166.4
 */
@XmlRootElement
public class Hyperneuron 
	extends Antineutron<Universe,Subspace> {

	/**
	 * -4548799042014185239L
	 */
	private static final long serialVersionUID = -4548799042014185239L;

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
	
	/**
	 * {@link Hyperneuron} default class constructor.
	 */
	public Hyperneuron() {
		super(Hyperneuron.class);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hyperneuron(Universe key, Subspace value) {
		super(Hyperneuron.class, key, value);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 * @param parent {@link Hyperbrain} the parent
	 */
	public Hyperneuron(Universe key, Subspace value, Hyperbrain parent) {
		super(Hyperneuron.class, key, value, parent);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperneuron(Class<Hyperxml> antitype) {
		super(Hyperneuron.class, antitype);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 */
	public Hyperneuron(Class<Hyperxml> antitype,
			Universe key, Subspace value) {
		super(Hyperneuron.class, antitype, key, value);
	}
	/**
	 * {@link Hyperneuron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Universe} the key
	 * @param value {@link Subspace} the value
	 * @param parent {@link Hyperbrain} the parent
	 */
	public Hyperneuron(Class<Hyperxml> antitype,
			Universe key, Subspace value, Hyperbrain parent) {
		super(Hyperneuron.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Universe,Subspace> o1, Mass<Universe,Subspace> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperxml) {
				// declare future
				Mass<Subspace,Universe> future;
				// cast source
				Hyperxml pair = (Hyperxml) event.getSource();
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
			if(event.getSource() instanceof Hyperxml) {
				// declare future
				Mass<Subspace,Universe> future;
				// cast source
				Hyperxml pair = (Hyperxml) event.getSource();
				// check if empty and chained
				if((future = get()) != null ?
						!future.isEmpty() ?
								!future.contains(pair)
								: false 
						: false) {
					// add pair
					future.add(pair);
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hyperxml) {
				// declare stem
				Mass<Subspace,Universe> future;
				// cast source
				Hyperxml pair = (Hyperxml) event.getSource();
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
			if(event.getSource() instanceof Hyperxml) {
				// declare stem
				Mass<Subspace,Universe> future;
				// cast source
				Hyperxml pair = (Hyperxml) event.getSource();
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
	public Mass.Transmuter<Universe,Subspace> matrix() {

		Mass.Transmuter<Universe,Subspace> m;
 		return (m = (Mass.Transmuter<Universe,Subspace>) matrix) != null ? 
 				m : (Mass.Transmuter<Universe,Subspace>) (matrix = new Hyperwafer());
	}
	/**
	 * {@link Hyperwafer} implementation class.
	 * @author joan
	 */
	protected class Hyperwafer 
		extends Comparator
			implements Mass.Transmuter<Universe,Subspace> {
		
		/**
		 * {@link Hyperwafer} default class constructor.
		 */
		public Hyperwafer() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#reproduce(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public int reproduce(Mass<Universe,Subspace> key, Mass<Subspace,Universe> value) {
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
		public void put(Universe key, Subspace value) {
			if(get() == null)
				super.set(instance(getAntitype(), getType(), value, key));
			else inject(instance(getType(), getAntitype(), key, value));
		}
	}
}