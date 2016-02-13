/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.BasePair;
import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.antimatter.Hyperrna;
import org.xmlrobot.dna.matter.Rna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Groove implementation class.
 * @author joan
 * @parity XY
 * @since 1520.1
 */
@XmlRootElement
public class Groove 
	extends Parent<Cromosoma,Diploid> {

	/**
	 * 5769021798206302143L
	 */
	private static final long serialVersionUID = 5769021798206302143L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Cromosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cromosoma setKey(Cromosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Diploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Diploid setValue(Diploid value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperrna.class)
	public Mass<Cromosoma,Diploid> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Groove} default class constructor.
	 */
	public Groove() {
		super(Hyperrna.class, Rna.class, Groove.class, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 */
	public Groove(Cromosoma key, Diploid value) {
		super(Hyperrna.class, Rna.class, Groove.class, key, value, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link Ribosoma} the parent
	 */
	public Groove(Cromosoma key, Diploid value, Ribosoma parent) {
		super(Hyperrna.class, Rna.class, Groove.class, key, value, parent);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Groove(Class<Plasmid> antitype) {
		super(Hyperrna.class, Rna.class, Groove.class, antitype, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 */
	public Groove(Class<Plasmid> antitype, Cromosoma key, Diploid value) {
		super(Hyperrna.class, Rna.class, Groove.class, antitype, key, value, Parity.XY);
	}
	/**
	 * {@link Groove} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Cromosoma} the key
	 * @param value {@link Diploid} the value
	 * @param parent {@link Ribosoma} the parent
	 */
	public Groove(Class<Plasmid> antitype, Cromosoma key, Diploid value, Ribosoma parent) {
		super(Hyperrna.class, Rna.class, Groove.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			
			if(event.getSource() instanceof BasePair) {
				// cast source
				BasePair pair = (BasePair) event.getSource();
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
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare child
		Object child;
		// assign and check
		if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Groove : false) {
			// cast source
			Groove pair = (Groove) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Hyperrna(Rna.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}