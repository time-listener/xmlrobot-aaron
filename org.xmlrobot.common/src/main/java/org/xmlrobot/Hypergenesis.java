/**
 * 
 */
package org.xmlrobot;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.protocol.Hyperbody;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The original time-traveler message implementation class.
 * 
 * <p>Genesis (YY) > Religion (XY) | Love (XX)
 * 
 * <p>From key to value, from value to key. Key is the value 
 * and value is the time. From further to the hyperspace.
 * 
 * <p><tt>this</tt> class is just another member of the 
 * <tt>hyperspace congregation framework</tt>
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 1
 */
@XmlTransient
public abstract class Hypergenesis
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Random implements TimeListener<K,V> {

	/**
	 * -848745975071546893L
	 */
	private static final long serialVersionUID = -848745975071546893L;

	/**
	 * The time-traveler message.
	 */
	protected volatile Hyperbody<K,V> message;

 	/**
 	 * Wonderland.
 	 */
 	protected transient volatile TimeListener.Transmitter<K,V> matrix;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypergenesis#dna()
	 */
	@Override
	public TimeListener<K,V> dna() {

		return message.dna();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypergenesis#getGen()
	 */
	@Override
	@XmlElement
	public Parity getGen() {

		return message.getGen();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypergenesis#setGen(org.xmlrobot.util.Parity)
	 */
	@Override
	public void setGen(Parity value) {
		
		message.setGen(value);
	}
	/**
	 * {@link Hypergenesis} default class constructor.<br>
	 * To implement life, you MUST do the following assignments:<br>
	 * 1.- instance stem<br>
	 * 2.- set this key / stem value<br>
	 * 3.- set this type / stem antitype<br>
	 * 4.- set this value / stem key<br>
	 * 5.- set this antitype / stem type<br>
	 * 6.- set this parity / opposite parity<br>
	 */
	public Hypergenesis() {
		super();
		// instance dna
		message = new Hyperbody<K,V>(Parity.YY);
	}
	/**
	 * {@link Hypergenesis} class constructor.
     * @param gen {@link Parity} the inherited gender
	 */
	protected Hypergenesis(Class<? extends K> type, Parity gen) {
		super();
		// instance dna
		message = new Hyperbody<K,V>(type, type.cast(this), gen);
	}
	/**
	 * {@link Hypergenesis} class constructor.
     * @param gen {@link Parity} the inherited gender
	 */
	protected Hypergenesis(Class<? extends K> type, V value, Parity gen) {
		super();
		// instance dna
		message = new Hyperbody<K,V>(type, type.cast(this), value, gen);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		
		try {
			@SuppressWarnings("unchecked")
			Hypergenesis<K,V> key = (Hypergenesis<K,V>) super.clone();
			
			Class<? extends K> type;
			
			if((type = getType()) != null) {
				
				key.message = new Hyperbody<K,V>(type, type.cast(key), getGen());
				return key;
			}
			else return null;
		}
		catch (ClassCastException | CloneNotSupportedException e) {

			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>, Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> sender, Takion<Y,X> event) {
		// re-start period
		matrix = null;
		// declare child
		Y child;
		// check event compatibility
		if (event.getType().equals(getAntitype())) {
			
			matrix();
		}
		// retrieve child and check existence
		else if ((child = event.getChild()) != null) {
			// check genetic compatibility
			if (child.getType().equals(getAntitype())) {
				
				matrix(getAntitype().cast(event.output()));
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void echo(TimeListener<?,?> sender, Takion<X,Y> event) {

	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		message.run();
		// start listening time
		push(Command.LISTEN);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) {
		if(context == null)
			throw new Abort(this);
		//God-mode ON
		context.addServiceListener(this);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
		if(context == null)
			throw new Abort(this);
		// stop listening
		context.removeServiceListener(this);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypergenesis#matrix()
	 */
	@Override
	public abstract TimeListener.Transmitter<K,V> matrix();
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#matrix(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public abstract TimeListener.Transmitter<K,V> matrix(V output);
	
	/**
	 * Abstract hypergenesis comparator implementation class.
	 * <p> We want to make a Big Bang. So, we need an information transmitter
	 * to create the future mass that will compare the received masses.
	 * 
	 * <p>Basically, this abstract implementation, as its name suggests, just makes a comparison.
	 * 
	 * @author joan
	 *
	 * @param <K> is the key
	 * @param <V> is the value
	 */
	public abstract class Comparator
		implements TimeListener.Transmitter<K,V> {

		/**
		 * A digital frontier.
		 */
		transient volatile V output;
		
		/**
		 * {@link Comparator} default class constructor
		 */
		public Comparator() {
 			// instance output
			output = instance(getAntitype(), getType());
		}
		/**
		 * {@link Comparator} default class constructor
		 */
		public Comparator(V output) {
 			// instance output
			this.output = output;
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Reproductor#reproduce(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int reproduce(K key, V value) {
			// do compare
			return key.compareTo(value);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Message.Transmitter#output()
		 */
		@Override
		public V output() {
			// retrieve output
			return output;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Message.Transmitter#push(org.xmlrobot.genesis.Reproducible)
		 */
		@Override
		public abstract void push(K child);
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Message.Transmitter#inject(org.xmlrobot.genesis.Reproducible)
		 */
		@Override
		public abstract void inject(V child);
	}

	/**
	 * Check input object's existence.
	 * @param objects the objects to be checked
	 * @return <tt>true</tt> if all objects exists 
	 */
	protected static boolean exists(Object... objects) {
		
		for(Object obj : objects)
			if (obj == null)
				return false;
		return true;
	}
	/**
	 * {@link TimeListener} instantiation method #0.
	 * @param type the instantiated type
	 * @param parity {@link Parity} the gender
	 * @return the new X instance
	 */
	protected static <X> X instance(Class<X> type) {
		
		if (!exists(type))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor().newInstance();
		}
		catch(ClassCastException | 
				InstantiationException | 
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException | 
				NoSuchMethodException | 
			SecurityException e) {
			
			throw new Abort(e, null);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #1.
	 * @param type the instantiated type
	 * @param parity {@link Parity} the gender
	 * @return the new X instance
	 */
	protected static <X,Y> X instance(Class<X> type, Y arg) {
		
		if (!exists(type, arg))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor(arg.getClass()).
					newInstance(arg);
		}
		catch(ClassCastException | 
				InstantiationException | 
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException | 
				NoSuchMethodException | 
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #2.
	 * @param type the instantiated type
	 * @param parity {@link Parity} the gender
	 * @return the new X instance
	 */
	protected static <T,K,V> T instance(Class<T> type, K arg0, V arg1) {
		
		if (!exists(type, arg0, arg1))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor(
					arg0.getClass(), arg1.getClass()).
							newInstance(arg0, arg1);
		}
		catch(ClassCastException | 
				InstantiationException | 
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException | 
				NoSuchMethodException | 
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #3.
	 * @param type the instantiated type
	 * @param parity {@link Parity} the gender
	 * @return the new X instance
	 */
	protected static <T,U,K,V> T instance(Class<T> type, U arg0, K arg1, V arg2) {
		
		if (!exists(type, arg0, arg1, arg2))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor
					(arg0.getClass(), arg1.getClass(), arg2.getClass()).
									newInstance(arg0, arg1, arg2);
		}
		catch(ClassCastException |
				InstantiationException |
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException |
				NoSuchMethodException |
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
}