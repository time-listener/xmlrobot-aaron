/**
 * 
 */
package org.xmlrobot.time;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * Mataphysical layer class.
 * 
 * <p> Programmatic philosophy, or maybe, the physics of ideas.
 * 
 * <p> Metaphysics is a programmatic philosophy that examines the 
 * nature of reality including relationships between the mind and 
 * matter. It can also deal with onirics programming.
 * 
 * <p> When one's imagination cannot provide an answer, one must seek 
 * out a greater imagination. There are times when even I find myself 
 * kneeling in prayer. 
 * 
 * @author joan
 *
 */
@XmlTransient
public abstract class Metaphysical
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Further<K,V> {
	
	/**
	 * -6819264682037012460L
	 */
	private static final long serialVersionUID = -6819264682037012460L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getFuture()
	 */
	@Override
	public K getFuture() {
		K child = getChild();
		return child != null ? child.getFuture() : getType().cast(this);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getPast()
	 */
	@Override
	public K getPast() {
		K parent = getParent();
		return parent != null ? parent.getPast() : getType().cast(this);
	}
	
    /**
     * {@link Metaphysical} default class constructor.
     */
    public Metaphysical() {
    	super();
    }
	/**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    public Metaphysical(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    public Metaphysical(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
	public Metaphysical(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Further#clone()
	 */
	@Override
	public Metaphysical<K,V> clone() {
	
		Metaphysical<K,V> metaphysical = (Metaphysical<K,V>) super.clone();
		
		metaphysical.setChild(null);
		metaphysical.setParent(null);
		
		return metaphysical;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submit(org.xmlrobot.genesis.Pair)
	 */
	public synchronized boolean submit(K listener) {
		// verify listener's existence
		if(listener == null)
			return false;
		// declare child
		K child;
		// verify child's existence
		if((child = getChild()) != null) {
			// disconnect child from parent. I.e, from current instance.
			child.setParent(null);
			setChild(null);
			// commute by parity
			switch (getGen()) 
			{
			case XY:
				// set listener as new future
				child = child.submitChild(listener);			
				break;
			default:
				// set listener as new past
				child = child.submitParent(listener);
				break;
			}
			// re-assign inheritance
			setChild(child);
			child.setParent(getType().cast(this));
		}
		else {
			// submit listener as new child
			setChild(listener);
			listener.setParent(getType().cast(this));
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderChild(java.lang.Object)
	 */
	public synchronized K submitChild(K listener) {
		// declare child
		K child;
		// re-assign and check child
		if((child = getChild()) == null) {
			// update inheritance
			listener.setParent(call());
			setChild(listener);
			// return the current parent of inheritance
			return getPast();	
		}
		// call recursion
		else return child.submitChild(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#orderParent(org.xmlrobot.genesis.TimeListener)
	 */
	public synchronized K submitParent(K listener) {
		// declare parent of inheritance
		K parent;
		// re-assign and check parent
		if((parent = getParent()) != null) {
			// set inheritance
			parent.setChild(listener);
			listener.setParent(parent);
		}
		// update inheritance
		setParent(listener);
		listener.setChild(getType().cast(this));
		// return the current parent
		return getPast();
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Congregation#submitAll(java.lang.Object)
     */
    public boolean submitAll(K c) {
    	boolean modified = false;
        for (K e : c)
        	if(submit(e))
        		modified = true;
        return modified;
    }
}