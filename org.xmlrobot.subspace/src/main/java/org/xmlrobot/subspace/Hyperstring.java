/**
 * 
 */
package org.xmlrobot.subspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Hypertext;
import org.xmlrobot.genesis.Plasma;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.EventHorizon;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.space.Space;
import org.xmlrobot.util.Abort;
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
 * @parity XY
 * @since 27
 */
@XmlTransient
public abstract class Hyperstring
	extends Space<Character,Integer>
		implements Plasma<Character,Integer>,
			Hypertext {

	/**
	 * 4765439639824940621L
	 */
	private static final long serialVersionUID = 4765439639824940621L;

	/**
	 * The mass implementation
	 */
	transient volatile Mass<Character,Integer> replicator;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Replicator#getPlasma()
	 */
	@Override
	public Mass<Character,Integer> getReplicator() {
		// return implemented mass
		return replicator;
	}
	
	/**
	 * {@link Hyperstring} default class constructor.
	 */
	public Hyperstring() {
		super();
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 */
	protected Hyperstring(
			Class<? extends Mass<Character,Integer>> matter, 
			Class<? extends Mass<Integer,Character>> antimatter, 
			Class<? extends Hyperstring> type) {
		super(type, Parity.XY);
		// instance mass
		replicator = instance(matter, antimatter);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	protected Hyperstring(
			Class<? extends Mass<Character,Integer>> matter, 
			Class<? extends Mass<Integer,Character>> antimatter, 
			Class<? extends Hyperstring> type,
			Character key, Integer value) {
		super(type, key, value, Parity.XY);
		// instance mass
		replicator = instance(matter, antimatter, key, value);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent the parent of inheritance
	 */
	protected Hyperstring(
			Class<? extends Mass<Character,Integer>> matter, 
			Class<? extends Mass<Integer,Character>> antimatter, 
			Class<? extends Hyperstring> type,
			Character key, Integer value, 
			Hyperstring parent) {
		super(type, key, value, parent);
		// instance mass
		replicator = instance(matter, antimatter, key, value, parent.getReplicator());
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperstring(
			Class<? extends Hyperstring> type, 
			Class<? extends Hyperinteger> antitype) {
		super(type, antitype, Parity.XY);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	protected Hyperstring(
			Class<? extends Hyperstring> type, 
			Class<? extends Hyperinteger> antitype, 
			Character key, Integer value) {
		super(type, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent the parent of inheritance
	 */
	protected Hyperstring(
			Class<? extends Hyperstring> type, 
			Class<? extends Hyperinteger> antitype, 
			Character key, Integer value, Hyperstring parent) {
		super(type, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Singularity#clone()
	 */
	@Override
	public Hyperstring clone() {
		
		try {
			Hyperstring string = (Hyperstring) super.clone();
			string.replicator = instance(replicator.getType(), replicator.getAntitype());
			return string;
		}
		catch(ClassCastException | Abort exception) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Hyperclock#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener,	Tachyon<Y,X> event) {
		
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
		void echo(TimeListener<?,?> listener, Tachyon<X,Y> event) {
		super.echo(listener, event);
		
		if(event.getSource() instanceof Hyperstring) {
			try {
				// listen time synchronously
				Thread.sleep(((Hypertext)event.getSource()).longValue());
			}
			catch(Exception ex) {
				// hum, we must see...
				push(Command.INTERRUPTED);
			}
		}
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

				replicator.push(Command.SUBMIT);
			} 
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator.push(Command.RELEASE);
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
			// hum, we must see...
			push(Command.INTERRUPTED);
		}
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.time.Time#set(org.xmlrobot.genesis.TimeListener)
 	 */
 	@Override
	public void set(Mass<Integer,Character> value) {
		super.set(value);
		// cast source
		Hyperinteger stem = (Hyperinteger) value;
		// set stem's plasma
		stem.replicator = replicator.get();
		// my plasma is listened by my root's plasma
		stem.replicator.setStem(replicator.getRoot());
		stem.replicator.setRoot(replicator.getStem());
		// listen plasma masses
		stem.replicator.addMassListener(this);
		replicator.addMassListener(stem);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public Mass.Transmuter<Character,Integer> matrix() {
		Mass.Transmuter<Character,Integer> m;
 		return (m = (Mass.Transmuter<Character,Integer>) matrix) != null ? 
 				m : (Mass.Transmuter<Character,Integer>) (matrix = new Hypermatrix());
	}
	/**
	 * @author joan
	 *
	 */
	protected class Hypermatrix 
		extends Comparator 
			implements Mass.Transmuter<Character,Integer> {

		/**
		 * {@link Hypermatrix} default class constructor.
		 */
		public Hypermatrix() {
			
			super();
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#reproduce(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int reproduce(Mass<Character,Integer> key, Mass<Integer,Character> value) {
			// compare value with key
			int cmp = super.reproduce(key, value);
			// minimization operation
			if(cmp > 0) {
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
		public void put(Character key, Integer value) {
			if(get() == null)
				super.set(instance(getAntitype(), getType(), value, key));
			else inject(instance(getType(), getAntitype(), key, value));
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#concat(java.lang.StringBuilder)
	 */
	public StringBuilder concat(StringBuilder o) {
		// do concatenation
		o.append(getKey());
        // return builder or call recursion
		return !isEmpty() ? ((Hypertext) getChild()).concat(o) : o ;
	}
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
		return call(index).getKey();
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
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Text#substring(java.lang.StringBuilder, int, int)
	 */
	public StringBuilder substring(StringBuilder builder, int beginIndex, int endIndex) {
		
		if (beginIndex <= 0) {
            builder.append(getKey());
        }
		if (endIndex == 0) {
			return builder;
		}
        // get the child
		Mass<Character,Integer> child = getChild();
        // return builder or call recursion
		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext) child).substring(builder, --beginIndex, --endIndex) 
						: builder 
				: builder;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#sum(java.lang.Integer)
	 */
	@Override
	public Integer sum(Integer o) {

		Mass<Character,Integer> child = getChild();
		
		o += getKey();

		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext) child).sum(o) 
						: o 
				: o;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#subtract(java.lang.Integer)
	 */
	@Override
	public Integer subtract(Integer o) {
		Mass<Character,Integer> child = getChild();
		
		o -= getKey();

		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext)child).subtract(o) 
						: o
				: o;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#multiply(java.lang.Integer)
	 */
	@Override
	public Integer multiply(Integer o) {
		Mass<Character,Integer> child = getChild();
		
		o *= getKey();

		return child != null ? 
				child instanceof Hypertext ? 
						((Hypertext)child).multiply(o) 
						: o 
				: o;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#divide(java.lang.Integer)
	 */
	@Override
	public Integer divide(Integer o) {

		Mass<Character,Integer> child = getChild();
		
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

		return getValue().intValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#longValue()
	 */
	@Override
	public long longValue() {

		return getValue().longValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#floatValue()
	 */
	@Override
	public float floatValue() {

		return getValue().floatValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Number#doubleValue()
	 */
	@Override
	public double doubleValue() {

		return getValue().doubleValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#getName()
	 */
	@Override
	@XmlElement
	public abstract String getName();
}