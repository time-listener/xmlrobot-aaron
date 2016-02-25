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
import org.xmlrobot.Aaron.Wormhole;
import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.core.BigBang;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.core.event.Gravity;
import org.xmlrobot.event.Hyperfission;
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
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * I, Robot.
 * @author joan
 * @parity YY
 * @since 41165.2
 */
@XmlRootElement
public class Robot 
	extends Parent<Subspace,Universe>
	implements Entity<Subspace,Universe> {

	/**
	 * -3478889532242260284L
	 */
	private static final long serialVersionUID = -3478889532242260284L;

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
	public Subspace getKey() {
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Subspace setKey(Subspace key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Universe getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Universe setValue(Universe value) {
		return !isEmpty() ? getChild().setValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypermind.class)
	public Entity<Subspace,Universe> getReplicator() {
		return (Entity<Subspace,Universe>) super.getReplicator();
	}
	
	/**
	 * {@link Robot} default class constructor.
	 */
	public Robot() {
		super(Hypermind.class, Hyperbrain.class, Robot.class, Parity.YY);
	}
	/**
	 * {@link Robot} class constructor.
	 * @param antitype the antitype
	 */
	public Robot(Class<Aaron> antitype) {
		super(Robot.class, antitype, Parity.YY);
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
		// call hypergenesis computation
		int cmp = get().matrix().reproduce(o.getChild(), getChild());
		// submit generated output into the hyperspace
		push(new Hyperfusion(get().output()));
		// turn back hypergenesis computation result
		return cmp;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Subspace) {
				// cast source
				Subspace entity = (Subspace) event.getSource();
				// push universe into hyperspace
				put(entity, (Universe) entity.get());
			}
			break;
		case ORDER:
			if(event.getSource() instanceof Hypertoroid) {
				// declare future
				Mass<Universe,Subspace> future;
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
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
			if(event.getSource() instanceof Hypertoroid) {
				// declare future
				Mass<Universe,Subspace> future;
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
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
			if(event.getSource() instanceof Subspace) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Subspace key = (Subspace) event.getSource();
					// push to the future
					getValue().pulse(this, new Gravity(key));	
				}
			}
			else if(event.getSource() instanceof Hypertoroid) {
				// check emptiness
				if(!isEmpty()) {
					// cast source
					Hypertoroid source = (Hypertoroid) event.getSource();
					// emit pulse
					getChild().pulse(this, new Hyperfission(source));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hypertoroid) {
				// declare stem
				Mass<Universe,Subspace> future;
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
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
			if(event.getSource() instanceof Hypertoroid) {
				// declare stem
				Mass<Universe,Subspace> future;
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
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
			if (event.getSource() instanceof BigBang) {
				// cast source
				BigBang pair = (BigBang) event.getSource();
				// free from inheritance
				pair.remove();
			}
			else if(event.getSource() instanceof Hypertoroid) {
				// stop toroid
				event.stop(getContext());
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
	public Universe put(Subspace key, Universe value) {
		// create child
		Hyperplasma pair = new Hyperplasma(Hypertoroid.class, key, value, this);
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
			// life ends here
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
		Object child;
		// get entity
		if((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Hyperplasma : false) {
			// cast source
			Hyperplasma pair = (Hyperplasma) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#valueVisor()
	 */
	@Override
	public Congregation<Universe> valueVisor() {
 		Congregation<Universe> values;
 		return (values = visor) == null ? 
 				(visor = new Visor(replicator)) : values;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#iterator()
	 */
	@Override
	public Iterator<Mass<Subspace,Universe>> iterator() {
		Mass<Subspace,Universe> future;
		return (future = getFuture()) != null ? future.iterator() : null;
	}
	// matrix implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#matrix()
 	 */
 	@Override
 	public Mass.Transmuter<Subspace,Universe> matrix() {
 		Mass.Transmuter<Subspace,Universe> m;
 		return (m = (Mass.Transmuter<Subspace,Universe>) matrix) != null ? 
 				m : (Mass.Transmuter<Subspace,Universe>) (matrix = new Blackhole());
 	}
	/**
	 * The blackhole implementation class.
	 * <b>root</b>'s mass receiver.
	 * @author joan
	 */
	protected class Blackhole
		extends Translocator {

		/**
		 * {@link Wormhole} default class constructor.
		 */
		public Blackhole() {
			super(instance(getAntitype(), getType()));
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#get()
		 */
		@Override
		public Aaron get() {
			return (Aaron) super.get();
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
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Subspace,Universe>> entrySet() {
		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Subspace, ? super Universe> action) {
    	forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Universe get(Subspace key) {
    	return getValue(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe getOrDefault(Subspace key, Universe defaultValue) {
    	return getValueOrDefault(key, defaultValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(Atlas<? extends Subspace, ? extends Universe, ? extends Mass<Subspace, Universe>> m) {
		for(Mass<Subspace,Universe> pair : m)
			put(pair.getKey(), pair.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putIfAbsent(Subspace key, Universe value) {
		return putValueIfAbsent(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Subspace key, Universe value) {
    	return removeByKey(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe replace(Subspace key, Universe value) {
		return replaceValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Subspace key, Universe oldValue, Universe newValue) {
		return replaceValue(key, oldValue, newValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> function) {
    	replaceAllValues(function);
	}
	
	// space implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putValue(Subspace key, Universe value) {
		return !isEmpty() ? getChild().putValue(key, value) : put(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putValueIfAbsent(Subspace key, Universe value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : null;
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
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<Subspace,Universe> call(Subspace key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public Universe getValue(Subspace key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe getValueOrDefault(Subspace key, Universe defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Subspace key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Subspace> collectKeys(Congregation<Subspace> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
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
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(Subspace key, Universe oldValue, Universe newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
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
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe replaceValue(Subspace key, Universe value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
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
	 * @see org.xmlrobot.space.Expansion#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe compute(Subspace key,
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().compute(key, remappingFunction) : null;
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
	 * @see org.xmlrobot.space.Dilatation#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Universe merge(Subspace key, Universe value,
			BiFunction<? super Universe, ? super Universe, ? extends Universe> remappingFunction) {
		return !isEmpty() ? getChild().merge(key, value, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<Subspace,Universe> removeByKey(Subspace key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(Subspace key, Universe value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
}