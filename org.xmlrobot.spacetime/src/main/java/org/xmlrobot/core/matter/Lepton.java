package org.xmlrobot.core.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.core.antimatter.Hyperlepton;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;

/**
 * Lepton implementation class.
 * @author joan
 * @parity XX
 * @since 41162.3
 */
@XmlRootElement
public class Lepton
	extends Antineutron<Columbia,Fornax> {

	/**
	 * -6065172273899408059L
	 */
	private static final long serialVersionUID = -6065172273899408059L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Columbia getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Columbia setKey(Columbia key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Fornax getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Fornax setValue(Fornax value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Lepton} default class constructor.
	 */
	public Lepton() {
		super();
	}
	/**
	 * {@link Lepton} class constructor.
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 */
	public Lepton(Columbia key, Fornax value) {
		super(Lepton.class, key, value);
	}
	/**
	 * {@link Lepton} class constructor.
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 * @param parent {@link Quark} the parent
	 */
	public Lepton(Columbia key, Fornax value, Quark parent) {
		super(Lepton.class, key, value, parent);
	}
	/**
	 * {@link Lepton} class constructor.
	 * @param antitype the antitype
	 */
	public Lepton(Class<Hyperlepton> antitype) {
		super(Lepton.class, antitype);
	}
	/**
	 * {@link Lepton} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 */
	public Lepton(Class<Hyperlepton> antitype, Columbia key, Fornax value) {
		super(Lepton.class, antitype, key, value);
	}
	/**
	 * {@link Lepton} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Columbia} the key
	 * @param value {@link Fornax} the value
	 * @param parent {@link Quark} the parent
	 */
	public Lepton(Class<Hyperlepton> antitype, Columbia key, Fornax value, Quark parent) {
		super(Lepton.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Columbia,Fornax> o1, Mass<Columbia,Fornax> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}