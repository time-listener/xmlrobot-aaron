/**
 * 
 */
package org.xmlrobot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperline;
import org.xmlrobot.matter.Hyperletter;
import org.xmlrobot.util.Command;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Hyperpair 
	extends Hyperstring {

	/**
	 * -8551753871097847645L
	 */
	private static final long serialVersionUID = -8551753871097847645L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public String getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public void setKey(String key) {
		super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Integer getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Integer value) {
		super.setValue(value);
	}
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
	public Hyperpair(String key, Integer value, Hypercube parent) {
		
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
			String key, Integer value, Hypercube parent) {
		
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
		
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Hyperpair) {
			// cast source
			Hyperpair pair = (Hyperpair) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hyperline(getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}