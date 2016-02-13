/**
 * 
 */
package org.xmlrobot.subspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Hypertext;
import org.xmlrobot.genesis.TimeListener;
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
 * @parity XX
 * @since 28
 */
@XmlTransient
public abstract class Hyperinteger
	extends Space<Integer,Character> 
		implements Hypertext {

	/**
	 * 3747383271792133254L
	 */
	private static final long serialVersionUID = 3747383271792133254L;
	
	private transient volatile Mass<Integer,Character> plasma;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	@XmlElement
	public String getName() {
		
		return getValue().toString();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Singularity#getReplicator()
	 */
	@Override
	public Mass<Integer,Character> getReplicator() {
		return plasma;
	}
	
	/**
	 * {@link Hyperinteger} default class constructor.
	 */
	public Hyperinteger() {
		
		super();
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the type
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,  
			Class<? extends Mass<Integer,Character>> type) {
		super(type, Parity.XX);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the type
	 * @param parent the parent of inheritance
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,  
			Class<? extends Mass<Integer,Character>> type,
			Mass<Integer,Character> parent) {
		super(type, parent);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,  
			Class<? extends Mass<Integer,Character>> type,
			Integer key, Character value) {
		// call constructor
		super(type, key, value, Parity.XX);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent the parent of inheritance
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,  
			Class<? extends Mass<Integer,Character>> type,
			Integer key, Character value, Mass<Integer,Character> parent) {
		super(type, key, value, parent);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,  
			Class<? extends Mass<Integer,Character>> type, 
			Class<? extends Hyperstring> antitype) {
		super(type, antitype, Parity.XX);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,
			Class<? extends Mass<Integer,Character>> type,
			Class<? extends Hyperstring> antitype, Mass<Integer,Character> parent) {
		super(type, antitype, parent);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,
			Class<? extends Mass<Integer,Character>> type, 
			Class<? extends Hyperstring> antitype, 
			Integer key, Character value) {
		// call constructor
		super(type, antitype, key, value, Parity.XX);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	protected Hyperinteger(
			Class<? extends Mass<Integer,Character>> matter,
			Class<? extends Mass<Character,Integer>> antimatter,
			Class<? extends Mass<Integer,Character>> type, 
			Class<? extends Hyperstring> antitype, 
			Integer key, Character value, Mass<Integer,Character> parent) {
		super(type, antitype, key, value, parent);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
		// listen mass
		plasma.addMassListener(this);
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
	public int compare(Mass<Integer,Character> o1, Mass<Integer,Character> o2) {

		return Character.compare(o1.getValue(), o2.getValue());
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Text#concat(java.lang.String)
     */
    public String concat(String str) {
    	
        if (getValue() == null) {
            return str;
        }
        // concatenate string
        str = str.concat(getValue().toString());
        // get the child
        Mass<Integer,Character> child = getChild();
        // return string or call recursion
        return child != null ? 
        		child instanceof Hypertext ? 
        				((Hypertext) child).concat(str) 
        				: str 
        		: str;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#concat(java.lang.StringBuilder)
	 */
	@Override
	public StringBuilder concat(StringBuilder o) {
		// do concatenation
		o.append(getValue());
        // get the child
		Mass<Integer,Character> child = getChild();
        // return builder or call recursion
		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext) child).concat(o) 
						: o 
				: o;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#substring(int, int)
	 */
	@Override
	public String substring(int beginIndex, int endIndex) {
		
		if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > depth()) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }
        int subLen = endIndex - beginIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        return this.substring(new StringBuilder(), beginIndex, endIndex).toString();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#substring(java.lang.StringBuilder, int, int)
	 */
	@Override
	public StringBuilder substring(StringBuilder builder, int beginIndex,
			int endIndex) {
		if (beginIndex <= 0) {
            builder.append(getKey());
        }
		if (endIndex == 0) {
			return builder;
		}
        // get the child
		Mass<Integer,Character> child = getChild();
        // return builder or call recursion
		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext) child).substring(builder, --beginIndex, --endIndex) 
						: builder 
				: builder;
	}
	/* (non-Javadoc)
	 * @see java.lang.CharSequence#length()
	 */
	@Override
	public int length() {

		return depth();
	}
	/* (non-Javadoc)
	 * @see java.lang.CharSequence#charAt(int)
	 */
	@Override
	public char charAt(int index) {
		if ((index < 0) || (index >= depth())) {
            throw new StringIndexOutOfBoundsException(index);
        }
		return call(index).getValue();
	}
	/* (non-Javadoc)
	 * @see java.lang.CharSequence#subSequence(int, int)
	 */
	@Override
	public CharSequence subSequence(int start, int end) {

		return this.substring(start, end);
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
		
		Mass<Integer,Character> child = getChild();
		
		o += getKey();

		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext) child).sum(o) 
						: o 
				: o;
	}
	/**
	 * Natural subtract
	 * @param o the output
	 * @return the output
	 */
	public Integer subtract(Integer o) {
		
		Mass<Integer,Character> child = getChild();
		
		o -= getKey();

		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext)child).subtract(o) 
						: o
				: o;
	}
	/**
	 * Natural multiplication
	 * @param o the output
	 * @return the output
	 */
	public Integer multiply(Integer o) {
		
		Mass<Integer,Character> child = getChild();
		
		o *= getKey();

		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext)child).multiply(o) 
						: o 
				: o;
	}
	/**
	 * Natural division
	 * @param o the output
	 * @return the output
	 */
	public Integer divide(Integer o) {

		Mass<Integer,Character> child = getChild();
		
		o /= getKey();

		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext)child).divide(o) 
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
	public TimeListener.Transmitter<Mass<Integer,Character>,Mass<Character,Integer>> matrix() {

		TimeListener.Transmitter<Mass<Integer,Character>,Mass<Character,Integer>> m;
 		return (m = matrix) != null ? m : (matrix = new Hypergrid());
	}
	@Override
	public org.xmlrobot.genesis.TimeListener.Transmitter<Mass<Integer, Character>, Mass<Character, Integer>> matrix(
			Mass<Character,Integer> output) {
		return null;
	}
	
	/**
	 * The hypergrid.
	 * 
	 * @author joan
	 *
	 */
	protected class Hypergrid 
		extends Comparator {

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
		public int reproduce(Mass<Integer,Character> key, Mass<Character,Integer> value) {
			// compute comparison result
			int cmp = super.reproduce(key, value);
			// maximization operation
			if(cmp < 0) {
				// assign key-value message
				push(instance(getType(), getAntitype(), value.getValue(), value.getKey()));
				return -1;
			}
			else if(cmp == 0) {
				// doubled paired output: evolve
				push(instance(getType(), getAntitype(), key.getKey(), key.getValue()));
				push(instance(getType(), getAntitype(), value.getValue(), value.getKey()));
				return 0;
			}
			else {
				// assign key-value mapping pair
				push(instance(getType(), getAntitype(), key.getKey(), key.getValue()));
				return 1;
			}
		}
		@Override
		public void push(Mass<Integer, Character> child) {

			output().get().add(child);
		}
		@Override
		public void inject(Mass<Character, Integer> child) {

			output().add(child);
		}
	}
}
