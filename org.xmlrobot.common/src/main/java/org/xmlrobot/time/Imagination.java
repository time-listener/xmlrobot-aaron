/**
 * 
 */
package org.xmlrobot.time;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * There are times, when I find myself transfixed 
 * by a shadow on the wall, or the splashing of water 
 * against a stone. I stare at it, the hours pass, 
 * the world around me drops away, replaced by worlds 
 * being created and destroyed by my imagination. 
 * <p> A way to focus the mind.
 * @author Leonardo Da Vinci
 *
 */
@XmlTransient
public abstract class Imagination
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Caos<K,V> {

	/**
	 * 1206561669055048643L
	 */
	private static final long serialVersionUID = 1206561669055048643L;
	
    /**
     * {@link Imagination} default class constructor.
     */
    public Imagination() {
    	super();
    }
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    public Imagination(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    public Imagination(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    public Imagination(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	@Override
	public synchronized boolean add(K e) {
		// just bulk to the future
		if(order(e)) {
			e.get().push(Command.SUBMIT);
			return true;
		}
		else return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Coherence#clone()
	 */
	@Override
	public Imagination<K,V> clone() {
		
		Imagination<K,V> imagination = (Imagination<K,V>) super.clone();
		return imagination;
	}
}