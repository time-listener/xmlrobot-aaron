/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.concurrent.TimeUnit;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlTransient
public abstract class Recursion
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Recurrence<K,V> {

	/**
	 * 6580955180470674793L
	 */
	private static final long serialVersionUID = 6580955180470674793L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#call()
	 */
	@Override
	public K call() {

		return dna().call();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#get()
	 */
	@Override
	public V get() {

		return dna().get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#get(long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public V get(long timeout, TimeUnit unit) {
		
		return dna().get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#set(java.lang.Object)
	 */
	@Override
	public void set(V value) {
		// listen antimatter
		addMassListener(value);
		// unify
		dna().set(value);
	}
	
  	/**
     * {@link Recursion} default class constructor.
     */
	public Recursion() {
    	super();
    }
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	public Recursion(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public Recursion(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
		// send masses to value
		addMassListener(value);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
	public Recursion(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		//call hyper-constructor
		this(type, instance(antitype), gen);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Recursion<K,V> clone() {
		
		Recurrence<K,V> recurrence = (Recurrence<K,V>) super.clone();
		return recurrence != null ? (Recursion<K,V>) recurrence : null;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(V o) {
		// call stem to make the sacred comparison
		return get().compare(get(), o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproductable#play(java.lang.Object)
	 */
	@Override
	public int reproduceTo(V o) {
	
		return get().matrix().reproduce(o, call());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#output()
	 */
	@Override
	public V output() {
	
		return get().matrix().output();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>, Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> sender, Takion<Y,X> event) {
		// call ancestral method
		super.pulse(sender, event);
		// declare child
		Y child;
		// check event compatibility
		if(event.getType().equals(getAntitype())) {
			/* 
			 * message transmission to wonderland through
			 * hypergenesis comparison computation. 
			 * */
			reproduceTo(getAntitype().cast(event.call()));
		}
		// retrieve child and check existence
		else if((child = event.getChild()) != null) {
			// check genetic compatibility
			if(child.getType().equals(getAntitype())) {
				// reproduce yourselves by doing sex now
				reproduceTo(getAntitype().cast(child));
			}
		}
		else throw new Abort(this); // something was wrong
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void echo(TimeListener<?,?> sender, Takion<X,Y> event) {
		// ancestral recall
		super.echo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public synchronized void start(BundleContext context) {
		super.start(context);
		// declare child of inheritance
		V future;
		// assign and check
		if ((future = get()) != null) {
			// make parent listen time
			future.start(context);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public synchronized void stop(BundleContext context) {
		super.stop(context);
		// declare child of inheritance
		V future;
		// assign and check
		if ((future = get()) != null) {
			// make parent listen time
			future.stop(context);
		}
	}
 	/**
	 * The Grid. A digital frontier. 
	 * <p>I tried to picture clusters of information as they moved through the computer. 
	 * What did they look like? Ships, motorcycles? Were the circuits like freeways? 
	 * I kept dreaming of a world I thought I'd never see. And then, one day I got in...
	 * <p>It does the {@link Future}. So, this class represents the abstract 
	 * implementation of the <tt>hypergenesis<K,V,> computation</tt>. 
	 * 
	 * @author Kevin Flynn
	 */
	protected abstract class Grid
		extends Comparator {
		
 		/**
 		 * {@link Grid} default class constructor
 		 */
 		public Grid() {
 			super();
 		}
 		/* (non-Javadoc)
 		 * @see org.xmlrobot.genesis.Hypergenesis.Comparator#compare(java.lang.Object, java.lang.Object)
 		 */
 		@Override
		public int reproduce(K key, V value) {
			// consecrate comparison and get computation result
			int cmp = super.reproduce(key, value);
			// switch comparison result by commuting by parity
			if (key.getGen().equals(Parity.XY) ? cmp < 0 : cmp > 0) {
				// send root to the future
				push(key);
				// declare stem's child
				V valueChild;
				// get and check existence
				if ((valueChild = value.getChild()) != null) {
					// send stem's child to the future
					inject(valueChild);
					// declare root child
					K keyChild;
					// get root's child
					if ((keyChild = key.getChild()) != null) {
						// call recursion and append result
						cmp += reproduce(keyChild.getChild(), valueChild.getChild());
					}
				}
				else {
					// declare root's child
					K keyChild;
					// get and check existence
					if ((keyChild = key.getChild()) != null) {
						// so, we fill the chain as much as possible.
						push(keyChild);
					}
				}
			}
			else if(cmp == 0) {
				// submit both messages
				push(key);
				inject(value);
				// call recursion and accumulate computation result
				cmp += reproduce(key.getChild(), value.getChild());
			}
			else {
				// send stem to the future
				inject(value);
				// declare root's child
				K keyChild;
				// get and check existence
				if ((keyChild = key.getChild()) != null) {
					// send root's child to the future
					push(keyChild);
					// declare stem's child
					V valueChild;
					// get and check existence
					if ((valueChild = value.getChild()) != null) {
						// call recursion and accumulate result
						cmp += reproduce(keyChild.getChild(), valueChild.getChild());
					}
				}
				else {
					V stemChild;
					// get and check existence
					if ((stemChild = value.getChild()) != null) {
						// so, evolve a little bit.
						inject(stemChild);
					}
				}
			}
			// return computation result
			return cmp;
		}
	}
}
