package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.dna.antimatter.Adam;
import org.xmlrobot.dna.antimatter.Sperma;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * @author joan
 * @parity XX
 * @since 1521.3
 */
@XmlRootElement
public class Eva 
	extends Antiproton<Tetraploid,Ribosoma> {

	/**
	 * -6997122399197352077L
	 */
	private static final long serialVersionUID = -6997122399197352077L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Tetraploid getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Tetraploid setKey(Tetraploid key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Ribosoma getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Ribosoma setValue(Ribosoma value) {
		return super.setValue(value);
	}
	
	/**
	 * 
	 */
	public Eva() {
		super(Eva.class);
	}
	/**
	 * @param antitype
	 */
	public Eva(Class<Adam> antitype) {
		super(Eva.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Sperma) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Sperma pair = (Sperma) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// release child
					stem.order(pair);
				}
			}
			break;
		case PUSH:
			if(event.getSource() instanceof Sperma) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Sperma pair = (Sperma) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.add(pair);
				}
			}
			break;
		case RELEASE:
			if(event.getSource() instanceof Sperma) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Sperma pair = (Sperma) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ? 
						!stem.isEmpty() ? 
								stem.contains(pair) 
								: false
						: false) {
					// release child
					stem.remove(pair);
				}
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof Sperma) {
				// declare stem
				Mass<Ribosoma,Tetraploid> stem;
				// cast source
				Sperma pair = (Sperma) event.getSource();
				// check if empty and chained
				if((stem = get()) != null ?
						!stem.isEmpty() ? 
								!stem.contains(pair) 
								: true
						: false) {
					// push child
					stem.submit(pair);
				}
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Ribosoma put(Tetraploid key, Ribosoma value) {
		// declare child
		Mass<Tetraploid,Ribosoma> child;
		// declare old value
		Ribosoma oldValue;
		// if update unsuccessful
		if ((oldValue = (child = getChild()) != null ? 
				child.putValue(key, value) : null) == null) {
			// create child
			Ovum pair = new Ovum(Sperma.class, key, value, this);
			// push child
			pair.push(Command.PUSH);
		}
		return oldValue;
	}
}
