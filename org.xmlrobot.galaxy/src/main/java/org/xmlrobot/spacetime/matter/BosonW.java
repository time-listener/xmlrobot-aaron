package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.spacetime.antimatter.HyperbosonW;

/**
 * BosonW implementation class.
 * @author joan
 * @parity XX
 * @since 41158.3
 */
@XmlRootElement
public class BosonW
	extends Positron<AlphaCentauri,Sun> {

	/**
	 * 4014918301790036086L
	 */
	private static final long serialVersionUID = 4014918301790036086L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	@XmlElement
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public AlphaCentauri getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public AlphaCentauri setKey(AlphaCentauri key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Sun getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Sun setValue(Sun value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link BosonW} default class constructor.
	 */
	public BosonW() {
		super();
	}
	/**
	 * {@link BosonW} class constructor.
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 */
	public BosonW(AlphaCentauri key, Sun value) {
		super(BosonW.class, key, value);
	}
	/**
	 * {@link BosonW} class constructor.
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 * @param parent {@link BosonZ} the parent
	 */
	public BosonW(AlphaCentauri key, Sun value, BosonZ parent) {
		super(BosonW.class, key, value, parent);
	}
	/**
	 * {@link BosonW} class constructor.
	 * @param antitype the antitype
	 */
	public BosonW(Class<HyperbosonW> antitype) {
		super(BosonW.class, antitype);
	}
	/**
	 * {@link BosonW} class constructor.
	 * @param antitype the antitype
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 */
	public BosonW(Class<HyperbosonW> antitype, AlphaCentauri key, Sun value) {
		super(BosonW.class, antitype, key, value);
	}
	/**
	 * {@link BosonW} class constructor.
	 * @param antitype the antitype
	 * @param key {@link AlphaCentauri} the key
	 * @param value {@link Sun} the value
	 * @param parent {@link BosonZ} the parent
	 */
	public BosonW(Class<HyperbosonW> antitype, AlphaCentauri key, Sun value, BosonZ parent) {
		super(BosonW.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<AlphaCentauri,Sun> o1, Mass<AlphaCentauri,Sun> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}