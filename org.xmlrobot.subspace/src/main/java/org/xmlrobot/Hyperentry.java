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
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Hyperentry 
	extends Hyperinteger {

	/**
	 * 6404666831053501412L
	 */
	private static final long serialVersionUID = 6404666831053501412L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Integer getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public void setKey(Integer key) {
		super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public String getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(String value) {
		super.setValue(value);
	}
	
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
	public Hyperentry(Integer key, String value, Hyperchain parent) {
		
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
			Integer key, String value, Hyperchain parent) {
		
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
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
		Object source = getContext().getService(event.getServiceReference());
		
		if(source instanceof Hyperentry) {
			// cast source
			Hyperentry pair = (Hyperentry) source;
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				replicator().add(new Hyperletter(Hyperline.class, pair.getKey(), pair.getValue()));
			} 
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				replicator().removeByKey(pair.getKey());
			}
		}
	}

}