/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Number;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.EventHorizon;
import org.xmlrobot.space.Space;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Theory of {@link Integer}s implementation class crossing 
 * the {@link EventHorizon}. Value is the key, and key is 
 * the time. From {@code hyperspace} to the {@code further}.
 * 
 * <p>The hyperinteger is the hyperstring. And vice-versa.
 * I.e, the hyperstring is the hyperinteger. And vice-versa.
 * Changes in the hyperinteger will be reflected in the hyperstring. 
 * And vice-versa. So, changes in the hyperstring will be 
 * reflected in the hyperinteger. And vice-versa.
 * 
 * @author joan
 *
 */
@XmlTransient
public abstract class Hyperinteger
	extends Space<Integer,String> 
		implements Number {

	/**
	 * 3747383271792133254L
	 */
	private static final long serialVersionUID = 3747383271792133254L;
	
	private transient volatile Mass<Integer,String> mass;
	/**
	 * {@link Hyperinteger} default class constructor.
	 */
	public Hyperinteger() {
		
		super();
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the type
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,  
			Class<? extends Mass<Integer,String>> type) {
		super(type, Parity.XX);
		// instance mass
		mass = instance(matter, antimatter);
		// listen mass
		mass.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the type
	 * @param parent the parent of inheritance
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,  
			Class<? extends Mass<Integer,String>> type,
			Mass<Integer,String> parent) {
		super(type, parent);
		// instance mass
		mass = instance(matter, antimatter);
		// listen mass
		mass.addMassListener(this);
	}

	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,  
			Class<? extends Mass<Integer,String>> type,
			Integer key, String value) {
		// call constructor
		super(type, key, value, Parity.XX);
		// instance mass
		mass = instance(matter, antimatter, key, value);
		// listen mass
		mass.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent the parent of inheritance
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,  
			Class<? extends Mass<Integer,String>> type,
			Integer key, String value, Mass<Integer,String> parent) {
		super(type, key, value, parent);
		// instance mass
		mass = instance(matter, antimatter, key, value);
		// listen mass
		mass.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,  
			Class<? extends Mass<Integer,String>> type, 
			Class<? extends Hyperstring> antitype) {
		super(type, antitype, Parity.XX);
		// instance mass
		mass = instance(matter, antimatter);
		// listen mass
		mass.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,
			Class<? extends Mass<Integer,String>> type,
			Class<? extends Hyperstring> antitype, Mass<Integer,String> parent) {
		super(type, antitype, parent);
		// instance mass
		mass = instance(matter, antimatter);
		// listen mass
		mass.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,
			Class<? extends Mass<Integer,String>> type, 
			Class<? extends Hyperstring> antitype, 
			Integer key, String value) {
		// call constructor
		super(type, antitype, key, value, Parity.XX);
		// instance mass
		mass = instance(matter, antimatter, key, value);
		// listen mass
		mass.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperinteger(
			Class<? extends Mass<Integer,String>> matter,
			Class<? extends Mass<String,Integer>> antimatter,
			Class<? extends Mass<Integer,String>> type, 
			Class<? extends Hyperstring> antitype, 
			Integer key, String value, Mass<Integer,String> parent) {
		super(type, antitype, key, value, parent);
		// instance mass
		mass = instance(matter, antimatter, key, value);
		// listen mass
		mass.addMassListener(this);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#clone()
	 */
	@Override
	public Hyperinteger clone() {
	
		return (Hyperinteger) super.clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Integer,String> o1, Mass<Integer,String> o2) {

		return o1.getValue().compareTo(getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#run()
	 */
	@Override
	public void run() {
		
		super.run();
		
		try {
			// listen time
			Thread.sleep(getKey());
			// mass transfer
			push(Command.TRANSFER);
		}
		catch(Exception ex) {
			// if someone kills current instance
			push(Command.INTERRUPTED);
		}
	}
	//natural numbers base operations
	/**
	 * Natural addition
	 * @param o the output
	 * @return the output
	 */
	public Integer sum(Integer o) {
		
		Mass<Integer,String> child = getChild();
		
		o += getKey();

		return child != null ? 
				child instanceof Number ? 
						((Number) child).sum(o) 
						: o 
				: o;
	}
	/**
	 * Natural subtract
	 * @param o the output
	 * @return the output
	 */
	public Integer subtract(Integer o) {
		
		Mass<Integer,String> child = getChild();
		
		o -= getKey();

		return child != null ? 
				child instanceof Number ? 
						((Number)child).subtract(o) 
						: o
				: o;
	}
	/**
	 * Natural multiplication
	 * @param o the output
	 * @return the output
	 */
	public Integer multiply(Integer o) {
		
		Mass<Integer,String> child = getChild();
		
		o *= getKey();

		return child != null ? 
				child instanceof Number ? 
						((Number)child).multiply(o) 
						: o 
				: o;
	}
	/**
	 * Natural division
	 * @param o the output
	 * @return the output
	 */
	public Integer divide(Integer o) {

		Mass<Integer,String> child = getChild();
		
		o /= getKey();

		return child != null ? 
				child instanceof Number ? 
						((Number)child).divide(o) 
						: o 
				: o;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#intValue()
	 */
	@Override
	public int intValue() {
		
		return getKey().intValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#longValue()
	 */
	@Override
	public long longValue() {

		return getKey().longValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#floatValue()
	 */
	@Override
	public float floatValue() {

		return getKey().floatValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {

		return getKey().doubleValue();
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<Integer,String>,Mass<String,Integer>> matrix() {

		TimeListener.Transmitter<Mass<Integer,String>,Mass<String,Integer>> m;
 		return (m = matrix) != null ? m : (matrix = new Hypergrid());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	@XmlElement
	public String getName() {
		
		return getValue().toString();
	}
	
	/**
	 * The hypergrid.
	 * 
	 * @author joan
	 *
	 */
	protected class Hypergrid 
		extends Transmuter {

		/**
		 * @throws Abort
		 */
		public Hypergrid() {
			super();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
		 */
		@Override
		public int reproduce(Mass<Integer,String> root, Mass<String,Integer> stem) {
			// compute comparison result
			int cmp = root.compareTo(stem);
			// maximization operation
			if(cmp < 0) {
				// assign key-value message
				output().setKey(stem.getValue());
				output().setValue(stem.getKey());
				return 1;
			}
			else if(cmp == 0) {
				// if pair comparison equals: evolve
				output().setKey(root.getKey());
				output().setValue(root.getValue());
				// instantiate new pair
				Mass<Integer,String> pair = instance(
						getType(), getAntitype(), stem.getValue(), stem.getKey());
				// doubled paired output
				push(pair);
				return 0;
			}
			else {
				// assign key-value message
				output().setKey(root.getKey());
				output().setValue(root.getValue());
				return -1;
			}
		}
	}
}
