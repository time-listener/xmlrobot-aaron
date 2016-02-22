package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.positron.Antiproton;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.antimatter.Hypergluon;
import org.xmlrobot.spacetime.antimatter.Hyperphoton;
import org.xmlrobot.util.Command;

/**
 * Photon implementation class.
 * 
 * A photon is an elementary particle, the quantum of light and all other forms of electromagnetic radiation. 
 * It is the force carrier for the electromagnetic force, even when static via virtual photons. 
 * The effects of this force are easily observable at the microscopic and at the macroscopic level, 
 * because the photon has zero rest mass; this allows long distance interactions. 
 * Like all elementary particles, photons are currently best explained by quantum mechanics and exhibit 
 * wave–particle duality, exhibiting properties of waves and of. For example, a single photon 
 * may be refracted by a lens or exhibit wave interference with itself, but also act as a particle 
 * giving a definite result when its position is measured. Waves and quanta, being two observable 
 * aspects of a single phenomenon, cannot have their true nature described in terms of any mechanical model.
 * 
 * It's elementary antiparticle is {@link Hyperphoton}.
 * 
 * @author joan
 * @parity XX
 * @since 41155.3
 */
@XmlRootElement
public class Photon 
	extends Antiproton<Saturn,Jupiter> {

	/**
	 * 8804208983784652129L
	 */
	private static final long serialVersionUID = 8804208983784652129L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getKey()
	 */
	@Override
	@XmlElement
	public Saturn getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setKey(java.lang.Object)
	 */
	@Override
	public Saturn setKey(Saturn key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#getValue()
	 */
	@Override
	@XmlElement
	public Jupiter getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#setValue(java.lang.Object)
	 */
	@Override
	public Jupiter setValue(Jupiter value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Photon} default class constructor.
	 */
	public Photon() {
		super(Photon.class);
	}
	/**
	 * {@link Photon} class constructor.
	 * @param antitype the antitype
	 */
	public Photon(Class<Hyperphoton> antitype) {
		super(Photon.class, antitype);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?, ?> event) {
		super.mass(sender, event);
		switch (event.getCommand()) {
		case ORDER:
			if(event.getSource() instanceof Hypergluon) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Hypergluon pair = (Hypergluon) event.getSource();
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
		case SEND:
			if(event.getSource() instanceof Hypergluon) {
				// declare stem
				Mass<Jupiter,Saturn> stem;
				// cast source
				Hypergluon pair = (Hypergluon) event.getSource();
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
			if(event.getSource() instanceof Hypergluon) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Hypergluon pair = (Hypergluon) event.getSource();
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
			if(event.getSource() instanceof Hypergluon) {
				// declare stem
				Mass<Jupiter,Saturn> future;
				// cast source
				Hypergluon pair = (Hypergluon) event.getSource();
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
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antiproton#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Jupiter put(Saturn key, Jupiter value) {
		// create child
		Gluon pair = new Gluon(Hypergluon.class, key, value, this);
		// push child
		pair.push(Command.SEND);
		return null;
	}
}