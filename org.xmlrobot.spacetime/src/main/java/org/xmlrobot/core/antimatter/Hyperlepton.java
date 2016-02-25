package org.xmlrobot.core.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.matter.Lepton;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;

/**
 * Hyperlepton implementation class.
 * @author joan
 * @parity XY
 * @since 41162.4
 */
@XmlRootElement
public class Hyperlepton 
	extends Positron<Fornax,Columbia> {

	/**
	 * 5334316184698114845L
	 */
	private static final long serialVersionUID = 5334316184698114845L;

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
	public Fornax getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Fornax setKey(Fornax key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Columbia getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Columbia setValue(Columbia value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperlepton} default class constructor.
	 */
	public Hyperlepton() {
		super(Hyperlepton.class);
	}
	/**
	 * {@link Hyperlepton} class constructor.
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 */
	public Hyperlepton(Fornax key, Columbia value) {
		super(Hyperlepton.class, key, value);
	}
	/**
	 * {@link Hyperlepton} class constructor.
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 * @param parent {@link Hyperquark} the parent
	 */
	public Hyperlepton(Fornax key, Columbia value, Hyperquark parent) {
		super(Hyperlepton.class, key, value, parent);
	}
	/**
	 * {@link Hyperlepton} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperlepton(Class<Lepton> antitype) {
		super(Hyperlepton.class, antitype);
	}
	/**
	 * {@link Hyperlepton} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 */
	public Hyperlepton(Class<Lepton> antitype, Fornax key, Columbia value) {
		super(Hyperlepton.class, antitype, key, value);
	}
	/**
	 * {@link Hyperlepton} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Fornax} the key
	 * @param value {@link Columbia} the value
	 * @param parent {@link Hyperquark} the parent
	 */
	public Hyperlepton(Class<Lepton> antitype, Fornax key, Columbia value, Hyperquark parent) {
		super(Hyperlepton.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Fornax, Columbia> o1, Mass<Fornax, Columbia> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}
