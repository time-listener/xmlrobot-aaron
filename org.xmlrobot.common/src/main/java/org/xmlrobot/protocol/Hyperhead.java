/**
 * 
 */
package org.xmlrobot.protocol;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Command;

/**
 * Entity's brain.
 * 
 * @author joan
 *
 */
public class Hyperhead 
	extends Dictionary<String,Object> 
		implements MassListener {

	/**
	 * The backing data
	 */
	Dictionary<String,Object> map;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#uuid()
	 */
	@Override
	public java.util.UUID uuid() {
		
		return getAndCast(UUID);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#family()
	 */
	@Override
	public ThreadGroup family() {

		return getAndCast(FAMILY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#host()
	 */
	@Override
	public ServiceRegistration<?> host() {

		return getAndCast(REGISTRATION);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {

		return getAndCast(NAME);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#runner()
	 */
	@Override
	public Thread runner() {
		
		return getAndCast(RUNNER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getCommand()
	 */
	@Override
	@XmlElement
	public Command command() {
		
		return getAndCast(COMMAND);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getContext()
	 */
	@Override
	@XmlTransient
	public BundleContext context() {
		
		return getAndCast(CONTEXT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setCommand(org.xmlrobot.util.Command)
	 */
	@Override
	public void push(Command value) {
		
		set(COMMAND, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) {
		
		set(CONTEXT, context);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
		
		compareAndSet(CONTEXT, context, null);
	}
	/**
	 * {@link Hyperhead} default class constructor.
	 */
	public Hyperhead() {
		// create time-traveler message properties
		map = new Hashtable<String,Object>();
		// inherit dna
		declareAndSet(TimeListener.DNA, this);
		// declare and set UUID
		declareAndSet(UUID, java.util.UUID.randomUUID());
		// declare and set family
		declareAndSet(FAMILY, Thread.currentThread());
		// declare context
		this.<BundleContext>declare(CONTEXT);
		// declare runner
		this.<Thread>declare(RUNNER);
		// declare registration
		this.<ServiceRegistration<?>>declare(REGISTRATION);
		// declare name
		this.<String>declare(NAME);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {

		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#elements()
	 */
	@Override
	public Enumeration<Object> elements() {
		
		return map.elements();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#get(java.lang.Object)
	 */
	@Override
	public Object get(Object key) {

		return map.get(key);
	}
	/**
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <X> X getAndCast(String key)
	{
		try {
			return ((AtomicReference<X>) this.get(key)).get();	
		}
		catch(ClassCastException | NullPointerException unused) {
			
			return null;
		}
	}
	/**
	 * Returns an atomic reference with the specified key. 
	 * @param key the key referenced to the current dictionary
	 * @return the atomic reference associated to the current key
	 */
	@SuppressWarnings("unchecked")
	public <X> AtomicReference<X> getReference(String key)
	{
		try {
			return (AtomicReference<X>) this.get(key);	
		}
		catch(ClassCastException | NullPointerException unused) {
			
			return null;
		}
	}
	/**
	 * Declares an atomic dictionary reference with the specified key.
	 * @param key the key referenced to the current dictionary
	 * @return true is key was previously declared
	 */
	public <X> boolean declare(String key) {
		
		return map.put(key, new AtomicReference<X>()) != null;
	}
	/**
	 * Declares an atomic dictionary reference with the specified key
	 * and sets the value associated to the key
	 * @param key the key referenced to the current dictionary
	 * @param value the value associated to the current key
	 * @return true if key was previously declared
	 */
	public <X> boolean declareAndSet(String key, X value) {
		
		return map.put(key, new AtomicReference<X>(value)) != null;
	}
	/**
	 * Compares expected value with current associated value. If
	 * comparison success sets the new value associated to the current key.
	 * @param key the key referenced to the current dictionary
	 * @param expected the expected value associated to the current key
	 * @param value the new value to be settled
	 * @return true is settling has been successful executed
	 */
	public <X> boolean compareAndSet(String key, X expected, X value) {
		
		try {
			AtomicReference<X> ref = getReference(key);
			return ref.compareAndSet(expected, value);
		}
		catch(ClassCastException | NullPointerException unused) {
			return false;
		}
		finally {
			update();
		}
	}
	/**
	 * Gets and sets the value associated to the current key.
	 * @param key the key referenced to the current dictionary
	 * @param value the value to be settled
	 * @return the old value associated to the current key
	 */
	public <X> X getAndSet(String key, X value) {
		
		try {
			AtomicReference<X> ref = getReference(key);
			return ref.getAndSet(value);
		}
		catch(ClassCastException | NullPointerException unused) {
			return null;
		}
		finally {
			update();
		}
	}
	/**
	 * Sets the value associated to the current key.
	 * @param key the key referenced to the current dictionary
	 * @param value the value to be settled
	 */
	public <X> void set(String key, X value) {
		
		try {
			
			this.<X>getReference(key).lazySet(value);
			update();
		}
		catch(NullPointerException unused) { 
			
			return;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#isEmpty()
	 */
	@Override
	public boolean isEmpty() {

		return map.isEmpty();
	}

	/* (non-Javadoc)
	 * @see java.util.Dictionary#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object put(String key, Object value) {

		return map.put(key, value);
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object key) {

		return map.remove(key);
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#size()
	 */
	@Override
	public int size() {

		return map.size();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#keys()
	 */
	@Override
	public Enumeration<String> keys() {
		
		return map.keys();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable command) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	@Override
	public void update() {
		return;
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		return;
	}
}
