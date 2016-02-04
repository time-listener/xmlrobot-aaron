package org.xmlrobot;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperdatagram;
import org.xmlrobot.event.Flop;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.DNA;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Text;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hyperword;
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
 * @parity XY
 * @author joan
 */
@XmlRootElement
public class Hypercube 
	extends Hyperstring 
	implements DNA<String,Integer> {

	/**
	 * 6096508309003670033L
	 */
	private static final long serialVersionUID = 6096508309003670033L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	public String getKey() {
		Mass<String,Integer> child;	
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	public Integer getValue() {
		Mass<String,Integer> child;	
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public void setKey(String key) {
		Mass<String,Integer> child;	
		if((child = getChild()) != null) 
			child.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Integer value) {
		Mass<String,Integer> child;	
		if((child = getChild()) != null) 
			child.setValue(value);
	}
	/**
	 * {@link Hypercube} default class constructor.
	 */
	public Hypercube() {
		
		super(Hyperdatagram.class, Hyperword.class, Hypercube.class);
	}
	/**
	 * {@link Hypercube} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hypercube(Class<Hyperchain> antitype) {
		
		super(Hyperdatagram.class, Hyperword.class, Hypercube.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<String,Integer> o1, Mass<String,Integer> o2) {
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
	public int compareTo(Mass<Integer,String> o) {
		// de-encapsulate chain by revealing child 
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<Integer,String> o) {

		return get().matrix().reproduce(o.getChild(), call().getChild());
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
		case SUBMIT:
			if(event.getSource() instanceof Hyperentry) {
				// declare key
				Mass<Integer,String> stem;
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
		case GENESIS:
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry string = (Hyperentry) event.getSource();
				// send pulse across the future
				Mass<String,Integer> child;
				// assign and check
				if((child = getChild()) != null) {
					// emit gigaflop to the future
					child.pulse(this, new Flop(string));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperentry) {
				// cast source
				Hyperentry entity = (Hyperentry) event.getSource();
				// transfer message contents
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
	public Iterator<Mass<String,Integer>> iterator() {
	
		Mass<String,Integer> future;
		return (future = getFuture()) != null ? future.iterator() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Integer get(String key) {
		
		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer put(String key, Integer value) {
		
		return putValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer putValue(String key, Integer value) {
		// declare child
		Mass<String, Integer> child;
		// declare old value
		Integer oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hyperpair pair = new Hyperpair(Hyperentry.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(
			Atlas<? extends String, ? extends Integer, ? extends Mass<String,Integer>> m) {
		
		for(Mass<String,Integer> string : m)
			putValue(string.getKey(), string.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#keySet()
	 */
	@Override
	public Congregation<String> keySet() {

		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.keyView() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#values()
	 */
	@Override
	public Congregation<Integer> values() {

		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.valueView() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<String,Integer>> entrySet() {

		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer getOrDefault(String key, Integer defaultValue) {

		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : defaultValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super String, ? super Integer> action) {

		Mass<String,Integer> child;
		
		if((child = getChild()) != null)
			child.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer putIfAbsent(String key, Integer value) {
	
		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(String key, Integer value) {

		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(String key, Integer oldValue, Integer newValue) {

		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Integer replace(String key, Integer value) {

		Mass<String,Integer> child;
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super String,? super Integer,? extends Integer> function) {
		
		Mass<String,Integer> child;
		
		if((child = getChild()) != null)
			child.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<String,Integer>,Mass<Integer,String>> matrix() {

 		TimeListener.Transmitter<Mass<String,Integer>,Mass<Integer,String>> m;
 		return (m = matrix) != null ? m : (matrix = new Holomatrix());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hyperstring#name()
	 */
	@Override
	@XmlElement
	public String getName() {

		return !isEmpty() ? ((Text) getChild()).concat(new String()) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {

		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Hyperpair) {
			// cast source
			Hyperpair pair = (Hyperpair) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().putValue(pair.getKey(), pair.getValue());
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
	/**
	 * The holomatrix class implementation
	 * to make simulations of human history.
	 * @author joan
	 *
	 */
	protected class Holomatrix
		extends Transmuter {

		/**
		 * {@link Holomatrix} default class constructor.
		 */
		public Holomatrix() {
			
			super();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Hypercube output() {
			
			return (Hypercube) super.output();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperstring.Hypermatrix#push(org.xmlrobot.lang.Hyperstring)
		 */
		@Override
		public void push(Mass<String,Integer> child) {
			// transfer key-value pair
			output().put(child.getKey(), child.getValue());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperstring.Hypermatrix#inject(org.xmlrobot.lang.Hyperinteger)
		 */
		@Override
		public void inject(Mass<Integer,String> child) {
			// transfer value-key pair
			output().put(child.getValue(), child.getKey());
		}
	}
}