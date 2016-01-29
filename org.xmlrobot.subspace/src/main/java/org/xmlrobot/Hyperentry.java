/**
 * 
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperline;
import org.xmlrobot.matter.Hyperletter;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Hyperentry 
	extends Hyperinteger {

	/**
	 * 6404666831053501412L
	 */
	private static final long serialVersionUID = 6404666831053501412L;
	
	/**
	 * {@link Hyperentry} default class constructor.
	 */
	public Hyperentry() {
		
		super(Hyperletter.class, Hyperline.class, Hyperentry.class);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent {@link Hyperinteger} the parent
	 */
	public Hyperentry(Integer key, Character value, Hyperinteger parent) {
		
		super(Hyperletter.class, Hyperline.class, Hyperentry.class, key, value, parent);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	public Hyperentry(Class<Hyperpair> antitype) {
		
		super(Hyperletter.class, Hyperline.class, Hyperentry.class, antitype);
	}
	/**
	 * {@link Hyperentry} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 * @param parent {@link Hyperinteger} the parent
	 */
	public Hyperentry(Class<Hyperpair> antitype, 
			Integer key, Character value, Hyperinteger parent) {
		
		super(Hyperletter.class, Hyperline.class, Hyperentry.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperinteger#run()
	 */
	@Override
	public void run() {
	
		super.run();
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {

		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}

}