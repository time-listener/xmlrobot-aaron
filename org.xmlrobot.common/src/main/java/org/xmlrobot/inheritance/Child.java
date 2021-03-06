/**
 * 
 */
package org.xmlrobot.inheritance;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.time.Inheritance;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The Child of {@link Inheritance}.
 * 
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity XY
 * @since 28
 */
@XmlTransient
public abstract class Child
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>>
		extends Parent<K,V> 
			 implements Entity<K,V> {
	/**
	 * 2604725583626718586L
	 */
	private static final long serialVersionUID = 2604725583626718586L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlTransient
	public K getKey() {
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public K setKey(K key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlTransient
	public V getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public V setValue(V value) {
		return !isEmpty() ? getChild().setValue(value) : null;
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#get()
	 */
	@Override
	public Entity<V,K> get() {
		return (Entity<V,K>) super.get();
	}
	
	/**
     * {@link Child} default class constructor.
	 */
	public Child() {
		super();
	}
	/**
	 * {@link Child} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Child(
			Class<? extends Entity<K,V>> matter, 
			Class<? extends Entity<V,K>> antimatter, 
			Class<? extends Child<K,V>> type, 
			Parity gen) {
		super(matter, antimatter, type, gen);
	}
	/**
	 * {@link Child} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Child(
			Class<? extends Child<K,V>> type,
			Class<? extends Child<V,K>> antitype,
			Parity gen) {
		super(type, antitype, gen);
	}
	
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
 	 */
 	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener, Tachyon<Y,X> event) {
 		// ancestral recall
 		super.pulse(listener, event);
		// rotate inheritance 1/2
 		spin();
 	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
 	 */
 	@Override
 	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
 		void echo(TimeListener<?,?> listener, Tachyon<X,Y> event) {
		super.echo(listener, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<K,V> o1, Mass<K,V> o2) {
		// typical recursive syntax
		if (o1 != null) {

			if (o2 != null) {
				// compare current pair value
				int cmp = o1.getValue().compareTo(o2.getKey());
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
			// start sum
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Mass<V,K> o) {
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#reproduceTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int reproduceTo(Mass<V,K> o) {
		// call hypergenesis computation
		int cmp = get().matrix().reproduce(o.getChild(), getChild());
		// push hypergenesis computation result
		push(new Graviton<K,V>(get().output()) {

			/**
			 * 5588441933378797548L
			 */
			private static final long serialVersionUID = 5588441933378797548L;
		});
		return cmp;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.Congregation)
	 */
	public boolean removeAll(Parent<K,V> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<K,V>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<K,V>> i = iterator(); i.hasNext(); ) {
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
	public final void run() {
		// avoid concurrent calls to run
		if (!message.compareAndSet(RUNNER, null, Thread.currentThread())) {
			// because it is already running
			return;
		}
		else {
			// life starts here
			super.run();
	    	// life ends here
	    	push(Command.TRANSFER);
		}
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#serviceChanged(org.osgi.framework.ServiceEvent)
 	 */
 	@Override
 	public abstract void serviceChanged(ServiceEvent event);

 	// visor implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Mass#valueVisor()
 	 */
 	@Override
 	public Congregation<V> valueVisor() {
 		Congregation<V> values;
 		return (values = visor) == null ? 
 				(visor = new Visor(replicator)) : values;
 	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#iterator()
	 */
	@Override
	public Iterator<Mass<K,V>> iterator() {
		Mass<K,V> future;
		return (future = getFuture()) != null ? future.iterator() : null;
	}
 	
	// matrix implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#matrix()
 	 */
 	@Override
 	public Mass.Transmuter<K,V> matrix() {
 		Mass.Transmuter<K,V> m;
 		return (m = (Mass.Transmuter<K,V>) matrix) != null ? 
 				m : (Mass.Transmuter<K,V>) (matrix = new Transductor());
 	}
	/**
	 * <b>root</b>'s mass transmitter.
	 * @author joan
	 */
	protected class Transductor
 		extends Translocator {
		
		/**
		 * {@link Transductor} default class constructor.
		 */
		public Transductor() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Child<V,K> get() {
			return (Child<V,K>) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(K key, V value) {
			get().put(value, key);
		}
	}
	
	// entity implementation
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
     */
    public abstract V put(K key, V value);
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	public V get(K key) {
    	return getValue(key);
    }
    
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
     */
    public void putAll(Atlas<? extends K, ? extends V, ? extends Mass<K,V>> m) {
    	for(Mass<K,V> e : m)
			put(e.getKey(), e.getValue());
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Atlas#entrySet()
     */
    @Override
    public Congregation<Mass<K,V>> entrySet() {
    	return getChild();
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
     */
    public void forEach(BiConsumer<? super K, ? super V> action) {
    	forEachKey(action);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
     */
    public V getOrDefault(K key, V defaultValue) {
    	return getValueOrDefault(key, defaultValue);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
     */
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
    	replaceAllValues(function);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
     */
    public V putIfAbsent(K key, V value) {
		return putValueIfAbsent(key, value);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
     */
    public boolean remove(K key, V value) {
    	return removeByKey(key, value);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public boolean replace(K key, V oldValue, V newValue){
		return replaceValue(key, oldValue, newValue);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
     */
    public V replace(K key, V value) {
		return replaceValue(key, value);
    }

	// space implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValue(K key, V value) {
		return !isEmpty() ? getChild().putValue(key, value) : put(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValueIfAbsent(K key, V value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : put(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllValues(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllValues(Mass<? extends K, ? extends V> m) {
		if(!isEmpty())
			super.putAllValues(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<K,V> call(K key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public V getValue(K key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V getValueOrDefault(K key, V defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<K> collectKeys(Congregation<K> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super K, ? super V> action) {
		if(!isEmpty())
			super.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(K key, V oldValue, V newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(BiFunction<? super K, ? super V, ? extends V> function) {
		if(!isEmpty())
			super.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V replaceValue(K key, V value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public V computeIfAbsent(K key,
			Function<? super K, ? extends V> mappingFunction) {
		return !isEmpty() ? getChild().computeIfAbsent(key, mappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V compute(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return !isEmpty() ? getChild().compute(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V computeIfPresent(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return !isEmpty() ? getChild().computeIfPresent(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V merge(K key, V value,
			BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return !isEmpty() ? getChild().merge(key, value, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<K,V> removeByKey(K key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(K key, V value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
}