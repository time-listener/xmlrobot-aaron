/**
 * 
 */
package org.xmlrobot.time;

import java.util.concurrent.Future;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Past;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Parity;

/**
 * Abstract time implementation class.
 * All implementing instances will inherit time. The future 
 * is the last child of the inheritance (the last {@link Future} 
 * entity). And the first parent is the past (the first 
 * {@link Past} entity).
 * <br><br> 
 * All entities will live in a natural order hierarchy. IE, 
 * the class hierarchy of always that is always changing. 
 * <br><br>
 * Hyperspace Navigation.
 * <br>
 * AN EXPANSIVE HISTORY OF TIME.
 * <br>
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @since before BigBang
 */
@XmlTransient
public abstract class Time
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Inheritance<K,V> {

    /**
	 * -1901517319441053527L
	 */
	private static final long serialVersionUID = -1901517319441053527L;
	
	/**
     * {@link Time} default class constructor.
     */
    public Time() {
    	super();
    }
	/**
     * {@link Time} class constructor.
	 * @param type the type
     * @param parent the parent of inheritance
	 */
	public Time(Class<? extends K> type, K parent) {
		super(type, parent.getGen());
		// inherit parent
		setParent(parent);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	public Time(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param parent the parent of inheritance
	 * @param value the value
	 */
	public Time(Class<? extends K> type, V value, K parent) {
		super(type, value, parent);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
	public Time(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
     * {@link Time} class constructor.
	 * @param type the type
	 * @param antitype the antitype
     * @param parent the parent of inheritance
	 */
	public Time(Class<? extends K> type, Class<? extends V> antitype, K parent) {
		super(type, antitype, parent);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
	public Time(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Metaphysical#clone()
	 */
	@Override
	public Time<K,V> clone() {
		try {
			Time<K,V> metaphysical = (Time<K,V>) super.clone();			
			return metaphysical;
		}
		catch(ClassCastException | NullPointerException unused) {
			
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> sender, Takion<Y,X> event) {
		// send pulse to the FUTURE
		super.pulse(sender, event);
		// rotate-revolve dna-chain
		event.spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.util.Love#echo(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void echo(TimeListener<?,?> sender, Takion<X,Y> event) {
		// send echo to the PAST
		super.echo(sender, event);
	}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public abstract int compare(K o1, K o2);
}