package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.dna.matter.Eva;
import org.xmlrobot.dna.matter.Ovum;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.util.Command;

/**
 * Adam implementation class.
 * @author joan
 * @parity XY
 * @since 1521.4
 */
@XmlRootElement
public class Adam 
	extends Antiproton<Ribosoma,Tetraploid> {

	/**
	 * -7001412700159246172L
	 */
	private static final long serialVersionUID = -7001412700159246172L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Ribosoma getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Ribosoma setKey(Ribosoma key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Tetraploid getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Tetraploid setValue(Tetraploid value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Adam} default class constructor.
	 */
	public Adam() {
		super(Adam.class);
	}
	/**
	 * {@link Adam} class constructor.
	 * @param antitype the antitype
	 */
	public Adam(Class<Eva> antitype) {
		super(Adam.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?, ?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Ovum) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Ovum pair = (Ovum) event.getSource();
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
		case SEND:
			if(event.getSource() instanceof Ovum) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Ovum pair = (Ovum) event.getSource();
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
			if(event.getSource() instanceof Ovum) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Ovum pair = (Ovum) event.getSource();
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
			if(event.getSource() instanceof Ovum) {
				// declare stem
				Mass<Tetraploid,Ribosoma> stem;
				// cast source
				Ovum pair = (Ovum) event.getSource();
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
	 * @see org.xmlrobot.positron.Antiproton#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Tetraploid put(Ribosoma key, Tetraploid value) {
		// create child
		Sperma pair = new Sperma(Ovum.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}