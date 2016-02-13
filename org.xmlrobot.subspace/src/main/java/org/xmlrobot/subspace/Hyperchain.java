package org.xmlrobot.subspace;

import java.util.Iterator;
import java.util.Objects;
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
 * 
 * <p>The hyperchain is the hypercube. And the hypercube is the hyperchain. So, changes 
 * in the hyperchain will be reflected in the hypercube. And vice-versa.
 * 
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
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Integer getKey() {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Integer setKey(Integer key) {
		Mass<Integer,Character> child;	
		if((child = getChild()) != null) 
			return child.setKey(key);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Character getValue() {
		Mass<Integer,Character> child;	
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Character setValue(Character value) {
		Mass<Integer,Character> child;	
		if((child = getChild()) != null) 
			return child.setValue(value);
		else return null;
	}
	
	@Override
	@XmlElement(type=Hyperpacket.class)
	public Mass<Integer, Character> getReplicator() {
		return super.getReplicator();
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
		super(Hyperpacket.class, Hyperdatagram.class, Hyperchain.class, antitype);
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

		return matrix.reproduce(o.get().getChild(), get().getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperinteger#run()
	 */
	@Override
	public void run() {
	
		super.run();
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {

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
		case PUSH:
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
		case LISTEN:
			if(event.getSource() instanceof Hyperpair) {
				// cast source
				Hyperpair string = (Hyperpair) event.getSource();
				// declare child of inheritance
				Mass<Integer,Character> child;
				// assign and check
				if((child = getChild()) != null) {
					// send pulse across the future
					child.pulse(this, new Instant(string));
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
				// cast source
				Hyperpair entity = (Hyperpair) event.getSource();
				// transfer message contents (to the future)
				get().putValue(entity.getKey(), entity.getValue());
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
		// spin -1/2 inheritance
		spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Past#echo(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void echo(TimeListener<?,?> listener, Takion<X,Y> event) {
		
		super.echo(listener, event);
		
		if(event.getSource() instanceof Hyperinteger) {
			// iterate through event's children
			for(X integer : event) {
				// load output result to current matrix
				matrix().push((Hyperinteger)integer);
			}	
		}
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
	 * @see org.xmlrobot.Hyperinteger#name()
	 */
	@Override
	@XmlElement
	public String getName() {

		return !isEmpty() ? ((Hypertext) getChild()).concat(new String()) : null;
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
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character getOrDefault(Integer key, Character defaultValue) {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : defaultValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Integer, ? super Character> action) {
		Mass<Integer,Character> child;
		if((child = getChild()) != null)
			child.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character putIfAbsent(Integer key, Character value) {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
	}
	@Override
	public boolean remove(Integer key, Character value) {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Integer key, Character oldValue, Character newValue) {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character replace(Integer key, Character value) {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(
			BiFunction<? super Integer, ? super Character, ? extends Character> function) {

		Mass<Integer,Character> child;
		
		if((child = getChild()) != null)
			child.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Character get(Integer key) {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character put(Integer key, Character value) {
		// create child
		Hyperentry gene = new Hyperentry(Hyperpair.class, key, value, this);
		// push child
		gene.push(Command.PUSH);
		return null;
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
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Integer,Character>> entrySet() {

		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<Integer,Character>,Mass<Character,Integer>> matrix() {

		TimeListener.Transmitter<Mass<Integer,Character>,Mass<Character,Integer>> m;
 		return (m = matrix) != null ? m : (Holomatrix) (matrix = new Holomatrix());
	}
	@Override
	public org.xmlrobot.genesis.TimeListener.Transmitter<Mass<Integer, Character>, Mass<Character, Integer>> matrix(
			Mass<Character, Integer> output) {
		return null;
	}
	/**
	 * @author joan
	 *
	 */
	protected class Holomatrix 
		extends Transmuter {

		/**
		 * @throws Abort
		 */
		public Holomatrix() {
			super();
		}
		@Override
		public Hypercube output() {
			return (Hypercube) super.output();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperinteger.Hypergrid#push(org.xmlrobot.lang.Hyperinteger)
		 */
		@Override
		public void push(Mass<Integer,Character> child) {
		
//			Mass<Integer,Character> key = child.clone();
//			Mass<Character,Integer> value = child.get().clone();
//			
//			key.setAntitype(value.getType());
//			value.setAntitype(key.getType());
//			
//			key.set(value);
//			value.set(key);
//			
//			output().add(key);
			output().put(child.getValue(), child.getKey());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperinteger.Hypergrid#inject(org.xmlrobot.lang.Hyperstring)
		 */
		@Override
		public void inject(Mass<Character,Integer> child) {
			
//			Mass<Character,Integer> key = child.clone();
//			Mass<Integer,Character> value = child.get().clone();
//			
//			key.setAntitype(value.getType());
//			value.setAntitype(key.getType());
//			
//			key.set(value);
//			value.set(key);
//			
//			output().get().add(key);

			output().put(child.getKey(), child.getValue());
		}
	}
}