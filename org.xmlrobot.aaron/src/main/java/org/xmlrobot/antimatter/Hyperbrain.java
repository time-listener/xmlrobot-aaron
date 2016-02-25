package org.xmlrobot.antimatter;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.event.Hyperfission;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Command;

/**
 * Hyperbrain implementation class.
 * @author joan
 * @parity YY
 * @since 41165.4
 */
@XmlRootElement
public class Hyperbrain 
	extends Positron<Universe,Subspace> 
		implements Entity<Universe,Subspace>{

	/**
	 * 8426959343924822410L
	 */
	private static final long serialVersionUID = 8426959343924822410L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getName()
	 */
	@Override
	@XmlElement
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Universe getKey() {
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Universe setKey(Universe key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Subspace getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Subspace setValue(Subspace value) {
		return !isEmpty() ? getChild().setValue(value) : null;
	}
	
	/**
	 * {@link Hyperbrain} default class constructor.
	 */
	public Hyperbrain() {
		super(Hyperbrain.class);
	}
	/**
	 * {@link Hyperbrain} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperbrain(Class<Hypermind> antitype) {
		super(Hyperbrain.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Universe,Subspace> o1, Mass<Universe,Subspace> o2) {
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
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Mass<Subspace,Universe> o) {
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#reproduceTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int reproduceTo(Mass<Subspace,Universe> o) {
		// call hypergenesis computation
		int cmp = get().matrix().reproduce(o.getChild(), getChild());
		// submit generated output into the hyperspace
		push(new Hyperfission(get().output()));
		// turn back hypergenesis computation result
		return cmp;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.Congregation)
	 */
	public boolean removeAll(Parent<Universe,Subspace> c) {
		
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<Universe,Subspace>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<Universe,Subspace>> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
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
								! future.contains(pair)
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
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace put(Universe key, Subspace value) {
		// create child
		Hyperneuron pair = new Hyperneuron(Hyperxml.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#iterator()
	 */
	@Override
	public Iterator<Mass<Universe,Subspace>> iterator() {
		Mass<Universe,Subspace> future;
		return (future = getFuture()) != null ? future.iterator() : null;
	}
	// matrix implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#matrix()
 	 */
 	@Override
 	public Mass.Transmuter<Universe,Subspace> matrix() {
 		Mass.Transmuter<Universe,Subspace> m;
 		return (m = (Mass.Transmuter<Universe,Subspace>) matrix) != null ? 
 				m : (Mass.Transmuter<Universe,Subspace>) (matrix = new Synaptic());
 	}
 	
	/**
	 * Neurotransmission, also called synaptic transmission, is the process by 
	 * which signaling molecules called neurotransmitters are released by a neuron, 
	 * and bind to and activate the receptors of another neuron. 
	 * Neurotransmission is essential for the process of communication between two neurons. 
	 * Synaptic transmission relies on: the availability of the neurotransmitter; 
	 * the release of the neurotransmitter by exocytosis; the binding of the 
	 * postsynaptic receptor by the neurotransmitter; the functional response of the 
	 * postsynaptic cell; and the subsequent removal or deactivation of the neurotransmitter.
	 * 
	 * <b>root</b>'s mass transmitter.
	 * @author joan
	 */
	protected class Synaptic
 		extends Translocator {
		
		/**
		 * {@link Synaptic} default class constructor.
		 */
		public Synaptic() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Hypermind get() {
			return (Hypermind) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(Universe key, Subspace value) {
			get().put(value, key);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Universe,Subspace>> entrySet() {
		// turn back child
		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Universe, ? super Subspace> action) {
    	forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Subspace get(Universe key) {
    	return getValue(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace getOrDefault(Universe key, Subspace defaultValue) {
    	return getValueOrDefault(key, defaultValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(Atlas<? extends Universe,? extends Subspace,? extends Mass<Universe,Subspace>> m) {
		for(Mass<Universe,Subspace> child : m)
			put(child.getKey(), child.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putIfAbsent(Universe key, Subspace value) {
		return putValueIfAbsent(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Universe key, Subspace value) {
    	return removeByKey(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace replace(Universe key, Subspace value) {
		return replaceValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Universe key, Subspace oldValue, Subspace newValue) {
		return replaceValue(key, oldValue, newValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super Universe, ? super Subspace, ? extends Subspace> function) {
    	replaceAllValues(function);
	}
	
	// space implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putValue(Universe key, Subspace value) {
		return !isEmpty() ? getChild().putValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putValueIfAbsent(Universe key, Subspace value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllValues(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllValues(Mass<? extends Universe, ? extends Subspace> m) {
		if(!isEmpty())
			super.putAllValues(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<Universe,Subspace> call(Universe key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public Subspace getValue(Universe key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace getValueOrDefault(Universe key, Subspace defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Universe key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Universe> collectKeys(Congregation<Universe> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super Universe, ? super Subspace> action) {
		if(!isEmpty())
			super.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(Universe key, Subspace oldValue, Subspace newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(BiFunction<? super Universe, ? super Subspace, ? extends Subspace> function) {
		if(!isEmpty())
			super.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace replaceValue(Universe key, Subspace value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public Subspace computeIfAbsent(Universe key,
			Function<? super Universe, ? extends Subspace> mappingFunction) {
		return !isEmpty() ? getChild().computeIfAbsent(key, mappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Subspace compute(Universe key,
			BiFunction<? super Universe, ? super Subspace, ? extends Subspace> remappingFunction) {
		return !isEmpty() ? getChild().compute(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Subspace computeIfPresent(Universe key,
			BiFunction<? super Universe, ? super Subspace, ? extends Subspace> remappingFunction) {
		return !isEmpty() ? getChild().computeIfPresent(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Subspace merge(Universe key, Subspace value,
			BiFunction<? super Subspace, ? super Subspace, ? extends Subspace> remappingFunction) {
		return !isEmpty() ? getChild().merge(key, value, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<Universe,Subspace> removeByKey(Universe key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(Universe key, Subspace value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
}