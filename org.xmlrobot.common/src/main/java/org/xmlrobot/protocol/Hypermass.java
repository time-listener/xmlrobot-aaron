/**
 * 
 */
package org.xmlrobot.protocol;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Mass;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Hypermass<K,V> 
	extends Hyperbody<Mass<K,V>,Mass<V,K>> 
		implements Mass<K,V> {

	/**
	 * 7165093430754941162L
	 */
	private static final long serialVersionUID = 7165093430754941162L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#getKey()
	 */
	@Override
	@XmlTransient
	public K getKey() {

		return getAndCast(Mass.KEY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#setKey(java.lang.Object)
	 */
	public void setKey(K key) {

		set(Mass.KEY, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#getValue()
	 */
	@Override
	@XmlTransient
	public V getValue() {

		return getAndCast(Mass.VALUE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(V value) {

		set(Mass.VALUE, value);
	}
	/**
	 * {@link Hypermass} default class constructor.
	 * @throws Abort when something is wrong
	 */
	public Hypermass() {
		
		super();
		// this is the mass listener
		initializeListener(this);
	}
	/**
	 * {@link Hypermass} meta-constructor.
	 * @throws Abort when something is wrong
	 */
	public Hypermass(Hyperbody<Mass<K,V>,Mass<V,K>> mass) {
		super(mass);
		// start mass listener initialization
		initializeListener(mass);
	}
	/**
	 * {@link Hypermass} meta-constructor.
	 * @throws Abort when something is wrong
	 */
	public Hypermass(Hyperbody<Mass<K,V>,Mass<V,K>> mass, K key, V value) {
		this(mass);
		// inherit key
		mass.set(Mass.KEY, key);
		// inherit value
		mass.set(Mass.VALUE, value);
	}
	/**
	 * Initializes the mass listener
	 * @param mass the inherited mass
	 */
	private void initializeListener(Hyperbody<Mass<K,V>,Mass<V,K>> mass) {
		// update dna reference
		mass.set(DNA, this);
		// inherit mass atomically
		this.map = mass;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hypermass#dna()
	 */
	@Override
	public Hypermass<K,V> dna() {
		
		return getAndCast(DNA);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hypermass#clone()
	 */
	@Override
	public Hypermass<K,V> clone() {

		Hypermass<K,V> message = (Hypermass<K,V>) super.clone();

		return message;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#collectPositive(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<K> collectKeys(Congregation<K> output) {

		return call().collectKeys(output);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#collectNegative(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<V> collectValues(Congregation<V> output) {

		return call().collectValues(output);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callPositive(java.lang.Object)
	 */
	@Override
	public Mass<K,V> call(K key) {

		return call().call(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callNegative(java.lang.Object)
	 */
	@Override
	public Mass<V,K> callReversed(V value) {

		return call().callReversed(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#containsPositive(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {

		return call().containsKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#containsNegative(java.lang.Object)
	 */
	@Override
	public boolean containsValue(V value) {

		return call().containsValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#positive()
	 */
	@Override
	public Congregation<K> keyView() {

		return call().keyView();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#negative()
	 */
	@Override
	public Congregation<V> valueView() {

		return call().valueView();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putNegative(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValue(K key, V value) {

		return call().putValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putPositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKey(V value, K key) {

		return call().putKey(value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putAllNegative(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void putAllValues(Mass<? extends K, ? extends V> t) {
		
		call().putAllValues(t);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putAllPositive(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void putAllKeys(Mass<? extends V, ? extends K> t) {

		call().putAllKeys(t);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putNegativeIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValueIfAbsent(K key, V value) {

		return call().putValueIfAbsent(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putPositiveIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKeyIfAbsent(V value, K key) {

		return call().putKeyIfAbsent(value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removeNegative(java.lang.Object)
	 */
	@Override
	public Mass<K,V> removeByKey(K key) {

		return call().removeByKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removePositive(java.lang.Object)
	 */
	@Override
	public Mass<V,K> removeByValue(V value) {

		return call().removeByValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getNegative(java.lang.Object)
	 */
	@Override
	public V getValue(K key) {

		return call().getValue(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getPositive(java.lang.Object)
	 */
	@Override
	public K getKey(V value) {

		return call().getKey(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getNegativeOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V getValueOrDefault(K key, V defaultValue) {

		return call().getValueOrDefault(key, defaultValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getPositiveOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K getKeyOrDefault(V value, K defaultKey) {

		return call().getKeyOrDefault(value, defaultKey);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#forEachPositive(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super K, ? super V> action) {
		call().forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#forEachNegative(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachValue(BiConsumer<? super V, ? super K> action) {
		
		call().forEachValue(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceAllNegative(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(
			BiFunction<? super K, ? super V, ? extends V> function) {
		call().replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceAllPositive(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllKeys(BiFunction<? super V, ? super K, ? extends K> function) {
		
		call().replaceAllKeys(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removeNegative(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(K key, V value) {

		return call().removeByKey(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removePositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByValue(V value, K key) {

		return call().removeByValue(value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceNegative(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(K key, V oldValue, V newValue) {
		
		return call().replaceValue(key, oldValue, newValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replacePositive(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceKey(V value, K oldKey, K newKey) {
		
		return call().replaceKey(value, oldKey, newKey);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceNegative(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V replaceValue(K key, V value) {
		
		return call().replaceValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replacePositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K replaceKey(V value, K key) {
		
		return call().replaceKey(value, key);	
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeIfAbsentByKey(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public V computeIfAbsent(K key, 
			Function<? super K, ? extends V> mappingFunction) {
		
		return call().computeIfAbsent(key, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeInvertedIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public K computeInvertedIfAbsent(V value,
			Function<? super V, ? extends K> mappingFunction) {
		
		return call().computeInvertedIfAbsent(value, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V computeIfPresent(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		
		return call().computeIfPresent(key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeInvertedIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K computeInvertedIfPresent(V value,
			BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		
		return call().computeInvertedIfPresent(value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V compute(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		
		return call().compute(key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeInverted(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K computeInverted(V value,
			BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		
		return call().computeInverted(value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V merge(K key, V value,
			BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		
		return call().merge(key, value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#mergeInverted(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K mergeInverted(V value, K key,
			BiFunction<? super K, ? super K, ? extends K> remappingFunction) {
		return call().mergeInverted(value, key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#brain()
	 */
	@Override
	public Mass<K, V> replicator() {

		return call().replicator();
	}
}
