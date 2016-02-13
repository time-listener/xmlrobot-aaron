/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Groove;
import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.dna.antimatter.Sperma;
import org.xmlrobot.dna.matter.Ovum;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Cytoplasm implementation class.
 * @author joan
 * @parity XY
 * @since 1522.1
 */
@XmlRootElement
public class Cytoplasm 
	extends Parent<Ribosoma,Tetraploid> {

	/**
	 * 2699555319928737598L
	 */
	private static final long serialVersionUID = 2699555319928737598L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Ribosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ribosoma setKey(Ribosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Tetraploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tetraploid setValue(Tetraploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Sperma.class)
	public Mass<Ribosoma,Tetraploid> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Cytoplasm} default class constructor.
	 */
	public Cytoplasm() {
		super(Sperma.class, Ovum.class, Cytoplasm.class, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 */
	public Cytoplasm(Ribosoma key, Tetraploid value) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, key, value, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Operon} the parent
	 */
	public Cytoplasm(Ribosoma key, Tetraploid value, Operon parent) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, key, value, parent);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, antitype, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Operon} the parent
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype, Ribosoma key, Tetraploid value) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Cytoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Ribosoma} the key
	 * @param value {@link Tetraploid} the value
	 * @param parent {@link Operon} the parent
	 */
	public Cytoplasm(Class<Nucleoplasm> antitype, Ribosoma key, Tetraploid value, Operon parent) {
		super(Sperma.class, Ovum.class, Cytoplasm.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Groove) { 
				// cast source
				Groove pair = (Groove) event.getSource();
				// see you next life
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#run()
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
				child instanceof Cytoplasm : false) {
			// cast source
			Cytoplasm pair = (Cytoplasm) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Sperma(Ovum.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}
