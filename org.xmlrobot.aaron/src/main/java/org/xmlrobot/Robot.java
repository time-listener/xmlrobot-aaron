package org.xmlrobot;

import java.util.Iterator;
import java.util.Objects;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.event.Gravity;
import org.xmlrobot.event.Hyperfission;
import org.xmlrobot.genesis.Chain;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * I, Robot.
 * @author joan
 */
public class Robot 
	extends ScrewDriver<Subspace,Universe>
		implements Chain<Subspace,Universe> {

	/**
	 * -3478889532242260284L
	 */
	private static final long serialVersionUID = -3478889532242260284L;

	/**
	 * {@link Robot} default class constructor.
	 */
	public Robot() {
		super(Hypermind.class, Hyperbrain.class, Robot.class, Parity.YY);
	}
	/**
	 * {@link Robot} class constructor.
	 * @param antitype the antitype
	 */
	public Robot(Class<Aaron> antitype) {
		super(Hypermind.class, Hyperbrain.class, Robot.class, antitype, Parity.YY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hypertoroid) {
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
				// declare future
				Mass<Universe,Subspace> future;
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					future.add(pair);
				}
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Subspace) {
				
				Subspace key = (Subspace) event.getSource();
				
				getValue().pulse(this, new Gravity(key));
			}
			else if(event.getSource() instanceof Hypertoroid){
				// cast source
				Hypertoroid source = (Hypertoroid) event.getSource();
				// declare child
				Mass<Subspace,Universe> child;
				// call
				if((child = getChild()) != null) {
					// emit pulse
					child.pulse(this, new Hyperfission(source));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hypertoroid) {
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
				// transfer message to the future
				get().putValue(pair.getKey(), pair.getValue());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#putValue(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Universe putValue(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// declare old value
		Universe oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hyperplasma pair = new Hyperplasma(Hypertoroid.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public boolean removeAll(Mass<Subspace,Universe> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<Subspace,Universe>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<Subspace,Universe>> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewNut#run()
	 */
	@Override
	public void run() {
		// start life
		super.run();
		// aaron infinite
		push(Command.RESURRECTION);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare source
		Object source;
		// get entity
		if ((source = getContext().getService(ref)) instanceof Hyperplasma) {
			// cast source
			Hyperplasma pair = (Hyperplasma) source;
			// switch command
			if (event.getType() == ServiceEvent.REGISTERED) {
				// input to the brain
				replicator().putValue(pair.getKey(), pair.getValue());
			}
			if (event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				replicator().removeByKey(pair.getKey());
			}
		}
	}
}