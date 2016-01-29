/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperline;
import org.xmlrobot.matter.Hyperletter;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
public class Hyperpair 
	extends Hyperstring {

	/**
	 * -8551753871097847645L
	 */
	private static final long serialVersionUID = -8551753871097847645L;

	/**
	 * {@link Hyperpair} default class constructor.
	 */
	public Hyperpair() {
		
		super(Hyperline.class, Hyperletter.class, Hyperpair.class);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent {@link Hyperstring} the parent
	 */
	public Hyperpair(Character key, Integer value, Hyperstring parent) {
		
		super(Hyperline.class, Hyperletter.class, Hyperpair.class, key, value, parent);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hyperpair(Class<Hyperentry> antitype) {
		
		super(Hyperline.class, Hyperletter.class, Hyperpair.class, antitype);
	}
	/**
	 * {@link Hyperpair} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 * @param parent {@link Hyperstring} the parent
	 */
	public Hyperpair(Class<Hyperentry> antitype, 
			Character key, Integer value, Hyperstring parent) {
		
		super(Hyperline.class, Hyperletter.class, Hyperpair.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperstring#run()
	 */
	@Override
	public void run() {
		// life starts
		super.run();
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}

}