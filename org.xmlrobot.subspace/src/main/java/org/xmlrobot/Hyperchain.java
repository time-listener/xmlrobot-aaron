package org.xmlrobot;

import java.util.Iterator;
import java.util.Objects;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.antimatter.Hyperdatagram;
import org.xmlrobot.event.Instant;
import org.xmlrobot.genesis.Chain;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hyperword;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;

/**
 * {@link Hyperstring}'s {@link Chain} implementation class.
 * <br>
 * @author joan
 */
public class Hyperchain
	extends Hyperinteger 
		implements Chain<Integer,Character> {

	/**
	 * -5554421412799541676L
	 */
	private static final long serialVersionUID = -5554421412799541676L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	public Integer getKey() {
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Integer setKey(Integer key) {
		Mass<Integer,Character> child;	
		return (child = getChild()) != null ? child.setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	public Character getValue() {
		Mass<Integer,Character> child;	
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Character setValue(Character value) {
		Mass<Integer,Character> child;	
		return (child = getChild()) != null ? child.setValue(value) : null;
	}
	/**
	 * {@link Hyperchain} default class constructor.
	 */
	public Hyperchain() {
		super(Hyperword.class, Hyperdatagram.class, Hyperchain.class);
	}
	/**
	 * {@link Hyperchain} class constructor.
	 * @param antitype the inherited antitype
	 */
	public Hyperchain(Class<Hypercube> antitype) {
		super(Hyperword.class, Hyperdatagram.class, Hyperchain.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hyperinteger#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<Integer,Character> o1, Mass<Integer,Character> o2) {
		// traditional recursive syntax
		if(o1 != null) {
			
			if(o2 != null) {
				// get current alphabetical pairs difference
				int cmp = Character.compare(o1.getValue(), o2.getValue());
				// call recursion
				cmp += compare(o1.getChild(), o2.getChild());
				// return computation result
				return cmp;
			}
			else {
				// append value
				return o1.getValue();
			}
		}
		else if(o2 != null) {
			// append value
			return -o2.getValue();
		}
		else {
			// starting-finishing
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#compareTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compareTo(Mass<Character,Integer> o) {
	
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<Character,Integer> o) {
	
		Mass<Integer,Character> protoXX = matrix().output();
		Mass<Character,Integer> protoXY = o.matrix().output();
		
		return protoXX.matrix().reproduce(protoXX.getChild(), protoXY.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#iterator()
	 */
	@Override
	public Iterator<Mass<Integer,Character>> iterator() {
	
		Mass<Integer,Character> child;
		return (child = getChild()) != null ? child.iterator() : super.iterator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {

		super.mass(sender, event);
		
		switch (event.command()) {
		case SUBMIT:
			if(event.getSource() instanceof Hyperpair) {
				// give him the universe
				event.getSource().start(context());
			}
			break;
		case GENESIS:
			if(event.getSource() instanceof Hyperpair) {
				// cast source
				Hyperpair string = (Hyperpair) event.getSource();
				// declare child of inheritance
				Mass<Integer,Character> child;
				// assign and check
				if((child = getChild()) != null) {
					// send pulse across the future
					child.pulse(this, new Instant(string));
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperpair) {
				// remove from hyperspace
				event.getSource().stop(context());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Future#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener, Takion<Y,X> event) {
		super.pulse(listener, event);
		// spin -1/2 inheritance
		spin();
		// declare source
		TimeListener<Y,X> source;
		// switch by source type 
		if( (source = event.getSource()) instanceof Hyperpair) {
			// declare child
			Mass<Integer,Character> child;
			// pulse retransmission
			if((child = getChild()) != null)
				child.pulse(listener, event);	
		}
		else if(source instanceof Hypercube) {
			// consecrate comparison
			reproduceTo((Hypercube) source);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Past#echo(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void echo(TimeListener<?,?> listener, Takion<X,Y> event) {
		
		if(event.getSource() instanceof Hyperinteger) {
			// iterate through event's children
			for(X integer : event) {
				// load output result to current matrix
				matrix().push((Hyperinteger)integer);
			}	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putNegative(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Character putValue(Integer key, Character value) {
		// declare child
		Mass<Integer,Character> child;
		// declare old value
		Character oldValue;
		// if update unsuccessful
		if((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Hyperentry gene = new Hyperentry(Hyperpair.class, key, value, this);
			// push child
			gene.push(Command.SUBMIT);
		}
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public boolean removeAll(Mass<Integer,Character> c) {

        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<Integer,Character>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<Integer,Character>> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.lang.Hyperinteger#run()
	 */
	@Override
	public void run() {
	
		super.run();
		// rest in peace
		push(Command.TRANSFER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<Integer,Character>,Mass<Character,Integer>> matrix() {

		TimeListener.Transmitter<Mass<Integer,Character>,Mass<Character,Integer>> m;
 		return (m = matrix) != null ? m : (Hypertube) (matrix = new Hypertube());
	}
	/**
	 * @author joan
	 *
	 */
	protected class Hypertube 
		extends Transmuter {

		/**
		 * @throws Abort
		 */
		public Hypertube() throws Abort {
			super();

		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperinteger.Hypergrid#push(org.xmlrobot.lang.Hyperinteger)
		 */
		@Override
		public void push(Mass<Integer,Character> child) {
		
			output().add(child.clone());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.lang.Hyperinteger.Hypergrid#inject(org.xmlrobot.lang.Hyperstring)
		 */
		@Override
		public void inject(Mass<Character,Integer> child) {
			
			output().get().add(child.clone());
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String name() {
		
		return getChild().name();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {

		Object source = context().getService(event.getServiceReference());
		
		if(source instanceof Hyperentry) {
			// cast source
			Hyperentry pair = (Hyperentry) source;
			// commute command
			if(event.getType() == ServiceEvent.REGISTERED) {
				
				if(replicator().contains(pair));
					// start entity's time
					execute(pair);
			}
			else if(event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				context().ungetService(event.getServiceReference());
			}
		}
	}


}
