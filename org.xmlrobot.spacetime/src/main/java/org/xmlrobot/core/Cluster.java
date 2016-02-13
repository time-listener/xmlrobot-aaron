/**
 * 
 */
package org.xmlrobot.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.core.antimatter.Hyperlepton;
import org.xmlrobot.core.matter.Lepton;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.spacetime.Capricornus;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Cluster implementation class.
 * @author joan
 * @parity XY
 * @since 41162.1
 */
@XmlRootElement
public class Cluster 
	extends Parent<Fornax,Columbia> {

	/**
	 * 2984591194160886042L
	 */
	private static final long serialVersionUID = 2984591194160886042L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Fornax getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Fornax setKey(Fornax key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Columbia getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Columbia setValue(Columbia value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperlepton.class)
	public Mass<Fornax,Columbia> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Cluster} default class constructor.
	 */
	public Cluster() {
		super(Hyperlepton.class, Lepton.class, Cluster.class, Parity.XY);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 * @param parent {@link Parent} the parent
	 */
	public Cluster(Fornax key, Columbia value) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, key, value, Parity.XY);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 * @param parent {@link Parent} the parent
	 */
	public Cluster(Fornax key, Columbia value, Spacetime parent) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, key, value, parent);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cluster(Class<Galaxy> antitype) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, antitype, Parity.XY);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 */
	public Cluster(Class<Galaxy> antitype, Fornax key, Columbia value) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Cluster} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 * @param parent {@link Spacetime} the parent
	 */
	public Cluster(Class<Galaxy> antitype, Fornax key, Columbia value, Spacetime parent) {
		super(Hyperlepton.class, Lepton.class, Cluster.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Capricornus) {
				// cast source
				Capricornus pair = (Capricornus) event.getSource();
				// make pair free
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#run()
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
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Cluster : false) {
			// cast source
			Cluster pair = (Cluster) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hyperlepton(Lepton.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}