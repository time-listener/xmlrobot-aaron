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
import org.xmlrobot.core.event.Antigravity;
import org.xmlrobot.event.Hyperfusion;
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
 * Aaron infinite. He is the master of all times. A.k.a Timemaster.
 * 
 * @author joan
 * @parity YY
 * @since 41165.1
 */
@XmlRootElement
public final class Aaron
	extends Parent<Universe,Subspace>
	implements Entity<Universe,Subspace>  {

	/**
	 * -9024346196425472952L
	 */
	private static final long serialVersionUID = -9024346196425472952L;
	
    /* (non-Javadoc)
     * @see org.xmlrobot.inheritance.Parent#getName()
     */
    @Override
	@XmlElement
    public String getName() {
    
    	return "Aaron";
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getKey()
	 */
	@Override
	@XmlElement
	public Universe getKey() {
		Mass<Universe,Subspace> child;
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Universe setKey(Universe key) {
		Mass<Universe,Subspace> child;
		if((child = getChild()) != null )
			return child.setKey(key);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getValue()
	 */
	@Override
	@XmlElement
	public Subspace getValue() {
		Mass<Universe,Subspace> child;
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#setValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Subspace setValue(Subspace value) {
		Mass<Universe,Subspace> child;
		if((child = getChild()) != null )
			return child.setValue(value);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.inheritance.Parent#getReplicator()
	 */
	@Override
	@XmlElement(type=Hyperbrain.class)
	public Mass<Universe,Subspace> getReplicator() {
		return super.getReplicator();
	}
	
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
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<Universe,Subspace>> entrySet() {
		// turn back child
		return getChild();
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
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public Subspace get(Universe key) {
		Mass<Universe,Subspace> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
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
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hyperplasma) {
				// declare future
				Mass<Subspace,Universe> future;
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// check if empty and chained
				if((future = get()) != null ? 
						!future.isEmpty() ? 
								!future.contains(pair) 
								: true
						: false) {
					// order child
					future.order(pair);
				}
			}
			break;
		case PUSH:
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
		case LISTEN:
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
		case RELEASE:
			if(event.getSource() instanceof Hyperplasma) {
				// declare stem
				Mass<Subspace,Universe> future;
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
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
			if(event.getSource() instanceof Hyperplasma) {
				// declare stem
				Mass<Subspace,Universe> future;
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
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
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Subspace put(Universe key, Subspace value) {
		// create child
		Hypertoroid pair = new Hypertoroid(Hyperplasma.class, key, value, this);
		// push child
		pair.push(Command.PUSH);
		return null;
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
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public boolean removeAll(Mass<Universe,Subspace> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<Universe,Subspace>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<Universe,Subspace>> i = iterator(); i.hasNext(); ) {
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
	public Subspace replace(Universe key, Subspace value) {
		// declare child
		Mass<Universe,Subspace> child;
		// check existence and channel
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
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
			// The resurrection of Aaron
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
				child instanceof Hypertoroid : false) {
			// cast source
			Hypertoroid pair = (Hypertoroid) child;
			
			if(event.getType() == ServiceEvent.REGISTERED) {
				// input to the positronic brain
				getReplicator().putValue(pair.getKey(), pair.getValue());
			}
			if(event.getType() == ServiceEvent.UNREGISTERING) {
				// rest in peace
				getReplicator().removeByKey(pair.getKey());
			}
		}
	}
}