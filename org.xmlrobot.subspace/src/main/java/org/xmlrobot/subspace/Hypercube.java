package org.xmlrobot.subspace;

import java.util.Iterator;
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
import org.xmlrobot.subspace.matter.Hyperunit;
import org.xmlrobot.util.Command;

/**
 * The hypercube. 
 * 
 * <p>One of the datagrams being sent between entities to get communicated through the 
 * abstract protocol. Some hypercube examples: word, phrase, oration, mass, 
 * sermon, order, XML, javadoc, etc.
 * 
 * <p>The hypercube is the hyperchain. And the hyperchain is the hypercube. So, changes 
 * in the hypercube will be reflected in the hyperchain. And vice-versa.
 * 
 * <p>This class is just another member of the {@code hyperspace congregation framework}
 * 
 * @author joan
 * @parity XY
 * @since 1513.1
 */
@XmlRootElement
public class Hypercube
	extends Hyperstring 
		implements Entity<Character,Integer> {

	/**
	 * 6096508309003670033L
	 */
	private static final long serialVersionUID = 6096508309003670033L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hyperstring#name()
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
	public Character getKey() {
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Character setKey(Character key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Integer getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Integer setValue(Integer value) {
		return !isEmpty() ? getChild().setValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperdatagram.class)
	public Entity<Character,Integer> getReplicator() {
		return (Entity<Character,Integer>) super.getReplicator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#get()
	 */
	@Override
	public Entity<Integer,Character> get() {
		return (Entity<Integer,Character>) super.get();
	}
	
	/**
	 * {@link Hypercube} default class constructor.
	 */
	public Hypercube() {
		super(Hyperdatagram.class, Hyperpacket.class, Hypercube.class);
	}
	/**
	 * {@link Hypercube} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hypercube(Class<Hyperchain> antitype) {
		super(Hypercube.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#clone()
	 */
	@Override
	public Hyperstring clone() {
		Hyperstring value = super.clone(); 
		return value;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<Character,Integer> o1, Mass<Character,Integer> o2) {
		// typical recursive logic-safe syntax
		if(o1 != null) {
			
			if(o2 != null) {
				// compare values
				int cmp = o1.getValue() - o2.getValue();
				// call recursion
				cmp += compare(o1.getChild(), o2.getChild());
				// return result
				return cmp;
			}
			else {
				return o1.getValue();
			}
		}
		else if(o2 != null) {
			// polarized value
			return -o2.getValue();
		}
		else {
			// starting-finishing
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Mass<Integer,Character> o) {
		// de-encapsulate chain by revealing child 
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#reproduceTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int reproduceTo(Mass<Integer,Character> o) {
		// call hypergenesis computation
		int cmp = get().matrix().reproduce(o.getChild(), getChild());
		// push hypergenesis computation result
		push(new Instant(get().output()));
		// return result computation
		return cmp;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#run()
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
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// ancestral recall
		super.mass(sender, event);
		// execute order
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperentry) {
				// declare stem
				Mass<Integer,Character> stem;
				// cast source
				Hyperentry pair = (Hyperentry) event.getSource();
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
			if(event.getSource() instanceof Hyperentry) {
				// declare key
				Mass<Integer,Character> stem;
				// cast source
				Hyperentry pair = (Hyperentry) event.getSource();
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
			if(event.getSource() instanceof Hyperentry) {
				// assign and check
				if(!isEmpty()) {
					// cast source
					Hyperentry pair = (Hyperentry) event.getSource();
					// emit gigaflop to the future
					getChild().pulse(this, new Flop(pair));
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Hyperunit) {
				// declare stem
				Mass<Integer,Character> stem;
				// cast source
				Hyperunit pair = (Hyperunit) event.getSource();
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
			if(event.getSource() instanceof Hyperunit) {
				// declare stem
				Mass<Integer,Character> stem;
				// cast source
				Hyperunit pair = (Hyperunit) event.getSource();
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
		case INTERRUPTED: 
		case TRANSFER:
			if(event.getSource() instanceof Hyperentry) {
				// rip
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
	public Integer put(Character key, Integer value) {
		// create child
		Hyperpair pair = new Hyperpair(Hyperentry.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void pulse(TimeListener<?,?> listener, Tachyon<Y,X> event) {
		super.pulse(listener, event);
		// spin inheritance
		spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>>
		void echo(TimeListener<?,?> listener, Tachyon<X,Y> event) {
		super.echo(listener, event);
		// nullify matrix
		matrix = null;
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
				child instanceof Hyperpair : false) {
			// cast source
			Hyperpair pair = (Hyperpair) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().putKey(pair.getValue(), pair.getKey());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release child
				getReplicator().removeByValue(pair.getValue());
			}
		}
	}

 	// visor implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.space.Space#valueVisor()
 	 */
 	@Override
 	public Congregation<Integer> valueVisor() {
 		Congregation<Integer> values;
 		return (values = visor) == null ? 
 				(visor = new Visor(replicator)) : values;
 	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#iterator()
	 */
	@Override
	public Iterator<Mass<Character,Integer>> iterator() {
		Mass<Character,Integer> future;
		return (future = getFuture()) != null ? future.iterator() : null;
	}
 	
 	// matrix implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#matrix()
	 */
	@Override
	public Mass.Transmuter<Character,Integer> matrix() {		
		Mass.Transmuter<Character,Integer> m;
 		return (m = (Mass.Transmuter<Character,Integer>) matrix) != null ? 
 				m 
 				: (Mass.Transmuter<Character,Integer>) (matrix = new Holodeck());
	}
	/**
	 * The holomatrix class implementation
	 * to make simulations of human history.
	 * @author joan
	 *
	 */
	protected class Holodeck
		extends Translocator {

		/**
		 * {@link Holodeck} default class constructor.
		 */
		public Holodeck() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Hyperchain get() {
			
			return (Hyperchain) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(Character key, Integer value) {
			get().put(value, key);
		}
	}
	
	// hypertext implementation
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
		// 
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
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Integer get(Character key) {
    	return getValue(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(
			Atlas<? extends Character, ? extends Integer, ? extends Mass<Character,Integer>> m) {
		for(Mass<Character,Integer> string : m)
			put(string.getKey(), string.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Character,Integer>> entrySet() {
		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer getOrDefault(Character key, Integer defaultValue) {
    	return getValueOrDefault(key, defaultValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Character, ? super Integer> action) {
    	forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer putIfAbsent(Character key, Integer value) {
		return putValueIfAbsent(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Character key, Integer value) {
    	return removeByKey(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Character key, Integer oldValue, Integer newValue) {
		return replaceValue(key, oldValue, newValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer replace(Character key, Integer value) {
		return replaceValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super Character,? super Integer,? extends Integer> function) {
    	replaceAllValues(function);
	}
	
	// space implementation
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public Integer putValue(Character key, Integer value) {
		return !isEmpty() ? getChild().putValue(key, value) : put(key, value);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object,java.lang.Object)
	 */
	@Override
	public Integer putValueIfAbsent(Character key, Integer value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : put(key, value);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllValues(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllValues(Mass<? extends Character, ? extends Integer> m) {
		if (!isEmpty())
			super.putAllValues(m);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<Character, Integer> call(Character key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public Integer getValue(Character key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object,java.lang.Object)
	 */
	@Override
	public Integer getValueOrDefault(Character key, Integer defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue)	: null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Character key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<Character> collectKeys(Congregation<Character> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super Character, ? super Integer> action) {
		if (!isEmpty())
			super.forEachKey(action);
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(Character key, Integer oldValue, Integer newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(
			BiFunction<? super Character, ? super Integer, ? extends Integer> function) {
		if (!isEmpty())
			super.replaceAllValues(function);
	}
	/*
	 * (non-Javadoc) 
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer replaceValue(Character key, Integer value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public Integer computeIfAbsent(Character key, 
			Function<? super Character, ? extends Integer> mappingFunction) {
		return !isEmpty() ? getChild().computeIfAbsent(key, mappingFunction) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Integer compute(Character key, 
			BiFunction<? super Character, ? super Integer, ? extends Integer> remappingFunction) {
		return !isEmpty() ? getChild().compute(key, remappingFunction) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Integer computeIfPresent(Character key, 
			BiFunction<? super Character, ? super Integer, ? extends Integer> remappingFunction) {
		return !isEmpty() ? getChild().computeIfPresent(key, remappingFunction)	: null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public Integer merge(Character key,	Integer value, 
			BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
		return !isEmpty() ? getChild().merge(key, value, remappingFunction) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<Character, Integer> removeByKey(Character key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(Character key, Integer value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
}