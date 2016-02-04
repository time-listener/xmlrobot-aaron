/**
 * 
 */
package org.xmlrobot.space;

import java.util.AbstractCollection;
import java.util.AbstractSet;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.protocol.Hypermass;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Parity;

/**
 * Spacetime singularity implementation class.
 * <br><br>
 * This class creates the massive message.
 * <br><br>
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 */
@XmlTransient
public abstract class Singularity<K,V> 
	extends Time<Mass<K,V>,Mass<V,K>>
		implements Mass<K,V> {

	/**
	 * -239201139092107139L
	 */
	private static final long serialVersionUID = -239201139092107139L;

	volatile Hypermass<K,V> mass;
	
	/**
	 * {@link Singularity} default class constructor.
	 */
	public Singularity() {
	
		super();
		// create message listener
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
     * {@link Singularity} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
    protected Singularity(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parity {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, parent);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, gen);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, Mass<K,V> parent) {
		super(type, stem, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, Parity gen) {
		super(type, stem, gen);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, K key, V value, Mass<K,V> parent) {
		super(type, stem, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, K key, V value, Parity gen) {
		super(type, stem, gen);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, parent);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		super(type, gen);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Unification#dna()
	 */
	@Override
	public Hypermass<K,V> dna() {

		return mass;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Replicator#plasm()
	 */
	@Override
	public Mass<K,V> replicator() {
		
		return this;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Singularity<K,V> clone() {
	
		Singularity<K,V> hyperspace = (Singularity<K,V>) super.clone();
		
		hyperspace.setKey(null);
		hyperspace.setValue(null);
		
		return hyperspace;
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.time.Logic#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (!(o instanceof Mass))
            return false;
        Mass<?,?> e = (Mass<?,?>)o;
        return equality(getKey(), e.getKey()) && equality(getValue(), e.getValue());
    }

    /**
     * Returns the hash code value for this map entry.  The hash code
     * of a map entry {@code e} is defined to be: <pre>
     *   (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
     *   (e.getValue()==null ? 0 : e.getValue().hashCode())</pre>
     * This ensures that {@code e1.equals(e2)} implies that
     * {@code e1.hashCode()==e2.hashCode()} for any two Entries
     * {@code e1} and {@code e2}, as required by the general
     * contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this map entry
     * @see    #equals
     */
    public int hashCode() {
    	return super.hashCode();
//        return (getKey()   == null ? 0 : getKey().hashCode()) ^
//               (getValue() == null ? 0 : getValue().hashCode());
    }
    /**
     * Each of these fields are initialized to contain an instance of the
     * appropriate view the first time this view is requested.  The views are
     * stateless, so there's no reason to create more than one of each.
     */
    transient volatile Congregation<K> keyView;
    transient volatile Congregation<V> valueView;
    
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation returns a set that subclasses {@link AbstractSet}.
     * The subclass's iterator method returns a "wrapper object" over this
     * map's <tt>entrySet()</tt> iterator.  The <tt>size</tt> method
     * delegates to this map's <tt>size</tt> method and the
     * <tt>contains</tt> method delegates to this map's
     * <tt>containsKey</tt> method.
     *
     * <p>The set is created the first time this method is called,
     * and returned in response to all subsequent calls.  No synchronization
     * is performed, so there is a slight chance that multiple calls to this
     * method will not all return the same set.
     */
    public Congregation<K> keyView() {
    	
        return keyView;
    }
    /**
     * {@inheritDoc}
     *
     * @implSpec
     * This implementation returns a collection that subclasses {@link
     * AbstractCollection}.  The subclass's iterator method returns a
     * "wrapper object" over this map's <tt>entrySet()</tt> iterator.
     * The <tt>size</tt> method delegates to this map's <tt>size</tt>
     * method and the <tt>contains</tt> method delegates to this map's
     * <tt>containsValue</tt> method.
     *
     * <p>The collection is created the first time this method is called, and
     * returned in response to all subsequent calls.  No synchronization is
     * performed, so there is a slight chance that multiple calls to this
     * method will not all return the same collection.
     */
    public Congregation<V> valueView() {
    	
        return valueView;
    }

}