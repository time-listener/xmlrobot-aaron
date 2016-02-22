/**
 * 
 */
package org.xmlrobot.subspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Hypertext;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.Replicator;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.EventHorizon;
import org.xmlrobot.space.Space;
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
 * <p>This class is just another member of the<br>
 * {@code hyperspace congregation framework}.
 * 
 * @author joan
 * @parity XX
 * @since 28
 */
@XmlTransient
public abstract class Hyperinteger
	extends Space<Integer,Character> 
		implements Replicator<Integer,Character>, 
			Hypertext {

	/**
	 * 3747383271792133254L
	 */
	private static final long serialVersionUID = 3747383271792133254L;
	
	transient volatile Mass<Integer,Character> plasma;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Replicator#getPlasma()
	 */
	@Override
	public Mass<Integer,Character> getPlasma() {
		return plasma;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#getName()
	 */
	@Override
	@XmlElement
	public String getName() {
		return getValue().toString();
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
			Class<? extends Hyperinteger> type) {
		super(type, Parity.XX);
		// instance mass
		plasma = instance(matter, antimatter);
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
			Class<? extends Hyperinteger> type,
			Integer key, Character value) {
		// call constructor
		super(type, key, value, Parity.XX);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
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
			Class<? extends Hyperinteger> type,
			Integer key, Character value, Hyperinteger parent) {
		super(type, key, value, parent);
		// instance mass
		plasma = instance(matter, antimatter, key, value, parent.getPlasma());
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 */
	protected Hyperinteger(
			Class<? extends Hyperinteger> type,
			Class<? extends Hyperstring> antitype) {
		super(type, antitype, Parity.XX);
	}

	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	protected Hyperinteger(
			Class<? extends Hyperinteger> type, 
			Class<? extends Hyperstring> antitype, 
			Integer key, Character value) {
		// call constructor
		super(type, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	protected Hyperinteger(
			Class<? extends Hyperinteger> type, 
			Class<? extends Hyperstring> antitype, 
			Integer key, Character value, Hyperinteger parent) {
		super(type, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#clone()
	 */
	@Override
	public Hyperinteger clone() {
	
		return (Hyperinteger) super.clone();
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
 	 */
 	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// assign and check
		if (ref.getProperty(TimeListener.KEY) == this) {
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {

				plasma.push(Command.SUBMIT);
			} 
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				plasma.push(Command.RELEASE);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#run()
	 */
	@Override
	public void run() {
		super.run();
		
		try {
			// listen time
			Thread.sleep(longValue());
		}
		catch(Exception ex) {
			// if someone kills current instance
			push(Command.INTERRUPTED);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#set(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void set(Mass<Character,Integer> value) {
		super.set(value);
		// cast source
		Hyperstring stem = (Hyperstring) value;
		// set child's plasma
		stem.plasma = plasma.get();
		// my plasma is listened by my root's plasma
		stem.plasma.setStem(plasma.getRoot());
		stem.plasma.setRoot(plasma.getStem());
		// listen plasma masses
		stem.plasma.addMassListener(this);
		plasma.addMassListener(stem);
	}

	// matrix implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public Mass.Transmuter<Integer,Character> matrix() {
		 Mass.Transmuter<Integer,Character> m;
 		return (m = (Mass.Transmuter<Integer,Character>) matrix) != null ? 
 				m : (Mass.Transmuter<Integer,Character>) (matrix = new Hypergrid());
	}
	/**
	 * The hypergrid. A hyperdigital frontier,
	 * 
	 * @author joan
	 */
	protected class Hypergrid 
		extends Comparator 
			implements Mass.Transmuter<Integer,Character> {

		/**
		 * {@link Hypergrid} default class constructor.
		 */
		public Hypergrid() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#reproduce(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int reproduce(Mass<Integer,Character> key, Mass<Character,Integer> value) {
			// compute comparison result
			int cmp = super.reproduce(key, value);
			// maximization operation
			if(cmp < 0) {
				// set key-value pair
				put(value.getValue(), value.getKey());
				return -1;
			}
			else if(cmp == 0) {
				// set key-value pair
				put(key.getKey(), key.getValue());
				// doubled paired output: evolve
				put(value.getValue(), value.getKey());
				return 0;
			}
			else {
				// set key-value pair
				put(key.getKey(), key.getValue());
				return 1;
			}
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Mass.Transmuter#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(Integer key, Character value) {
			if(get() == null)
				super.set(instance(getAntitype(), getType(), value, key));
			else inject(instance(getType(), getAntitype(), key, value));
		}
	}
	//natural numbers base operations
	/**
	 * Natural addition
	 * @param o the output
	 * @return the output
	 */
	public Integer sum(Integer o) {
		o += getKey();
		return !isEmpty() ? ((Hypertext) getChild()).sum(o) : o;
	}
	/**
	 * Natural subtract
	 * @param o the output
	 * @return the output
	 */
	public Integer subtract(Integer o) {
		o -= getKey();
		return !isEmpty() ?	((Hypertext)getChild()).subtract(o) : o;
	}
	/**
	 * Natural multiplication
	 * @param o the output
	 * @return the output
	 */
	public Integer multiply(Integer o) {
		o *= getKey();
		return !isEmpty() ? ((Hypertext)getChild()).multiply(o)	: o;
	}
	/**
	 * Natural division
	 * @param o the output
	 * @return the output
	 */
	public Integer divide(Integer o) {
		o /= getKey();
		return !isEmpty() ?	((Hypertext)getChild()).divide(o) : o ;
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
	
	// text implementation
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Text#concat(java.lang.String)
     */
    public String concat(String str) {
        // concatenate string
        str = str.concat(getKey().toString());
        // return string or call recursion
        return !isEmpty() ? ((Hypertext) getChild()).concat(str) : str;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#concat(java.lang.StringBuilder)
	 */
	@Override
	public StringBuilder concat(StringBuilder o) {
		// do concatenation
		o.append(getKey());
        // return builder or call recursion
		return !isEmpty() ? ((Hypertext) getChild()).concat(o) : o ;
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
        // return builder or call recursion
		return !isEmpty() ? 
				((Hypertext) getChild()).substring(builder, --beginIndex, --endIndex) 
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
}