package org.xmlrobot;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.core.event.Antigravity;
import org.xmlrobot.event.Hyperfusion;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Aaron infinite. He is the master of all times. A.k.a Timemaster.
 * 
 * @author joan
 * @parity YY
 * @since 41165.1
 */
@XmlRootElement
public final class Aaron
	extends Parent<Universe,Subspace>
	implements Entity<Universe,Subspace>  {

	/**
	 * -9024346196425472952L
	 */
	private static final long serialVersionUID = -9024346196425472952L;
	
    /* (non-Javadoc)
     * @see org.xmlrobot.inheritance.Parent#getName()
     */
    @Override
	@XmlElement
    public String getName() {
    	return "Aaron";
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Universe getKey() {
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Universe setKey(Universe key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Subspace getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Subspace setValue(Subspace value) {
		return !isEmpty() ? getChild().setValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperbrain.class)
	public Entity<Universe,Subspace> getPlasma() {
		return (Entity<Universe,Subspace>) super.getPlasma();
	}
	
	/**
	 * {@link Aaron} default class constructor.
	 */
	public Aaron() {
		super(Hyperbrain.class, Hypermind.class, Aaron.class, Parity.YY);
	}
	/**
	 * {@link Aaron} class constructor.
	 * @param antitype the antitype
	 */
	public Aaron(Class<Robot> antitype) { 
		super(Aaron.class, antitype, Parity.YY);
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

		return matrix().reproduce(o.get().getChild(), get().getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperplasma) {
				// declare future
				Mass<Subspace,Universe> future;
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// order child
					future.order(pair);
				}
			}
			break;
		case SEND:
			if(event.getSource() instanceof Hyperplasma) {
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// declare future
				Mass<Subspace,Universe> future;
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
			if(event.getSource() instanceof Universe) {
				// cast source
				Universe dna = (Universe) event.getSource();
				// send pulse to the future
				getValue().pulse(this, new Antigravity(dna));
			}
			else if(event.getSource() instanceof Hyperplasma){
				// cast source
				Hyperplasma source = (Hyperplasma) event.getSource();
				// call
				if(!isEmpty()) {
					// emit pulse
					getChild().pulse(this, new Hyperfusion(source));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hyperplasma) {
				// declare stem
				Mass<Subspace,Universe> future;
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
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
			if(event.getSource() instanceof Hyperplasma) {
				// declare stem
				Mass<Subspace,Universe> future;
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
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
			if(event.getSource() instanceof Hyperplasma) {
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// transfer message to the future
				put(pair.getValue(), pair.getKey());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace put(Universe key, Subspace value) {
		// create child
		Hypertoroid pair = new Hypertoroid(Hyperplasma.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public boolean removeAll(Mass<Universe,Subspace> c) {
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
	 * @see org.xmlrobot.inheritance.Parent#run()
	 */
	@Override
	public void run() {
		// avoid concurrent calls to run
		if (!message.compareAndSet(RUNNER, null, Thread.currentThread())) {
			// because is already running
			return;
		} else {
			// life starts here
			super.run();
			// Aaron Resurrection. Episode III.
			push(Command.RESURRECTION);
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
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// instance pair
				Hyperneuron pair = instance(Hyperneuron.class, Hyperxml.class, 
						child.getKey(), child.getValue(), getPlasma());
				// input to the brain
				pair.push(Command.SUBMIT);
			}
			if(event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				getPlasma().release();
			}
		}
	}
	// matrix implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#matrix()
 	 */
 	@Override
 	public Mass.Transmuter<Universe,Subspace> matrix() {
 		Mass.Transmuter<Universe,Subspace> m;
 		return (m = (Mass.Transmuter<Universe,Subspace>) matrix) != null ? 
 				m : (Mass.Transmuter<Universe,Subspace>) (matrix = new Wormhole());
 	}
	/**
	 * The wormhole implementation class.
	 * <b>root</b>'s mass emitter.
	 * @author joan
	 *
	 */
	protected class Wormhole
		extends Translocator {

		/**
		 * {@link Wormhole} default class constructor.
		 */
		public Wormhole() {
			super(instance(getAntitype(), getType()));
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#get()
		 */
		@Override
		public Robot get() {
			return (Robot) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(Universe key, Subspace value) {
			get().put(value, key);
		}
	}

	// entity implementation
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
    	if(!isEmpty())
    		getChild().forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Subspace get(Universe key) {
    	return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace getOrDefault(Universe key, Subspace defaultValue) {
    	return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
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
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Universe key, Subspace value) {
    	return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace replace(Universe key, Subspace value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Universe key, Subspace oldValue, Subspace newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super Universe, ? super Subspace, ? extends Subspace> function) {
    	if(!isEmpty())
    		getChild().replaceAllValues(function);
	}
	// space implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putValue(Universe key, Subspace value) {
		return !isEmpty() ? getChild().putValue(key, value) : put(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putKey(Subspace value, Universe key) {
		return !isEmpty() ? getChild().putKey(value, key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putValueIfAbsent(Universe key, Subspace value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putKeyIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putKeyIfAbsent(Subspace value, Universe key) {
		return !isEmpty() ? getChild().putKeyIfAbsent(value, key) : null;
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
	 * @see org.xmlrobot.space.Contraction#putAllKeys(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllKeys(Mass<? extends Subspace, ? extends Universe> m) {
		if(!isEmpty())
			super.putAllKeys(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<Universe,Subspace> call(Universe key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#callReversed(java.lang.Object)
	 */
	@Override
	public Mass<Subspace, Universe> callReversed(Subspace value) {
		return !isEmpty() ? getChild().callReversed(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public Subspace getValue(Universe key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getKey(java.lang.Object)
	 */
	@Override
	public Universe getKey(Subspace value) {
		return !isEmpty() ? getChild().getKey(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace getValueOrDefault(Universe key, Subspace defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getKeyOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe getKeyOrDefault(Subspace value, Universe defaultKey) {
		return !isEmpty() ? getChild().getKeyOrDefault(value, defaultKey) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Universe key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Subspace value) {
		return !isEmpty() ? getChild().containsValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Universe> collectKeys(Congregation<Universe> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectValues(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Subspace> collectValues(Congregation<Subspace> values) {
		return !isEmpty() ? getChild().collectValues(values) : null;
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
	 * @see org.xmlrobot.space.Attraction#forEachValue(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachValue(BiConsumer<? super Subspace, ? super Universe> action) {
		if(!isEmpty())
			super.forEachValue(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(Universe key, Subspace oldValue, Subspace newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceKey(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceKey(Subspace value, Universe oldKey, Universe newKey) {
		return !isEmpty() ? getChild().replaceKey(value, oldKey, newKey) : null;
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
	 * @see org.xmlrobot.space.Repulsion#replaceAllKeys(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllKeys(BiFunction<? super Subspace, ? super Universe, ? extends Universe> function) {
		if(!isEmpty())
			super.replaceAllKeys(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace replaceValue(Universe key, Subspace value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe replaceKey(Subspace value, Universe key) {
		return !isEmpty() ? getChild().replaceKey(value, key) : null;
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
	 * @see org.xmlrobot.space.Expansion#computeInvertedIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public Universe computeInvertedIfAbsent(Subspace key,
			Function<? super Subspace, ? extends Universe> mappingFunction) {
		return !isEmpty() ? getChild().computeInvertedIfAbsent(key, mappingFunction) : null;
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
	 * @see org.xmlrobot.space.Expansion#computeInverted(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe computeInverted(Subspace value,
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().computeInverted(value, remappingFunction) : null;
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
	 * @see org.xmlrobot.space.Expansion#computeInvertedIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe computeInvertedIfPresent(Subspace key,
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().computeInvertedIfPresent(key, remappingFunction) : null;
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
	 * @see org.xmlrobot.space.Dilatation#mergeInverted(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe mergeInverted(Subspace value, Universe key,
			BiFunction<? super Universe, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().mergeInverted(value, key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<Universe,Subspace> removeByKey(Universe key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByValue(java.lang.Object)
	 */
	@Override
	public Mass<Subspace,Universe> removeByValue(Subspace value) {
		return !isEmpty() ? getChild().removeByValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(Universe key, Subspace value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByValue(Subspace value, Universe key) {
		return !isEmpty() ? getChild().removeByValue(value, key) : null;
	}
}