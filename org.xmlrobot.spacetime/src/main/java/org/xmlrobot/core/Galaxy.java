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
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.spacetime.Perseus;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Galaxy implementation class.
 * @author joan
 * @parity XX
 * @since 41162.2
 */
@XmlRootElement
public class Galaxy 
	extends Parent<Columbia,Fornax> {

	/**
	 * -2596731065653123335L
	 */
	private static final long serialVersionUID = -2596731065653123335L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Columbia getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Columbia setKey(Columbia key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Fornax getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Fornax setValue(Fornax value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Lepton.class)
	public Mass<Columbia,Fornax> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Galaxy} default class constructor.
	 */
	public Galaxy() {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, Parity.XX);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 */
	public Galaxy(Columbia key, Fornax value) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, key, value, Parity.XY);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 * @param parent {@link Minkowski} the parent
	 */
	public Galaxy(Columbia key, Fornax value, Minkowski parent) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, key, value, parent);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Galaxy(Class<Cluster> antitype) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, antitype, Parity.XX);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 */
	public Galaxy(Class<Cluster> antitype, Columbia key, Fornax value) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Galaxy} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 * @param parent {@link Minkowski} the parent
	 */
	public Galaxy(Class<Cluster> antitype, Columbia key, Fornax value, Minkowski parent) {
		super(Lepton.class, Hyperlepton.class, Galaxy.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Perseus) {
				// cast source
				Perseus pair = (Perseus) event.getSource();
				// rip
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
				child instanceof Galaxy : false) {
			// cast source
			Galaxy pair = (Galaxy) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Lepton(Hyperlepton.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}