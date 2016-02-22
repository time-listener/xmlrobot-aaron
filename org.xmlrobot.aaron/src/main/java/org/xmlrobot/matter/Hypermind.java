package org.xmlrobot.matter;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

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
import org.xmlrobot.horizon.Tachyon;
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
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Subspace setKey(Subspace key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Universe getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Universe setValue(Universe value) {
		return !isEmpty() ? getChild().setValue(value) : null;
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

	// inheritance implementation
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
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Mass<Universe,Subspace> o) {

		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#reproduceTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int reproduceTo(Mass<Universe,Subspace> o) {

		return matrix().reproduce(o.get().getChild(), get().getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?, ?> event) {
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
		case SEND:
			if(event.getSource() instanceof Hyperneuron) {
				// declare future
				Mass<Universe,Subspace> future;
				// cast source
				Hyperneuron pair = (Hyperneuron) event.getSource();
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
		pair.push(Command.SEND);
		return null;
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
	
	// matrix implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#matrix()
 	 */
 	@Override
 	public Mass.Transmuter<Subspace,Universe> matrix() {
 		Mass.Transmuter<Subspace,Universe> m;
 		return (m = (Mass.Transmuter<Subspace,Universe>) matrix) != null ? 
 				m : (Mass.Transmuter<Subspace,Universe>) (matrix = new Neocortex());
 	}
	/**
	 * The neocortex, also called the neopallium and isocortex, is a part of the mammalian brain. 
	 * In the human brain, it is the largest part of the cerebral cortex which covers 
	 * the two cerebral hemispheres, with the allocortex making up the rest. 
	 * 
	 * The neocortex is made up of six layers, labelled from the outermost inwards, I to VI. 
	 * In humans, the neocortex is involved in higher functions such as sensory perception, 
	 * generation of motor commands, spatial reasoning, conscious thought and language. 
	 * 
	 * There are two types of cortex in the neocortex – the true isocortex and the proisocortex.
	 * 
	 * <b>root</b>'s mass transmitter.
	 * @author joan
	 */
	protected class Neocortex
 		extends Translocator {
		
		/**
		 * {@link Neocortex} default class constructor.
		 */
		public Neocortex() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Hyperbrain get() {
			return (Hyperbrain) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(Subspace key, Universe value) {
			get().put(value, key);
		}
	}
	
	// entity implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe getOrDefault(Subspace key, Universe defaultValue) {
    	return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Subspace, ? super Universe> action) {
    	if(!isEmpty())
    		getChild().forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putIfAbsent(Subspace key, Universe value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Subspace key, Universe value) {
    	return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Subspace key, Universe oldValue, Universe newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe replace(Subspace key, Universe value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super Subspace, ? super Universe, ? extends Universe> function) {
    	if(!isEmpty())
    		getChild().replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Universe get(Subspace key) {
    	return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(Atlas<? extends Subspace, ? extends Universe, ? extends Mass<Subspace,Universe>> m) {
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
	
	// space implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putValue(Subspace key, Universe value) {
		return !isEmpty() ? getChild().putValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putKey(Universe value, Subspace key) {
		return !isEmpty() ? getChild().putKey(value, key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putValueIfAbsent(Subspace key, Universe value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putKeyIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putKeyIfAbsent(Universe value, Subspace key) {
		return !isEmpty() ? getChild().putKeyIfAbsent(value, key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllValues(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllValues(Mass<? extends Subspace, ? extends Universe> m) {
		if(!isEmpty())
			super.putAllValues(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllKeys(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllKeys(Mass<? extends Universe, ? extends Subspace> m) {
		if(!isEmpty())
			super.putAllKeys(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<Subspace,Universe> call(Subspace key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#callReversed(java.lang.Object)
	 */
	@Override
	public Mass<Universe, Subspace> callReversed(Universe value) {
		return !isEmpty() ? getChild().callReversed(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public Universe getValue(Subspace key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getKey(java.lang.Object)
	 */
	@Override
	public Subspace getKey(Universe value) {
		return !isEmpty() ? getChild().getKey(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe getValueOrDefault(Subspace key, Universe defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getKeyOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace getKeyOrDefault(Universe value, Subspace defaultKey) {
		return !isEmpty() ? getChild().getKeyOrDefault(value, defaultKey) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Subspace key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Universe value) {
		return !isEmpty() ? getChild().containsValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Subspace> collectKeys(Congregation<Subspace> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectValues(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Universe> collectValues(Congregation<Universe> values) {
		return !isEmpty() ? getChild().collectValues(values) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super Subspace, ? super Universe> action) {
		if(!isEmpty())
			super.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachValue(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachValue(BiConsumer<? super Universe, ? super Subspace> action) {
		if(!isEmpty())
			super.forEachValue(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(Subspace key, Universe oldValue, Universe newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceKey(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceKey(Universe value, Subspace oldKey, Subspace newKey) {
		return !isEmpty() ? getChild().replaceKey(value, oldKey, newKey) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(BiFunction<? super Subspace, ? super Universe, ? extends Universe> function) {
		if(!isEmpty())
			super.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllKeys(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllKeys(BiFunction<? super Universe, ? super Subspace, ? extends Subspace> function) {
		if(!isEmpty())
			super.replaceAllKeys(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe replaceValue(Subspace key, Universe value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace replaceKey(Universe value, Subspace key) {
		return !isEmpty() ? getChild().replaceKey(value, key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public Universe computeIfAbsent(Subspace key,
			Function<? super Subspace, ? extends Universe> mappingFunction) {
		return !isEmpty() ? getChild().computeIfAbsent(key, mappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeInvertedIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public Subspace computeInvertedIfAbsent(Universe key,
			Function<? super Universe, ? extends Subspace> mappingFunction) {
		return !isEmpty() ? getChild().computeInvertedIfAbsent(key, mappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe compute(Subspace key,
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().compute(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeInverted(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Subspace computeInverted(Universe value,
			BiFunction<? super Universe, ? super Subspace, ? extends Subspace> remappingFunction) {
		return !isEmpty() ? getChild().computeInverted(value, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe computeIfPresent(Subspace key,
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().computeIfPresent(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeInvertedIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Subspace computeInvertedIfPresent(Universe key,
			BiFunction<? super Universe, ? super Subspace, ? extends Subspace> remappingFunction) {
		return !isEmpty() ? getChild().computeInvertedIfPresent(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe merge(Subspace key, Universe value,
			BiFunction<? super Universe, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().merge(key, value, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#mergeInverted(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Subspace mergeInverted(Universe value, Subspace key,
			BiFunction<? super Subspace, ? super Subspace, ? extends Subspace> remappingFunction) {
		return !isEmpty() ? getChild().mergeInverted(value, key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<Subspace,Universe> removeByKey(Subspace key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByValue(java.lang.Object)
	 */
	@Override
	public Mass<Universe,Subspace> removeByValue(Universe value) {
		return !isEmpty() ? getChild().removeByValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(Subspace key, Universe value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByValue(Universe value, Subspace key) {
		return !isEmpty() ? getChild().removeByValue(value, key) : null;
	}
}