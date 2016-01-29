/**
 * 
 */
package org.xmlrobot.hyperspace;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The current <tt>hyperspace</tt> implementation class.
 * 
 * <p>Hyperspace allows for near instantaneous transportation between two points, 
 * however an object traveling through hyperspace cannot independently control 
 * its exiting point. To travel to a congregation destination a corresponding hyperspace 
 * gate must be implemented at the destination. This second gate effectively pulls 
 * the object out of hyperspace and back to normal space.
 * 
 * <p>Activate hyperspace protocol: energy.
 * 
 * @author joan
 *
 */
public abstract class Hyperspace
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends NorthernLights<K,V> {

	/**
	 * -2410739439956912487L
	 */
	private static final long serialVersionUID = -2410739439956912487L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#host()
	 */
	@Override
	public ServiceRegistration<?> host() {
		
		return dna().getAndCast(REGISTRATION);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#getState()
	 */
	@Override
	public Command command() {
		
		return dna().command();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#setState(org.xmlrobot.type.State)
	 */
	@Override
	public void push(Command value) {
		// set command header
		dna().push(value);
		// submit command into the hyperspace
		push(new Takion<K, V>(this) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 3217060066232920443L;});
	}
	
    /**
     * Hyperspace default class constructor.
     */
    public Hyperspace() {
    	super();
    }
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    public Hyperspace(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    public Hyperspace(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    public Hyperspace(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#run()
	 */
	@Override
	public void run() {
		// call ancestral method
		super.run();
		// declare future
		V future;
		// assign and check
		if((future = get()) != null) {
			// run opposite instance
			execute(future);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#setContext(org.osgi.framework.BundleContext)
	 */
	@Override
	public final synchronized void start(BundleContext hyperspace) {
		// call ancestral start
		super.start(hyperspace);
		// the entity is registered into the hyperspace by itself
		ServiceRegistration<?> host = 
				hyperspace.registerService(TimeListener.class, this, dna());
		// finally, save entity's registration object.
		dna().set(REGISTRATION, host);
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public final synchronized void stop(BundleContext context) {
		// call ancestral stop
		super.stop(context);
		// declare host
		ServiceRegistration<?> host;
		// assign and check
		if((host = host()) != null)
			// auto-execution
			host.unregister();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Abstract#update()
	 */
	public void update() {
		// declare host
		ServiceRegistration<?> host;
		// the hyperspace host
		if((host = host()) != null)
			host.setProperties(dna());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.NorthernLights#clone()
	 */
	@Override
	public Hyperspace<K,V> clone() {
		
		try {
			Hyperspace<K,V> hyperspace = (Hyperspace<K,V>) super.clone();			
			return hyperspace;
		}
		catch(NullPointerException | ClassCastException unused) {
			
			return null;
		}
	}
}