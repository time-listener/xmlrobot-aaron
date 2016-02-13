package org.xmlrobot.matter;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Command;

/**
 * Hypermind implementation class.
 * @author joan
 * @parity YY
 * @since 41165.3
 */
@XmlRootElement
public class Hypermind 
	extends Positron<Subspace,Universe> 
		implements Entity<Subspace,Universe> {

	/**
	 * 2824932644399451406L
	 */
	private static final long serialVersionUID = 2824932644399451406L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {
		
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Subspace getKey() {
		Mass<Subspace,Universe> child;
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Subspace setKey(Subspace key) {
		Mass<Subspace,Universe> child;
		if((child = getChild()) != null)
			return child.setKey(key);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Universe getValue() {
		Mass<Subspace,Universe> child;
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Universe setValue(Universe value) {
		Mass<Subspace,Universe> child;
		if((child = getChild()) != null)
			return child.setValue(value);
		else return null;
	}

	/**
	 * {@link Hypermind} default class constructor.
	 */
	public Hypermind() {
		super(Hypermind.class);
	}
	/**
	 * {@link Hypermind} class constructor.
	 * @param antitype the antitype
	 */
	public Hypermind(Class<Hyperbrain> antitype) {
		super(Hypermind.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?, ?> event) {
		// call ancestral method
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
		case PUSH:
			if(event.getSource() instanceof Hyperneuron) {
				
				Hyperneuron pair = (Hyperneuron) event.getSource();
				
				Mass<Universe,Subspace> stem;
				
				if((stem = get()) != null ? 
						!stem.isEmpty() ?
								! stem.contains(pair)
								: false 
						: false) {
					// add pair
					stem.add(pair);
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
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe put(Subspace key, Universe value) {
		// create child
		Hyperxml pair = new Hyperxml(Hyperneuron.class, key, value, this);
		// push child
		pair.push(Command.PUSH);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Subspace,Universe> o1, Mass<Subspace,Universe> o2) {
		// typical recursive composition
		if (o1 != null) {

			if (o2 != null) {
				// get current identifier pairs difference
				int cmp = o1.compareTo(o2.get());
				// call recursion
				cmp += compare(o1.getChild(), o2.getChild());
				// return result
				return cmp;
			} else {
				return 1;
			}
		} else if (o2 != null) {

			return -1;
		} else {
			// starting-finishing
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public boolean removeAll(Mass<Subspace,Universe> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<Subspace,Universe>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<Subspace,Universe>> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe getOrDefault(Subspace key, Universe defaultValue) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Subspace, ? super Universe> action) {
		// declare child
		Mass<Subspace, Universe> child;
		// check existence and channel
		if ((child = getChild()) != null)
			child.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putIfAbsent(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Subspace key, Universe oldValue, Universe newValue) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe replace(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> function) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		if((child = getChild()) != null)
			child.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Universe get(Subspace key) {
		Mass<Subspace,Universe> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(
			Atlas<? extends Subspace, ? extends Universe, ? extends Mass<Subspace,Universe>> m) {
		for(Mass<Subspace,Universe> pair : m)
			put(pair.getKey(), pair.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Subspace,Universe>> entrySet() {
		return getChild();
	}
}