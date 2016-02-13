package org.xmlrobot.spacetime.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.matter.BosonW;

/**
 * HyperbosonW implementation class.
 * @author joan
 * @parity XY
 * @since 41158.4
 */
@XmlRootElement
public class HyperbosonW 
	extends Antineutron<Sun,AlphaCentauri> {

	/**
	 * 1745339382778302728L
	 */
	private static final long serialVersionUID = 1745339382778302728L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Sun getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Sun setKey(Sun key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public AlphaCentauri setValue(AlphaCentauri value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link HyperbosonW} default class constructor.
	 */
	public HyperbosonW() {
		super();
	}
	/**
	 * {@link HyperbosonW} class constructor.
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 */
	public HyperbosonW(Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, key, value);
	}
	/**
	 * {@link HyperbosonW} class constructor.
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link HyperbosonZ} the parent
	 */
	public HyperbosonW(Sun key, AlphaCentauri value, HyperbosonZ parent) {
		super(HyperbosonW.class, key, value, parent);
	}
	/**
	 * {@link HyperbosonW} class constructor.
	 * @param antitype the antitype
	 */
	public HyperbosonW(Class<BosonW> antitype) {
		super(HyperbosonW.class, antitype);
	}
	/**
	 * {@link HyperbosonW} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 */
	public HyperbosonW(Class<BosonW> antitype, Sun key, AlphaCentauri value) {
		super(HyperbosonW.class, antitype, key, value);
	}
	/**
	 * {@link HyperbosonW} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Sun} the key
	 * @param value {@link AlphaCentauri} the value
	 * @param parent {@link HyperbosonZ} the parent
	 */
	public HyperbosonW(Class<BosonW> antitype, Sun key, AlphaCentauri value, HyperbosonZ parent) {
		super(HyperbosonW.class, antitype, key, value, parent);
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
	public int compare(Mass<Sun,AlphaCentauri> o1, Mass<Sun,AlphaCentauri> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}