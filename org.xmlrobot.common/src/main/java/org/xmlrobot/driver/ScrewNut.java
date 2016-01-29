/**
 * 
 */
package org.xmlrobot.driver;

import java.util.Iterator;
import java.util.Objects;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Chain;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlTransient
public abstract class ScrewNut
	<K extends TimeListener<? super K,? super V>, 
	 V extends TimeListener<? super V,? super K>>
		extends ScrewDriver<K,V> 
		   implements Chain<K,V> {
	
	/**
	 * -3034534042797671430L
	 */
	private static final long serialVersionUID = -3034534042797671430L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	public K getKey() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public K setKey(K key) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	public V getValue() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public V setValue(V value) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.setValue(value) : null;
	}
	
	/**
	 * {@link ScrewNut} default class constructor.
	 */
	public ScrewNut() {
		super();
	}
	/**
	 * {@link ScrewNut} default class constructor.
	 * @param type the inherited type
	 */
	public ScrewNut(Class<? extends Mass<K,V>> positive, 
			Class<? extends Mass<V,K>> negative,
			Class<? extends ScrewNut<K,V>> type) {
		super(positive, negative, type, Parity.XX);
	}
	/**
	 * {@link ScrewNut} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 */
	public ScrewNut(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter,
			Class<? extends ScrewNut<K,V>> type,
					Class<? extends Screw<V,K>> antitype) {
		super(matter, antimatter, type, antitype, Parity.XX);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public abstract V putValue(K key, V value);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener, Takion<Y,X> event) {
		super.pulse(listener, event);
		// revolve inheritance
 		spin();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#compare(org.xmlrobot.driver.ScrewDriver, org.xmlrobot.driver.ScrewDriver)
	 */
	@Override
	public synchronized int compare(Mass<K,V> o1, Mass<K,V> o2) {

		if(o1 != null){
			
			if(o2 != null) {
				
				return ScrewDriver.superCompare(o1.getChild(), o2.getChild()); 
			}
			return 1;
		}
		else if(o2 != null) {
			return -1;
		}
		else {
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.Congregation)
	 */
	public boolean removeAll(ScrewDriver<K,V> c) {
		
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<K,V>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<K,V>> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
    }
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Entity#matrix(java.lang.Class)
 	 */
 	@Override
 	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {
 	
 		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (matrix = new Translocator());
 	}
    /* (non-Javadoc)
     * @see org.xmlrobot.driver.ScrewDriver#run()
     */
    @Override
    public void run() {
    	// inheritance cycle starts here
    	super.run();
    	// inheritance cycle ends here
    	push(Command.TRANSFER);
    }
	/**
	 * It does the translocation by cloning matrix inputs via inject/push methods. 
	 * For example, the proton translocation or the chromosomic translocation.
	 * 
	 * @author joan
	 *
	 */
	protected class Translocator
 		extends Transmuter {
		
 		/**
 		 * {@link Translocator} default class constructor.
		 */
		public Translocator() {
			// construct transmuter
			super();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Star#push(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void push(Mass<K,V> child) {
			Mass<K,V> key = child.call().clone();
			Mass<V,K> value = child.get().clone();
			
			key.set(value);
			value.set(key);
			
			super.push(child.clone());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Star#inject(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void inject(Mass<V, K> child) {
			// message re-transmission
			super.inject(child.clone());
		}
 	}
}
