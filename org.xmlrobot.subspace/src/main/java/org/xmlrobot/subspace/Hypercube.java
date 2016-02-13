package org.xmlrobot.subspace;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.subspace.antimatter.Hyperdatagram;
import org.xmlrobot.subspace.event.Flop;
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

		return !isEmpty() ? ((Hypertext) getChild()).concat(new String()) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Character getKey() {
		Mass<Character,Integer> child;	
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Character setKey(Character key) {
		Mass<Character,Integer> child;	
		if((child = getChild()) != null) 
			return child.setKey(key);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Integer getValue() {
		Mass<Character,Integer> child;	
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Integer setValue(Integer value) {
		Mass<Character,Integer> child;	
		if((child = getChild()) != null) 
			return child.setValue(value);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.Hyperstring#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperdatagram.class)
	public Mass<Character, Integer> getReplicator() {
		return super.getReplicator();
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
		super(Hyperdatagram.class, Hyperpacket.class, Hypercube.class, antitype);
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
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
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
	 * @see org.xmlrobot.lang.Hyperstring#compareTo(org.xmlrobot.lang.Hyperinteger)
	 */
	@Override
	public int compareTo(Mass<Integer,Character> o) {
		// de-encapsulate chain by revealing child 
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<Integer,Character> o) {

		return matrix.reproduce(o.get().getChild(), get().getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperstring#run()
	 */
	@Override
	public void run() {
		
		super.run();
		// it's time to transfer its contents
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#mass(org.xmlrobot.genesis.Genesis, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
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
		case PUSH:
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
		case LISTEN:
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry pair = (Hyperentry) event.getSource();
				// send pulse across the future
				Mass<Character,Integer> child;
				// assign and check
				if((child = getChild()) != null) {
					// emit gigaflop to the future
					child.pulse(this, new Flop(pair));
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
		case TRANSFER:
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry pair = (Hyperentry) event.getSource();
				// transfer message contents
				get().putValue(pair.getKey(), pair.getValue());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Future#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void pulse(TimeListener<?,?> listener, Takion<Y,X> event) {
		super.pulse(listener, event);
		// spin inheritance
		spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Past#echo(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>>
		void echo(TimeListener<?,?> listener, Takion<X,Y> event) {
		super.echo(listener, event);
		
		if(event.getSource() instanceof Hyperstring) {
			for(X string : event) {
				// message re-transmission to the matrix
				matrix().push((Hyperstring)string);
			}	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#iterator()
	 */
	@Override
	public Iterator<Mass<Character,Integer>> iterator() {
	
		Mass<Character,Integer> future;
		return (future = getFuture()) != null ? future.iterator() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Integer get(Character key) {
		
		Mass<Character,Integer> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer put(Character key, Integer value) {
		// create child
		Hyperpair pair = new Hyperpair(Hyperentry.class, key, value, this);
		// push child
		pair.push(Command.PUSH);
		
		return null;
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

		Mass<Character,Integer> child;
		return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : defaultValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Character, ? super Integer> action) {
		Mass<Character,Integer> child;
		if((child = getChild()) != null)
			child.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer putIfAbsent(Character key, Integer value) {
	
		Mass<Character,Integer> child;
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Character key, Integer value) {

		Mass<Character,Integer> child;
		return (child = getChild()) != null ? child.removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Character key, Integer oldValue, Integer newValue) {

		Mass<Character,Integer> child;
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer replace(Character key, Integer value) {

		Mass<Character,Integer> child;
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super Character,? super Integer,? extends Integer> function) {
		
		Mass<Character,Integer> child;
		
		if((child = getChild()) != null)
			child.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<Character,Integer>,Mass<Integer,Character>> matrix() {

 		TimeListener.Transmitter<Mass<Character,Integer>,Mass<Integer,Character>> m;
 		return (m = matrix) != null ? m : (matrix = new Holodeck());
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
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
	/**
	 * The holomatrix class implementation
	 * to make simulations of human history.
	 * @author joan
	 *
	 */
	protected class Holodeck
		extends Transmuter {

		/**
		 * {@link Holodeck} default class constructor.
		 */
		public Holodeck() {
			
			super();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Hyperchain output() {
			
			return (Hyperchain) super.output();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperstring.Hypermatrix#push(org.xmlrobot.lang.Hyperstring)
		 */
		@Override
		public void push(Mass<Character,Integer> child) {
			System.out.print(" push : " + child.getName());
			// transfer key-value pair
			output().put(child.getValue(), child.getKey());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperstring.Hypermatrix#inject(org.xmlrobot.lang.Hyperinteger)
		 */
		@Override
		public void inject(Mass<Integer,Character> child) {
			System.out.print(" inject : " + child.getName());
			// transfer value-key pair
			output().put(child.getKey(), child.getValue());
		}
	}

}