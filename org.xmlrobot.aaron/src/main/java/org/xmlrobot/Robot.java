package org.xmlrobot;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.antimatter.Hyperbrain;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.core.event.Gravity;
import org.xmlrobot.event.Hyperfission;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.inheritance.Parent;
import org.xmlrobot.matter.Hypermind;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * I, Robot.
 * @author joan
 * @parity YY
 * @since 41165.2
 */
@XmlRootElement
public class Robot 
	extends Parent<Subspace,Universe>
	implements Entity<Subspace,Universe> {

	/**
	 * -3478889532242260284L
	 */
	private static final long serialVersionUID = -3478889532242260284L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Subspace getKey() {
		Mass<Subspace,Universe> child;
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Subspace setKey(Subspace key) {
		Mass<Subspace,Universe> child;
		if((child = getChild()) != null)
			return child.setKey(key);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Universe getValue() {
		Mass<Subspace,Universe> child;
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Universe setValue(Universe value) {
		Mass<Subspace,Universe> child;
		if((child = getChild()) != null)
			return child.setValue(value);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Hypermind.class)
	public Mass<Subspace,Universe> getReplicator() {
		return super.getReplicator();
	}
	
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
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Subspace, Universe>> entrySet() {

		return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super Subspace, ? super Universe> action) {
		// declare child
		Mass<Subspace, Universe> child;
		// check existence and channel
		if ((child = getChild()) != null)
			child.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Universe get(Subspace key) {
		Mass<Subspace,Universe> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe getOrDefault(Subspace key, Universe defaultValue) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : null;
	}
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);

		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hypertoroid) {
				// declare future
				Mass<Universe,Subspace> future;
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// release child
					future.order(pair);
				}
			}
			break;
		case PUSH:
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
		case LISTEN:
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
		case RELEASE:
			if(event.getSource() instanceof Hypertoroid) {
				// declare stem
				Mass<Universe,Subspace> future;
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								future.contains(pair) 
								: false
						: false) {
					// release child
					future.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Hypertoroid) {
				// declare stem
				Mass<Universe,Subspace> future;
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// push child
					future.submit(pair);
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
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe put(Subspace key, Universe value) {
		// create child
		Hyperplasma pair = new Hyperplasma(Hypertoroid.class, key, value, this);
		// push child
		pair.push(Command.PUSH);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(
			Atlas<? extends Subspace, ? extends Universe, ? extends Mass<Subspace, Universe>> m) {

		for(Mass<Subspace,Universe> pair : m)
			put(pair.getKey(), pair.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe putIfAbsent(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.removeByKey(key, value) : null;
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
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Universe replace(Subspace key, Universe value) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(Subspace key, Universe oldValue, Universe newValue) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(
			BiFunction<? super Subspace, ? super Universe, ? extends Universe> function) {
		// declare child
		Mass<Subspace,Universe> child;
		// check existence and channel
		if((child = getChild()) != null)
			child.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#run()
	 */
	@Override
	public void run() {
		// avoid concurrent calls to run
		if (!message.compareAndSet(RUNNER, null, Thread.currentThread())) {
			// because is already running
			return;
		} else {
			// life starts here
			super.run();
			// life ends here
			push(Command.RESURRECTION);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare source
		Object child;
		// get entity
		if((child = ref.getProperty(TimeListener.KEY)) != null ? 
				child instanceof Hyperplasma : false) {
			// cast source
			Hyperplasma pair = (Hyperplasma) child;
			// switch command
			if (event.getType() == ServiceEvent.REGISTERED) {
				// input to the brain
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			if (event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}