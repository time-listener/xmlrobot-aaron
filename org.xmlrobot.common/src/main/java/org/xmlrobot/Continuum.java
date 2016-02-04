package org.xmlrobot;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.launch.Framework;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Genoma;

/**
 * The Continuum Q.
 * 
 * The Q Continuum is an extradimensional plane of existence inhabited 
 * by a race of beings known as the Q. 
 * 
 * As a race, the Q are immortal, omniscient, and omnipotent, possessing 
 * the ability of instantaneous matter-energy transformation and teleportation, 
 * as well as the ability of time travel. 
 * 
 * Their apparent abilities include moving entire asteroid belts and stars, 
 * creating alternate timelines, and affecting universal states of nature 
 * such as the gravitational constant. In fact, the only time a Q is seen 
 * as unable to do something is during a period where their powers are reduced 
 * or revoked by the Continuum. 
 * 
 * The Q claim to have always existed, with no explanation as to how they first 
 * came into existence. Based on descriptions by numerous Q, including the Q later 
 * known as Quinn, as well as Amanda Rogers, the Q Continuum is a highly ordered 
 * society, but is also the result of <tt>eons</tt> of evolutionary stagnation.
 * 
 * @author joan
 */
public abstract class Continuum implements MassListener {

	/**
	 * 2576687634078939125L
	 */
	private static final long serialVersionUID = 2576687634078939125L;
	
	/**
	 * The hyperspace.
	 */
	static Framework context = null;
	
	/**
	 * 
	 */
	public Continuum() {
		try {
			// create hyperspace
			context = Genoma.createHyperspace();
			// initialize hyperspace
			context.init();
			// start hyperspace
			context.start();
			// listen everything
			context.getBundleContext().addServiceListener(this);
		} 
		catch (Exception e) {

			throw new Abort(e);
		}
	}
	@Override
	public void run() {

		
	}
	@Override
	public Thread newThread(Runnable r) {

		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable command) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void addMassListener(MassListener listener) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	@Override
	public void update() {
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
		context.getBundleContext().getService(event.getServiceReference());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#context()
	 */
	@Override
	public BundleContext getContext() {
		
		return context.getBundleContext();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#uuid()
	 */
	@Override
	public java.util.UUID getUUID() {

		return java.util.UUID.randomUUID();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#family()
	 */
	@Override
	public ThreadGroup getFamily() {

		return Thread.currentThread().getThreadGroup();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#host()
	 */
	@Override
	public ServiceRegistration<?> getHost() {

		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String getName() {

		return "Q";
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#runner()
	 */
	@Override
	public Thread getRunner() {
		return Thread.currentThread();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#command()
	 */
	@Override
	public Command getCommand() {
	
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#push(org.xmlrobot.util.Command)
	 */
	@Override
	public void push(Command value) {
		
	}
}
