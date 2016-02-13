package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.matter.Higgs;

/**
 * Hyperhiggs implementation class.
 * @author joan
 * @parity XY
 * @since 41160.4
 */
@XmlRootElement
public class Hyperhiggs 
	extends Antineutron<MilkyWay,Andromeda> {

	/**
	 * -7362327731493805890L
	 */
	private static final long serialVersionUID = -7362327731493805890L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public MilkyWay getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public MilkyWay setKey(MilkyWay key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Andromeda getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Andromeda setValue(Andromeda value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs() {
		
		super();
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs(MilkyWay key, Andromeda value) {
		
		super(Hyperhiggs.class, key, value);
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Hypermuon} the parent
	 */
	public Hyperhiggs(MilkyWay key, Andromeda value, Hypermuon parent) {
		
		super(Hyperhiggs.class, key, value, parent);
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param antitype the antitype
	 */
	public Hyperhiggs(Class<Higgs> antitype) {
		
		super(Hyperhiggs.class, antitype);
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param antitype the antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 */
	public Hyperhiggs(Class<Higgs> antitype, MilkyWay key, Andromeda value) {
		
		super(Hyperhiggs.class, antitype, key, value);
	}
	/**
	 * {@link Hyperhiggs} default class constructor.
	 * @param antitype the antitype
	 * @param key {@link MilkyWay} the key
	 * @param value {@link Andromeda} the value
	 * @param parent {@link Hypermuon} the parent
	 */
	public Hyperhiggs(Class<Higgs> antitype, MilkyWay key, Andromeda value, Hypermuon parent) {
		
		super(Hyperhiggs.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<MilkyWay,Andromeda> o1, Mass<MilkyWay,Andromeda> o2) {

		return o1.getKey().compareTo(o2.getValue());
	}
}
