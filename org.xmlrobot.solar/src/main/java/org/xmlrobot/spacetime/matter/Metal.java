package org.xmlrobot.spacetime.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.spacetime.antimatter.Hypermetal;

/**
 * Metal implementation class.
 * @author joan
 * @parity XX
 * @since 41154.3
 */
@XmlRootElement
public class Metal 
	extends Antineutron<Biosphere,Ecosystem> {

	/**
	 * -359433908567036074L
	 */
	private static final long serialVersionUID = -359433908567036074L;

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
	public Biosphere getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Biosphere setKey(Biosphere key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Ecosystem getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Ecosystem setValue(Ecosystem value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Metal} default class constructor.
	 */
	public Metal() {
		super(Metal.class);
	}
	/**
	 * {@link Metal} class constructor.
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 */
	public Metal(Biosphere key, Ecosystem value) {
		super(Metal.class, key, value);
	}
	/**
	 * {@link Metal} class constructor.
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link Gas} the parent
	 */
	public Metal(Biosphere key, Ecosystem value, Gas parent) {
		super(Metal.class, key, value, parent);
	}
	/**
	 * {@link Metal} class constructor.
	 * @param antitype the antitype
	 */
	public Metal(Class<Hypermetal> antitype) {
		super(Metal.class, antitype);
	}
	/**
	 * {@link Metal} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 */
	public Metal(Class<Hypermetal> antitype, Biosphere key, Ecosystem value) {
		super(Metal.class, antitype, key, value);
	}
	/**
	 * {@link Metal} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Biosphere} the key
	 * @param value {@link Ecosystem} the value
	 * @param parent {@link Gas} the parent
	 */
	public Metal(Class<Hypermetal> antitype, Biosphere key, Ecosystem value, Gas parent) {
		super(Metal.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Biosphere,Ecosystem> o1, Mass<Biosphere,Ecosystem> o2) {
		
		return o1.getKey().compareTo(o2.getValue());
	}
}