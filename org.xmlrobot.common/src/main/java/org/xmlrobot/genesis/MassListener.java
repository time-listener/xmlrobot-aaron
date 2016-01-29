/**
 * 
 */
package org.xmlrobot.genesis;

import java.time.Instant;
import java.util.concurrent.Executor;

import org.osgi.framework.AllServiceListener;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.hyperspace.Hyperspace;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Command;

/**
 * <center>
 * Our {@code root} in {@link Hyperspace},<br>
 * abstract be your name.<br>
 * Your {@code inheritance} implement,<br>
 * your methods will be ran,<br>
 * on known universe,<br>
 * as it is in {@link Hyperspace}.<br>
 * Send us this {@link Instant}<br> 
 * our instantly {@link Time},<br>
 * and forgive us our executions,<br>
 * as we also have forgiven our executors.<br>
 * And lead us not into synchrony,<br>
 * but deliver us from Borg Imperium.<br>
 * <br>
 * In the name of<br>
 * {@code parent}, {@code child}<br>
 * and {@link MassListener}.<br>
 * [EoL]
 * <br><br>
 * </center>
 * 
 * @author joan
 *
 */
public interface MassListener 
	extends AllServiceListener, 
		BundleActivator, 
			BundleTerminator,
				Executor {
	/**
	 * The family.
	 */
	public static final String FAMILY = "mass-listener.family";
	
	/**
	 * The registration
	 */
	public static final String REGISTRATION = "mass-listener.registration";

	/**
	 * The runner.
	 */
	public static final String RUNNER = "mass-listener.runner";

	/**
	 * The UUID.
	 */
	public static final String UUID = "mass-listener.uuid";

	/**
	 * The name.
	 */
	public static final String NAME = "mass-listener.name";

	/**
	 * The context
	 */
	public static final String CONTEXT = "mass-listener.context";

    /**
	 * The command.
	 */
	public static final String COMMAND = "mass-listener.command";

	/**
	 * The inheritance mass.
	 * @return {@link Command} the value.
	 */
	Command command();
	
	/**
	 * @return {@link BundleContext} the hyperspace
	 */
	BundleContext context();

	/**
	 * @return {@link ThreadGroup} the inherited family
	 */
	ThreadGroup family();

	/**
	 * Returns the registration object.
	 * @return {@link ServiceRegistration} the value
	 */
	ServiceRegistration<?> host();
	
	/**
	 * Abstract be your name.
	 * Everyone in the {@code hyperspace} has a name.
	 * For example, my name is {@code time-listener}.
	 * @return the entity's name
	 */
	String name();

	/**
	 * Gets the runner thread
	 * @return {@link Thread} the value
	 */
	Thread runner();
	
	/**
	 * @return the universal unique ID
	 */
	java.util.UUID uuid();
	
	/**
	 * Adds a mass listener for its prayers. 
	 * @param listener the future {@link MassListener} receiver
	 */ 
	void addMassListener(MassListener listener);

	/**
	 * A {@link Takion} is being transmitted to the past.
	 * @param sender {@link MassListener} the sender entity
	 * @param event {@link Takion} the mass being sent to the past
	 */
	void mass(MassListener sender, Takion<?,?> event);

	/**
	 * Sets the current {@link Command}.
	 * @param value {@link Command} the new command
	 */
	void push(Command value);
	
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	void start(BundleContext context);
	
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	void stop(BundleContext context);
	
	/**
	 * Updates properties of the hyperspace
	 */
	void update();
}