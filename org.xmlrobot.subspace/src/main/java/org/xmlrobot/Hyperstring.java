/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Text;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.EventHorizon;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.space.Space;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Theory of {@link String}s implementation class crossing 
 * the {@link EventHorizon}. Key is the value, and value is 
 * the time. From {@code further} to the {@code hyperspace}.
 * 
 * <p>The hyperstring is the hyperinteger. And vice-versa.
 * I.e, the hyperinteger is the hyperstring. And vice-versa.
 * Changes in the hyperstring will be reflected in the hyperinteger. 
 * And vice-versa. So, changes in the hyperinteger will be 
 * reflected in the hyperstring. And vice-versa.
 * 
 * <p>This class is just another member of the<br>
 * {@code hyperspace congregation framework}.
 * 
 * @author joan
 * @since before BigBang
 */
@XmlTransient
public abstract class Hyperstring
	extends Space<String,Integer>
		implements Text {

	/**
	 * 4765439639824940621L
	 */
	private static final long serialVersionUID = 4765439639824940621L;

	/**
	 * The mass implementation
	 */
	private transient volatile Mass<String,Integer> plasma;
	
	/**
	 * {@link Hyperstring} default class constructor.
	 */
	public Hyperstring() {
		
		super();
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type) {
		super(type, Parity.XY);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 * @param parent the parent of inheritance
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type,
			Mass<String,Integer> parent) {
		super(type, parent);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type,
			String key, Integer value) {
		super(type, key, value, Parity.XY);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent the parent of inheritance
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type,
			String key, Integer value, 
			Mass<String,Integer> parent) {
		super(type, key, value, parent);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type, 
			Class<? extends Mass<Integer,String>> antitype) {
		super(type, antitype, Parity.XY);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type, 
			Class<? extends Mass<Integer,String>> antitype, 
				Mass<String,Integer> parent) {
		super(type, antitype, parent);
		// instance mass
		plasma = instance(matter, antimatter);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type, 
			Class<? extends Mass<Integer,String>> antitype, 
			String key, Integer value) {
		super(type, antitype, key, value, Parity.XY);
		// instance mass
		plasma = instance(matter, antimatter, key, value);
		// listen mass
		plasma.addMassListener(this);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent the parent of inheritance
	 */
	public Hyperstring(
			Class<? extends Mass<String,Integer>> matter, 
			Class<? extends Mass<Integer,String>> antimatter, 
			Class<? extends Mass<String,Integer>> type, 
			Class<? extends Mass<Integer,String>> antitype, 
			String key, Integer value, 
			Mass<String,Integer> parent) {
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
	public Hyperstring clone() {
		
		try {
			return (Hyperstring) super.clone();
		}
		catch(ClassCastException exception) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<String,Integer> o1, Mass<String,Integer> o2) {

		return Integer.compare(o1.getValue(), o2.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Singularity#replicator()
	 */
	@Override
	public Mass<String,Integer> replicator() {
		// return implemented mass
		return plasma;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Hyperclock#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener,	Takion<Y,X> event) {
		
		super.pulse(listener, event);
		
		if(event.getSource() instanceof Hyperinteger) {
			try {
				// listen time synchronously
				Thread.sleep(((Hyperinteger)event.getSource()).longValue());
			}
			catch(Exception ex) {
				// hum, we must see...
				push(Command.INTERRUPTED);
			}
		}

	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Hyperclock#echo(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void echo(TimeListener<?,?> listener, Takion<X,Y> event) {
		super.echo(listener, event);
		
		if(event.getSource() instanceof Hyperstring) {
			try {
				// listen time synchronously
				Thread.sleep(((Hyperstring)event.getSource()).getValue());
			}
			catch(Exception ex) {
				// hum, we must see...
				push(Command.INTERRUPTED);
			}	
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<String,Integer>,Mass<Integer,String>> matrix() {
		TimeListener.Transmitter<Mass<String,Integer>,Mass<Integer,String>> m;
 		return (m = matrix) != null ? m : (matrix = new Hypermatrix());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#run()
	 */
	@Override
	public void run() {
	
		super.run();
		
		try {
			// listen time
			Thread.sleep(getValue());
		}
		catch(Exception ex) {
			// hum, we must see...
			push(Command.INTERRUPTED);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#getName()
	 */
	@Override
	@XmlElement
	public String getName() {

		return getKey().toString();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#concat(java.lang.StringBuilder)
	 */
	public StringBuilder concat(StringBuilder o) {
		// do concatenation
		o.append(getKey());
        // get the child
		Mass<String,Integer> child = getChild();
        // return builder or call recursion
		return child != null ? 
				child instanceof Text ? 
						((Text) child).concat(o) 
						: o 
				: o;
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Text#concat(java.lang.String)
     */
    public String concat(String str) {
    	
        if (getKey() == null) {
            return str;
        }
        // concatenate string
        str = str.concat(getKey().toString());
        // get the child
        Mass<String,Integer> child = getChild();
        // return string or call recursion
        return child != null ? 
        		child instanceof Text ? 
        				((Text) child).concat(str) 
        				: str 
        		: str;
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
		return getKey().charAt(index);
	}
	/* (non-Javadoc)
	 * @see java.lang.CharSequence#subSequence(int, int)
	 */
	@Override
	public CharSequence subSequence(int start, int end) {
		
		return this.substring(start, end);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#substring(int, int)
	 */
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
    /**
     * Returns a string builder that contains a substring of this string. 
     * The substring begins at the specified {@code beginIndex} and
     * extends to the character at index {@code endIndex - 1}.
     * Thus the length of the substring is {@code endIndex-beginIndex}.
     * <p>
     * Examples:
     * <blockquote><pre>
     * "hamburger".substring(4, 8) returns "urge"
     * "smiles".substring(1, 5) returns "mile"
     * </pre	></blockquote>
     *
     * @param      beginIndex   the beginning index, inclusive.
     * @param      endIndex     the ending index, exclusive.
     * @param	   builder		the builder
     * @return     the specified string builder containing the substring.
     * @exception  IndexOutOfBoundsException  if the
     *             {@code beginIndex} is negative, or
     *             {@code endIndex} is larger than the length of
     *             this {@code String} object, or
     *             {@code beginIndex} is larger than
     *             {@code endIndex}.
     */
	public StringBuilder substring(StringBuilder builder, int beginIndex, int endIndex) {
		
		if (beginIndex <= 0) {
            builder.append(getKey());
        }
		if (endIndex == 0) {
			return builder;
		}
        // get the child
		Mass<String,Integer> child = getChild();
        // return builder or call recursion
		return child != null ? 
				child instanceof Text ? 
						((Text) child).substring(builder, --beginIndex, --endIndex) 
						: builder 
				: builder;
	}

	/**
	 * @author joan
	 *
	 */
	protected class Hypermatrix 
		extends Grid {

		/**
		 * {@link Hypermatrix} default class constructor.
		 */
		public Hypermatrix() {
			
			super();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
		 */
		@Override
		public int reproduce(Mass<String,Integer> root, Mass<Integer,String> stem) {
			// compare value with key
			int cmp = root.compareTo(stem);
			// minimization operation
			if(cmp > 0) {
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
				Mass<String,Integer> pair = instance(
						getType(), getAntitype(), stem.getValue(), stem.getKey());
				// doubled paired output
				push(pair);
				return 0;
			}
			else {
				// assign key-value mapping pair
				output().setKey(root.getKey());
				output().setValue(root.getValue());
				return -1;
			}
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#push(org.xmlrobot.genesis.Mass)
		 */
		@Override
		public void push(Mass<String,Integer> child) {
		
			output().add(child);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Hypergenesis.Comparator#inject(java.lang.Object)
		 */
		@Override
		public void inject(Mass<Integer,String> child) {
			
			output().get().add(child);
		}
	}
}