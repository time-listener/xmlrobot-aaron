package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.antimatter.Hyperhiggs;

/**
 * root's particle implementation class.
 * @author joan
 * @parity XX
 * @since 41160.3
 */
@XmlRootElement
public class Higgs 
	extends Antineutron<Andromeda,MilkyWay> {

	/**
	 * 8168068608683637802L
	 */
	private static final long serialVersionUID = 8168068608683637802L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Andromeda getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Andromeda setKey(Andromeda key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public MilkyWay getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public MilkyWay setValue(MilkyWay value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Higgs} default class constructor.
	 */
	public Higgs() {
		super(Higgs.class);
	}
	/**
	 * {@link Higgs} class constructor.
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 */
	public Higgs(Andromeda key, MilkyWay value) {
		super(Higgs.class, key, value);
	}
	/**
	 * {@link Higgs} class constructor.
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link Muon} the parent
	 */
	public Higgs(Andromeda key, MilkyWay value, Muon parent) {
		super(Higgs.class, key, value, parent);
	}
	/**
	 * {@link Higgs} class constructor.
	 * @param antitype the antitype
	 */
	public Higgs(Class<Hyperhiggs> antitype) {
		super(Higgs.class, antitype);
	}
	/**
	 * {@link Higgs} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 */
	public Higgs(Class<Hyperhiggs> antitype, Andromeda key, MilkyWay value) {
		super(Higgs.class, antitype, key, value);
	}
	/**
	 * {@link Higgs} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Andromeda} the key
	 * @param value {@link MilkyWay} the value
	 * @param parent {@link Muon} the parent
	 */
	public Higgs(Class<Hyperhiggs> antitype, Andromeda key, MilkyWay value, Muon parent) {
		super(Higgs.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Andromeda,MilkyWay> o1, Mass<Andromeda,MilkyWay> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}

}
