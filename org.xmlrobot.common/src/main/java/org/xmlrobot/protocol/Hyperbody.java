/**
 * 
 */
package org.xmlrobot.protocol;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Phaser;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Massive message body implementation class.
 * 
 * @author joan
 * @parity YY
 */
@XmlRootElement
public class Hyperbody
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Hyperhead 
			implements TimeListener<K,V> {
	
	/**
	 * -7589606931673287328L
	 */
	private static final long serialVersionUID = -7589606931673287328L;
	
	/**
	 * The head of the message.
	 */
	Hyperhead head;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#get()
	 */
	@Override
	@XmlTransient
	public V get() {

		return getAndCast(VALUE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#set(java.lang.Object)
	 */
	@Override
	public V set(V value) {
		
		return getAndSet(VALUE, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#call()
	 */
	@Override
	@XmlTransient
	public K call() {
		
		return getAndCast(KEY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#dna()
	 */
	@Override
	public Hyperbody<K,V> dna() {
		
		return getAndCast(DNA);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getGen()
	 */
	@Override
	@XmlElement
	public Parity getGen() {

		return getAndCast(PARITY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setGen(org.xmlrobot.util.Parity)
	 */
	@Override
	public void setGen(Parity gene) {
		
		set(PARITY, gene);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getType()
	 */
	@Override
	@XmlElement
	public Class<K> getType() {

		return getAndCast(TYPE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> type) {
		
		set(TYPE, type);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getAntitype()
	 */
	@Override
	@XmlElement
	public Class<? extends V> getAntitype() {
		
		return getAndCast(ANTITYPE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setAntitype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> value) {
		
		set(ANTITYPE, value);
	}



	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getChild()
	 */
	@Override
	public K getChild() {
		
		return getAndCast(CHILD);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getParent()
	 */
	@Override
	public K getParent() {
		
		return getAndCast(PARENT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#setChild(java.lang.Object)
	 */
	@Override
	public K setChild(K listener) {
		
		return getAndSet(CHILD, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#setParent(java.lang.Object)
	 */
	@Override
	public K setParent(K listener) {
		
		return getAndSet(PARENT, listener);
	}

	/**
	 * {@link Hyperbody} default class constructor.
	 * @throws Abort when something is wrong
	 */
	public Hyperbody() {
		this(Parity.YY);
	}
	/**
	 * {@link Hyperbody} class constructor.
	 */
	public Hyperbody(Parity parity) {
		this(new Hyperhead());
		// inherit parity
		set(PARITY, parity);
	}
	/**
	 * {@link Hyperbody} class constructor.
	 */
	public Hyperbody(Class<? extends K> type, K key, Parity parity) {
		this(parity);
		// inherit key
		set(KEY, key);
		// inherit type
		set(TYPE, type);
	}
	/**
	 * {@link Hyperbody} class constructor.
	 */
	public Hyperbody(Class<? extends K> type, K key, V value, Parity parity) {
		this(type, key, parity);
		// inherit value
		set(VALUE, key);
		// inherit antitype
		set(ANTITYPE, value.getType());
	}
	/**
	 * @param map
	 * @throws Abort
	 */
	public Hyperbody(Hyperhead map) {
		if(map == null)
			throw new Abort();
		// start dna initialization
		initializeDna(map);
	}
	/**
	 * @param parity
	 */
	private void initializeDna(Hyperhead map) {
		// declare key reference
		map.<K>declare(KEY);
		// declare value reference
		map.<V>declare(VALUE);
		// declare parent reference
		map.<K>declare(PARENT);
		// declare child reference
		map.<K>declare(CHILD);
		// declare parity
		map.<Parity>declare(PARITY);
		// declare antitype reference
		map.<Class<? extends K>>declare(TYPE);
		// declare antitype reference
		map.<Class<? extends V>>declare(ANTITYPE);
		// inherit default startup command
		map.declareAndSet(COMMAND, Command.CLONE);
		// update dna reference
		map.set(DNA, this);
		// inherit map
		this.head = map;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Hyperbody<K,V> clone() {

		@SuppressWarnings("unchecked")
		Hyperbody<K,V> dna = (Hyperbody<K,V>) super.clone();
		return dna;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> sender, Takion<Y,X> event) {
		
		call().pulse(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> void echo(
			TimeListener<?,?> sender, Takion<X,Y> event) {
		
		call().echo(sender, event);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable entity) {

		call().execute(entity);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable entity) {

		return call().newThread(entity);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.RunnableFuture#run()
	 */
	@Override
	public void run() {
		
		call().run();
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
		call().serviceChanged(event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		
		call().mass(sender, event);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#shutdown()
	 */
	@Override
	public void shutdown() {
	
		call().shutdown();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#shutdownNow()
	 */
	@Override
	public List<Runnable> shutdownNow() {

		return call().shutdownNow();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#submit(java.util.concurrent.Callable)
	 */
	@Override
	public <T> Phaser<T> submit(Callable<T> task) {

		return call().submit(task);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#submit(java.lang.Runnable)
	 */
	@Override
	public Phaser<?> submit(Runnable task) {

		return call().submit(task);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#submit(java.lang.Runnable, java.lang.Object)
	 */
	@Override
	public <T> Phaser<T> submit(Runnable task, T result) {

		return call().submit(task, result);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		
		return call().isCancelled();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isDone()
	 */
	@Override
	public boolean isDone() {
		
		return call().isDone();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isShutdown()
	 */
	@Override
	public boolean isShutdown() {

		return call().isShutdown();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isTerminated()
	 */
	@Override
	public boolean isTerminated() {

		return call().isTerminated();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAll(java.util.Collection)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
			throws InterruptedException {

		return call().invokeAll(tasks);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(
			Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {

		return call().invokeAll(tasks, timeout, unit);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAny(java.util.Collection)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {

		return call().invokeAny(tasks);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAny(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
			long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {

		return call().invokeAny(tasks, timeout, unit);
	}
	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit)
			throws InterruptedException {

		return call().awaitTermination(timeout, unit);
	}
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {

		return call().cancel(mayInterruptIfRunning);
	}
	@Override
	public int compareTo(V o) {
	
		return call().compareTo(o);
	}
	@Override
	public K call(int N) {

		return call().call(N);
	}
	@Override
	public void polarize(K parent, K child) {
		
		call().polarize(parent, child);
	}
	@Override
	public void remove() {
		
		call().remove();
	}
	@Override
	public K getFuture() {

		return call().getFuture();
	}
	@Override
	public K getPast() {

		return call().getPast();
	}
	@Override
	public void orderAt(K listener, int index) {
		
		call().orderAt(listener, index);
	}
	@Override
	public K submitChild(K listener) {
		
		return call().submitChild(listener);
	}
	@Override
	public K orderInfer(K listener) {
		
		return call().orderInfer(listener);
	}
	@Override
	public K submitParent(K listener) {
		
		return call().submitParent(listener);
	}
	@Override
	public K orderSuper(K listener) {

		return call().orderSuper(listener);
	}
	@Override
	public K permute(int N) {

		return call().permute(N);
	}
	@Override
	public K releaseChild() {

		return call().releaseChild();
	}
	@Override
	public K releaseParent() {
		
		return call().releaseParent();
	}
	@Override
	public K revolve() {

		return call().revolve();
	}
	@Override
	public K rotate() {

		return call().rotate();
	}
	@Override
	public void swap(K listener) {
		
		call().swap(listener);
	}
	@Override
	public boolean add(K e) {

		return call().add(e);
	}
	@Override
	public int delve(int counter) {

		return call().delve(counter);
	}
	@Override
	public int depth() {

		return call().depth();
	}
	@Override
	public boolean contains(K entity) {

		return call().contains(entity);
	}
	@Override
	public Object[] toArray() {

		return call().toArray();
	}
	@Override
	public <X> X[] toArray(X[] a) {

		return call().toArray(a);
	}
	@Override
	public int compare(K o1, K o2) {
		
		return call().compare(o1, o2);
	}
	@Override
	public Congregation<K> collect(Congregation<K> entities) {
		
		return call().collect(entities);
	}
	@Override
	public void clear() {
		
		call().clear();
	}
	@Override
	public V get(long timeout, TimeUnit unit) {

		return call().get(timeout, unit);
	}
	@Override
	public boolean hasMoreElements() {
		return call().hasMoreElements();
	}
	@Override
	public K nextElement() {
		return call().nextElement();
	}
	@Override
	public Iterator<K> iterator() {
		return call().iterator();
	}
	@Override
	public boolean containsAll(K c) {
		return call().containsAll(c);
	}
	@Override
	public boolean addAll(K c) {
		return call().addAll(c);
	}
	@Override
	public boolean removeAll(K c) {
		return call().removeAll(c);
	}
	@Override
	public boolean retainAll(K c) {
		return call().retainAll(c);
	}
	@Override
	public void polarize() {
		call().polarize();
	}
	@Override
	public boolean order(K listener) {
		return call().order(listener);
	}
	@Override
	public K release() {
		return call().release();
	}
	@Override
	public void spin() {
		call().spin();
	}
	@Override
	public boolean submit(K entity) {
		
		return call().submit(entity);
	}
	@Override
	public boolean removeIf(Predicate<? super K> filter) {

		return call().removeIf(filter);
	}
	@Override
	public TimeListener.Transmitter<K,V> matrix() {

		return call().matrix();
	}
	@Override
	public int reproduceTo(V o) {
		
		return call().reproduceTo(o);
	}
	@Override
	public boolean submitAll(K c) {
		
		return call().submitAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		
		call().addMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#output()
	 */
	@Override
	public V output() {
		
		return call().output();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	@Override
	public void update() {
		
		call().update();
	}
}
