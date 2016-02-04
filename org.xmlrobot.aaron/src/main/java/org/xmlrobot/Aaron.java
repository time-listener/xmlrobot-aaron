package org.xmlrobot;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.event.Antigravity;
import org.xmlrobot.event.Hyperfusion;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.DNA;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Aaron infinite. He is the master of all times. A.k.a Timemaster.
 * @author joan
 */
@XmlRootElement
public final class Aaron
	extends ScrewDriver<Universe,Subspace>
	implements DNA<Universe,Subspace>  {

	/**
	 * -9024346196425472952L
	 */
	private static final long serialVersionUID = -9024346196425472952L;
	
	/**
	 * {@link Aaron} default class constructor.
	 */
	public Aaron() {
		super(Hyperbrain.class, Hypermind.class, Aaron.class, Parity.YY);
	}
	/**
	 * {@link Aaron} class constructor.
	 * @param antitype the antitype
	 */
	public Aaron(Class<Robot> antitype) { 
		super(Hyperbrain.class, Hypermind.class, Aaron.class, antitype, Parity.YY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperplasma) {
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// declare future
				Mass<Subspace,Universe> future;
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
			if(event.getSource() instanceof Universe) {
				// cast source
				Universe dna = (Universe) event.getSource();
				// send pulse to the future
				getValue().pulse(this, new Antigravity(dna));
			}
			else if(event.getSource() instanceof Hyperplasma){
				// cast source
				Hyperplasma source = (Hyperplasma) event.getSource();
				// declare child
				Mass<Universe,Subspace> child;
				// call
				if((child = getChild()) != null) {
					// emit pulse
					child.pulse(this, new Hyperfusion(source));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperplasma) {
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// transfer message to the future
				get().putValue(pair.getKey(), pair.getValue());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#putValue(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public Subspace putValue(Universe key, Subspace value) {
		// declare child
		Mass<Universe,Subspace> child;
		// declare old value
		Subspace oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key,	value) : null) == null) {
			// create child
			Hypertoroid pair = new Hypertoroid(Hyperplasma.class, key, value, this);
			// push child
			pair.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.Screw#run()
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
		if((source = getContext().getService(ref)) instanceof Hypertoroid) {

			Hypertoroid pair = (Hypertoroid) source;
			
			if(event.getType() == ServiceEvent.REGISTERED) {
				// input to the brain
				replicator().putValue(pair.getKey(), pair.getValue());
			}
			if(event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				replicator().removeByKey(pair.getKey());
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Subspace get(Universe key) {
		Mass<Universe,Subspace> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace put(Universe key, Subspace value) {
		return putValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(Atlas<? extends Universe,? extends Subspace,? extends Mass<Universe,Subspace>> m) {
		
		for(Mass<Universe,Subspace> child : m)
			putValue(child.getKey(), child.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#keySet()
	 */
	@Override
	public Congregation<Universe> keySet() {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.keyView() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#values()
	 */
	@Override
	public Congregation<Subspace> values() {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.valueView() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Universe,Subspace>> entrySet() {
		// turn back child
		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace getOrDefault(Universe key, Subspace defaultValue) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Universe, ? super Subspace> action) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		if((child = getChild()) != null)
			child.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace putIfAbsent(Universe key, Subspace value) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Universe key, Subspace value) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Universe key, Subspace oldValue, Subspace newValue) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace replace(Universe key, Subspace value) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(
			BiFunction<? super Universe, ? super Subspace, ? extends Subspace> function) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		if((child = getChild()) != null)
			child.replaceAllValues(function);
	}
}