/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.xmlrobot.protocol.Hypermass;

/**
 * 
 * Massive message implementation interface.
 * 
 * <p>Everyone in the <tt>hyperspace</tt> implements the <tt>mass</tt>. 
 * For example, me. So, any process can call magically to it's methods.
 * 
 * <p>The root interface in the <i>mass hierarchy</i>.  The <tt>Mass</tt> 
 * interface provides two <i>congregation views</i>, which allow a Mass's 
 * contents to be viewed as a congregation of keys, congregation of values. 
 * The <i>order</i> of a Mass is defined as the order in which the iterators 
 * on the Mass's congregation views return their elements. All Mass 
 * implementations, like the <tt>Screw</tt> class do not make specific 
 * guarantees as to their order. The <tt>stem</tt> is who orders the 
 * inheritance.
 *
 * <p>All general-purpose <tt>Mass</tt> implementation classes (which
 * typically implement <tt>Mass</tt> indirectly through one of its
 * subclasses) should provide many "standard" constructors: a void (no
 * arguments) constructor, which creates an empty Mass with YY parity, 
 * and a constructor with a single argument of type <tt>Parity</tt>, which
 * creates a new Mass with the same parity as its arguments, for example.
 *
 * <p>Some Mass implementations have restrictions on the keys and values they
 * may contain.  For example, some implementations prohibit null keys and
 * values, and some have restrictions on the types of their keys.  Attempting
 * to insert an ineligible key or value throws an unchecked exception,
 * typically <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.
 * Attempting to query the presence of an ineligible key or value may throw an
 * exception, or it may simply return false; some implementations will exhibit
 * the former behavior and some will exhibit the latter.  More generally,
 * attempting an operation on an ineligible key or value whose completion
 * would not result in the insertion of an ineligible element into the Mass may
 * throw an <tt>Abort</tt> or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "imposed" in the specification for this
 * interface.
 *
 * <p>Many methods in {@code hyperspace congregation framework} interfaces are 
 * defined in terms of the {@link Object#equals(Object) equals} method.  For
 * example, the specification for the {@link #containsKey(Object)
 * containsKey(Object key)} method says: "returns <tt>true</tt> if and
 * only if this Mass contains a mapping for a key <tt>k</tt> such that
 * <tt>(key==null ? k==null : key.equals(k))</tt>." This specification should
 * <i>not</i> be construed to imply that invoking <tt>Mass.containsKey</tt>
 * with a non-null argument <tt>key</tt> will cause <tt>key.equals(k)</tt> to
 * be invoked for any key <tt>k</tt>.  Implementations are free to
 * implement optimizations whereby the <tt>equals</tt> invocation is avoided,
 * for example, by first comparing the hash codes of the two keys.  (The
 * {@link Object#hashCode()} specification guarantees that two objects with
 * unequal hash codes cannot be equal.)  More generally, implementations of
 * the various Collections Framework interfaces are free to take advantage of
 * the specified behavior of underlying {@link Object} methods wherever the
 * implementor deems it appropriate.
 * 
 * <p>This interface is a member of the <tt>hyperspace congregation framework</tt>.
 * @author joan
 * 
 * @parity YY
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @see TimeListener
 * @see Pair
 * 
 */
public interface Mass<K,V>
	extends TimeListener<Mass<K,V>,Mass<V,K>>, 
		Pair<K,V,Mass<K,V>>, Plasma<K,V>  {

	/**
	 * The key.
	 */
	public static final String KEY = "time-listener.key";
	
	/**
	 * The value.
	 */
	public static final String VALUE = "time-listener.value";
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#clone()
	 */
	@Override
	Mass<K,V> clone();
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#dna()
	 */
	public Hypermass<K,V> dna();
	
	/**
     * Returns the key corresponding to this time-listener.
     * @return the key corresponding to this time-listener
     * @throws IllegalStateException implementations may, but are not
     * required to, throw this exception if the time-listener has been
     * removed from the backing map.
     */
    K getKey();
    
    /**
     * Replaces the key corresponding to this time-listener
     * with the specified key (optional operation).  (Writes through 
     * to the map.)  The behavior of this call is undefined if the mapping 
     * has already been removed from the map (by the iterator's 
     * <tt>remove</tt> operation).
     *
     * @param key new key to be stored in this time-listener
     * @return old key corresponding to the time-listener
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing map
     * @throws ClassCastException if the class of the specified key
     *         prevents it from being stored in the backing map
     * @throws NullPointerException if the backing map does not permit
     *         null values, and the specified key is null
     * @throws IllegalArgumentException if some property of this key
     *         prevents it from being stored in the backing map
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the time-listener has been
     *         removed from the backing map.
     */
    K setKey(K key);
    
    /**
     * Returns the value corresponding to this time-listener.  If the mapping
     * has been removed from the backing map (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     *
     * @return the value corresponding to this time-listener
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the time-listener has been
     *         removed from the backing map.
     */
    V getValue();

    /**
     * Replaces the value corresponding to this time-listener with the specified
     * value (optional operation).  (Writes through to the map.)  The
     * behavior of this call is undefined if the mapping has already been
     * removed from the map (by the iterator's <tt>remove</tt> operation).
     *
     * @param value new value to be stored in this time-listener
     * @return old value corresponding to the time-listener
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing map
     * @throws ClassCastException if the class of the specified value
     *         prevents it from being stored in the backing map
     * @throws NullPointerException if the backing map does not permit
     *         null values, and the specified value is null
     * @throws IllegalArgumentException if some property of this value
     *         prevents it from being stored in the backing map
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the time-listener has been
     *         removed from the backing map.
     */
    V setValue(V value);

    /**
     * Compares the specified object with this time-listener for equality.
     * Returns <tt>true</tt> if the given object is also a time-listener and
     * the two entries represent the same mapping.  More formally, two
     * entries <tt>e1</tt> and <tt>e2</tt> represent the same mapping
     * if<pre>
     *     (e1.getKey()==null ?
     *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
     *     (e1.getValue()==null ?
     *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
     * </pre>
     * This ensures that the <tt>equals</tt> method works properly across
     * different implementations of the <tt>TimeListener</tt> interface.
     *
     * @param o object to be compared for equality with this time-listener
     * @return <tt>true</tt> if the specified object is equal to this time-listener
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this time-listener.  The hash code
     * of a time-listener <tt>e</tt> is defined to be: <pre>
     *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
     *     (e.getValue()==null ? 0 : e.getValue().hashCode())
     * </pre>
     * This ensures that <tt>e1.equals(e2)</tt> implies that
     * <tt>e1.hashCode()==e2.hashCode()</tt> for any two TimeListeners
     * <tt>e1</tt> and <tt>e2</tt>, as required by the general
     * contract of <tt>Object.hashCode</tt>.
     *
     * @return the hash code value for this time-listener
     * @see Object#hashCode()
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();
	
	/**
	 * Gets the entity's keys.
	 * @param output {@link Collection} of K
	 * @return the {@link Collection}
	 */
	Congregation<K> collectKeys(Congregation<K> output);
	
    /**
	 * Gets the entity's values.
	 * @param output {@link Set} of V
	 * @return the {@link Set}
	 */
	Congregation<V> collectValues(Congregation<V> output);
	
	/**
	 * Inquires the inheritance for matching an element.
	 * Return null if entity hasn't been found.
	 * @param key the key of the process that you're looking for.
	 */
	Mass<K,V> call(K key);
	
	/**
	 * Inquires the inheritance for matching an element.
	 * Return null if entity hasn't been found.
	 * @param value the key of the process that you're looking for.
	 */
	Mass<V,K> callReversed(V value);
	  
    /**
     * Returns <tt>true</tt> if this time-listener contains a mapping for the specified
     * key.  More formally, returns <tt>true</tt> if and only if
     * this time-listener contains a mapping for a key <tt>k</tt> such that
     * <tt>(key==null ? k==null : key.equals(k))</tt>.  (There can be
     * at most one such mapping.)
     * 
     * @param key key whose presence in this time-listener is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified key
     * @throws ClassCastException if the key is of an inappropriate type for this map
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this map does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsKey(K key);
    
    /**
     * Returns <tt>true</tt> if this time-listener maps one or more keys to the
     * specified value.  More formally, returns <tt>true</tt> if and only if
     * this time-listener contains at least one mapping to a value <tt>n</tt> such that
     * <tt>(value==null ? n==null : value.equals(n))</tt>.  This operation
     * will probably require time linear in the time-listener depth for most
     * implementations of the <tt>TimeListener</tt> interface.
     *
     * @param value value whose presence in this time-listener is to be tested
     * @return <tt>true</tt> if this time-listener maps one or more keys to the specified value
     * @throws ClassCastException if the value is of an inappropriate type for this map
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this time-listener does not permit null values
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsValue(V value);
    
	 // Poles
    /**
     * Returns a {@link Congregation} view of the values contained in this time-listener.
     * The congregation is backed by the time-listener, so changes to the time-listener are
     * reflected in the congregation, and vice-versa.  If the time-listener is
     * modified while an iteration over the congregation is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The congregation
     * supports element removal, which removes the corresponding
     * mapping from the time-listener, via the <tt>Iterator.remove</tt>,
     * <tt>Congregation.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a congregation view of the values contained in this time-listener
     */
	Congregation<K> keyView();
	
    /**
     * Returns a {@link Congregation} view of the values contained in this time-listener.
     * The congregation is backed by the time-listener, so changes to the time-listener are
     * reflected in the congregation, and vice-versa.  If the time-listener is
     * modified while an iteration over the congregation is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The congregation
     * supports element removal, which removes the corresponding
     * mapping from the time-listener, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a congregation view of the values contained in this time-listener
     */
	Congregation<V> valueView();
	
    // Modification Operations
    /**
     * Associates the specified value with the specified key in this time-listener
     * (optional operation).  If the time-listener previously contained a mapping for
     * the key, the old value is replaced by the specified value.  (A time-listener
     * <tt>a</tt> is said to contain a mapping for a key <tt>k</tt> if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * <tt>true</tt>.)
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the time-listener
     *         previously associated <tt>null</tt> with <tt>key</tt>,
     *         if the implementation supports <tt>null</tt> values.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this time-listener
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this time-listener
     * @throws NullPointerException if the specified key or value is null
     *         and this time-listener does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this time-listener
     */
    V putValue(K key, V value);
    
    /**
     * Associates the specified value with the specified key in this time-listener
     * (optional operation).  If the time-listener previously contained a mapping for
     * the key, the old value is replaced by the specified value.  (A time-listener
     * <tt>a</tt> is said to contain a mapping for a key <tt>k</tt> if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * <tt>true</tt>.)
     *
     * @param value key with which the specified value is to be associated
     * @param key value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the time-listener
     *         previously associated <tt>null</tt> with <tt>key</tt>,
     *         if the implementation supports <tt>null</tt> values.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this time-listener
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this time-listener
     * @throws NullPointerException if the specified key or value is null
     *         and this time-listener does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this time-listener
     */
    K putKey(V value, K key);
    
    // Bulk Operations
    /**
     * Copies all of the mappings from the specified time-listener to this time-listener
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #putValue(Object,Object) put(k, v)} on this time-listener once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified time-listener.  The behavior of this operation is undefined if the
     * specified time-listener is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this time-listener
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this time-listener
     * @throws ClassCastException if the class of a key or value in the
     *         specified time-listener prevents it from being stored in this time-listener
     * @throws NullPointerException if the specified time-listener is null, or if
     *         this time-listener does not permit null keys or values, and the
     *         specified time-listener contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified time-listener prevents it from being stored in this time-listener
     */
    void putAllValues(Mass<? extends K,? extends V> m);
    
    /**
     * Copies all of the mappings from the specified time-listener to this time-listener
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #putValue(Object,Object) put(k, v)} on this time-listener once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified time-listener.  The behavior of this operation is undefined if the
     * specified time-listener is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this time-listener
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this time-listener
     * @throws ClassCastException if the class of a key or value in the
     *         specified time-listener prevents it from being stored in this time-listener
     * @throws NullPointerException if the specified time-listener is null, or if
     *         this time-listener does not permit null keys or values, and the
     *         specified time-listener contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified time-listener prevents it from being stored in this time-listener
     */
    void putAllKeys(Mass<? extends V,? extends K> m);
    
    /**
     * If the specified key is not already associated with a value (or is mapped
     * to {@code null}) associates it with the given value and returns
     * {@code null}, else returns the current value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code
     * time-listener}:
     *
     * <pre> {@code
     * V v = time-listener.getValue(key);
     * if (v == null)
     *     v = time-listener.putValue(key, value);
     *
     * return v;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no mapping for the key.
     *         (A {@code null} return can also indicate that the time-listener
     *         previously associated {@code null} with the key,
     *         if the implementation supports null values.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the key or value is of an inappropriate
     *         type for this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key or value is null,
     *         and this time-listener does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V putValueIfAbsent(K key, V value);
    
    /**
     * If the specified value is not already associated with a key (or is mapped
     * to {@code null}) associates it with the given key and returns
     * {@code null}, else returns the current key.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code
     * time-listener}:
     *
     * <pre> {@code
     * K k = time-listener.getKey(value);
     * if (k == null)
     *     k = time-listener.putKey(value, key);
     *
     * return k;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param value value with which the specified key is to be associated
     * @param key key to be associated with the specified value
     * @return the previous key associated with the specified value, or
     *         {@code null} if there was no mapping for the value.
     *         (A {@code null} return can also indicate that the time-listener
     *         previously associated {@code null} with the value,
     *         if the implementation supports null values.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the value or key is of an inappropriate
     *         type for this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value or key is null,
     *         and this time-listener does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of the specified value
     *         or key prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    K putKeyIfAbsent(V value, K key) ;
  
    /**
     * Removes the mapping for a key from this time-listener if it is present
     * (optional operation). More formally, if this time-listener contains a mapping
     * from key <tt>p</tt> to value <tt>n</tt> such that
     * <code>(key==null ?  k==null : key.equals(k))</code>, that mapping
     * is removed.  (The time-listener can contain at most one such mapping.)
     *
     * <p>Returns the key to which this time-listener previously associated the key,
     * or <tt>null</tt> if the time-listener contained no mapping for the key.
     *
     * <p>If this time-listener permits null values, then a return key of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the time-listener
     * contained no mapping for the key; it's also possible that the time-listener
     * explicitly mapped the key to <tt>null</tt>.
     *
     * <p>The time-listener will not contain a mapping for the specified key once the
     * call returns.
     *
     * @param key key whose mapping is to be removed from the time-listener
     * @return the previous key associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this time-listener
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this time-listener
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this
     *         time-listener does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    Mass<K,V> removeByKey(K key);
    
    /**
     * Removes the mapping for a value from this time-listener if it is present
     * (optional operation). More formally, if this time-listener contains a mapping
     * from value <tt>p</tt> to value <tt>n</tt> such that
     * <code>(value==null ?  k==null : value.equals(k))</code>, that mapping
     * is removed.  (The time-listener can contain at most one such mapping.)
     *
     * <p>Returns the value to which this time-listener previously associated the value,
     * or <tt>null</tt> if the time-listener contained no mapping for the value.
     *
     * <p>If this time-listener permits null values, then a return value of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the time-listener
     * contained no mapping for the value; it's also possible that the time-listener
     * explicitly mapped the value to <tt>null</tt>.
     *
     * <p>The time-listener will not contain a mapping for the specified value once the
     * call returns.
     *
     * @param value value whose mapping is to be removed from the time-listener
     * @return the previous value associated with <tt>value</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>value</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this time-listener
     * @throws ClassCastException if the value is of an inappropriate type for
     *         this time-listener
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this
     *         time-listener does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    Mass<V,K> removeByValue(V value);
    
    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this time-listener contains no mapping for the key.
     *
     * <p>More formally, if this time-listener contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>If this time-listener permits null values, then a return value of
     * {@code null} does not <i>necessarily</i> indicate that the time-listener
     * contains no mapping for the key; it's also possible that the time-listener
     * explicitly maps the key to {@code null}.  The {@link #containsKey
     * containsKey} operation may be used to distinguish these two cases.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this time-listener contains no mapping for the key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this time-listener
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this map
     *         does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    V getValue(K key);
    
    /**
     * Returns the key to which the specified value is mapped,
     * or {@code null} if this time-listener contains no mapping for the value.
     *
     * <p>More formally, if this time-listener contains a mapping from a value
     * {@code k} to a key {@code v} such that {@code (value==null ? k==null :
     * value.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>If this time-listener permits null keys, then a return key of
     * {@code null} does not <i>necessarily</i> indicate that the time-listener
     * contains no mapping for the value; it's also possible that the time-listener
     * explicitly maps the value to {@code null}.  The {@link #containsKey
     * containsKey} operation may be used to distinguish these two cases.
     *
     * @param value the value whose associated key is to be returned
     * @return the key to which the specified value is mapped, or
     *         {@code null} if this time-listener contains no mapping for the value
     * @throws ClassCastException if the value is of an inappropriate type for
     *         this time-listener
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this map
     *         does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    K getKey(V value);
    
    /**
     * Returns the value to which the specified key is mapped, or
     * {@code defaultNegative} if this time-listener contains no mapping for the key.
     *
     * @implSpec
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key the key whose associated value is to be returned
     * @param defaultValue the default mapping of the key
     * @return the value to which the specified key is mapped, or
     * {@code defaultNegative} if this time-listener contains no mapping for the key
     * @throws ClassCastException if the key is of an inappropriate type for
     * this time-listener
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this time-listener
     * does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V getValueOrDefault(K key, V defaultValue);
    
    /**
     * Returns the key to which the specified value is mapped, or
     * {@code defaultkey} if this time-listener contains no mapping for the value.
     *
     * @implSpec
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param value the value whose associated key is to be returned
     * @param defaultKey the default mapping of the value
     * @return the key to which the specified value is mapped, or
     * {@code defaultkey} if this time-listener contains no mapping for the value
     * @throws ClassCastException if the value is of an inappropriate type for
     * this time-listener
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this time-listener
     * does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    K getKeyOrDefault(V value, K defaultKey);
    
    /**
     * Performs the given action for each time-listener in this time-listener until all time-listeners
     * have been processed or the action throws an exception.   Unless
     * otherwise specified by the implementing class, actions are performed in
     * the order of time-listener set iteration (if an iteration order is specified.)
     * Exceptions thrown by the action are relayed to the caller.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     * <pre> {@code
     * for (time-listener.time-listener<K, V> time-listener : time-listener.entrySet())
     *     action.accept(time-listener.getKey(), time-listener.getValue());
     * }</pre>
     *
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param action The action to be performed for each time-listener
     * @throws NullPointerException if the specified action is null
     * @throws ConcurrentModificationException if an time-listener is found to be
     * removed during iteration
     * @since 1.8
     */
    void forEachKey(BiConsumer<? super K, ? super V> action);
    
    /**
     * Performs the given action for each time-listener in this time-listener until all time-listeners
     * have been processed or the action throws an exception.   Unless
     * otherwise specified by the implementing class, actions are performed in
     * the order of time-listener set iteration (if an iteration order is specified.)
     * Exceptions thrown by the action are relayed to the caller.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     * <pre> {@code
     * for (time-listener<K, V> time-listener : time-listener)
     *     action.accept(time-listener.getKey(), time-listener.getValue());
     * }</pre>
     *
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param action The action to be performed for each time-listener
     * @throws NullPointerException if the specified action is null
     * @throws ConcurrentModificationException if an time-listener is found to be
     * removed during iteration
     * @since 1.8
     */
    void forEachValue(BiConsumer<? super V, ? super K> action);
    
    /**
     * Replaces each time-listener's values with the result of invoking the given
     * function on that time-listener until all entries have been processed or the
     * function throws an exception.  Exceptions thrown by the function are
     * relayed to the caller.
     *
     * @implSpec
     * <p>The default implementation is equivalent to, for this {@code time-listener}:
     * <pre> {@code
     * for (time-listener<K, V> time-listener : time-listener)
     *     time-listener.setValue(function.apply(time-listener.getKey(), time-listener.getValue()));
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param function the function to apply to each time-listener
     * @throws UnsupportedOperationException if the {@code set} operation
     * is not supported by this time-listener's time-listener set iterator.
     * @throws ClassCastException if the class of a replacement value
     * prevents it from being stored in this time-listener
     * @throws NullPointerException if the specified function is null, or the
     * specified replacement value is null, and this time-listener does not permit null
     * values
     * @throws ClassCastException if a replacement value is of an inappropriate
     *         type for this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if function or a replacement value is null,
     *         and this time-listener does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a replacement value
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ConcurrentModificationException if an time-listener is found to be
     * removed during iteration
     * @since 1.8
     */
    void replaceAllValues(BiFunction<? super K, ? super V, ? extends V> function);
    
    /**
     * Replaces each time-listener's key with the result of invoking the given
     * function on that time-listener until all entries have been processed or the
     * function throws an exception.  Exceptions thrown by the function are
     * relayed to the caller.
     *
     * @implSpec
     * <p>The default implementation is equivalent to, for this {@code time-listener}:
     * <pre> {@code
     * for (time-listener<K, V> time-listener : time-listener)
     *     time-listener.setValue(function.apply(time-listener.getKey(), time-listener.getValue()));
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param function the function to apply to each time-listener
     * @throws UnsupportedOperationException if the {@code set} operation
     * is not supported by this time-listener's time-listener set iterator.
     * @throws ClassCastException if the class of a replacement key
     * prevents it from being stored in this time-listener
     * @throws NullPointerException if the specified function is null, or the
     * specified replacement key is null, and this time-listener does not permit null
     * keys
     * @throws ClassCastException if a replacement key is of an inappropriate
     *         type for this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if function or a replacement key is null,
     *         and this time-listener does not permit null keys or keys
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a replacement key
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ConcurrentModificationException if an time-listener is found to be
     * removed during iteration
     * @since 1.8
     */
    void replaceAllKeys(BiFunction<? super V, ? super K, ? extends K> function);

    /**
     * Removes the time-listener for the specified key only if it is currently
     * mapped to the specified value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     *
     * <pre> {@code
     * if (time-listener.containsKey(key) && Objects.equals(time-listener.getValue(key), value)) {
     *     time-listener.removeByKey(key);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key key with which the specified value is associated
     * @param value value expected to be associated with the specified key
     * @return {@code true} if the value was removed
     * @throws UnsupportedOperationException if the {@code remove} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the key or value is of an inappropriate
     *         type for this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key or value is null,
     *         and this time-listener does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    boolean removeByKey(K key, V value);
    
    /**
     * Removes the time-listener for the specified value only if it is currently
     * mapped to the specified key.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     *
     * <pre> {@code
     * if (time-listener.containsKey(value) && Objects.equals(time-listener.getKey(value), key)) {
     *     time-listener.removeByValue(value);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param value value with which the specified key is associated
     * @param key key expected to be associated with the specified value
     * @return {@code true} if the key was removed
     * @throws UnsupportedOperationException if the {@code remove} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the value or key is of an inappropriate
     *         type for this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value or key is null,
     *         and this time-listener does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    boolean removeByValue(V value, K key);
    
    /**
     * Replaces the time-listener for the specified key only if currently
     * mapped to the specified value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     *
     * <pre> {@code
     * if (time-listener.containsKey(key) && Objects.equals(time-listener.getValue(key), value)) {
     *     time-listener.putValue(key, newValue);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * The default implementation does not throw NullPointerException
     * for time-listener that do not support null values if oldValue is null unless
     * newValue is also null.
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key key with which the specified value is associated
     * @param oldValue value expected to be associated with the specified key
     * @param newValue value to be associated with the specified key
     * @return {@code true} if the value was replaced
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of a specified key or value
     *         prevents it from being stored in this time-listener
     * @throws NullPointerException if a specified key or newValue is null,
     *         and this time-listener does not permit null keys or values
     * @throws NullPointerException if oldValue is null and this time-listener does not
     *         permit null values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a specified key
     *         or value prevents it from being stored in this time-listener
     * @since 1.8
     */
    boolean replaceValue(K key, V oldValue, V newValue);

    /**
     * Replaces the time-listener for the specified value only if currently
     * mapped to the specified key.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     *
     * <pre> {@code
     * if (time-listener.containsKey(value) && Objects.equals(time-listener.getKey(value), key)) {
     *     time-listener.putKey(value, newKey);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * The default implementation does not throw NullPointerException
     * for time-listener that do not support null values if oldValue is null unless
     * newValue is also null.
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param value value with which the specified key is associated
     * @param oldKey key expected to be associated with the specified value
     * @param newKey key to be associated with the specified value
     * @return {@code true} if the key was replaced
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of a specified value or key
     *         prevents it from being stored in this time-listener
     * @throws NullPointerException if a specified value or newValue is null,
     *         and this time-listener does not permit null keys or values
     * @throws NullPointerException if oldValue is null and this time-listener does not
     *         permit null values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a specified value
     *         or key prevents it from being stored in this time-listener
     * @since 1.8
     */
    boolean replaceKey(V value, K oldKey, K newKey);
    
    /**
     * Replaces the time-listener for the specified key only if it is
     * currently mapped to some value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     *
     * <pre> {@code
     * if (time-listener.containsKey(key)) {
     *     return time-listener.putValue(key, value);
     * } else
     *     return null;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
      *
     * @param key key with which the specified value is associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no mapping for the key.
     *         (A {@code null} return can also indicate that the time-listener
     *         previously associated {@code null} with the key,
     *         if the implementation supports null values.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key or value is null,
     *         and this time-listener does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this time-listener
     * @since 1.8
     */
    V replaceValue(K key, V value);
    
    /**
     * Replaces the time-listener for the specified value only if it is
     * currently mapped to some key.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code time-listener}:
     *
     * <pre> {@code
     * if (time-listener.containsValue(value)) {
     *     return time-listener.putKey(value, key);
     * } else
     *     return null;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
      *
     * @param value value with which the specified key is associated
     * @param key key to be associated with the specified value
     * @return the previous key associated with the specified value, or
     *         {@code null} if there was no mapping for the value.
     *         (A {@code null} return can also indicate that the time-listener
     *         previously associated {@code null} with the value,
     *         if the implementation supports null values.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified value or key
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value or key is null,
     *         and this time-listener does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified value
     *         or key prevents it from being stored in this time-listener
     * @since 1.8
     */
    K replaceKey(V value, K key);
    
    /**
     * If the specified key is not already associated with a value (or is mapped
     * to {@code null}), attempts to compute its value using the given mapping
     * function and enters it into this time-listener unless {@code null}.
     *
     * <p>If the function returns {@code null} no mapping is recorded. If
     * the function itself throws an (unchecked) exception, the
     * exception is rethrown, and no mapping is recorded.  The most
     * common usage is to construct a new object serving as an initial
     * mapped value or memoized result, as in:
     *
     * <pre> {@code
     * time-listener.computeIfAbsent(key, k -> new value(f(k)));
     * }</pre>
     *
     * <p>Or to implement a multi-value time-listener, {@code time-listener<K,Collection<V>>},
     * supporting multiple values per key:
     *
     * <pre> {@code
     * time-listener.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
     * }</pre>
     *
     *
     * @implSpec
     * The default implementation is equivalent to the following steps for this
     * {@code time-listener}, then returning the current value or {@code null} if now
     * absent:
     *
     * <pre> {@code
     * if (time-listener.getValue(key) == null) {
     *     V newValue = mappingFunction.apply(key);
     *     if (newValue != null)
     *         time-listener.putValue(key, newValue);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the value is not
     * present.
     *
     * @param key key with which the specified value is to be associated
     * @param mappingFunction the function to compute a value
     * @return the current (existing or computed) value associated with
     *         the specified key, or null if the computed value is null
     * @throws NullPointerException if the specified key is null and
     *         this time-listener does not support null keys, or the mappingFunction
     *         is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V computeIfAbsent(K key, 
    		Function<? super K, ? extends V> mappingFunction);
    
    /**
     * If the specified value is not already associated with a key (or is mapped
     * to {@code null}), attempts to compute its key using the given mapping
     * function and enters it into this time-listener unless {@code null}.
     *
     * <p>If the function returns {@code null} no mapping is recorded. If
     * the function itself throws an (unchecked) exception, the
     * exception is rethrown, and no mapping is recorded.  The most
     * common usage is to construct a new object serving as an initial
     * mapped key or memorized result, as in:
     *
     * <pre> {@code
     * time-listener.computeInvertedIfAbsent(value, k -> new key(f(k)));
     * }</pre>
     *
     * <p>Or to implement a multi-key time-listener, {@code time-listener<K,Collection<V>>},
     * supporting multiple values per value:
     *
     * <pre> {@code
     * time-listener.computeInvertedIfAbsent(value, k -> new HashSet<V>()).add(v);
     * }</pre>
     *
     *
     * @implSpec
     * The default implementation is equivalent to the following steps for this
     * {@code time-listener}, then returning the current key or {@code null} if now
     * absent:
     *
     * <pre> {@code
     * if (time-listener.getKey(value) == null) {
     *     V newValue = mappingFunction.apply(value);
     *     if (newValue != null)
     *         time-listener.putKey(value, newKey);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the key is not
     * present.
     *
     * @param value value with which the specified key is to be associated
     * @param mappingFunction the function to compute a key
     * @return the current (existing or computed) key associated with
     *         the specified value, or null if the computed key is null
     * @throws NullPointerException if the specified value is null and
     *         this time-listener does not support null keys, or the mappingFunction
     *         is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified value or key
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    K computeInvertedIfAbsent(V value, 
    		Function<? super V, ? extends K> mappingFunction);
    
    /**
     * If the value for the specified key is present and non-null, attempts to
     * compute a new mapping given the key and its current mapped value.
     *
     * <p>If the function returns {@code null}, the mapping is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current mapping is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code time-listener}, then returning the current value or
     * {@code null} if now absent:
     *
     * <pre> {@code
     * if (time-listener.getValue(key) != null) {
     *     V oldValue = time-listener.getValue(key);
     *     V newValue = remappingFunction.apply(key, oldValue);
     *     if (newValue != null)
     *         time-listener.putValue(key, newValue);
     *     else
     *         time-listener.removeByKey(key);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the value is not
     * present.
     *
     * @param key key with which the specified value is to be associated
     * @param remappingFunction the function to compute a value
     * @return the new value associated with the specified key, or null if none
     * @throws NullPointerException if the specified key is null and
     *         this time-listener does not support null keys, or the
     *         remappingFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    public V computeIfPresent(K key, 
    		BiFunction<? super K, ? super V, ? extends V> remappingFunction) ;
    
    /**
     * If the key for the specified value is present and non-null, attempts to
     * compute a new mapping given the value and its current mapped key.
     *
     * <p>If the function returns {@code null}, the mapping is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current mapping is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code time-listener}, then returning the current key or
     * {@code null} if now absent:
     *
     * <pre> {@code
     * if (getKey(value) != null) {
     *     K oldKey = getKey(value);
     *     V newKey = remappingFunction.apply(value, oldKey);
     *     if (newKey != null)
     *         time-listener.putKey(value, newKey);
     *     else
     *         time-listener.removeByKey(key);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the key is not
     * present.
     *
     * @param value value with which the specified key is to be associated
     * @param remappingFunction the function to compute a key
     * @return the new key associated with the specified value, or null if none
     * @throws NullPointerException if the specified value is null and
     *         this time-listener does not support null keys, or the
     *         remappingFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified value or key
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    public K computeInvertedIfPresent(V value, 
    		BiFunction<? super V, ? super K, ? extends K> remappingFunction);
    
    /**
     * Attempts to compute a mapping for the specified key and its current
     * mapped value (or {@code null} if there is no current mapping). For
     * example, to either create or append a {@code String} msg to a value
     * mapping:
     *
     * <pre> {@code
     * time-listener.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))}</pre>
     * (Method {@link #merge merge()} is often simpler to use for such purposes.)
     *
     * <p>If the function returns {@code null}, the mapping is removed (or
     * remains absent if initially absent).  If the function itself throws an
     * (unchecked) exception, the exception is rethrown, and the current mapping
     * is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code time-listener}, then returning the current value or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldValue = time-listener.getValue(key);
     * V newValue = remappingFunction.apply(key, oldValue);
     * if (oldValue != null ) {
     *    if (newValue != null)
     *       time-listener.putValue(key, newValue);
     *    else
     *       time-listener.removeByKey(key);
     * } else {
     *    if (newValue != null)
     *       time-listener.putValue(key, newValue);
     *    else
     *       return null;
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the value is not
     * present.
     *
     * @param key key with which the specified value is to be associated
     * @param remappingFunction the function to compute a value
     * @return the new value associated with the specified key, or null if none
     * @throws NullPointerException if the specified key is null and
     *         this time-listener does not support null keys, or the
     *         remappingFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    public V compute(K key,
    		BiFunction<? super K, ? super V, ? extends V> remappingFunction);
    
    /**
     * Attempts to compute a mapping for the specified value and its current
     * mapped key (or {@code null} if there is no current mapping). For
     * example, to either create or append a {@code String} msg to a key
     * mapping:
     *
     * <pre> {@code
     * time-listener.compute(value, (k, v) -> (v == null) ? msg : v.concat(msg))}</pre>
     * (Method {@link #merge merge()} is often simpler to use for such purposes.)
     *
     * <p>If the function returns {@code null}, the mapping is removed (or
     * remains absent if initially absent).  If the function itself throws an
     * (unchecked) exception, the exception is rethrown, and the current mapping
     * is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code time-listener}, then returning the current key or
     * {@code null} if absent:
     *
     * <pre> {@code
     * K oldKey = time-listener.getKey(value);
     * K newKey = remappingFunction.apply(value, oldKey);
     * if (oldKey != null ) {
     *    if (newKey != null)
     *       time-listener.putKey(value, newKey);
     *    else
     *       time-listener.removeByValue(value);
     * } else {
     *    if (newKey != null)
     *       time-listener.putKey(value, newKey);
     *    else
     *       return null;
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the key is not
     * present.
     *
     * @param value value with which the specified key is to be associated
     * @param remappingFunction the function to compute a key
     * @return the new key associated with the specified value, or null if none
     * @throws NullPointerException if the specified value is null and
     *         this time-listener does not support null keys, or the
     *         remappingFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified value or key
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    public K computeInverted(V value,
    		BiFunction<? super V, ? super K, ? extends K> remappingFunction);
    
    /**
     * If the specified key is not already associated with a key or is
     * associated with null, associates it with the given non-null key.
     * Otherwise, replaces the associated key with the results of the given
     * remapping function, or removes if the result is {@code null}. This
     * method may be of use when combining multiple mapped values for a key.
     * For example, to either create or append a {@code String msg} to a
     * key mapping:
     *
     * <pre> {@code
     * time-listener.merge(key, msg, String::concat)
     * }</pre>
     *
     * <p>If the function returns {@code null} the mapping is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current mapping is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code time-listener}, then returning the current key or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldValue = time-listener.getValue(key);
     * V newValue = (oldValue == null) ? key :
     *              remappingFunction.apply(oldValue, key);
     * if (newValue == null)
     *     time-listener.removeByKey(key);
     * else
     *     time-listener.putValue(key, newValue);
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the key is not
     * present.
     *
     * @param key key with which the resulting key is to be associated
     * @param value the non-null value to be merged with the existing key
     *        associated with the key or, if no existing key or a null key
     *        is associated with the key, to be associated with the key
     * @param remappingFunction the function to recompute a key if present
     * @return the new key associated with the specified key, or null if no
     *         key is associated with the key
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or key
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this time-listener
     *         does not support null keys or the key or remappingFunction is
     *         null
     * @since 1.8
     */
    V merge(K key, V value,
            BiFunction<? super V, ? super V, ? extends V> remappingFunction);
    
    /**
     * If the specified value is not already associated with a key or is
     * associated with null, associates it with the given non-null key.
     * Otherwise, replaces the associated key with the results of the given
     * remapping function, or removes if the result is {@code null}. This
     * method may be of use when combining multiple mapped values for a value.
     * For example, to either create or append a {@code String msg} to a
     * key mapping:
     *
     * <pre> {@code
     * time-listener.mergeInverted(value, msg, String::concat)
     * }</pre>
     *
     * <p>If the function returns {@code null} the mapping is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current mapping is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code time-listener}, then returning the current key or
     * {@code null} if absent:
     *
     * <pre> {@code
     * K oldKey = time-listener.getKey(value);
     * K newKey = (oldValue == null) ? key :
     *              remappingFunction.apply(oldKey, value);
     * if (newValue == null)
     *     time-listener.removeByValue(value);
     * else
     *     time-listener.putKey(value, newKey);
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrenttime-listener} must document
     * whether the function is applied once atomically only if the key is not
     * present.
     *
     * @param value value with which the resulting key is to be associated
     * @param key the non-null key to be merged with the existing key
     *        associated with the value or, if no existing key or a null key
     *        is associated with the value, to be associated with the value
     * @param remappingFunction the function to recompute a key if present
     * @return the new key associated with the specified value, or null if no
     *         key is associated with the value
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified value or key
     *         prevents it from being stored in this time-listener
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this time-listener
     *         does not support null values  or the key or remappingFunction is
     *         null
     * @since 1.8
     */
    K mergeInverted(V value, K key,
            BiFunction<? super K, ? super K, ? extends K> remappingFunction) ;
}