/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Plasmid;
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
 * Nucleoplasm implementation class.
 * @author joan
 * @parity XX
 * @since 1522.2
 */
@XmlRootElement
public class Nucleoplasm 
	extends Parent<Tetraploid,Ribosoma> {

	/**
	 * 3057140414113756471L
	 */
	private static final long serialVersionUID = 3057140414113756471L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Tetraploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tetraploid setKey(Tetraploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Ribosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Ribosoma setValue(Ribosoma value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Ovum.class)
	public Mass<Tetraploid,Ribosoma> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Nucleoplasm} default class constructor.
	 */
	public Nucleoplasm() {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Cell} the parent
	 */
	public Nucleoplasm(Tetraploid key, Ribosoma value) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, key, value, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Cell} the parent
	 */
	public Nucleoplasm(Tetraploid key, Ribosoma value, Cell parent) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, key, value, parent);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, antitype, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype, Tetraploid key, Ribosoma value) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Nucleoplasm} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Tetraploid} the key
	 * @param value {@link Ribosoma} the value
	 * @param parent {@link Cell} the parent
	 */
	public Nucleoplasm(Class<Cytoplasm> antitype, Tetraploid key, Ribosoma value, Cell parent) {
		super(Ovum.class, Sperma.class, Nucleoplasm.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case TRANSFER: 
			if(event.getSource() instanceof Plasmid) {
				// cast source
				Plasmid pair = (Plasmid) event.getSource();
				// free from inheritance
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
				child instanceof Nucleoplasm : false) {
			// cast source
			Nucleoplasm pair = (Nucleoplasm) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Ovum(Sperma.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}