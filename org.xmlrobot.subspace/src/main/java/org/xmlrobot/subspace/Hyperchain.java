package org.xmlrobot.subspace;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.Hypertext;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.subspace.antimatter.Hyperdatagram;
import org.xmlrobot.subspace.event.Flop;
import org.xmlrobot.subspace.event.Instant;
import org.xmlrobot.subspace.matter.Hyperpacket;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;

/**
 * The hyperchain.
 * 
 * <p>One of the datagrams being sent between entities to get communicated through the 
 * abstract protocol. Some hypercube examples: word, phrase, oration, mass, 
 * sermon, order, XML, javadoc, etc.
 * <p>The hyperchain is the hypercube. And the hypercube is the hyperchain. So, changes 
 * in the hyperchain will be reflected in the hypercube. And vice-versa.
 * <p>This class is just another member of the {@code hyperspace congregation framework}
 * 
 * @author joan
 * @parity XX
 * @since 1513.2
 */
@XmlRootElement
public class Hyperchain
	extends Hyperinteger
		implements Entity<Integer,Character> {

	/**
	 * -5554421412799541676L
	 */
	private static final long serialVersionUID = -5554421412799541676L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.Hyperinteger#name()
	 */
	@Override
	@XmlElement
	public String getName() {
		return concat(new String());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Integer getKey() {
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Integer setKey(Integer key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Character getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Character setValue(Character value) {
		return !isEmpty() ? getChild().setValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperinteger#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperpacket.class)
	public Entity<Integer,Character> getReplicator() {
		return (Entity<Integer,Character>) super.getReplicator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#get()
	 */
	@Override
	public Entity<Character,Integer> get() {
		return (Entity<Character,Integer>) super.get();
	}
	
	/**
	 * {@link Hyperchain} default class constructor.
	 */
	public Hyperchain() {
		super(Hyperpacket.class, Hyperdatagram.class, Hyperchain.class);
	}
	/**
	 * {@link Hyperchain} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hyperchain(Class<Hypercube> antitype) {
		super(Hyperchain.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hyperinteger#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<Integer,Character> o1, Mass<Integer,Character> o2) {
		// traditional recursive syntax
		if(o1 != null) {
			
			if(o2 != null) {
				// get current alphabetical pairs difference
				int cmp = o1.getValue().compareTo(o2.getValue());
				// call recursion
				cmp += compare(o1.getChild(), o2.getChild());
				// return computation result
				return cmp;
			}
			else {
				// append value
				return 1;
			}
		}
		else if(o2 != null) {
			// append value
			return -1;
		}
		else {
			// starting-finishing
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#compareTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compareTo(Mass<Character,Integer> o) {
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<Character,Integer> o) {
		// call hypergenesis computation
		int cmp = get().matrix().reproduce(o.getChild(), getChild());
		// push hypergenesis computation result
		push(new Flop(get().output()));
		// return result computation
		return cmp;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperinteger#run()
	 */
	@Override
	public void run() {
		// avoid concurrent calls to run
		if (!message.compareAndSet(RUNNER, null, Thread.currentThread())) {
			// because is already running
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
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperpair) {
				// declare stem
				Mass<Character,Integer> stem;
				// cast source
				Hyperpair pair = (Hyperpair) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// release child
					stem.order(pair);
				}
			}
			break;
		case SEND:
			if(event.getSource() instanceof Hyperpair) {
				// declare key
				Mass<Character,Integer> stem;
				// cast source
				Hyperpair pair = (Hyperpair) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ?
						!stem.isEmpty() ?
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.add(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Hyperpair) {
				// assign and check
				if(!isEmpty()) {
					// cast source
					Hyperpair string = (Hyperpair) event.getSource();
					// send pulse across the future
					getChild().pulse(this, new Instant(string));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hyperpair) {
				// declare stem
				Mass<Character,Integer> stem;
				// cast source
				Hyperpair pair = (Hyperpair) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								stem.contains(pair) 
								: false
						: false) {
					// release child
					stem.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Hyperpair) {
				// declare stem
				Mass<Character,Integer> stem;
				// cast source
				Hyperpair pair = (Hyperpair) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.submit(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperpair) {
				// live long and prosper
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
	public Character put(Integer key, Character value) {
		// create child
		Hyperentry gene = new Hyperentry(Hyperpair.class, key, value, this);
		// push child
		gene.push(Command.SEND);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Hyperclock#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener, Tachyon<Y,X> event) {
		super.pulse(listener, event);
		// spin -1/2 inheritance
		spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Hyperclock#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void echo(TimeListener<?,?> listener, Tachyon<X,Y> event) {
		super.echo(listener, event);
		matrix = null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public boolean removeAll(Mass<Integer,Character> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<Integer,Character>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<Integer,Character>> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#iterator()
	 */
	@Override
	public Iterator<Mass<Integer,Character>> iterator() {
		Mass<Integer,Character> future;
		return (future = getFuture()) != null ? future.iterator() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Hyperentry : false) {
			// cast source
			Hyperentry pair = (Hyperentry) child;
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
 	// visor implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Mass#valueVisor()
 	 */
 	@Override
 	public Congregation<Character> valueVisor() {
 		Congregation<Character> values;
 		return (values = visor) == null ? 
 				(visor = new Visor(replicator)) : values;
 	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public Mass.Transmuter<Integer,Character> matrix() {

		TimeListener.Transmitter<Mass<Integer,Character>, Mass<Character, Integer>> m;
 		return (m = matrix) != null ? (Holomatrix) m : (Holomatrix) (matrix = new Holomatrix());
	}

	/**
	 * @author joan
	 *
	 */
	protected class Holomatrix 
		extends Translocator {
		/**
		 * @throws Abort
		 */
		public Holomatrix() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#output()
		 */
		@Override
		public Hypercube get() {
			return (Hypercube) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(Integer key, Character value) {
			get().put(value, key);
		}
	}
	// hyperstring implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#concat(java.lang.StringBuilder)
	 */
	@Override
	public StringBuilder concat(StringBuilder o) {
		return !isEmpty() ? ((Hypertext) getChild()).concat(o) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#concat(java.lang.String)
	 */
	@Override
	public String concat(String str) {
		return !isEmpty() ? ((Hypertext) getChild()).concat(str) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#charAt(int)
	 */
	@Override
	public char charAt(int index) {
		return !isEmpty() ? ((Hypertext) getChild()).charAt(index): null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#subSequence(int, int)
	 */
	@Override
	public CharSequence subSequence(int start, int end) {
		return !isEmpty() ? ((Hypertext) getChild()).subSequence(start, end) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#substring(int, int)
	 */
	@Override
	public String substring(int beginIndex, int endIndex) {
		return !isEmpty() ? ((Hypertext) getChild()).substring(beginIndex, endIndex) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#substring(java.lang.StringBuilder, int, int)
	 */
	@Override
	public StringBuilder substring(StringBuilder builder, int beginIndex, int endIndex) {
		return !isEmpty() ? ((Hypertext) getChild()).substring(builder, beginIndex, endIndex) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#sum(java.lang.Integer)
	 */
	@Override
	public Integer sum(Integer o) {
		return !isEmpty() ? ((Hypertext) getChild()).sum(o) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#subtract(java.lang.Integer)
	 */
	@Override
	public Integer subtract(Integer o) {
		return !isEmpty() ? ((Hypertext) getChild()).subtract(o) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#multiply(java.lang.Integer)
	 */
	@Override
	public Integer multiply(Integer o) {
		return !isEmpty() ? ((Hypertext) getChild()).multiply(o) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#divide(java.lang.Integer)
	 */
	@Override
	public Integer divide(Integer o) {
		return !isEmpty() ? ((Hypertext) getChild()).divide(o) : null;
	}
	
	// entity implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Integer,Character>> entrySet() {

		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character getOrDefault(Integer key, Character defaultValue) {
    	return getValueOrDefault(key, defaultValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Integer, ? super Character> action) {
    	forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character putIfAbsent(Integer key, Character value) {
		return putValueIfAbsent(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Integer key, Character value) {
    	return removeByKey(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Integer key, Character oldValue, Character newValue) {
		return replaceValue(key, oldValue, newValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character replace(Integer key, Character value) {
		return replaceValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super Integer, ? super Character, ? extends Character> function) {
    	replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Character get(Integer key) {
    	return getValue(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(
			Atlas<? extends Integer, ? extends Character, ? extends Mass<Integer, Character>> m) {
		for(Mass<Integer,Character> integer : m)
			put(integer.getKey(), integer.getValue());
	}
	
	// space implementation
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public Character putValue(Integer key, Character value) {
		return !isEmpty() ? getChild().putValue(key, value) : put(key, value);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object,java.lang.Object)
	 */
	@Override
	public Character putValueIfAbsent(Integer key, Character value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : put(key, value);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllValues(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllValues(Mass<? extends Integer, ? extends Character> m) {
		if (!isEmpty())
			super.putAllValues(m);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<Integer, Character> call(Integer key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public Character getValue(Integer key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object,java.lang.Object)
	 */
	@Override
	public Character getValueOrDefault(Integer key, Character defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue)	: null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Integer key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Integer> collectKeys(Congregation<Integer> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super Integer, ? super Character> action) {
		if (!isEmpty())
			super.forEachKey(action);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(Integer key, Character oldValue, Character newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(
			BiFunction<? super Integer, ? super Character, ? extends Character> function) {
		if (!isEmpty())
			super.replaceAllValues(function);
	}
	/*
	 * (non-Javadoc) 
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character replaceValue(Integer key, Character value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public Character computeIfAbsent(Integer key, 
			Function<? super Integer, ? extends Character> mappingFunction) {
		return !isEmpty() ? getChild().computeIfAbsent(key, mappingFunction) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Character compute(Integer key, 
			BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
		return !isEmpty() ? getChild().compute(key, remappingFunction) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Character computeIfPresent(Integer key, 
			BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
		return !isEmpty() ? getChild().computeIfPresent(key, remappingFunction)	: null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Character merge(Integer key,	Character value, 
			BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
		return !isEmpty() ? getChild().merge(key, value, remappingFunction) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<Integer, Character> removeByKey(Integer key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(Integer key, Character value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
}