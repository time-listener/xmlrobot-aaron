package org.xmlrobot.dna.antimatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.matter.Intron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antineutron;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;

/**
 * Hyperintron implementation class.
 * @author joan
 * @parity XY
 * @since 1516.4
 */
@XmlRootElement
public class Hyperintron 
	extends Antineutron<Hypercube,Hyperchain> {

	/**
	 * 4517820012623779722L
	 */
	private static final long serialVersionUID = 4517820012623779722L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
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
	public Hypercube getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Hypercube setKey(Hypercube key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Hyperchain getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Hyperchain setValue(Hyperchain value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Hyperintron} default class constructor.
	 */
	public Hyperintron() {
		super(Hyperintron.class);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 */
	public Hyperintron(Hypercube key, Hyperchain value) {
		super(Hyperintron.class, key, value);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Hyperexon} the parent
	 */
	public Hyperintron(Hypercube key, Hyperchain value, Hyperexon parent) {
		super(Hyperintron.class, key, value, parent);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param antitype the antitype
	 */
	public Hyperintron(Class<Intron> antitype) {
		super(Hyperintron.class, antitype);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 */
	public Hyperintron(Class<Intron> antitype, Hypercube key, Hyperchain value) {
		super(Hyperintron.class, antitype, key, value);
	}
	/**
	 * {@link Hyperintron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hypercube} the key
	 * @param value {@link Hyperchain} the value
	 * @param parent {@link Hyperexon} the parent
	 */
	public Hyperintron(Class<Intron> antitype, Hypercube key, Hyperchain value, Hyperexon parent) {
		super(Hyperintron.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Hypercube,Hyperchain> o1, Mass<Hypercube,Hyperchain> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}