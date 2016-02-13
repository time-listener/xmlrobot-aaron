/**
 * 
 */
package org.xmlrobot.dna;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.dna.Allele;
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
 * Plasmid implementation class.
 * @author joan
 * @parity XX
 * @since 1520.2
 */
@XmlRootElement
public class Plasmid 
	extends Parent<Diploid,Cromosoma> {

	/**
	 * 2106329525287215569L
	 */
	private static final long serialVersionUID = 2106329525287215569L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlElement
	public Diploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Diploid setKey(Diploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlElement
	public Cromosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Cromosoma setValue(Cromosoma value) {
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getReplicator()
	 */
	@Override
	@XmlElement(type=Rna.class)
	public Mass<Diploid,Cromosoma> getReplicator() {
		return super.getReplicator();
	}
	
	/**
	 * {@link Plasmid} default class constructor.
	 */
	public Plasmid() {
		super(Rna.class, Hyperrna.class, Plasmid.class, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 */
	public Plasmid(Diploid key, Cromosoma value) {
		super(Rna.class, Hyperrna.class, Plasmid.class, key, value, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link Tetraploid} the parent
	 */
	public Plasmid(Diploid key, Cromosoma value, Tetraploid parent) {
		super(Rna.class, Hyperrna.class, Plasmid.class, key, value, parent);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Plasmid(Class<Ribosoma> antitype) {
		super(Rna.class, Hyperrna.class, Plasmid.class, antitype, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 */
	public Plasmid(Class<Groove> antitype, Diploid key, Cromosoma value) {
		super(Rna.class, Hyperrna.class, Plasmid.class, antitype, key, value, Parity.XX);
	}
	/**
	 * {@link Plasmid} class constructor.
	 * @param antitype the inherited antitype
	 * @param key {@link Diploid} the key
	 * @param value {@link Cromosoma} the value
	 * @param parent {@link Tetraploid} the parent
	 */
	public Plasmid(Class<Groove> antitype, Diploid key, Cromosoma value, Tetraploid parent) {
		super(Rna.class, Hyperrna.class, Plasmid.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Allele) {
				// cast
				Allele pair = (Allele) event.getSource();
				// rip
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
				child instanceof Plasmid : false) {
			// cast source
			Plasmid pair = (Plasmid) child;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				// replicate mass
				getReplicator().add(new Rna(Hyperrna.class, pair.getKey(), pair.getValue()));
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}